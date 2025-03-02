package com.partials;

import javax.swing.JLabel;

public class cInfonilai extends JLabel {
    public cInfonilai(String kata, int x, int y){
        super();
        setBounds(x, y, 450, 70);       
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFont.fontbesar);
        setForeground(cColor.RED);
        setText(kata);
    }
}
