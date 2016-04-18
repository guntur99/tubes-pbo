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
public class Kelas {
    private String namaKelas;
    private Matakuliah matakuliah;
    ArrayList<Tugas> tugas = new ArrayList();
    ArrayList<Mahasiswa> anggota = new ArrayList();
    
    
    public Kelas(String namaKelas,Matakuliah makul) {
        this.namaKelas = namaKelas;
        this.matakuliah = makul;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public void addMahasiswa (Mahasiswa mhs){
        if (anggota.size() < 40) {
          anggota.add(mhs);
        }
        else System.out.println("Penuh!");
    }
    
    public ArrayList<Mahasiswa> getAllAnggota (){
        return anggota;
    }
    
    public Mahasiswa getMhsByIndeks (int indeks){
        return anggota.get(indeks);
    }
    
    public Mahasiswa getMhsById (String id){
        Mahasiswa m = null;
        for (int i = 0; i < getAllAnggota().size();i++){
            if (getMhsByIndeks(i).getId() == id){
                m = getMhsByIndeks(i);
            }
        }
        return m;
    }
    
    public void createTugas (String namaTugas){
        Tugas tugas = new Tugas(namaTugas);
        this.tugas.add(tugas);
    }
    
    public ArrayList<Tugas> getAllTugas (){
        return tugas;
    }
    
    public Tugas getTugasByIndeks (int indeks){
        return tugas.get(indeks);
    }
    
    
    
    
    
}
