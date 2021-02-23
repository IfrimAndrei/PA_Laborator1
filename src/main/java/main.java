public class main {
    public static void main ( String[] args){
        compulsory();
        optional(args);
        bonus();

    }

    private static void bonus() {
        Bonus obj3=new Bonus();
        obj3.execute();
    }

    private static void optional(String[] args) {
        Optional obj2=new Optional();
        obj2.execute(args);
    }

    private static void compulsory() {
        Compulsory obj1=new Compulsory();
        obj1.execute();
    }


}