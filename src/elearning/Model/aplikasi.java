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
public class aplikasi {
    private ArrayList<Dosen> daftarDosen = new ArrayList();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList();
    private ArrayList<Matakuliah> daftarMakul = new ArrayList();
    private Kelas kls;
    public aplikasi (){
        
    }

    public void setDaftarDosen(ArrayList<Dosen> daftarDosen) {
        this.daftarDosen = daftarDosen;
    }

    public void setDaftarMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    public void setDaftarMakul(ArrayList<Matakuliah> daftarMakul) {
        this.daftarMakul = daftarMakul;
    }
    

    public ArrayList<Dosen> getDaftarDosen() {
        return daftarDosen;
    }

    public ArrayList<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public ArrayList<Matakuliah> getDaftarMakul() {
        return daftarMakul;
    }
    
    
    
    
    public boolean loginDosen(String nama, String idDosen){
        boolean b = false;
        for (Dosen dosen : daftarDosen) {
            if (dosen.getId().equals(idDosen) ){
                if (dosen.getNama().equals(nama)){
                    b = true;
                }
            }
        }
        return b;
    }
    
    public boolean loginMhs(String nama,String idMhs){
        boolean b = false;
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getId().equals(idMhs)){
                if(mhs.getNama().equals(nama)){
                    b = true;
                }
            }
        }
        return b;
    }
    
    public void addAnggota (String idMhs,String kls,String idDosen){
        int x = 0;
        Mahasiswa m = null;
        for (Mahasiswa mhs : daftarMahasiswa) {
            if(mhs.getId().equals(idMhs)){
                x = 1;
                m = mhs;
            }
        }
        
        if(x == 1){
            Dosen d = getDosenById(idDosen);
            for (Kelas kelas : d.daftarKelas) {
                if (kelas.getNamaKelas().equals(kls)){
                    kelas.addMahasiswa(m);
                    System.out.println("add anggota BERHASIL");
                }
                
            }
        }else {
            System.out.println("Mahasiswa dengan id "+idMhs+" tidak di temukan");
        }
        
    }
    
    public void createKelas (String namaKelas, String idDosen){
        for (Dosen dosen : daftarDosen) {
            if (idDosen.equals(dosen.getId())){
                Matakuliah makul = new Matakuliah (dosen.getMatakuliah());
                dosen.createKelas(namaKelas,makul);
                System.out.println("create kelas BERHASIL");
            }
        }
    }
    
    public void deleteAnggota (String idMhs,String kelas,String idDosen){
        Dosen d = getDosenById(idDosen);
        int x = 0;
        for (Kelas kls : d.getAllKelas()) {
            if (kls.getNamaKelas().equals(kelas)){
                for (Mahasiswa m : kls.getAllAnggota()) {
                    if (m.getId().equals(idMhs)){
                        kls.getAllAnggota().remove(m);
                        System.out.println("delete mahasiswa "+ idMhs+" BERHASIL");
                        x = 1;
                    }
                }
            }
        }
        if (x == 0){
            System.out.println("delete mahasiswa "+ idMhs +" GAGAL");
        }
    }
    
    public void createTugas (String tugas, String kelas,String idDosen){
        for (Kelas kls : getDosenById(idDosen).getAllKelas()) {
            if (kelas.equals(kls.getNamaKelas())){
                kls.createTugas(tugas);
            }
        }
    }
    
     
    public void daftarKelas(){
        System.out.println("Daftar Kelas");
        System.out.println("===================");
        for (Dosen dosen : daftarDosen) {
                for (Kelas kls : dosen.daftarKelas) {
                    System.out.println(kls.getNamaKelas()+" "+kls.getMatakuliah().getNamaMatkul());
                }
        }
    
    }
    
    public void addToKelas (String kelas, String Mk, String idMhs){
        Mahasiswa mhs=null;
        for(Mahasiswa m : daftarMahasiswa){
            if(idMhs.equals(m.getId())){
                mhs=m;
            }
        }
        for (Dosen dosen : daftarDosen) {
            for (Kelas kls : dosen.daftarKelas) {
                if(kls.getNamaKelas().equals(kelas) && kls.getMatakuliah().getNamaMatkul().equals(Mk)){
                    kls.addMahasiswa(mhs);
                }
            }
            
        }
        
        
        
    }
    
    public String showTugas (String idMhs){
        
        for (Dosen dosen : daftarDosen) {
            for (Kelas kelas : dosen.getAllKelas()){
                for (Mahasiswa mhs : kelas.getAllAnggota()){
                    if (mhs.getId().equals(idMhs)){
                        for (Tugas tugas : kelas.getAllTugas()){
                            return (tugas.getNamaTugas());
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public String getKelasByDosen (String idDosen){
       
        for (Dosen dosen : daftarDosen) {
            if (dosen.getId().equals(idDosen)){
                for (Kelas kls : dosen.getAllKelas()) {
                    return (kls.getNamaKelas());
                }
            }
            
        }
        return null;
    }
    
    public void getMhsByDosen (String idDosen){
        for (Dosen dosen : daftarDosen) {
            if (dosen.getId().equals(idDosen)){
                for (Kelas kls : dosen.getAllKelas()) {
                    System.out.println("+++++++++++");
                    System.out.println(kls.getNamaKelas());
                    System.out.println("+++++++++++");
                    for (Mahasiswa mhs : kls.getAllAnggota()){
                        System.out.println(mhs.getNama());
                    }
                }
            }
            
        }
    }
    
    
     
    public void addDosen(String nama, String id, String jurusan,String matakuliah){
        daftarDosen.add(new Dosen (nama,id,jurusan,matakuliah));
    }
    
    public Dosen getDosenById (String id){
        Dosen d = null;
        for (Dosen dosen : daftarDosen) {
            if(dosen.getId().equals(id)) {
                d = dosen;
            }
        }
        return d;
    }
    
    public void addMahasiswa (String nama, String id, String jurusan,String kelas) {
        daftarMahasiswa.add(new Mahasiswa (nama,id,jurusan,kelas));
    }
    
    public void addAnggotaByKelas (Mahasiswa m){
        for (Dosen d : daftarDosen){
            for (Kelas kls : d.getAllKelas()){
                if (kls.getNamaKelas().equals(m.getKelas())){
                    kls.addMahasiswa(m);
                }
            }
        }
    }
        
    
    
    public Mahasiswa getMhsById (String id){
        for (Mahasiswa mhs : daftarMahasiswa) {
            if(mhs.getId().equals(id)) {
                return mhs;
            }
        }
        return null;
    }
    
    public void addMatakuliah (String namaMatkul){
        daftarMakul.add(new Matakuliah (namaMatkul));
    }
    
    
    
    public ArrayList<Dosen> getAllDosen (){
        return daftarDosen;
    }
    
    public Dosen getDosenByIndeks (int indeks) {
        return daftarDosen.get(indeks);
    }
    
    
    
    public void addMahasiswaByDosen (String id,String kelas,String idDosen){
        Mahasiswa mhs = null;
        int x= 0;
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getId().equals(id)){
                x = 1;
                mhs = m;
            }
        }
        if (x == 1){
            for (Dosen dosen : daftarDosen) {
                if (dosen.getId().equals(idDosen)){
                    for (Kelas kls : dosen.getAllKelas()) {
                        if (kls.getNamaKelas().equals(kelas)){
                            kls.addMahasiswa(mhs);
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Id Mahasiswa tidak diemukan");
        }
    }
    
    
    public Mahasiswa getMahasiswaByDosen (String idDosen,String idMahasiswa){
        Mahasiswa m = null;
        for (int i = 0; i < daftarDosen.size();i++){
            if (getDosenByIndeks(i).getId().equals(idDosen)){
                for (int n = 0; n < getDosenByIndeks(i).getAllKelas().size();n++){
                    for (int x = 0; x  < getDosenByIndeks(i).getKelasByIndeks(n).anggota.size();x++){
                        if (getDosenByIndeks(i).getKelasByIndeks(n).getMhsByIndeks(x).getId().equals(idMahasiswa)){
                            m = getDosenByIndeks(i).getKelasByIndeks(n).getMhsByIndeks(x);
                        }
                        
                    }
                }
            }
        }
        return m;
    }
    
    public void deleteMahasiswaByIdByDosen (String idDosen,String idMahasiswa){
        for (int i = 0; i < daftarDosen.size();i++){
            if (getDosenByIndeks(i).getId().equals(idDosen)){
                for (int n = 0; n < getDosenByIndeks(i).getAllKelas().size();n++){
                    for (int x = 0; x  < getDosenByIndeks(i).getKelasByIndeks(n).anggota.size();x++){
                        if (getDosenByIndeks(i).getKelasByIndeks(n).getMhsByIndeks(x).getId().equals(idMahasiswa)){
                            getDosenByIndeks(i).getKelasByIndeks(n).getAllAnggota().remove(x);
                        }
                        
                    }
                }
            }
        }
    }
    
    public void addKelas (String idDosen, Kelas kelas){
        int x = 0;
        for (int i = 0; i < daftarDosen.size();i++){
            if (getDosenByIndeks(i).getId().equals(idDosen)){
                getDosenByIndeks(i).getAllKelas().add(kelas);
            }
        }
    }
    
    public void deleteKelasByNama (){
        
    }
    
    
}
