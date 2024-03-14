package ksiegarnia;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class AplikacjaGUI {
    private Biblioteka biblioteka = new Biblioteka();
    private JFrame frame;
    private JTextArea textArea;
    private JTextField wyszukiwanieTextField;
    private JTextField tytulTextField, autorTextField, rokTextField, gatunekTextField;
    private JTable table;
    private KsiazkiTableModel tableModel;

    public AplikacjaGUI() {
        przygotujGUI();
    }

    private void przygotujGUI() {
        frame = new JFrame("Zarządzanie książkami");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        tableModel = new KsiazkiTableModel(biblioteka.getKsiazki());
        table = new JTable(tableModel);

        // Włączenie sortowania
        table.setAutoCreateRowSorter(true);


        //textArea = new JTextArea(20, 50); bez tabeli
        //frame.add(new JScrollPane(textArea), BorderLayout.CENTER); bez tabeli

        JPanel panel = new JPanel(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.EAST);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);


        // Pole wyszukiwania
        wyszukiwanieTextField = new JTextField();
        panel.add(wyszukiwanieTextField);
        JButton wyszukajButton = new JButton("Wyszukaj");
        wyszukajButton.addActionListener(e -> wyszukajKsiazki());
        panel.add(wyszukajButton);

        // Pola do dodawania nowej książki
        tytulTextField = new JTextField();
        tytulTextField.setBorder(BorderFactory.createTitledBorder("Tytuł"));
        panel.add(tytulTextField);

        autorTextField = new JTextField();
        autorTextField.setBorder(BorderFactory.createTitledBorder("Autor"));
        panel.add(autorTextField);

        rokTextField = new JTextField();
        rokTextField.setBorder(BorderFactory.createTitledBorder("Rok Wydania"));
        panel.add(rokTextField);

        gatunekTextField = new JTextField();
        gatunekTextField.setBorder(BorderFactory.createTitledBorder("Gatunek"));
        panel.add(gatunekTextField);

        JButton dodajButton = new JButton("Dodaj książkę");
        dodajButton.addActionListener(e -> dodajKsiazke());
        panel.add(dodajButton);

        //  przycisk do wyswietlania wszystkich książek
        JButton wyswietlWszystkie = new JButton("Wyświetl wszystkie");
        wyswietlWszystkie.addActionListener(e -> wyswietlKsiazki());
        panel.add(wyswietlWszystkie);
        tableModel.fireTableDataChanged(); // Odświeżenie modelu tabeli

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JTextField tytulDoUsunieciaTextField = new JTextField();
        tytulDoUsunieciaTextField.setBorder(BorderFactory.createTitledBorder("Tytuł książki do usunięcia"));
        panel.add(tytulDoUsunieciaTextField);

        JTextField idDoUsunieciaTextField = new JTextField();
        idDoUsunieciaTextField.setBorder(BorderFactory.createTitledBorder("ID książki do usunięcia"));
        panel.add(idDoUsunieciaTextField);

        JButton usunButton = new JButton("Usuń książkę");
        usunButton.addActionListener(e -> usunKsiazkePoTytulueIId(tytulDoUsunieciaTextField.getText(), idDoUsunieciaTextField.getText()));
        panel.add(usunButton);

        JButton zapiszDoCsvButton = new JButton("Zapisz do CSV");
        zapiszDoCsvButton.addActionListener(e -> DataManager.zapiszKsiazkiDoPlikuCsv(biblioteka.getKsiazki(), "ksiazki.csv"));
        panel.add(zapiszDoCsvButton);

        // słuchacz zdarzeń okna, który zapisuje dane przed zamknięciem aplikacji
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DataManager.zapiszKsiazkiDoPlikuCsv(biblioteka.getKsiazki(), "ksiazki.csv");
                System.exit(0);
            }
        });

    }


    private void wyszukajKsiazki() {
        String wzorzec = wyszukiwanieTextField.getText();
        List<Ksiazka> znalezione = biblioteka.wyszukajKsiazki(wzorzec);
        tableModel.setKsiazki(znalezione); // pokazuje listę książek jako wynik wyszukiwania
    }

    private void dodajKsiazke() {
        try {
            String tytul = tytulTextField.getText();
            String autor = autorTextField.getText();
            int rok = Integer.parseInt(rokTextField.getText());
            String gatunek = gatunekTextField.getText();
            Ksiazka nowaKsiazka = new Ksiazka(tytul, autor, rok, gatunek);
            biblioteka.dodajKsiazke(nowaKsiazka);
            JOptionPane.showMessageDialog(frame, "Książka dodana pomyślnie!");
            // Odświeżenie modelu tabeli
            tableModel.fireTableDataChanged();
            // Czyszczenie pól tekstowych po dodaniu książki
            tytulTextField.setText("");
            autorTextField.setText("");
            rokTextField.setText("");
            gatunekTextField.setText("");

            // Zapisuję zaktualizowaną listę książek do pliku CSV
            DataManager.zapiszKsiazkiDoPlikuCsv(biblioteka.getKsiazki(), "ksiazki.csv");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Błąd przy dodawaniu książki. Sprawdź poprawność danych.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void usunKsiazkePoTytulueIId(String tytul, String idText) {
        try {
            int id = Integer.parseInt(idText);
            boolean usunieto = biblioteka.usunKsiazkePoTytulueIId(tytul, id);
            if (usunieto) {
                JOptionPane.showMessageDialog(frame, "Książka została usunięta.");
                //tableModel.fireTableDataChanged(); // Odświeżenie modelu tabeli
                wyswietlKsiazki(); // Odświeżenie listy książek w tabeli
            } else {
                JOptionPane.showMessageDialog(frame, "Nie znaleziono książki o podanym tytule i ID.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "ID musi być liczbą.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void wyswietlKsiazki() {
        tableModel = new KsiazkiTableModel(biblioteka.getKsiazki()); // Tworzenie nowego modelu z aktualną listą książek
        table.setModel(tableModel); // Ustawianie nowego modelu dla tabeli
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikacjaGUI();
            }
        });
    }
}
