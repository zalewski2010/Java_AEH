package ksiegarnia;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class DataManager {
    // miejsce na inne metody

    // Metoda do wczytywania książek z pliku CSV
    public static List<Ksiazka> wczytajKsiazkiZPlikuCsv(String sciezkaPliku) {
        List<Ksiazka> ksiazki = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(sciezkaPliku))) {
            String line;
            br.readLine(); // Pomijam nagłówek
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Zakładam, że przecinek (,) jest separatorem
                // Tworzenie nowej książki na podstawie danych z pliku CSV
                // ważna kolejnosc i typ danych
                Ksiazka ksiazka = new Ksiazka(
                        values[1], // tytuł
                        values[2], // autor
                        Integer.parseInt(values[3]), // rok wydania
                        values[4] // gatunek
                );
                ksiazki.add(ksiazka);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ksiazki;
    }

    // Metoda do zapisywania książek z pliku CSV
    public static void zapiszKsiazkiDoPlikuCsv(List<Ksiazka> ksiazki, String sciezkaPliku) {
        try (FileWriter writer = new FileWriter(sciezkaPliku)) {
            writer.append("ID,Tytuł,Autor,Rok wydania,Gatunek\n"); // Nagłówki kolumn

            for (Ksiazka ksiazka : ksiazki) {
                writer.append(String.valueOf(ksiazka.getId())).append(",");
                writer.append(ksiazka.getTytul().replace(",", ";")).append(","); // Zastąpienie przecinków, aby nie zakłócały formatu CSV
                writer.append(ksiazka.getAutor().replace(",", ";")).append(",");
                writer.append(String.valueOf(ksiazka.getRokWydania())).append(",");
                writer.append(ksiazka.getGatunek().replace(",", ";")).append("\n");
            }

            System.out.println("Zapisano dane do pliku CSV: " + sciezkaPliku);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisu danych do pliku CSV: " + e.getMessage());
        }
    }
}
