package com.partials;

import javax.swing.JLabel;


public class cErrorlabel extends JLabel{
    public cErrorlabel(String kata, int x, int y, int lebar, boolean taruhditengah){
        super();
        setBounds(x, y, lebar, 20);
        if (taruhditengah) {
            setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFont.fontlabeleror);
        setForeground(cColor.RED);
        setText(kata);
    }
}
