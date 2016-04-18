/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elearning.Model;

import java.util.ArrayList;

/**
 *
 * @author iqbal
 */
public class Dosen extends Orang{
    private String matakuliah;
    ArrayList<Kelas> daftarKelas = new ArrayList();
    
    Matakuliah makul = new Matakuliah(matakuliah);
    
    public Dosen(String nama, String id, String jurusan, String matakuliah) {
        super(nama, id, jurusan);
        this.matakuliah = matakuliah;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
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
    
    public void createKelas (String kls,Matakuliah makul){
        Kelas k = new Kelas(kls,makul);
        daftarKelas.add(k);
    }
    
    public ArrayList<Kelas> getAllKelas (){
        return daftarKelas;
    }
    
    public Kelas getKelasByIndeks(int indeks){
        return daftarKelas.get(indeks);
    }
    
}
