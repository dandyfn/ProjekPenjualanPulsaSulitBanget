package com.views;

import javax.swing.event.MouseInputAdapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.partials.cBluebutton;
import com.partials.cErrorlabel;
import com.partials.cFormlabel;
import com.partials.cLinkstart;
import com.partials.cPasswordfield;
import com.partials.cTextfield;
import com.program.cController;
import com.templates.cStartframe;

public class cStartview extends cStartframe {
    private cFormlabel nohppenggunamasuk = new cFormlabel
    ("No HP", 0, 84, 450, true);
    private cTextfield isinohppenggunamasuk = new cTextfield
    (65, 114, 320, true);
    private cErrorlabel nohppenggunasalahmasuk = new cErrorlabel
    ("No hp belum diisi atau salah", 0, 149, 450, true);
    private cFormlabel sandipenggunamasuk = new cFormlabel
    ("Kata Sandi", 0, 183, 450, true);
    private cPasswordfield isisandipenggunamasuk = new cPasswordfield
    (65, 213, 320, true);
    private cErrorlabel sandipenggunasalahmasuk = new cErrorlabel
    ("Kata sandi belum diisi atau salah", 0, 248, 450, true);
    private cBluebutton tombolpenggunamasuk = new cBluebutton("Masuk", 65, 282, 320);
    private cLinkstart masukmitradarimasukpelanggan = new cLinkstart("Sudah Punya Akun Mitra?", 322);
    private cLinkstart daftarnmitradarimasukpelanggan = new cLinkstart("Daftar Sebagai Mitra", 342);
    private cLinkstart daftarpelanggandarimasukpelanggan = new cLinkstart("Belum Punya Akun Pelanggan?", 362);
    private cLinkstart masukadmindarimasukpelanggan = new cLinkstart("Masuk Sebagai Admin", 382);

    private cFormlabel namapelanggandaftar = new cFormlabel
    ("Nama", 0, 84, 450, true);
    private cTextfield isinamapelanggandaftar = new cTextfield
    (65, 114, 320, true);
    private cErrorlabel namapelanggansalahdaftar = new cErrorlabel
    ("Nama belum diisi", 0, 149, 450, true);
    private cFormlabel nohppelanggandaftar = new cFormlabel
    ("No HP", 0, 183, 450, true);
    private cTextfield isinohppelanggandaftar = new cTextfield
    (65, 213, 320, true);
    private cErrorlabel nohppelanggansalahdaftar = new cErrorlabel
    ("Nomer belum diisi", 0, 248, 450, true);
    private cFormlabel sandipelanggandaftar = new cFormlabel
    ("Kata Sandi", 0, 282, 450, true);
    private cPasswordfield isisandipelanggandaftar = new cPasswordfield
    (65, 312, 320, true);
    private cErrorlabel sandipelanggansalahdaftar = new cErrorlabel
    ("Kata sandi belum diisi", 0, 347, 450, true);
    private cBluebutton tombolpelanggandaftar = new cBluebutton("Daftar", 65, 381, 320);
    private cLinkstart masukmitradaridaftarpelanggan = new cLinkstart("Sudah Punya Akun Mitra?", 421);
    private cLinkstart daftarnmitradaridaftarpelanggan = new cLinkstart("Daftar Sebagai Mitra", 441);
    private cLinkstart masukpelanggandaridaftarpelanggan = new cLinkstart("Sudah Punya Akun Pelanggan?", 461);
    private cLinkstart masukadmindaridaftarpelanggan = new cLinkstart("Masuk Sebagai Admin", 481);

    private cFormlabel labelemailmitramasuk = new cFormlabel
    ("Email", 0, 84, 450, true);
    private cTextfield isinemailmitramasuk = new cTextfield
    (65, 114, 320, true);
    private cErrorlabel labeleroremailmitramasuk = new cErrorlabel
    ("Email belum diisi atau salah", 0, 149, 450, true);
    private cFormlabel labelsandimitramasuk = new cFormlabel
    ("Kata Sandi", 0, 183, 450, true);
    private cPasswordfield isisandimitramasuk = new cPasswordfield
    (65, 213, 320, true);
    private cErrorlabel labelsandimitrasalahmasuk = new cErrorlabel
    ("Kata sandi belum diisi atau salah", 0, 248, 450, true);
    private cBluebutton tombolmitramasuk = new cBluebutton("Masuk", 65, 282, 320);
    private cLinkstart daftarmitradarimasukmitra = new cLinkstart("Belum Punya Akun Mitra?", 322);
    private cLinkstart daftarpelanggandarimasukmitra = new cLinkstart("Daftar Sebagai Pelanggan", 342);
    private cLinkstart masukpelanggandarimasukmitra = new cLinkstart("Sudah Punya Akun Pelanggan?", 362);
    private cLinkstart masukadmindarimasukmitra = new cLinkstart("Masuk Sebagai Admin", 382);

