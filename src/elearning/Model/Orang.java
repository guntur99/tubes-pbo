/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elearning.Model;

/**
 *
 * @author iqbal
 */
public abstract class Orang {
    private String nama;
    private String id;
    private String jurusan;
    
    public Orang (String nama, String id, String jurusan){
        this.nama = nama;
        this.id = id;
        this.jurusan = jurusan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }

    public String getJurusan() {
        return jurusan;
    }
    
    
    
}
