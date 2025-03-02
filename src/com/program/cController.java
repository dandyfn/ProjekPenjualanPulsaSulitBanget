package com.program;

import com.views.cAdminview;
import com.views.cDashbordview;
import com.views.cMitraview;
import com.views.cStartview;

public class cController {
    private static cStartview frameregristasi = new cStartview();
  
    public static void tampilanmasukpengguna(){
        frameregristasi.setVisible(false);
        frameregristasi.inisiasipelangganmasuk();
        frameregristasi.setVisible(true);
    };
    public static void tampilandaftarpengguna(){
        frameregristasi.setVisible(false);
        frameregristasi.inisiasidaftarpelanggan();
        frameregristasi.setVisible(true);
    };
    public static void tampilanmasukmitra(){
        frameregristasi.setVisible(false);
        frameregristasi.inisiasimitramasuk();
        frameregristasi.setVisible(true);
    };
    public static void tampilandaftarmitra(){
        frameregristasi.setVisible(false);
        frameregristasi.inisiasidaftramitra();
        frameregristasi.setVisible(true);
    };
    public static void tampilanmasukadmin(){
        frameregristasi.setVisible(false);
        frameregristasi.inisiasiadminmasuk();
        frameregristasi.setVisible(true);
    };
    public static void tampilanberandamitra(Integer id){
       
        cMitraview berandamitra = new cMitraview(id);
        berandamitra.setVisible(true);
    };
    public static void tampilanberandapengguna(Integer id){
       
        cDashbordview berandapengguna = new cDashbordview(id);
        berandapengguna.setVisible(true);
    };
    public static void tampilanberandaadmin(boolean statusmasuk){
        cAdminview berandaadmin = new cAdminview(statusmasuk);
        berandaadmin.setVisible(true);
    };
}