    private cFormlabel namamitradaftar = new cFormlabel
    ("Nama", 0, 84, 450, true);
    private cTextfield isinamamitraadaftar = new cTextfield
    (65, 114, 320, true);
    private cErrorlabel namamitrasalahdaftar = new cErrorlabel
    ("Nama belum diisi", 0, 149, 450, true);
    private cFormlabel emailmitradaftar = new cFormlabel
    ("Email", 0, 183, 450, true);
    private cTextfield isiemailmitradaftar = new cTextfield
    (65, 213, 320, true);
    private cErrorlabel emailmitrasalahdaftar = new cErrorlabel
    ("Email belum diisi", 0, 248, 450, true);
    private cFormlabel sandimitradaftar = new cFormlabel
    ("Kata Sandi", 0, 282, 450, true);
    private cPasswordfield isisandimitradaftar = new cPasswordfield
    (65, 312, 320, true);
    private cErrorlabel sandimitrasalahdaftar = new cErrorlabel
    ("Kata sandi belum diisi", 0, 347, 450, true);
    private cBluebutton tombolmitradaftar = new cBluebutton("Daftar", 65, 381, 320);
    private cLinkstart masukmitradaridaftarmitra = new cLinkstart("Sudah Punya Akun Mitra?", 421);
    private cLinkstart daftarpelanggandaridaftarmitra = new cLinkstart("Daftar Sebagai Pelanggan", 441);
    private cLinkstart masukpelanggandaridaftarmitra = new cLinkstart("Sudah Punya Akun Pelanggan?", 461);
    private cLinkstart masukadmindaridaftarmitra = new cLinkstart("Masuk Sebagai Admin", 481);

    private cFormlabel usernameadminmasuk = new cFormlabel
    ("Nama Pengguna", 0, 84, 450, true);
    private cTextfield isiusernameadminmasuk = new cTextfield
    (65, 114, 320, true);
    private cErrorlabel usernameadminsalahmasuk = new cErrorlabel
    ("Nama pengguna belum diisi atau salah", 0, 149, 450, true);
    private cFormlabel sandiadminmasuk = new cFormlabel
    ("Kata Sandi", 0, 183, 450, true);
    private cPasswordfield isisandiadminmasuk = new cPasswordfield
    (65, 213, 320, true);
    private cErrorlabel sandiadminsalahmasuk = new cErrorlabel
    ("Kata sandi belum diisi atau salah", 0, 248, 450, true);
    private cBluebutton tomboladminmasuk = new cBluebutton("Masuk", 65, 282, 320);
    private cLinkstart masukmitradarimasukadmin = new cLinkstart("Belum Punya Akun Mitra?", 322);
    private cLinkstart daftarnmitradarimasukadmin = new cLinkstart("Sudah Punya Akun Mitra", 342);
    private cLinkstart daftarpelanggandarimasukadmin = new cLinkstart("Belum Punya Akun Pelanggan?", 362);
    private cLinkstart masukpelanggandarimasukadmin = new cLinkstart("Sudah Punya Akun Pelanggan", 382);

