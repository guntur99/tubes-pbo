/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elearning.Model;
import elearning.Model.Matakuliah;
import elearning.Model.Dosen;
import elearning.Model.Mahasiswa;
import elearning.Model.aplikasi;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author iqbal
 */
public class JavaIO {
    aplikasi app;
    public JavaIO(aplikasi app){
        this.app = app;
    }
    
    public void saveFileDosen(){
        try(FileOutputStream fouts = new FileOutputStream("Dosen.txt")){
            ObjectOutputStream oouts = new ObjectOutputStream(fouts);
            oouts.writeObject(app.getDaftarDosen());
            oouts.flush();
        }catch(Exception e){
            
        }
    }
    
    public void readFileDosen(){
        try(ObjectInputStream oist = new ObjectInputStream(new FileInputStream("Dosen.txt"))){
            app.setDaftarDosen((ArrayList<Dosen>) oist.readObject());
            oist.close();
        }catch(Exception e){
            
        }
    }
    
    public void saveFileMhs(){
        try(FileOutputStream fouts = new FileOutputStream("Mahasiswa.txt")){
            ObjectOutputStream oouts = new ObjectOutputStream(fouts);
            oouts.writeObject(app.getDaftarMahasiswa());
            oouts.flush();
        }catch(Exception e){
            
        }
    }
    
    public void readFileMhs(){
        try(ObjectInputStream oist = new ObjectInputStream(new FileInputStream("Mahasiswa.txt"))){
            app.setDaftarMahasiswa((ArrayList<Mahasiswa>) oist.readObject());
            oist.close();
        }catch(Exception e){
            
        }
    }
    
    public void saveFileMakul(){
        try(FileOutputStream fouts = new FileOutputStream("Matakuliah.txt")){
            ObjectOutputStream oouts = new ObjectOutputStream(fouts);
            oouts.writeObject(app.getDaftarMakul());
            oouts.flush();
        }catch(Exception e){
            
        }
    }
    
    public void readFileMakul(){
        try(ObjectInputStream oist = new ObjectInputStream(new FileInputStream("Matakuliah.txt"))){
            app.setDaftarMakul((ArrayList<Matakuliah>) oist.readObject());
            oist.close();
        }catch(Exception e){
            
        }
    }
    
    public aplikasi app(){
        return app;
    }
    
}
