public class LeitorDeDados {
    static String[] meses = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"};


    public static void getMeses () { // Print do "Header" com os meses
        for (String mes : meses) {
            System.out.print("\t" + mes);
        }
    }



    public static void main(String[] args) {

        getMeses();
        
        

    }
}
