package com.templates;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.partials.cCheckbox;
import com.partials.cColor;
import com.partials.cExitlink;
import com.partials.cFont;
import com.partials.cInfo;
import com.partials.cInfonilai;
import com.partials.cRadionbutton;
import com.partials.cScrollpane;
import com.partials.cSidebarmenu;
import com.partials.cTable;
import com.partials.cTeksarea;

public class cDashboardframe2 extends JFrame {
    public JPanel bilahsamping = new JPanel();
    public JPanel tajuk = new JPanel();
    public JPanel menuutama = new JPanel();
    public JPanel kontenutama = new JPanel();
    public JLabel namaapp = new JLabel();
    public JLabel namabagian = new JLabel();
    public cExitlink tombolkeluarprogram = new cExitlink(938);
    public JLabel namamenu = new JLabel();
    public JLabel copyright = new JLabel();
    public cInfo info = new cInfo("Sisa pulsa", 25, 25);
    public cInfonilai infopulsa = new cInfonilai("15.000", 25, 60);
    public cRadionbutton pilihbesaranpulsa = new 
    cRadionbutton("50K", "Pilihan1", 25, 150, 100);
    public cCheckbox pilihaktifkan = new cCheckbox("Aktifkan",
     "pilihaktifkan", 250, 150, 100);
    public cSidebarmenu berandamenu = new cSidebarmenu("Beranda", 70);
    public cSidebarmenu berandamenu1 = new cSidebarmenu("Token Listrik", 120);
    public cTeksarea deskripsi = new cTeksarea(false);
    public cScrollpane scrollpane1 = new cScrollpane(deskripsi, 25, 200, 300, 100);
    public cTable tabelpengguna;
    public cScrollpane scrollpane2;

    public cDashboardframe2(){
        super();
        setSize(1280, 720);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        bilahsamping.setBackground(cColor.WHITE);
        bilahsamping.setBounds(0, 0, 230, 720);
        bilahsamping.setLayout(null);
        tajuk.setLayout(null);
        tajuk.setBackground(cColor.PURPLE);
        tajuk.setBounds(230, 0, 1050, 70);
        menuutama.setLayout(null);
        menuutama.setBackground(cColor.WHITE_GRAY);
        menuutama.setBounds(230, 70, 1050, 650);
        kontenutama.setLayout(null);
        kontenutama.setBackground(cColor.WHITE);
        kontenutama.setBounds(30, 70, 990, 520);

        namaapp.setBounds(0, 0, 230, 70);
        namaapp.setForeground(cColor.PURPLE);
        namaapp.setHorizontalAlignment(JLabel.CENTER);
        namaapp.setVerticalAlignment(JLabel.CENTER);
        namaapp.setText("Pulsa");
        namaapp.setFont(cFont.fontnamaapp);

        namabagian.setBounds(30, 0, 400, 70);
        namabagian.setForeground(cColor.WHITE);
        namabagian.setVerticalAlignment(JLabel.CENTER);
        namabagian.setText("Admin");
        namabagian.setFont(cFont.fontnamabagian);

        namamenu.setBounds(30, 10, 600, 50);
        namamenu.setForeground(cColor.BLACK_GRAY);
        namamenu.setVerticalAlignment(JLabel.CENTER);
        namamenu.setText("Menu");
        namamenu.setFont(cFont.fontjudulmenu);

        copyright.setBounds(30, 610, 1050, 20);
        copyright.setForeground(cColor.GRAY);
        copyright.setVerticalAlignment(JLabel.CENTER);
        copyright.setHorizontalAlignment(JLabel.CENTER);
        copyright.setText("Copyright 2025 @dandygamingstudios");
        copyright.setFont(cFont.fontteksisi);

        deskripsi.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        
        String judul [ ] = {"Nama","No","Pekerjaan"};
        String isi [][] = {{"Dnady","12","Dev enginer"},{"Nasya","14","Cyber security"}};
        DefaultTableModel edittabel = new DefaultTableModel(isi,judul);
        tabelpengguna = new cTable(edittabel);
        scrollpane2 = new cScrollpane(tabelpengguna, 25, 300, 500, 100);

        bilahsamping.add(namaapp);
        bilahsamping.add(berandamenu);
        bilahsamping.add(berandamenu1);
        tajuk.add(namabagian);
        tajuk.add(tombolkeluarprogram);
        menuutama.add(namamenu);
        menuutama.add(copyright);
        kontenutama.add(info);
        kontenutama.add(infopulsa);
        kontenutama.add(pilihbesaranpulsa);
        kontenutama.add(pilihaktifkan);
        kontenutama.add(scrollpane1);
        kontenutama.add(scrollpane2);
        menuutama.add(kontenutama);
        add(bilahsamping);
        add(tajuk);
        add(menuutama);
       


    }

    public cDashboardframe2(String teks){
        this();
        setTitle(teks);
    }
}
