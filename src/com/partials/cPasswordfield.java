package com.partials;

import javax.swing.JPasswordField;


import javax.swing.border.LineBorder;

public class cPasswordfield extends JPasswordField{
    public cPasswordfield(int x, int y, int lebar, boolean taruhditengah){
        super();
        setBounds(x, y, lebar, 35);
        if (taruhditengah) {
            setHorizontalAlignment(JPasswordField.CENTER);
        }
        setFont(cFont.fontteksisi);
        setForeground(cColor.BLACK);
        setBorder(new LineBorder(cColor.PURPLE,1));
    }
}
