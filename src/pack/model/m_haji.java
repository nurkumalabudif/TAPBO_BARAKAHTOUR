/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.model;

/**
 *
 * @author MALBUF
 */
public class m_haji {
    public String Nama_Jamaah, Jenis_Pelayanan, Lama_Hari, Kategori; 
    public String Id_Jamaah; 

    public String getkode() 
    { 
        return Id_Jamaah; 
    } 
    public String getnama() 
    { 
        return Nama_Jamaah; 
    } 
    public String getkategori()  
    { 
        return Kategori; 
    } 

    public String getjenis() 
    { 
        return Jenis_Pelayanan; 
    } 
    public String getharga() 
    { 
        return Lama_Hari; 
    } 

    //method set  
    public void setkode(String kode) 
    { 
        this.Id_Jamaah= kode; 
    } 
    public void setnama(String nama) 
    { 
        this.Nama_Jamaah= nama; 
    } 
    public void setkategori(String kategori)  
    { 
        this.Kategori=kategori; 
    } 
    public void setjenis(String jenis) 
    { 
        this.Jenis_Pelayanan= jenis; 
    } 
    public void setharga(String harga) 
    { 
        this.Lama_Hari= harga; 
    }  
  
}
