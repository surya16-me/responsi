/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.model;

/**
 *
 * @author Lenovo
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class tableModelPerpustakaan extends AbstractTableModel{
    
    List<perpustakaan>lb;
    public tableModelPerpustakaan(List<perpustakaan>lb){
        this.lb=lb;
    }

    @Override
    public int getRowCount() {
        return lb.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "id";
            case 1:
                return "judul";
            case 2:
                return "genre";
            case 3:
                return "penulis";
            case 4:
                return "penerbit";
            case 5:
                return "lokasi";
            case 6:
                return "stock";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getJudul();
            case 2:
                return lb.get(row).getGenre();
            case 3:
                return lb.get(row).getPenulis();
            case 4:
                return lb.get(row).getPenerbit();
            case 5:
                return lb.get(row).getLokasi();
            case 6: 
                return lb.get(row).getStock();
            default:
                return null;
        }
    }
    
    
}
