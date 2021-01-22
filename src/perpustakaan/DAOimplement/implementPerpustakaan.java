/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.DAOimplement;

/**
 *
 * @author Lenovo
 */
import java.util.List;
import perpustakaan.model.*;
public interface implementPerpustakaan {
    public void insert(perpustakaan p);
    public void update(perpustakaan p);
    
    public void delete(int id);
    public List<perpustakaan> getALL();
    public List<perpustakaan> getCarijudul(String judul);
}
