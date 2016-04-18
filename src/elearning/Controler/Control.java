/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elearning.Controler;

import elearning.Model.JavaIO;
import elearning.Model.aplikasi;
import elearning.View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author iqbal
 */
public class Control implements ActionListener {
    AddAnggota aa;
    AddToKelas atk;
    CreateKelas ck;
    CreateTugas ct;
    DeleteAnggotaKelas dak;
    LoginDosen ld;
    LoginMhs lm;
    MenuAwal ma;
    MenuDosen md;
    MenuMhs mm;
    ShowKelas sk;
    ShowMahasiswa sm;
    ShowTugas st;
    Object view;
    JavaIO io;
    aplikasi app;
    String idDosen;
    String idMhs;
    
    
    public Control (aplikasi app){
        menuAwal();
        this.app=app;
        io = new JavaIO(app);
        app=io.app();
    }
    
    public void addAnggota(){
        aa= new AddAnggota();
        aa.actionListener(this);
        aa.setVisible(true);
        view=aa;
    }
    
    public void addToKelas(){
        atk= new AddToKelas();
        atk.actionListener(this);
        atk.setVisible(true);
        view=atk;
    }
   
    public void createKelas(){
        ck= new CreateKelas();
        ck.actionListener(this);
        ck.setVisible(true);
        view=ck;
    }
    
    public void createTugas(){
        ct= new CreateTugas();
        ct.actionListener(this);
        ct.setVisible(true);
        view=ct;
    }
    
    public void deleteAnggotaKelas(){
        dak= new DeleteAnggotaKelas();
        dak.actionListener(this);
        dak.setVisible(true);
        view=dak;
    }
    
    public void loginDosen(){
        ld= new LoginDosen();
        ld.actionListener(this);
        ld.setVisible(true);
        view=ld;
    }
    
    public void loginMhs(){
        lm= new LoginMhs();
        lm.actionListener(this);
        lm.setVisible(true);
        view=lm;
    }
    
    public void menuAwal(){
        ma= new MenuAwal();
        ma.actionListener(this);
        ma.setVisible(true);
        view=ma;
    }
    
    public void menuDosen(){
        md= new MenuDosen();
        md.actionListener(this);
        md.setVisible(true);
        view=md;
    }
    
    public void menuMhs(){
        mm= new MenuMhs();
        mm.actionListener(this);
        mm.setVisible(true);
        view=mm;
    }
    
    public void showMahasiswa(){
        sm= new ShowMahasiswa();
        sm.actionListener(this);
        sm.setVisible(true);
        view=sm;
    }
    
    public void showKelas(){
        sk= new ShowKelas();
        sk.actionListener(this);
        sk.setVisible(true);
        view=sk;
    }
    
    public void showTugas(){
        st= new ShowTugas();
        st.actionListener(this);
        st.setVisible(true);
        view=st;
        for (int i = 0 ; i <10 ; i++){
            st.getTShowTugas().setValueAt(app.showTugas(idMhs), i, i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (view instanceof MenuAwal){
            if (source.equals(ma.getBtnMenuDosen())){
                loginDosen();
                ma.dispose();
            }else if (source.equals(ma.getBtnMenuMhs())){
                loginMhs();
                ma.dispose();
            }
        }else if(view instanceof LoginDosen){
            if (source.equals(ld.getBtnLogin())){
                io.readFileDosen();
                idDosen = ld.getTextIdDosen();
                if (app.loginDosen(ld.getTextNamaDosen(),idDosen)){
                    menuDosen();
                    ld.dispose();
                }
            }else if (source.equals(ld.getBtnBack())){
                menuAwal();
                ld.dispose();
            }
        }else if (view instanceof LoginMhs){
            if (source.equals(lm.getBtnLogin())){
                io.readFileDosen();
                idMhs = lm.getTextIdMhs();
                if (app.loginMhs(lm.getTextNamaMhs(),idMhs )){
                    menuMhs();
                    lm.dispose();
                }
            } else if (source.equals(lm.getBtnBack())){
                menuAwal();
                lm.dispose();
            }
        }else if (view instanceof MenuDosen){
            if (source.equals(md.getBtnAddAnggota())){
                addAnggota();
                md.dispose();
            } else if (source.equals(md.getBtnCreateKelas())){
                createKelas();
                md.dispose();
            }else if (source.equals(md.getBtnCreateTugas())){
                createTugas();
                md.dispose();
            }else if (source.equals(md.getBtnDeleteAnggotaKelas())){
                deleteAnggotaKelas();
                md.dispose();
            }else if (source.equals(md.getBtnLogout())){
                menuAwal();
                md.dispose();
            }else if (source.equals(md.getBtnShowKelas())){
                showKelas();
                md.dispose();
            }else if (source.equals(md.getBtnShowMahasiswa())){
                showMahasiswa();
                md.dispose();
            }
        }else if (view instanceof AddAnggota){
            if (source.equals(aa.getBtnAdd())){
                io.readFileDosen();
                app.addAnggota(aa.getTextIdMhs(), aa.getTextIdMhs(), idDosen);
                io.saveFileDosen();
                menuDosen();
                aa.dispose();
            } else if (source.equals(aa.getBtnBack())){
                menuDosen();
                aa.dispose();
            }
        }else if (view instanceof CreateKelas){
            if (source.equals(ck.getBtnAdd())){
                io.readFileDosen();
                app.createKelas(ck.getTextKelas(), idDosen);
                io.saveFileDosen();
                menuDosen();
                ck.dispose();
            } else if (source.equals(ck.getBtnBack())){
                menuDosen();
                ck.dispose();
            }
        }else if (view instanceof CreateTugas){
            if (source.equals(ct.getBtnCreate())){
                io.readFileDosen();
                app.createTugas(ct.getTextTugas(), ct.getTextKelas(), idDosen);
                io.saveFileDosen();
                menuDosen();
                ct.dispose();
            } else if (source.equals(ct.getBtnBack())){
                menuDosen();
                ct.dispose();
            }
        }else if (view instanceof DeleteAnggotaKelas){
            if (source.equals(dak.getBtnDelete())){
                io.readFileDosen();
                app.deleteAnggota(dak.getTextIdMhs(), dak.getTextKelas(), idDosen);
                io.saveFileDosen();
                menuDosen();
                dak.dispose();
            } else if (source.equals(dak.getBtnBack())){
                menuDosen();
                dak.dispose();
            }
        }else if (view instanceof ShowKelas){
            if (source.equals(sk.getBtnBack())){
                menuDosen();
                sk.dispose();
            } 
        }else if (view instanceof ShowMahasiswa){
            if (source.equals(sm.getBtnBack())){
                menuDosen();
                sm.dispose();
            } 
        }
        
        
        else if (view instanceof MenuMhs){
            if (source.equals(mm.getBtnAddToKelas())){
                addToKelas();
                mm.dispose();
            } else if (source.equals(mm.getBtnShowTugas())){
                
                showTugas();
                mm.dispose();
            }else if (source.equals(mm.getBtnLogout())){
                menuAwal();
                mm.dispose();
            }
        }else if (view instanceof AddToKelas){
            if (source.equals(atk.getBtnAdd())){
                io.readFileDosen();
                app.addToKelas(atk.getTextKelas(), atk.getTextMakul(), idMhs);
                io.saveFileDosen();
                menuMhs();
                atk.dispose();
            } else if (source.equals(atk.getBtnBack())){
                menuMhs();
                atk.dispose();
            }
        }else if (view instanceof ShowTugas){
            if (source.equals(st.getBtnBack())){
                menuMhs();
                st.dispose();
            }
        }
    }
}
