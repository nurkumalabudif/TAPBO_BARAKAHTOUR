/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.model; 
 
import java.util.List; 
import javax.swing.table.AbstractTableModel; 
 
/**
 *
 * @author MALBUF
 */
public class tableModelJamaah extends AbstractTableModel{
    
    List<m_haji>lt; 
    public tableModelJamaah(List<m_haji> lt) { 
    this.lt=lt; 
    } 
 
    @Override 
    public int getRowCount() { 
    return lt.size();  
    } 
 
    @Override 
    public int getColumnCount() { 
    return 5; 
    } 
    public String getColumnName(int column) { 
    switch (column){ 
        case 0: 
            return"Id_Jamaah"; 
        case 1: 
            return"Nama_Jamaah"; 
        case 2: 
            return"Kategori"; 
        case 3: 
            return"Jenis_Pelayanan"; 
        case 4: 
            return"Lama_Hari"; 
        default: 
            return null; 
    }} 
    @Override 
    public Object getValueAt(int row, int column) { 
    switch (column){ 
        case 0: 
            return lt.get(row).getkode(); 
        case 1: 
            return lt.get(row).getnama(); 
        case 2: 
            return lt.get(row).getkategori(); 
        case 3: 
            return lt.get(row).getjenis(); 
        case 4: 
            return lt.get(row).getharga(); 
        default: 
            return null; 
    }    
  }
}
