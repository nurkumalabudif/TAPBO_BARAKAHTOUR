/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;
import java.util.List; 
import pack.model.m_haji; 
/**
 *
 * @author MALBUF
 */
public interface implementHaji {
    public void TampilData(m_haji a); 
    public void UbahData(m_haji a); 
    public void SimpanData(m_haji a); 
    public void HapusData(String kode); 
    public List<m_haji> getCariKategori(String kategori); 
    public List<m_haji> getAll();
}
