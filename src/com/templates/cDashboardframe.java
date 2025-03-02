package com.templates;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.partials.cColor;
import com.partials.cExitlink;
import com.partials.cFont;


public abstract class cDashboardframe extends JFrame {
    
    public JPanel bilahsamping = new JPanel();
    public JPanel tajuk = new JPanel();
    public JPanel menuutama = new JPanel();
    public JPanel kontenutama = new JPanel();
    public JLabel namaapp = new JLabel();
    public JLabel namabagian = new JLabel();
    public cExitlink tombolkeluarprogram = new cExitlink(938);
    public JLabel namamenu = new JLabel();
   
    public JLabel copyright = new JLabel();
   

    public cDashboardframe(){
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


        copyright.setBounds(30, 610, 1050, 20);
        copyright.setForeground(cColor.GRAY);
        copyright.setVerticalAlignment(JLabel.CENTER);
        copyright.setHorizontalAlignment(JLabel.CENTER);
        copyright.setText("Copyright 2025 @dandygamingstudios");
        copyright.setFont(cFont.fontteksisi);

        namamenu.setBounds(30, 10, 600, 50);
        namamenu.setForeground(cColor.BLACK_GRAY);
        namamenu.setVerticalAlignment(JLabel.CENTER);
        namamenu.setText("Menu");
        namamenu.setFont(cFont.fontjudulmenu);

        bilahsamping.add(namaapp);
       
        tajuk.add(namabagian);
        tajuk.add(tombolkeluarprogram);
       
        menuutama.add(copyright);
    
        menuutama.add(namamenu);
        menuutama.add(kontenutama);
        add(bilahsamping);
        add(tajuk);
        add(menuutama);
       


    }

    public cDashboardframe(String teks){
        this();
        setTitle(teks);
    }
}
