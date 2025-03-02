package com.partials;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class cExitlink extends JLabel{
    public cExitlink(int x){
        super();
        setBounds(x, 0, 82, 70);
        setText("Keluar?");
        setFont(cFont.fonttautankeluar);
        setForeground(cColor.BLACK);
        setBackground(cColor.BLACK);
        addMouseListener(new MouseAdapter() {
            public void mouseEntered (MouseEvent e){
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent f){
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            public void mouseClicked(MouseEvent g){
                int angkajpane = JOptionPane.showConfirmDialog
                (null, "Apakah anda yakin ingin keluar?", "Pemberitahuan Keluar", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (angkajpane==0) {
                     System.exit(0);
                }
           
            }
        });
    }
}
