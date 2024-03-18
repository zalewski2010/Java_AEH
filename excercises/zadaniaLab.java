package excercises;

public class zadaniaLab {

    public static void main(String[] args) {

        //wypisanie zad1
        System.out.println(add(5,6) + " to wynik dodawania zad1");
        System.out.println(subtr(4,2)+ " to wynik odejmowania zad1");
        System.out.println(multipl(3,3)+ " to wynik mnożenia zad1");
        System.out.println(divid(12,4) + " to wynik dzielenia zad1");
        
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

    public static int divid(int a , int b) {
                    int sum = a / b;
                    return sum; }

    

    
}



//2) Stwórz tablicę liczb całkowitych a następnie oblicz średnią wartość.
//3) Wyświetl, czy dana liczba jest parzysta czy nieparzysta.
//4) Napisz program obliczający wskaźnik masy ciała (BMI).
//5) Napisz program, który dla tablicy wyników z kilkoma ocenami obliczy średnią ocen i określi odpowiedni stopień zaliczenia (np. "A", "B", "C" itp.).
//6) Napisz program, który sprawdza, czy dane słowo jest palindromem.



//1.1) Napisz funkcję, która przyjmuje tablicę i liczbę do znalezienia, a następnie zwraca indeks tej liczby w tablicy (lub -1, jeśli nie znaleziono).

//1.2) Napisz funkcję, która przyjmuje zakres liczb i zwraca tablicę liczb pierwszych w tym zakresie.

//1.3) Napisz funkcję, która przyjmuje tablicę i liczbę, a następnie zlicza ile razy ta liczba występuje w tablicy.

//1.4) Napisz funkcję rekurencyjną, która oblicza sumę liczby całkowitej, dodając do niej wszystkie liczby od 1 do tej liczby.
//Link: https://pl.wikipedia.org/wiki/Rekurencja
