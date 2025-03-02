package com.partials;

import javax.swing.JCheckBox;

public class cCheckbox extends JCheckBox{
    public cCheckbox(String teks, String nilai, int x, int y, int lebar){
        super();
        setBounds(x, y, lebar, 20);
        setFont(cFont.fontradiobutton);
        setForeground(cColor.RED);
        setBackground(cColor.WHITE);
        setHorizontalAlignment(JCheckBox.CENTER);
        setVerticalAlignment(JCheckBox.CENTER);
        setActionCommand(nilai);
        setText(teks);

    }
}
