package com.partials;

import javax.swing.JRadioButton;

public class cRadionbutton extends JRadioButton{
    public cRadionbutton(String teks, String nilai, int x, int y, int lebar){
        super();
        setBounds(x, y, lebar, 20);
        setFont(cFont.fontradiobutton);
        setForeground(cColor.RED);
        setBackground(cColor.WHITE);
        setHorizontalAlignment(JRadioButton.CENTER);
        setVerticalAlignment(JRadioButton.CENTER);
        setActionCommand(nilai);
        setText(teks);

    }
}
