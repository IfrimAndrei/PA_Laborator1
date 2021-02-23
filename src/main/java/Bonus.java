public class Bonus {

    public static void main ()
    {


        //---------------------Generarea arborelui
        int n = (int) (Math.random() * 1_000_000)%20+1;
        int[] parinte=new int[n];
        vectorTati(n, parinte);

        //---------------------Stabilirea nivelelor nodurilor
        int[] nivel = getNivel(n, parinte);

        //----------------------Stabilirea frunzelor;
        int[] notFrunza=new int[n];
        for(int i=0;i<n;i++)
            notFrunza[parinte[i]]=1;

        //----------------------Afisarea finala
        int[] vizited=new int[n];
        afisare(0,parinte,vizited,n,nivel,notFrunza);

    }

    private static void vectorTati(int n, int[] parinte)
    {
        for(int i = 1; i< n; i++)
            parinte[i]=(int) (Math.random() * 1_000_000)%i;
        System.out.println("Vectorul de tati :");
        for(int i = 0; i< n; i++)
            System.out.print(parinte[i]+ " ");
        System.out.println();
    }

    private static int[] getNivel(int n, int[] parinte)
    {
        int[] nivel=new int[n];
        nivel[0]=0;
        for(int i = 1; i< n; i++)
            nivel[i]=nivel[parinte[i]]+1;
        System.out.println("Vectorul de nivele :");
        for(int i = 0; i< n; i++)
            System.out.print(nivel[i]+ " ");
        System.out.println("\n");
        return nivel;
    }

    public static void afisare(int nod, int[] tree, int[] vizited, int n, int[] nivel, int[] notFrunza)
    {
        for(int i=0;i<n;i++)
        {
            if(tree[i]==nod)
            {
                if(vizited[i]!=1)
                {
                    vizited[i]=1;
                    for(int j=0;j<nivel[i];j++)
                        System.out.print("  ");
                    if(notFrunza[i]==1)
                        System.out.println("+node" + i);
                    else
                        System.out.println("-node" + i);
                    afisare(i,tree,vizited,n,nivel,notFrunza);
                }
            }
        }
    }

}
