/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import pack.control.c_koneksi; 
import pack.model.m_haji; 
/**
 *
 * @author MALBUF
 */
public class daoHaji implements implementHaji{
     Connection connection; 
    public String TampilData = "SELECT * FROM `datajamaah`"; 
    public String UbahData = "UPDATE `barang` SET `Nama_Jamaah`=?, `Lama_Hari`=?, `Kategori`=?, `Jenis_Pelayanan`=? Where `Id_Jamaah`=?;"; 
    public String SimpanData = "INSERT INTO `datajamaah` VALUES (?, ?, ?, ?, ?)"; 
    public String HapusData = "DELETE FROM `datajamaah` WHERE Id_Jamaah=?"; 
    public String CariKategori = "SELECT `Id_Jamaah`, `Nama_Jamaah`, `Kategori`, `Jenis_Pelayanan`, `Lama_Hari` FROM `Id_Jamaah` WHERE Kategori like ?"; 
    public daoHaji(){ 
        connection = c_koneksi.setKoneksi(); 
    } 
     
    @Override 
    public void TampilData(m_haji a) { 
         
    } 
 
    @Override 
    public void UbahData(m_haji a) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(UbahData); 
        statement.setString(5, a.getkode()); 
        statement.setString(1, a.getnama()); 
        statement.setString(2, a.getharga()); 
        statement.setString(3, a.getkategori()); 
        statement.setString(4, a.getjenis()); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) { 
            
        Logger.getLogger(daoHaji.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
 
    @Override 
    public void SimpanData(m_haji a) { 
        PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(SimpanData); 
        statement.setString(1, a.getkode()); 
        statement.setString(2, a.getnama()); 
        statement.setString(3, a.getkategori()); 
        statement.setString(4, a.getjenis()); 
        statement.setString(5, a.getharga()); 
        statement.executeUpdate(); 
        ResultSet rs = statement.getGeneratedKeys(); 
        while (rs.next()){ 
            a.setkode(rs.getString(1)); 
        } 
    }   catch (SQLException ex) { 
            
    Logger.getLogger(daoHaji.class.getName()).log(Level.SEVERE, null, ex); 
        } 
         
    } 
 
//menampilkan data ke tabel sesuai pencarian 
    @Override 
    public List<m_haji> getCariKategori(String kategori) { 
    List<m_haji> lt=null; 
    try { 
        lt = new ArrayList<m_haji>();  
        PreparedStatement st=connection.prepareStatement(CariKategori); 
        st.setString(1, "%"+kategori+"%"); 
        ResultSet rs = st.executeQuery(); 
        while (rs.next()){ 
            m_haji toko = new m_haji(); 
            toko.setkode(rs.getString("Kode_Barang")); 
            toko.setnama(rs.getString("Nama_Barang")); 
            toko.setkategori(rs.getString("Kategori")); 
            toko.setjenis(rs.getString("Jenis")); 
            toko.setharga(rs.getString("Harga")); 
            lt.add(toko); 
    } 
    }   catch (SQLException ex) { 
            
        Logger.getLogger(daoHaji.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    return lt; 
    } 
    //menampilkan data ke Tabel 
    @Override 
    public List<m_haji> getAll() { 
    List<m_haji> lt=null; 
    try { 
        lt = new ArrayList<m_haji>(); 
        Statement st = connection.createStatement(); 
        ResultSet rs = st.executeQuery(TampilData); 
        while (rs.next()){ 
            m_haji toko = new m_haji(); 
            toko.setkode(rs.getString("Kode_Barang")); 
            toko.setnama(rs.getString("Nama_Barang")); 
            toko.setkategori(rs.getString("Kategori")); 
            toko.setjenis(rs.getString("Jenis")); 
            toko.setharga(rs.getString("Harga")); 
            lt.add(toko); 
    } 
    }   catch (SQLException ex) { 
            
        Logger.getLogger(daoHaji.class.getName()).log(Level.SEVERE, null, ex); 
        } 
   return lt; 
    }    
    //hapus data 
    @Override 
    public void HapusData(String kode) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(HapusData); 
        statement.setString(1, kode); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) { 
            
        Logger.getLogger(daoHaji.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
    //pencarian data 
    public void CariKategori(int kode) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(CariKategori); 
        statement.setInt(1, kode); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) { 
            
        Logger.getLogger(daoHaji.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
} 
