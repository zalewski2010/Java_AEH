package ksiegarnia;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class KsiazkiTableModel extends AbstractTableModel {
    private List<Ksiazka> ksiazki;
    private final String[] columnNames = {"ID", "Tytuł", "Autor", "Rok wydania", "Gatunek"};

    public KsiazkiTableModel(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
        fireTableDataChanged(); // Informuje model, że dane zostały zmienione
    }

    @Override
    public int getRowCount() {
        return ksiazki.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ksiazka ksiazka = ksiazki.get(rowIndex);
        switch (columnIndex) {
            case 0: return ksiazka.getId();
            case 1: return ksiazka.getTytul();
            case 2: return ksiazka.getAutor();
            case 3: return ksiazka.getRokWydania();
            case 4: return ksiazka.getGatunek();
            default: return null;
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Integer.class; // Dla kolumny ID zwracam klasę Integer, inaczej nie posortuje numerycznie
            case 3: return Integer.class; // Rok wydania również traktowany jako integer
            default: return String.class; // Dla pozostałych kolumn używam String
        }
    }
}
