public class Compulsory {

        public static void main (){

            System.out.println("Hello world");

            String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

            Compulsory Program=new Compulsory();
            int result=Program.operatieComplexa();
            System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
        }

        private int operatieComplexa()
        {
            int n = (int) (Math.random() * 1_000_000);

            n*=3;
            String BinaryNumber= "10101";
            n=n+Integer.parseInt(BinaryNumber,2);

            String HexaNumber= "FF";

            n=n+Integer.parseInt(HexaNumber,16);
            n=n*6;


            return sumaCifrelor(n);

        }

    private int sumaCifrelor(int n) {
        while ( n > 9 )
        {
            int x= n %10;
            n /=10;
            n = n +x;
        }
        return n;
    }



}
