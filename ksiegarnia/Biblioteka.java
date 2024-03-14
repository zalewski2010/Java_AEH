package ksiegarnia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Biblioteka {
    private List<Ksiazka> ksiazki;


    public Biblioteka() {
        ksiazki = new ArrayList<>();
        // przykładowe książki do listy deafultowo dla programu
        dodajKsiazke(new Ksiazka("Wiedźmin - Ostatnie życzenie", "Andrzej Sapkowski", 1993, "Fantasy"));
        dodajKsiazke(new Ksiazka("Wiedźmin - Miecz przeznaczenia", "Andrzej Sapkowski", 1992, "Fantasy"));
        dodajKsiazke(new Ksiazka("1984", "George Orwell", 1949, "Science Fiction"));
        dodajKsiazke(new Ksiazka("Hobbit", "J.R.R. Tolkien", 1937, "Fantasy"));
        dodajKsiazke(new Ksiazka("Władca Pierścieni", "J.R.R. Tolkien", 1954, "Fantasy"));
        dodajKsiazke(new Ksiazka("Metro 2033", "Dmitrij Głuchowski", 2005, "Postapokaliptyczna"));
        dodajKsiazke(new Ksiazka("Mały Książę", "Antoine de Saint-Exupéry", 1943, "Literatura piękna"));
        dodajKsiazke(new Ksiazka("Duma i uprzedzenie", "Jane Austen", 1813, "Romans"));
        dodajKsiazke(new Ksiazka("Zbrodnia i kara", "Fiodor Dostojewski", 1866, "Literatura piękna"));
        dodajKsiazke(new Ksiazka("Wojna i pokój", "Lew Tołstoj", 1869, "Literatura piękna"));
        dodajKsiazke(new Ksiazka("Rok 1984", "George Orwell", 1949, "Science Fiction"));
        dodajKsiazke(new Ksiazka("Lalka", "Bolesław Prus", 1890, "Literatura piękna"));
        dodajKsiazke(new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", 1834, "Epopeja narodowa"));
        dodajKsiazke(new Ksiazka("Chłopi", "Władysław Reymont", 1904, "Literatura piękna"));
        dodajKsiazke(new Ksiazka("Harry Potter i Kamień Filozoficzny", "J.K. Rowling", 1997, "Fantasy"));
        dodajKsiazke(new Ksiazka("Harry Potter i Komnata Tajemnic", "J.K. Rowling", 1998, "Fantasy"));
        dodajKsiazke(new Ksiazka("Harry Potter i Więzień Azkabanu", "J.K. Rowling", 1999, "Fantasy"));
        dodajKsiazke(new Ksiazka("Sherlock Holmes", "Arthur Conan Doyle", 1887, "Kryminał"));
        dodajKsiazke(new Ksiazka("Dracula", "Bram Stoker", 1897, "Horror"));
        dodajKsiazke(new Ksiazka("Frankenstein", "Mary Shelley", 1818, "Horror"));
        dodajKsiazke(new Ksiazka("Wielkie nadzieje", "Charles Dickens", 1861, "Literatura piękna"));
        dodajKsiazke(new Ksiazka("Fahrenheit 451", "Ray Bradbury", 1953, "Science Fiction"));
        dodajKsiazke(new Ksiazka("Niezwyciężony", "Stanisław Lem", 1964, "Science Fiction"));
        dodajKsiazke(new Ksiazka("Solaris", "Stanisław Lem", 1961, "Science Fiction"));
        dodajKsiazke(new Ksiazka("Java na początek", "Java Javovski", 1961, "Programming"));


        // Wczytanie listy książek z pliku CSV
        List<Ksiazka> ksiazkiZPliku = DataManager.wczytajKsiazkiZPlikuCsv("ksiazki.csv");
        for (Ksiazka ksiazkaZPliku : ksiazkiZPliku) {
            if (ksiazki.stream().noneMatch(k -> k.getTytul().equalsIgnoreCase(ksiazkaZPliku.getTytul()) &&
                    k.getAutor().equalsIgnoreCase(ksiazkaZPliku.getAutor()))) {
                ksiazki.add(ksiazkaZPliku);
            }
        }
    }


    public void dodajKsiazke(Ksiazka ksiazka) {
        ksiazki.add(ksiazka);
    }


    public List<Ksiazka> wyszukajKsiazkiPoTytule(String tytul) {
        return ksiazki.stream()
                .filter(ksiazka -> ksiazka.getTytul().equalsIgnoreCase(tytul))
                .collect(Collectors.toList());
    }
    public void usunKsiazke(Ksiazka ksiazka) { // zostawiam na razie
        ksiazki.remove(ksiazka);
    }

    public boolean usunKsiazkePoTytulueIId(String tytul, int id) {
        return ksiazki.removeIf(ksiazka -> ksiazka.getId() == id && ksiazka.getTytul().equalsIgnoreCase(tytul));
    }

    public List<Ksiazka> wyszukajKsiazki(String wzorzec) {
        Pattern pattern = Pattern.compile(wzorzec, Pattern.CASE_INSENSITIVE); // Dodajemy flagę CASE_INSENSITIVE
        return ksiazki.stream()
                .filter(ksiazka -> pattern.matcher(ksiazka.getTytul()).find() ||
                        pattern.matcher(ksiazka.getAutor()).find() ||
                        pattern.matcher(ksiazka.getGatunek()).find() ||
                        pattern.matcher(String.valueOf(ksiazka.getRokWydania())).find())
                .collect(Collectors.toList());
    }

    public void sortujPoTytule() {
        ksiazki.sort(Comparator.comparing(Ksiazka::getTytul));
    }

    // Sortowanie  według autora
    public void sortujPoAutorze() {
        Collections.sort(ksiazki, Comparator.comparing(Ksiazka::getAutor));
    }

    // Sortowanie  według roku wydania
    public void sortujPoRokuWydania() {
        Collections.sort(ksiazki, Comparator.comparingInt(Ksiazka::getRokWydania));
    }

    // Sortowanie według gatunku
    public void sortujPoGatunku() {
        Collections.sort(ksiazki, Comparator.comparing(Ksiazka::getGatunek));
    }
    // sortowanie po id
    public void sortujPoId() {
        ksiazki.sort(Comparator.comparingInt(Ksiazka::getId));
    }

    //  informacje o książkach
    public String wyswietlInformacje() {
        return ksiazki.stream()
                .map(Ksiazka::toString)
                .collect(Collectors.joining("\n"));
    }

    // Getter dla listy książek
    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    // ewentualne dodatkowe metody
}
