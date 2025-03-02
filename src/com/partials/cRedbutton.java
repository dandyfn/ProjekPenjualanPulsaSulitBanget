package com.partials;

import javax.swing.JButton;

public class cRedbutton extends JButton{
    public cRedbutton(String kata, int x, int y, int lebar){
        super();
        setText(kata);
        setBounds(x, y, lebar, 35);
        setFont(cFont.fonttombol);
        setBackground(cColor.RED);
        setForeground(cColor.WHITE);
        setBorder(null);
    };
}