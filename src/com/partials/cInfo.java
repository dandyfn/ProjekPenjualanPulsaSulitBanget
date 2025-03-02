package com.partials;

import javax.swing.JLabel;

public class cInfo extends JLabel {
    public cInfo(String kata, int x, int y){
        super();
        setBounds(x, y, 450, 40);       
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFont.fontlabelinfo);
        setForeground(cColor.BLACK);
        setText(kata);
    }
}
