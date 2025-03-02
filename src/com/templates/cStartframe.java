package com.templates;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import com.partials.cColor;

import com.partials.cFont;
import com.partials.cExitlink;


public abstract class cStartframe extends JFrame{
    public JPanel latarbelakang = new JPanel();
    public JPanel kartumulai = new JPanel();
    public JLabel judulmulai = new JLabel("AAAAHHHH ENAKK");
    public cExitlink tombolkeluarprogram = new cExitlink(1168);



    public cStartframe(){
    super();    
    setSize(1280, 720);
    setUndecorated(true);
    setDefaultCloseOperation(cStartframe.EXIT_ON_CLOSE);
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
    
    
   
    kartumulai.add(judulmulai);
   
    latarbelakang.add(tombolkeluarprogram);
    latarbelakang.add(kartumulai);
    add(latarbelakang);
   }

   public cStartframe(String judul){
    this();
    setTitle(judul);
   }
  
}
