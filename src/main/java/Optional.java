public class Optional {
    public void execute ( String[] args)
    {
        //------------------------------------------- Validare n
        if(!validare(args))
        {
            System.err.println("Eroare la argumente");
        }
        else
        {

            int n=Integer.parseInt(args[0]);

            long start=1;
            if(n>=100)
            {
                start = System.nanoTime();
            }

            //------------------------------------------- Construire matrice
            int[][] matrice = new int [n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<=n;j++)
                    if ( j < i )
                        matrice[i][j]=matrice[j][i]=(int) (Math.random() * 1_000)%2;

            if(n<100) {
                System.out.println("Matricea originala a grafului :");
                afisare(matrice, n);
            }
            else
            {
                long finish = System.nanoTime();
                long timeElapsed = finish - start;
                System.out.println("Timpul rularii este: " + timeElapsed);
            }

            //------------------------------------------- Conexitate
            int[][] componentaConexa = new int [n][n];
            copiereMatrice(matrice,componentaConexa,n);
            int numarConex=0;
            int nr=2;
            if(n<=300)
            for(int i=0;i<n;i++)
            {
                copiereMatrice(matrice,componentaConexa,n);
                if(parcurgere(i, matrice, n,nr))
                {
                    nr++;
                    numarConex++;

                }
            }

            System.out.println("Numarul de componente conexe este: "+ numarConex );

            //------------------------------------------- Afisare componente conexe
            if(numarConex>1 && n<100)
            {
                for(int x=2;x<nr;x++)
                {
                    System.out.println("Matricea de adiacenta asociata componentei conexe " + (x-1));
                    for(int i=0;i<n;i++) {

                        for (int j = 0; j < n; j++) {
                            if (matrice[i][j] == x)
                                System.out.print(matrice[i][j] / x + " ");
                            else
                                System.out.print("0 ");
                        }
                        System.out.println();
                    }
                    System.out.println();}
            }
            else//------------------------------------------- Arbore Partial
                if(numarConex==1 && n<100 )
                {
                    for(int i=0;i<n;i++)
                        for(int j=0;j<n;j++)
                            if(matrice[i][j]!=0)
                                matrice[i][j]=1;
                    int[] vizitat=new int[n];
                    int[][]arbore=new int[n][n];
                    afisare(matrice,n);
                    DFS(0,matrice,n,vizitat,arbore);

                    System.out.println("Matricea de adiacenta a arborelui partial este :");

                    afisare(arbore,n);
                }

        }

    }

    public static boolean validare(String[] args)
    {
        if ( args.length!=1)
        {
            return false;
        }

        for(int i=0;i< args[0].length(); i++)
            if(args[0].charAt(i)<'0' || args[0].charAt(i)>'9')
            {
                return false;
            }
        return true;

    }

    public static boolean parcurgere(int Nod, int[][] matrice, int n, int valoare)
    {
        for(int i=0;i<n;i++)
            if(matrice[i][Nod]==1)
            {
                matrice[i][Nod]=matrice[Nod][i]=valoare;
                parcurgere(i, matrice, n,valoare);
                return true;
            }
        return false;
    }

    public static void DFS(int Nod,int[][] matrice,int n,int[] vizitat,int[][] arbore)
    {

        vizitat[Nod]=1;
        for(int i=0;i<n;i++)
            if(matrice[i][Nod]==1)
            {

                if(vizitat[i]!=1)
                {
                    arbore[i][Nod]=arbore[Nod][i]=1;
                    //System.out.println("Am trecut prin nodul " + i);
                    DFS(i, matrice, n,vizitat,arbore);
                }

            }
    }

    public static void afisare(int[][] matrice, int n)
    {
        for(int i=0;i<n;i++)
        {
            for (int j = 0; j <n; j++)
            {
                System.out.print(matrice[i][j]+" ");
            }
            System.out.println();
        }
    }
    public  static void copiereMatrice(int[][] matrice, int[][] matrice2, int n)
    {
        for(int i=0;i<n;i++)
            for (int j = 0; j <n; j++)
                matrice2[i][j]=matrice[i][j];

    }
}
