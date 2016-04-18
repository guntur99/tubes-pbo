/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elearning.Controler;
import elearning.Model.JavaIO;
import elearning.Model.Matakuliah;
import elearning.Model.Mahasiswa;
import elearning.Model.aplikasi;
import java.util.*;
/**
 *
 * @author iqbal
 */
public class ConsoleUI {
    
    String idDosen;
    String idMhs;
    
    Scanner filterString = new Scanner (System.in);
    Scanner inputString = new Scanner (System.in);
    Scanner filterChar = new Scanner (System.in);
    Scanner filterNum = new Scanner (System.in);
    aplikasi app;
    JavaIO io;
    
    
    
    
    public ConsoleUI(aplikasi app, JavaIO io){
        this.app = app;
        this.io = io;
    }
    
    public void data(){
        app.addDosen("Andika","1","S1 Teknik Informatika","Kalkulus");
        app.addDosen("Hambali", "2", "S1 Teknik Informatika", "DAP");
        app.addDosen("Husein", "3", "S1 Teknik Informatika", "ASD");
        app.addDosen("Bambang", "4", "S1 Teknik Informatika", "Matdis");
        app.addMatakuliah("DAP");
        app.addMatakuliah("ASD");
        app.addMatakuliah("Matdis");
        
        app.getDosenById("1").createKelas("IF 38 01", new Matakuliah(app.getDosenById("1").getMatakuliah()));
        app.getDosenById("1").createKelas("IF 38 02", new Matakuliah(app.getDosenById("1").getMatakuliah()));
        app.getDosenById("1").createKelas("IF 38 03", new Matakuliah(app.getDosenById("1").getMatakuliah()));
        
        app.getDosenById("2").createKelas("IF 38 01", new Matakuliah(app.getDosenById("2").getMatakuliah()));
        app.getDosenById("2").createKelas("IF 38 02", new Matakuliah(app.getDosenById("2").getMatakuliah()));
        app.getDosenById("2").createKelas("IF 38 04", new Matakuliah(app.getDosenById("2").getMatakuliah()));
        
        app.getDosenById("3").createKelas("IF 38 02", new Matakuliah(app.getDosenById("3").getMatakuliah()));
        app.getDosenById("3").createKelas("IF 38 03", new Matakuliah(app.getDosenById("3").getMatakuliah()));
        app.getDosenById("3").createKelas("IF 38 04", new Matakuliah(app.getDosenById("3").getMatakuliah()));
        
        app.addAnggotaByKelas(new Mahasiswa ("Guntur","1301141032","S1 Teknik Informatika","IF 38 03"));
        app.addMahasiswa("Guntur","1301141032","S1 Teknik Informatika","IF 38 03");
        app.addAnggotaByKelas(new Mahasiswa ("Manda","1301140062","S1 Teknik Informatika","IF 38 02"));
        app.addMahasiswa("Manda","1301140062","S1 Teknik Informatika","IF 38 02");
        app.addAnggotaByKelas(new Mahasiswa ("Iqbal","1301144052","S1 Teknik Informatika","IF 38 01"));
        app.addMahasiswa("Iqbal","1301144052","S1 Teknik Informatika","IF 38 01");
        app.addAnggotaByKelas(new Mahasiswa ("Rizky","13011441023","S1 Teknik Informatika","IF 38 01"));
        app.addMahasiswa("Rizky","13011441023","S1 Teknik Informatika","IF 38 01");
        app.addAnggotaByKelas(new Mahasiswa ("Dede","13011441022","S1 Teknik Informatika","IF 38 02"));
        app.addMahasiswa("Dede","13011441022","S1 Teknik Informatika","IF 38 02");
        app.addAnggotaByKelas(new Mahasiswa ("Thoriq","1301132045","S1 Teknik Informatika","IF 38 03"));
        app.addMahasiswa("Thoriq","1301132045","S1 Teknik Informatika","IF 38 03");
        app.addAnggotaByKelas(new Mahasiswa ("Haqi","1301132056","S1 Teknik Informatika","IF 38 04"));
        app.addMahasiswa("Haqi","1301132056","S1 Teknik Informatika","IF 38 04");
        
        io.saveFileDosen();
        io.saveFileMhs();
        io.saveFileMakul();
        
        
    }
    
    private void pressAnyKeyToContinue(){
        System.out.println("Tekan apa saja untuk melanjutkan...");
        try{
            System.in.read();
        }catch(Exception e){
            
        }
    }
    
    
    
    public void menuAwal (){
        System.out.println("E-Learning");
        System.out.println("=================");
        System.out.println("1. Menu Dosen ");
        System.out.println("2. Menu Mahasiswa");
        System.out.println("0. keluar ");
        System.out.println("=================");
        System.out.print("Pilih : ");
        int pilMenuAwal = filterNum.nextInt();
        
        switch (pilMenuAwal){
            case 1 :
                menuLoginDosen();
                break;
            case 2 :
                loginMhs();
                break;
            case 0 :
                break;
            default :
                System.out.println("Pilihan salah");
                menuAwal();
        }
        
        
        
    }
    