    public cStartview(){
        super();
        masukmitradarimasukpelanggan.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukmitra();
            }
          
        });
        daftarnmitradarimasukpelanggan.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilandaftarmitra();
            }
          
        });
        daftarpelanggandarimasukpelanggan.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilandaftarpengguna();;
            }
          
        });
        masukadmindarimasukpelanggan.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukadmin();
            }
          
        });

        masukmitradaridaftarpelanggan.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukmitra();
            }
          
        });
        daftarnmitradaridaftarpelanggan.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilandaftarmitra();
            }
          
        });
        masukpelanggandaridaftarpelanggan.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukpengguna();
            }
          
        });
        masukadmindaridaftarpelanggan.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukadmin();
            }
          
        });

        daftarmitradarimasukmitra.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilandaftarmitra();
            }
          
        });
        daftarpelanggandarimasukmitra.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilandaftarpengguna();
            }
          
        });
        masukpelanggandarimasukmitra.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukpengguna();
            }
          
        });
        masukadmindarimasukmitra.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukadmin();
            }
          
        });

        masukmitradaridaftarmitra.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukmitra();
            }
          
        });
        daftarpelanggandaridaftarmitra.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilandaftarpengguna();
            }
          
        });
        masukpelanggandaridaftarmitra.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukpengguna();
            }
          
        });
        masukadmindaridaftarmitra.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukadmin();
            }
          
        });

        masukmitradarimasukadmin.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukmitra();
            }
          
        });
        daftarnmitradarimasukadmin.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilandaftarmitra();
            }
          
        });
        daftarpelanggandarimasukadmin.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilandaftarpengguna();
            }
          
        });
        masukpelanggandarimasukadmin.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me){
                cController.tampilanmasukpengguna();
            }
          
        });
    }


    public void inisiasipelangganmasuk(){
        this.setTitle("Masuk Pelanggan");
        kartumulai.removeAll();
        judulmulai.setText("Masuk Pelanggan");
        
        tombolpenggunamasuk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ea){
                cController.tampilanmasukpengguna();
                if (isinohppenggunamasuk.getText().equalsIgnoreCase("")) {
                    kartumulai.add(nohppenggunasalahmasuk);
                }
                if (String.valueOf(isisandipenggunamasuk.getPassword()).equalsIgnoreCase("")) {
                    kartumulai.add(sandipenggunasalahmasuk);
                }
            }
        });


        kartumulai.add(judulmulai);
        kartumulai.add(nohppenggunamasuk);
        kartumulai.add(isinohppenggunamasuk);
       
        kartumulai.add(sandipenggunamasuk);
        kartumulai.add(isisandipenggunamasuk);
        
        kartumulai.add(tombolpenggunamasuk);
        kartumulai.add(masukmitradarimasukpelanggan);
        kartumulai.add(daftarnmitradarimasukpelanggan);
        kartumulai.add(daftarpelanggandarimasukpelanggan);
        kartumulai.add(masukadmindarimasukpelanggan);
    }

    public void inisiasidaftarpelanggan(){
        this.setTitle("Daftar Pelanggan");
        kartumulai.removeAll();
        judulmulai.setText("Daftar Pelanggan");

        tombolpelanggandaftar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent sd){
                cController.tampilandaftarpengguna();
                if (isinamapelanggandaftar.getText().equalsIgnoreCase("")) {
                    kartumulai.add(namapelanggansalahdaftar);
                }
                if (isinohppelanggandaftar.getText().equalsIgnoreCase("")) {
                     kartumulai.add(nohppelanggansalahdaftar);
                }
                if (String.valueOf(isisandipelanggandaftar.getPassword()).equalsIgnoreCase("")) {
                    kartumulai.add(sandipelanggansalahdaftar);
                }
            }
        });
        kartumulai.add(judulmulai);
        kartumulai.add(namapelanggandaftar);
        kartumulai.add(isinamapelanggandaftar);
       
        kartumulai.add(nohppelanggandaftar);
        kartumulai.add(isinohppelanggandaftar);
       
        kartumulai.add(sandipelanggandaftar);
        kartumulai.add(isisandipelanggandaftar);
   
        kartumulai.add(tombolpelanggandaftar);
        kartumulai.add(masukmitradaridaftarpelanggan);
        kartumulai.add(daftarnmitradaridaftarpelanggan);
        kartumulai.add(masukpelanggandaridaftarpelanggan);
        kartumulai.add(masukadmindaridaftarpelanggan);
    }
    public void inisiasimitramasuk(){
        setTitle("Masuk Mitra");
        kartumulai.removeAll();
        judulmulai.setText("Masuk Mitra");
        tombolmitramasuk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent fd){
                cController.tampilanmasukmitra();
                if (isinemailmitramasuk.getText().equalsIgnoreCase("")) {
                    kartumulai.add(labeleroremailmitramasuk); 
                }
                if (String.valueOf(isisandimitramasuk.getPassword()).equalsIgnoreCase("")) {
                     kartumulai.add(labelsandimitrasalahmasuk);  
                }
            }
        });
        kartumulai.add(judulmulai);
        kartumulai.add(labelemailmitramasuk);
        kartumulai.add(isinemailmitramasuk);
      
        kartumulai.add(labelsandimitramasuk);
        kartumulai.add(isisandimitramasuk);
     
        kartumulai.add(tombolmitramasuk);
        kartumulai.add(daftarmitradarimasukmitra);
        kartumulai.add(daftarpelanggandarimasukmitra);
        kartumulai.add(masukpelanggandarimasukmitra);
        kartumulai.add(masukadmindarimasukmitra);
    }
    public void inisiasidaftramitra(){
        setTitle("Daftar Mitra");
        kartumulai.removeAll();
        judulmulai.setText("Daftar Mitra");
        
        kartumulai.add(judulmulai);
        
        tombolmitradaftar.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent hj){
                cController.tampilandaftarmitra();
              
            if (isinamamitraadaftar.getText().equalsIgnoreCase("")) {
                    kartumulai.add(namamitrasalahdaftar);  
           }
           if (isiemailmitradaftar.getText().equalsIgnoreCase("")) {
                kartumulai.add(emailmitrasalahdaftar);
           }
           if (String.valueOf(isisandimitradaftar.getPassword()).equalsIgnoreCase("")) {
                   kartumulai.add(sandimitrasalahdaftar);
           }
            }
        });
        // tombolmitradaftar.addActionListener(new ActionListener() {
        //     public void actionPerformed (ActionEvent hj){
        //         cController.tampilandaftarmitra();
        //         if (isinamamitraadaftar.getText().equalsIgnoreCase("")) {
        //                  kartumulai.add(namamitrasalahdaftar);  
        //         }
        //         if (isiemailmitradaftar.getText().equalsIgnoreCase("")) {
        //              kartumulai.add(emailmitrasalahdaftar);
        //         }
        //         if (String.valueOf(isisandimitradaftar.getPassword()).equalsIgnoreCase("")) {
        //                 kartumulai.add(sandimitrasalahdaftar);
        //         }
            
        //     }
        // });
           
        kartumulai.add(namamitradaftar);
        kartumulai.add(isinamamitraadaftar);
 
        kartumulai.add(emailmitradaftar);
        kartumulai.add(isiemailmitradaftar);
       
        kartumulai.add(sandimitradaftar);
        kartumulai.add(isisandimitradaftar);
    
        kartumulai.add(tombolmitradaftar);
        kartumulai.add(masukmitradaridaftarmitra);
        kartumulai.add(daftarpelanggandaridaftarmitra);
        kartumulai.add(masukpelanggandaridaftarmitra);
        kartumulai.add(masukadmindaridaftarmitra);
    }

    public void inisiasiadminmasuk(){
        setTitle("Masuk Admin");
        kartumulai.removeAll();
        judulmulai.setText("Masuk Admin");
        kartumulai.add(judulmulai);

        tomboladminmasuk.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent hj){
                cController.tampilanmasukadmin();
                if (isiusernameadminmasuk.getText().equalsIgnoreCase("")) {
                          kartumulai.add(usernameadminsalahmasuk);
                }
                if (String.valueOf(isisandiadminmasuk.getPassword()).equalsIgnoreCase("")) {
                    kartumulai.add(sandiadminsalahmasuk);
                }
            
            }
        });
        kartumulai.add(usernameadminmasuk);
        kartumulai.add(isiusernameadminmasuk);
  
        kartumulai.add(sandiadminmasuk);
        kartumulai.add(isisandiadminmasuk);
      
        kartumulai.add(tomboladminmasuk);
        kartumulai.add(masukmitradarimasukadmin);
        kartumulai.add(daftarnmitradarimasukadmin);
        kartumulai.add(masukpelanggandarimasukadmin);
        kartumulai.add(daftarpelanggandarimasukadmin);
        
    }
}
