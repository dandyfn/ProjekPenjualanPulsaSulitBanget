package com.templates;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.partials.cBluebutton;
import com.partials.cColor;
import com.partials.cErrorlabel;
import com.partials.cFont;
import com.partials.cExitlink;
import com.partials.cFormlabel;
import com.partials.cLinkstart;
import com.partials.cTextfield;

public class cStartframe2 extends JFrame{
    public JPanel latarbelakang = new JPanel();
    public JPanel kartumulai = new JPanel();
    public JLabel judulmulai = new JLabel("AAAAHHHH ENAKK");
    public cExitlink tombolkeluarprogram = new cExitlink(1168);
    public cFormlabel labelformulir = new 
    cFormlabel("Dandy",0, 84, 450, true);
    public cTextfield isiteks = new 
    cTextfield(65, 114, 320, true);
    public cErrorlabel pemberitahuangalat = new 
    cErrorlabel("Nama tidak boleh kosong", 0, 149, 450, true);
    public cLinkstart tautanmulai1 = new cLinkstart("Menuju tanpa batas", 200);
    public cBluebutton tombolbiru = new cBluebutton("Serahkan", 65, 252, 320);


    public cStartframe2(){
    super();    
    setSize(1280, 720);
    setUndecorated(true);
    setDefaultCloseOperation(cStartframe2.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);

    latarbelakang.setBackground(cColor.BLUE);
    latarbelakang.setBounds(0, 0, 1280, 720);
    latarbelakang.setLayout(null);
    kartumulai.setBackground(cColor.WHITE90);
    kartumulai.setBounds(415, 90, 450, 540);
    kartumulai.setLayout(null);
    judulmulai.setFont(cFont.fontjudulmulai);
    judulmulai.setForeground(cColor.BLACK);
    judulmulai.setBounds(0, 30, 450, 40);
    judulmulai.setVerticalAlignment(JLabel.CENTER);
    judulmulai.setHorizontalAlignment(JLabel.CENTER);
    
    
    kartumulai.add(isiteks);
    kartumulai.add(judulmulai);
    kartumulai.add(labelformulir);
    kartumulai.add(pemberitahuangalat);
    kartumulai.add(tautanmulai1);
    kartumulai.add(tombolbiru);
    latarbelakang.add(tombolkeluarprogram);
    latarbelakang.add(kartumulai);
    add(latarbelakang);
   }
   public cStartframe2(String judul){
    this();
    setTitle(judul);
   }
  
}