    public void menuLoginDosen (){
        
        System.out.println("Login Dosen");
        System.out.println("=================");
        System.out.print("Nama : ");
        String nama = filterString.nextLine();
        System.out.print("Id   : ");
        idDosen = filterString.nextLine();
        boolean x = app.loginDosen(nama, idDosen);
        if (x == true){
            menuDosen();
        }else{
            System.out.println("Akun Tidak Tercantum");
            menuAwal();
        }
        
        
    }
    
    public void menuDosen(){
        int pilMenuDosen = 0;
        do{
            System.out.println("Menu Dosen");
            System.out.println("========================");
            System.out.println("1. add anggota kelas ");
            System.out.println("2. create kelas");
            System.out.println("3. delete anggota kelas");
            System.out.println("4. create tugas");
            System.out.println("5. show kelas");
            System.out.println("6. show mahasiswa");
            System.out.println("0. logout");
            System.out.println("========================");
            System.out.print("Pilih : ");
            pilMenuDosen = filterNum.nextInt();
            
            switch (pilMenuDosen){
                case 1 : 
                    System.out.println("add anggota kelas");
                    System.out.println("===================");
                    System.out.print("id    : ");
                    String idMhsD = filterString.nextLine();
                    System.out.print("Kelas : ");
                    String klsD = filterString.nextLine();
                    app.addAnggota(idMhsD, klsD, idDosen);
                    io.saveFileDosen();
                    break;
                case 2 :
                    System.out.println("create kelas");
                    System.out.println("=================");
                    System.out.print("nama kelas : ");
                    String namaKelas = filterString.nextLine();
                    app.createKelas(namaKelas, idDosen);
                    io.saveFileDosen();
                    break;
                case 3 :
                    System.out.println("delete anggota kelas");
                    System.out.println("====================");
                    System.out.print("id mahasiswa : ");
                    String id = filterString.nextLine();
                    System.out.print("kelas        : ");
                    String kelas = filterString.nextLine();
                    app.deleteAnggota(id, kelas, idDosen);
                    io.saveFileDosen();
                    break;
                case 4 :
                    System.out.println("create tugas");
                    System.out.println("=================");
                    System.out.print("nama tugas : ");
                    String namaTugas = filterString.nextLine();
                    System.out.print("kelas      : ");
                    kelas = filterString.nextLine();
                    app.createTugas(namaTugas, kelas, idDosen);
                    io.saveFileDosen();
                    break;
                case 5 :
                    System.out.println("show kelas");
                    System.out.println("============");
                    io.readFileDosen();
                    System.out.println(app.getKelasByDosen(idDosen));
                    System.out.println("============");
                    pressAnyKeyToContinue();
                    break;
                    
                case 6 :
                    System.out.println("show anggota");
                    System.out.println("============");
                    io.readFileDosen();
                    app.getMhsByDosen(idDosen);
                    System.out.println("============");
                    pressAnyKeyToContinue();
                    break;
                    
                    
            }
        }while(pilMenuDosen != 0);
        
        menuAwal();
    }
    
    public void loginMhs(){
        System.out.println("login mahasiswa");
        System.out.println("=================");
        System.out.print("Nama : ");
        String nama = filterString.nextLine();
        System.out.print("Id   : ");
        idMhs = filterString.nextLine();
        boolean x = app.loginMhs(nama, idMhs);
        if (x){
            menuMhs();
        }else{
            System.out.println("Akun Tidak Tercantum");
            menuAwal();
        }
    }
    
    public void menuMhs(){
        int pilMenuMhs = 0;
        do{
        System.out.println("menu mahasiswa");
        System.out.println("=================");
        System.out.println("1. add to kelas");
        System.out.println("2. show tugas");
        System.out.println("0. logout");
        System.out.println("=================");
        System.out.print("pilih : ");
        pilMenuMhs = filterString.nextInt();
        
        switch (pilMenuMhs){
            case 1 :
                System.out.println("add to kelas");
                System.out.println("===============");
                io.readFileDosen();
                app.daftarKelas();
                System.out.println("===============");
                System.out.println("===============");
                String y = filterString.nextLine();
                System.out.print ("Pilih Matakuliah: ");
                String mk = filterString.nextLine();
                System.out.print("kelas           :");
                String kls = inputString.nextLine();
                app.addToKelas(kls,mk,idMhs);
                io.saveFileDosen();
                System.out.println("Berhasil");
                break;
            case 2 :
                System.out.println("show tugas");
                System.out.println("=============");
                io.readFileDosen();
                System.out.println(app.showTugas(idMhs));
                System.out.println("=============");
                break;
            default :
                System.out.println("inputan SALAH");
                break;
        }
        }while(pilMenuMhs != 0);
        menuAwal();
        
        
    }
   
  
}
    
    
    
    
    
    

