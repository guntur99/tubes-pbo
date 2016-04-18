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
public class Mahasiswa extends Orang {
    private String kelas;
    
    public Mahasiswa(String nama, String id, String jurusan,String kelas) {
        super(nama, id, jurusan);
        this.kelas = kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKelas() {
        return kelas;
    }

    @Override
    public void setNama(String nama) {
        super.setNama(nama); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(String id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setJurusan(String jurusan) {
        super.setJurusan(jurusan); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNama() {
        return super.getNama(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJurusan() {
        return super.getJurusan(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
