# 1. Zarządzanie książkami

Projekt "Zarządzanie książkami" to aplikacja konsolowa napisana w języku Java, która umożliwia użytkownikom zarządzanie kolekcją książek.

## Spis treści

- [Zarządzanie książkami :](#zarządzanie-książkami)
    - [Funkcjonalności](#funkcjonalności)
    - [Opis działania programu](#opis_programu)
    - [Instrukcje obsługi](#instrukcje-obsługi)
        - [Wymagania wstępne](#wymagania-wstępne)
        - [Uruchomienie aplikacji](#uruchomienie-aplikacji)
    - [Autor](#autor)




### Funkcjonalności

W ramach projektu zaimplementowano następujące funkcjonalności:
- **Dodawanie książek**: Umożliwia dodanie nowej książki do kolekcji.
- **Usuwanie książek**: Umożliwia usunięcie książki z kolekcji na podstawie tytułu oraz ID.
- **Wyszukiwanie książek**: Umożliwia wyszukiwanie książek na podstawie różnych kryteriów, takich jak tytuł, autor, rok wydania czy gatunek. Wyszukiwanie wspiera wyrażenia regularne.
- **Sortowanie książek**: Umożliwia sortowanie książek według tytułu, autora, roku wydania, gatunku oraz ID.
- **Wyświetlanie informacji o wszystkich książkach**: Umożliwia wyświetlenie szczegółowych informacji o wszystkich książkach w kolekcji.

# Opis programu

Program posiada wbudowaną listę 25 książek, których nie można trwale (pomiędzy sesjami) usunąć.
Książki te posiadają nadane trwałe numery id od 1 do 25. Lista ta jest zapisana w programie i tylko osoba z dostępem do kodu,
może ingerować w zawartosc listy. Lista tych książek oraz ewentualnie dodanych książek przez użytkownika,
jest zapisywana do pliku csv, który pełni rolę bazy danych. Każda książka dodana przez użytkownika,
dodstaje numer id, z czego najniższy możliwy numer id to 51. Książki dodane przez użytkownika, można usuwać trwale.
W programie jest możliwosc zapisu aktualnego stanu listy książek.

## Instrukcje obsługi

Po uruchomieniu programu masz możliwosci:
1. Aby wyszukać książkę należy nad przyciskiem Wyszukaj minimum jedną literę lub cyfrę,
lub podać autora, tytuł, ok wydania lub gatunek a następnie kliknąć przycisk Wyszukaj.
2. Aby dodać książkę, należy nad przyciskiem "Dodaj książkę" wypełnić odpowiednie pola :
Tytuł, Autor, Rok Wydania, Gatunek, a następnie kliknąć przycisk "Dodaj książkę".
3.  Aby wyswietlić wszystkie książki ze zbioru należy kliknać w przycisk "Wyswietl wszystkie".
4.  Aby usunąć książkę , należy najpierw wyszukać daną książkę i zapamiętać jej numer id a następnie
5. wpisać w polach "Tytuł książki do usunięcia" oraz "ID książki do usunięcia" a następnie należy
kliknąc przycisk "Usuń książkę".
6. Aby zapisać aktualny stan zbioru książek, należy kliknąć przycisk "Zapisz do CSV",
program ma dodatkowo wbudowaną funkcję zapisywania zbioru przed wyłączeniem programu, oraz automatyczny
zapis po dodaniu każdej książki.

### Wymagania wstępne

Aby uruchomić aplikację, potrzebujesz:
- Zainstalowanego środowiska Java Runtime Environment (JRE) w wersji 8 lub nowszej.
- System operacujny potrafiący uruchomić plik JAR

### Uruchomienie aplikacji

Aby uruchomić aplikację, wykonaj poniższe kroki:
1. Uruchomić w konsoli plik AplikacjaGUI.java lub: 
2. Pobierz plik JAR aplikacji `ZarzadzanieKsiazkami.jar`.
2. Otwórz terminal lub wiersz poleceń.
3. Przejdź do katalogu, w którym znajduje się pobrany plik JAR.
4. Uruchom aplikację, wpisując polecenie: `java -jar ZarzadzanieKsiazkami.jar`.
5. Plik Jar można też uruchomić bezposrednio w windows jesli ma się zainstalowaną Javę.

## Autor

Projekt został stworzony przez [Krzysztof Zalewski / EvilCodeKZ].
Autor nie odpowiada za błędy programu i utratę bazy ze zbiorem książek.
Rozpowrzechnianie surowo zabronione , z wyłaczeniem terytorium Rosji,Chin i Korei Północnej.