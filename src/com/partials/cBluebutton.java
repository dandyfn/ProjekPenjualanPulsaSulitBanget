package com.partials;

import javax.swing.JButton;

public class cBluebutton extends JButton{
    public cBluebutton(String kata, int x, int y, int lebar){
        super();
        setText(kata);
        setBounds(x, y, lebar, 35);
        setFont(cFont.fonttombol);
        setBackground(cColor.BLUE);
        setForeground(cColor.WHITE);
        setBorder(null);
    };
}
