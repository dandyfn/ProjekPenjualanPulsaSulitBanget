package com.partials;

import javax.swing.JButton;

public class cGreenbutton extends JButton{
    public cGreenbutton(String kata, int x, int y, int lebar){
        super();
        setText(kata);
        setBounds(x, y, lebar, 35);
        setFont(cFont.fonttombol);
        setBackground(cColor.GREEN);
        setForeground(cColor.WHITE);
        setBorder(null);
    };
}