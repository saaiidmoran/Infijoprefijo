package com.saaiidmoran.infijoprefijo;

import com.saaiidmoran.infijoprefijo.view.Interfaz;

public class infijoprefijo {

    /**
     * @param args the command line arguments
     */   
    
    public static void main(String[] args) {
        // TODO code application logic here
        ServiceMain sm = new ServiceMain();
        Interfaz a = new Interfaz();
        a.setIconImage(sm.generarIcono());
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }
    
}
