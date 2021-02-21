public class main {
    public static void main ( String args[]){

        System.out.println("Hello world");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        main Program=new main();
        int result=Program.OperatieComplexa();
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    int OperatieComplexa()
    {
        int n = (int) (Math.random() * 1_000_000);
        //System.out.println("Numarul initial este :\n" + n);
        n*=3;
        String BinaryNumber= "10101";
        n=n+Integer.parseInt(BinaryNumber,2);
        //System.out.println("Numarul 10101 este: " + Integer.parseInt(BinaryNumber,2));
        String HexaNumber= "FF";
        //System.out.println("Numarul FF este: " + Integer.parseInt(HexaNumber,16));
        n=n+Integer.parseInt(HexaNumber,16);
        n=n*6;
        //System.out.println("Rezultatul operatiilor este :" + n);

        while ( n > 9 )
        {
            int x= n%10;
            n/=10;
            n=n+x;
        }
        return n;
        //System.out.println("Rezultatul final este :" + n);
    }

}