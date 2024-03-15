package nauka;

public class master {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet.";
        final String alternativeText = "Some text"; // jest to stała (final)

        //typy proste / typy prymitywne
        int someNumber = 12;
        double doubleValue = 3.14;
        boolean booleanValue = true;
        char chartValue = 'A';

        // typy referencyjne
        String textStr = "Hello, Wolrd!";
        Integer someNumber1 = Integer.valueOf(13);
        String numberAsText = "123";
        int convertedTextAsNumber = Integer.parseInt(numberAsText);

        // text = "!!!"; wpisanie innego tekstu zmienia zmienną czyli !!! zamiast lorem...
       // alternativeText = "????"; taka zmiana nie przejdzie bo final

       // Instrukcje proste (to co kończy się średnikiem)
        int a = 5;
        System.out.println(a);

       // Instrukcje złożone (to co ma nawiasy {} )

        int number = 5;
        if (number > 0 ) {
            System.out.println("Is positive");
            System.out.println("It is an complex solution");
        } else if (number < 0) {
            System.out.println("Is negative");
        } else {
            System.out.println("Is equal zero");
        }

        // switch (czyli instrukcja warunkowa) (przełaczanie zadań na podstawie wartości)
        int grade = 5;
        switch (grade) {
            case 3:
                System.out.println("you failed");
                break;
            case 4:
                System.out.println("You were closed");
            break;
            case 5:
                System.out.println("You passsed");
            break;
            default:
                System.out.println("Huh?");
        }

        // Trenany operator / Elvis operator (tak zwany operator argumentowy)
        int someNumb = 7;
        String result = (someNumb % 2 == 0) ? "even" : "odd";
        System.out.println("Number is " + result + " (modulo z elvis operator parzysta czy nieparzysta)");


        System.out.println(text);
        System.out.println(alternativeText);
        System.out.println(someNumber);
        System.out.println(doubleValue);
        System.out.println(booleanValue);
        System.out.println(chartValue);
        System.out.println(textStr);
        System.out.println(numberAsText);
        System.out.println(convertedTextAsNumber);
        System.out.println(add(2, 5) + " dodawanie");
        final int SUM = add(3, 5);
        System.out.println(SUM);
        
    }
    public static int add(int a , int b) {
        int sum = a + b;
    
        return sum; }

   
}
