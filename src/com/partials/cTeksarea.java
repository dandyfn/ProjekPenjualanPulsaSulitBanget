package com.partials;

import javax.swing.JTextArea;

public class cTeksarea extends JTextArea{
    public cTeksarea (boolean bisadiedit){
        super();
        setFont(cFont.fontteksisi);
        setBackground(cColor.WHITE);
        if (bisadiedit) {
            setForeground(cColor.RED);
        } else {
            setForeground(cColor.BLACK);
            setEditable(false);
        }
        setLineWrap(true);
        setWrapStyleWord(true);
    }
    
    public cTeksarea (String text, int x, int y, boolean editable)
  {
    this(editable);
    setBounds(x, y, 360, 200);
  }
}
