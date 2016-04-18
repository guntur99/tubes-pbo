/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elearning.Controler;

import elearning.Model.JavaIO;
import elearning.Model.aplikasi;

/**
 *
 * @author iqbal
 */
public class Main {
    public static void main(String[] args) {
        aplikasi app = new aplikasi();
        JavaIO io = new JavaIO(app);
        ConsoleUI ui = new ConsoleUI(app, io);
        ui.data();
        Control c = new Control(app);
    }
    
}
