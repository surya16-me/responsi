/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.controller;

/**
 *
 * @author Lenovo
 */
import java.util.List;
import javax.swing.JOptionPane;
import perpustakaan.DAO.daoPerpustakaan;
import perpustakaan.DAOimplement.implementPerpustakaan;
import perpustakaan.model.perpustakaan;
import perpustakaan.model.tableModelPerpustakaan;
import perpustakaan.view.MainView;
public class controllerPerpustakaan {
    MainView frame;
    implementPerpustakaan implPerpustakaan;
    List<perpustakaan> lb;
    
    public controllerPerpustakaan(MainView frame){
        this.frame = frame;
        implPerpustakaan = new daoPerpustakaan();
        lb = implPerpustakaan.getALL();
    }
    public void isiTabel(){
        lb = implPerpustakaan.getALL();
        tableModelPerpustakaan mp = new tableModelPerpustakaan(lb);
        frame.getTabeldata().setModel(mp);
    }
    public void reset(){
        frame.getTxtid().setText("");
        frame.getTxtjudul().setText("");
        frame.getTxtgenre().setText("");
        frame.getTxtpenulis().setText("");
        frame.getTxtpenerbit().setText("");
        frame.getTxtlokasi().setText("");
        frame.getTxtstock().setText("");
        
    }
    public void isiField(int row){
        frame.getTxtid().setText(lb.get(row).getId().toString());
        frame.getTxtjudul().setText(lb.get(row).getJudul());
        frame.getTxtgenre().setText(lb.get(row).getGenre());
        frame.getTxtpenulis().setText(lb.get(row).getPenulis());
        frame.getTxtpenerbit().setText(lb.get(row).getPenerbit());
        frame.getTxtlokasi().setText(lb.get(row).getLokasi());
        frame.getTxtstock().setText(lb.get(row).getStock());
    }
    public void insert(){
        if(!frame.getTxtjudul().getText().trim().isEmpty()& !frame.getTxtgenre().getText().trim().isEmpty()& !frame.getTxtpenulis().getText().trim().isEmpty()& !frame.getTxtpenerbit().getText().trim().isEmpty()& !frame.getTxtlokasi().getText().trim().isEmpty()& !frame.getTxtstock().getText().trim().isEmpty()){
            perpustakaan p = new perpustakaan();
            p.setJudul(frame.getTxtjudul().getText());
            p.setGenre(frame.getTxtgenre().getText());
            p.setPenulis(frame.getTxtpenulis().getText());
            p.setPenerbit(frame.getTxtpenerbit().getText());
            p.setLokasi(frame.getTxtlokasi().getText());
            p.setStock(frame.getTxtstock().getText());
            implPerpustakaan.insert(p);
        }else{
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
        
    }
    public void update(){
        if(!frame.getTxtjudul().getText().trim().isEmpty()& !frame.getTxtgenre().getText().trim().isEmpty()& !frame.getTxtpenulis().getText().trim().isEmpty()& !frame.getTxtpenerbit().getText().trim().isEmpty()& !frame.getTxtlokasi().getText().trim().isEmpty()& !frame.getTxtstock().getText().trim().isEmpty()){
            perpustakaan p = new perpustakaan();
            p.setJudul(frame.getTxtjudul().getText());
            p.setGenre(frame.getTxtgenre().getText());
            p.setPenulis(frame.getTxtpenulis().getText());
            p.setPenerbit(frame.getTxtpenerbit().getText());
            p.setLokasi(frame.getTxtlokasi().getText());
            p.setStock(frame.getTxtstock().getText());
            p.setId(Integer.parseInt(frame.getTxtid().getText()));
            implPerpustakaan.update(p);
        
        }else{
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }
    public void delete(){
        if (!frame.getTxtid().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtid().getText());
            implPerpustakaan.delete(id);
           
            JOptionPane.showMessageDialog(null, "Hapus Data  sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
        }
    
    public void isiTableCariNama() {
        lb = implPerpustakaan.getCarijudul(frame.getTxtcarijudul().getText());
        tableModelPerpustakaan tmb = new tableModelPerpustakaan(lb);
        frame.getTabeldata().setModel(tmb);
    }

    public void carinama() {
        if (!frame.getTxtcarijudul().getText().trim().isEmpty()) {
            implPerpustakaan.getCarijudul(frame.getTxtcarijudul().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
    
    
}
