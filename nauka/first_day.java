package nauka;

public class first_day {
    public static void main(String[] args) {
        //pętle:

        //for
        for (int i =1; i <= 5; i++) { // operator posinkrementacji cyli o 1, pętla się wykonuje od 1 do 5
            System.out.println(i + " pętla for");
        }

        //while
        int j = 1;
        while (j <= 5) {
            System.out.println(j + " pętla while");
            j++;
        }

        //do while (zawsze się wykona bo sprawdza warunek na końcu)
        int k = 2;
        do {
            System.out.println(k + " pętla do while");
            k++;
       }while (k <= 5);

       // tablice (jednowymiarowe)
       int[] integerNumber = new int[5];

       integerNumber[0] = 10;
       integerNumber[2] = 30;
       integerNumber[4] = 50;
       System.out.println(integerNumber);
       System.out.println(integerNumber[2]);

       String[] strings = {"A", "B", "C"};
       System.out.println("E11: " + strings[1]);
       System.out.println("E13: " + integerNumber[integerNumber.length -1]); // pokazuje ostatni element w tablicy
       System.out.println("E14: " + strings[strings.length -1]);

       for (int integerNumbers : integerNumber) {
            System.out.println("E1: " + integerNumbers);
       }
    }
    
}
