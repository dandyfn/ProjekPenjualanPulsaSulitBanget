package com.partials;

import javax.swing.JLabel;


public class cFormlabel extends JLabel{
    public cFormlabel(String kata, int x, int y, int lebar, boolean taruhditengah){
        super();
        setBounds(x, y, lebar, 30);
        if (taruhditengah) {
            setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFont.fontlabelformulir);
        setForeground(cColor.BLACK);
        setText(kata);
    }
}
