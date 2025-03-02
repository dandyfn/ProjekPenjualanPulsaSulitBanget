package com.partials;

import javax.swing.JScrollPane;

import javax.swing.border.LineBorder;

import java.awt.Component;

public class cScrollpane extends JScrollPane{
    public cScrollpane (Component view, int x, int y, int lebar, int tinggi){
        super(view);
        setBounds(x, y, lebar, tinggi);
        getViewport().setBackground(cColor.WHITE);
        setBorder(new LineBorder(cColor.BLUE,1));
    }
}
