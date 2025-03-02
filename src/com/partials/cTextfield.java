package com.partials;

import javax.swing.JTextField;

import javax.swing.border.LineBorder;

public class cTextfield extends JTextField{
    public cTextfield(int x, int y, int lebar, boolean taruhditengah){
        super();
        setBounds(x, y, lebar, 35);
        if (taruhditengah) {
            setHorizontalAlignment(JTextField.CENTER);
        }
        setFont(cFont.fontteksisi);
        setForeground(cColor.BLACK);
        setBorder(new LineBorder(cColor.PURPLE,1));
    }
}
