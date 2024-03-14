package ksiegarnia;
public class Ksiazka {
    private static int licznikId = 0; // Statyczny licznik ID dla wszystkich książek
    private int id;
    private String tytul;
    private String autor;
    private int rokWydania;
    private String gatunek;

    public Ksiazka(String tytul, String autor, int rokWydania, String gatunek) {
        this.id = ++licznikId; // Inkrementacja ID dla każdej nowej książki
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
        this.gatunek = gatunek;
    }

    // Gettery i Settery
    public int getId() { return id; }
    public String getTytul() { return tytul; }
    public String getAutor() { return autor; }
    public int getRokWydania() { return rokWydania; }
    public String getGatunek() { return gatunek; }

    @Override
    public String toString() {
        return "ID: " + id + ", Tytuł: " + tytul + ", Autor: " + autor + ", Rok wydania: " + rokWydania + ", Gatunek: " + gatunek;
    }
}
