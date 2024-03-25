package excercises;

import java.util.ArrayList;
import java.util.List;

public class zadaniaLab {

    public static void main(String[] args) {

        //wypisanie zad1
        System.out.println(add(5,6) + " to wynik dodawania zad1");
        System.out.println(subtr(4,2)+ " to wynik odejmowania zad1");
        System.out.println(multipl(3,3)+ " to wynik mnożenia zad1");
        System.out.println(divid(12,4) + " to wynik dzielenia zad1");
        
        //wypisanie zad2 - avg tablicy
        int[] integerNumbers = {1, 2, 3, 4, 6, 14};
        System.out.println("średnia z tablicy w zad2 to: " + calcAvg(integerNumbers));

        // Wypisanie zad3 parzysta czy nieparzysta liczba
        int someNumb = 7; //liczba do sprawdzenia
        System.out.println("Liczba " + someNumb + " jest " + evenOdd(someNumb) + " (even or odd? zad3)");

        // Wypisanie zad3 wskaźnik BMI
        double weight = 76; // Masa ciała w kilogramach
        double height = 1.75; // Wzrost w metrach
        System.out.println("BMI wynosi: " + calcBMI(weight, height) + " (zad4 bmi calculator)");

        // Zad 5 , Tworzenie listy studentów z ocenami
        List<Student> students = new ArrayList<>();
        students.add(new Student("John Smith", new int[]{90, 92, 88, 95}));
        students.add(new Student("John Doe", new int[]{82, 75, 80, 79}));
        students.add(new Student("John Woo", new int[]{70, 72, 68, 65}));
        students.add(new Student("John Johnson", new int[]{60, 65, 55, 70}));
        students.add(new Student("John Soft", new int[]{50, 45, 55, 60}));
        // Obliczanie średniej ocen dla klasy
        double totalSum = 0;
        int totalGradesCount = 0;
        for (Student student : students) {
            for (int grade : student.grades) {
                totalSum += grade;
                totalGradesCount++;
            }
        }
        double classAverage = totalSum / totalGradesCount;
        System.out.println("Średnia ocen dla klasy wynosi: " + classAverage + "...(zad5)");
        // Obliczanie średniej ocen
        for (Student student : students) {
            System.out.println("Student: " + student.name + ": Ma ocenę końcową : " + calculateFinalGrade(student.grades) + " ...(zad5)");
        }

        // zad6 wpisanie słowa - Sprawdzenie czy słowo jest palindromem
        String word = "kajak";
        System.out.println("Czy Słowo " + word + " jest palindromem? Odpowiedź: " + isPalindrome(word) + " (zad6)");

    
        
    }
    // zadanie 1 = Wyświetl wynik dodawania, odejmowania, mnożenia oraz dzielenia 2 wartości.
    // - jest to wersja bez wyboru rodzaju operacji, i bez inputa dla użytkownika
    public static int add(int a , int b) {
        int sum = a + b;
        return sum; }

    public static int subtr(int a , int b) {
            int sum = a - b;
            return sum; }
    
    public static int multipl(int a , int b) {
                int sum = a * b;
                return sum; }

    public static double divid(int a , int b) {
                    double sum = a / b;
                    return sum; }
    
    // Zadanie 2. Stwórz tablicę liczb całkowitych a następnie oblicz średnią wartość.
    public static double calcAvg(int[] array) {
        if (array == null || array.length == 0) {
            return 0; // Zwraca 0, jeśli tablica jest pusta lub null
        }
        double sum = 0;
        for (int number : array) {
            sum += number; // Sumuje wszystkie liczby w tablicy
        }
        return sum / array.length; // Dzieli sumę przez liczbę elementów, aby uzyskać średnią
    }
    
    // Zadanie 3 Wyświetl, czy dana liczba jest parzysta czy nieparzysta.
    public static String evenOdd(int number) {
        return (number % 2 == 0) ? "even" : "odd";
    }

    //zadanie 4 program obliczający wskaźnik masy ciała (BMI).
    public static String calcBMI(double weight, double height) {
        double bmi = weight / (height * height); // wzór: masa (kg) / (wzrost (m))^2
        return String.format("%.2f", bmi); // Zaokrąglenie wyniku do do dwóch miejsc po przecinku
    }
    
    // zadanie 5 program, który dla tablicy wyników z kilkoma ocenami obliczy średnią ocen i określi 
    // odpowiedni stopień zaliczenia (np. "A", "B", "C" itp.).
    static class Student {
        String name;
        int[] grades;

        public Student(String name, int[] grades) {
            this.name = name;
            this.grades = grades;
        }
    }
    // Zad5 cdn Metoda obliczająca średnią ocen i przypisująca stopień zaliczenia
    public static String calculateFinalGrade(int[] grades) {
        if (grades == null || grades.length == 0) {
            return "N/A"; // Zwraca "N/A", jeśli tablica jest pusta lub null
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade; // Sumuje wszystkie oceny
        }
        double average = sum / grades.length; // Oblicza średnią
        
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    // Zad6 program, który sprawdza, czy dane słowo jest palindromem.
    public static boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false; // Jeśli znaki są różne, słowo nie jest palindromem
            }
            i++;
            j--;
        }
        return true; // jeśli nie ma różnic, słowo jest palindromem
    }

}





//6) Napisz program, który sprawdza, czy dane słowo jest palindromem.



//1.1) Napisz funkcję, która przyjmuje tablicę i liczbę do znalezienia, a następnie zwraca indeks tej liczby w tablicy (lub -1, jeśli nie znaleziono).

//1.2) Napisz funkcję, która przyjmuje zakres liczb i zwraca tablicę liczb pierwszych w tym zakresie.

//1.3) Napisz funkcję, która przyjmuje tablicę i liczbę, a następnie zlicza ile razy ta liczba występuje w tablicy.

//1.4) Napisz funkcję rekurencyjną, która oblicza sumę liczby całkowitej, dodając do niej wszystkie liczby od 1 do tej liczby.
//Link: https://pl.wikipedia.org/wiki/Rekurencja
