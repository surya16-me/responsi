/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.DAO;

/**
 *
 * @author Lenovo
 */
import perpustakaan.koneksi.koneksi;
import perpustakaan.model.perpustakaan;
import perpustakaan.DAOimplement.implementPerpustakaan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class daoPerpustakaan implements implementPerpustakaan{

   Connection connection;
   final String insert = "insert into dataperpus(judul, genre, penulis, penerbit, lokasi, stock) values (?,?,?,?,?,?);";
   final String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?;";
   final String delete = "delete from dataperpus where id=?;";
   final String select = "select * from dataperpus;";
   final String cari = "select * from dataperpus where judul like ?;";
   
   public daoPerpustakaan(){
       connection = koneksi.connection();
   }
   public void insert(perpustakaan p){
       PreparedStatement statement = null;
       try{
           statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, p.getJudul());
           statement.setString(2, p.getGenre());
           statement.setString(3, p.getPenulis());
           statement.setString(4, p.getPenerbit());
           statement.setString(5, p.getLokasi());
           statement.setString(6, p.getStock());
           statement.executeUpdate();
           ResultSet rs = statement.getGeneratedKeys();
           while(rs.next()){
               p.setId(rs.getInt(1));
           }
       }catch(SQLException ex){
           ex.printStackTrace();
       } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
       }
    }
    public void update(perpustakaan p){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setString(6, p.getStock());
            statement.setInt(7, p.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void delete(int id){
       PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
   }
    public List<perpustakaan> getALL(){
        List<perpustakaan>lb = null;
        try{
            lb = new ArrayList<perpustakaan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                perpustakaan p = new perpustakaan();
                p.setId(rs.getInt("id"));
                p.setJudul(rs.getString("judul"));
                p.setGenre(rs.getString("genre"));
                p.setPenulis(rs.getString("penulis"));
                p.setPenerbit(rs.getString("penerbit"));
                p.setLokasi(rs.getString("lokasi"));
                p.setStock(rs.getString("stock"));
                lb.add(p);
            }
        }catch (SQLException ex) {
            Logger.getLogger(daoPerpustakaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lb;
    }
    public List<perpustakaan> getCarijudul(String judul){
        List<perpustakaan>lb = null;
        try{
            lb = new ArrayList<perpustakaan>();
            PreparedStatement st = connection.prepareStatement(cari);
            st.setString(1,"%" + judul + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                perpustakaan p = new perpustakaan();
                p.setId(rs.getInt("id"));
                p.setJudul(rs.getString("judul"));
                p.setGenre(rs.getString("genre"));
                p.setPenulis(rs.getString("penulis"));
                p.setPenerbit(rs.getString("penerbit"));
                p.setLokasi(rs.getString("lokasi"));
                p.setStock(rs.getString("stock"));
                lb.add(p);
            }
        }catch (SQLException ex) {
            Logger.getLogger(daoPerpustakaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    return lb;
    }
}
