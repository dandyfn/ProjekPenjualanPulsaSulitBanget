package com.partials;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;


public class cSidebarmenu extends JLabel{

    public  MouseAdapter bilahsisiaktif= new MouseAdapter() {
        public void mouseEntered(MouseEvent q){
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setForeground(cColor.WHITE);
            setBackground(cColor.PURPLE);
        }
        public void mouseExited(MouseEvent f){
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            setForeground(cColor.WHITE);
            setBackground(cColor.PURPLE);
        }
    };

    public  MouseAdapter bilahsisitidakaktif= new MouseAdapter() {
        public void mouseEntered(MouseEvent q){
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setForeground(cColor.WHITE);
            setBackground(cColor.BLUE);
        }
        public void mouseExited(MouseEvent f){
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            setForeground(cColor.GRAY);
            setBackground(cColor.WHITE);
        }
    };


    public cSidebarmenu(String teks, int y){
        super();
        setBounds(0, y, 230, 50);
        setText("     "+teks);
        setFont(cFont.fontbilanhsamping);
        setOpaque(true);
        setForeground(cColor.GRAY);
        setBackground(cColor.WHITE);
      
        aturbilahsisitidakaktif();
    }

    public void aturbilahsisiaktif(){
        try {
            removeMouseListener(bilahsisitidakaktif);
        } catch (Exception e) {
            // TODO: handle exception
        }
        addMouseListener(bilahsisiaktif);
    }
    public void aturbilahsisitidakaktif(){
        try {
            removeMouseListener(bilahsisiaktif);
        } catch (Exception e) {
            // TODO: handle exception
        }
        addMouseListener(bilahsisitidakaktif);
    }
}
