package com.partials;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;




public class cLinkstart extends JLabel{
    public cLinkstart(String kata,  int y){
        super();
        setBounds(0, y, 450, 20);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFont.fonttautanmulai);
        setForeground(cColor.BLUE);
        setText(kata);
          addMouseListener(new MouseAdapter() {
            public void mouseEntered (MouseEvent e){
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent f){
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            } });
    }
}
