package com.views;
import com.templates.cDashboardframe;
import com.partials.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class cMitraview extends cDashboardframe{

  Integer idMitra = null;
  Integer idSelected = null;

  // sidebar menu
  private cSidebarmenu menuBeranda = new cSidebarmenu("Beranda", 70);
  private cSidebarmenu menuInfoSaldo = new cSidebarmenu("Info Saldo", 70+50);
  private cSidebarmenu menuRequestPulsa = new cSidebarmenu("Request Pulsa", 70+50+50);
  private cSidebarmenu menuTransaksiSaya = new cSidebarmenu("Transaksi Saya", 70+50+50+50);
  private cSidebarmenu menuLogout = new cSidebarmenu("Logout", 70+50+50+50+50);

  // components of beranda
  private cInfo labelSisaSaldoBeranda = new cInfo("Sisa Saldo Anda", 25, 20);
  private cInfonilai valueSisaSaldoBeranda = new cInfonilai("25.000", 25, 60);
  private cInfo labelPelayananBeranda = new cInfo("Pelayanan Pulsa Customer", 25, 150);
  private cInfonilai valuePelayananBeranda = new cInfonilai("10", 25, 190);
  private cInfo labelRequestPulsaBeranda = new cInfo("Request Pulsa Customer Saat Ini", 25, 280);
  private cInfonilai valueRequestPulsaBeranda = new cInfonilai("31", 25, 320);


  private cInfo labelSisaSaldoInfoSaldo = new cInfo("Sisa Saldo Anda", 25, 20);
  private cInfonilai valueSisaSaldoInfoSaldo = new cInfonilai("25.000", 25, 60);
  private cInfo labelRequestSaldoInfoSaldo = new cInfo("Data Request", 25, 150);
  private DefaultTableModel dmRequestSaldo;
  private cTable tblDataRequestSaldo;
  private cScrollpane spDataRequestSaldo;
  private cInfo labelDoRequestSaldoInfoSaldo = new cInfo("Sisa Saldo Anda", 490, 20);
  private cErrorlabel errorDoRequestSaldoInfoSaldo = new cErrorlabel("tidak bisa melakukan request jika saldo masih diatas 100K", 490, 60, 400, false);
  private cBluebutton btnRequestSaldo = new cBluebutton("Request", 490, 90, 155);
  
  

  private cInfo labelDataRequestPulsa = new cInfo("Sisa Saldo Anda", 25, 20);
  private DefaultTableModel dmRequestPulsa;
  private cTable tblDataRequestPulsa;
  private cScrollpane spDataRequestPulsa;
  private cBluebutton btnIsiPulsa = new cBluebutton("Isi Pulsa", 25, 280, 155);
  


  private cInfo labelDataTransaksiSaya = new cInfo("Data Pelayanan Pulsa Berhasil Anda", 25, 20);
  private DefaultTableModel dmTransaksiSaya;
  private cTable tblDataTransaksiSaya;
  private cScrollpane spDataTransaksiSaya;



  private void resetSidebar()
  {
    try {
      setVisible(false);

      menuBeranda.setForeground(cColor.GRAY);
      menuBeranda.setBackground(cColor.WHITE);
      menuBeranda.aturbilahsisitidakaktif();

      menuInfoSaldo.setForeground(cColor.GRAY);
      menuInfoSaldo.setBackground(cColor.WHITE);
      menuInfoSaldo.aturbilahsisitidakaktif();

      menuRequestPulsa.setForeground(cColor.GRAY);
      menuRequestPulsa.setBackground(cColor.WHITE);
      menuRequestPulsa.aturbilahsisitidakaktif();

      menuTransaksiSaya.setForeground(cColor.GRAY);
      menuTransaksiSaya.setBackground(cColor.WHITE);
      menuTransaksiSaya.aturbilahsisitidakaktif();
      
      menuLogout.aturbilahsisitidakaktif();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

  // method refresh content
  private void refreshContent()
  {
    try{
      kontenutama.removeAll();
    } catch(Exception e) {
    }
  }

  public cMitraview( Integer id )
  {
    super("Dashboard Mitra");
    idMitra = id;
    namabagian.setText("Mitra | Nama Mitra");
    menuBeranda.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeranda();
      }
    });
    menuInfoSaldo.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsInfoSaldo();
      }
    });
    menuRequestPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsRequestPulsa();
      }
    });
    menuTransaksiSaya.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsTransaksiSaya();
      }
    });
    menuLogout.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Object[] options = { "YA", "BATAL" };
        int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, options, options[0]);
        if(confirm == 0 ){
          idMitra = null;
          idSelected = null;
          com.program.cController.tampilanmasukmitra();
        }
      }
    });
 
    bilahsamping.add(menuBeranda);
    bilahsamping.add(menuInfoSaldo);
    bilahsamping.add(menuRequestPulsa);
    bilahsamping.add(menuTransaksiSaya);
    bilahsamping.add(menuLogout);

    initsBeranda();
  }

  private void initsBeranda()
  {
    idSelected = null;
    resetSidebar();
    menuBeranda.setBackground(cColor.BLUE);
    menuBeranda.setForeground(cColor.WHITE);
    refreshContent();
    menuBeranda.aturbilahsisiaktif();
    namamenu.setText("Beranda");
    kontenutama.add(labelSisaSaldoBeranda);
    kontenutama.add(valueSisaSaldoBeranda);
    kontenutama.add(labelPelayananBeranda);
    kontenutama.add(valuePelayananBeranda);
    kontenutama.add(labelRequestPulsaBeranda);
    kontenutama.add(valueRequestPulsaBeranda);
    
    setVisible(true);
  }
  
  private void initsInfoSaldo()
  {
    idSelected = null;
    resetSidebar();
    menuInfoSaldo.setBackground(cColor.BLUE);
    menuInfoSaldo.setForeground(cColor.WHITE);
    refreshContent();
    menuInfoSaldo.aturbilahsisiaktif();
    namabagian.setText("Informasi Saldo");
    String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
    String[][] dataUser = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
      {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
      {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
    };
    dmRequestSaldo = new DefaultTableModel(dataUser, dataUserHeader);
    tblDataRequestSaldo = new cTable(dmRequestSaldo);
    spDataRequestSaldo = new cScrollpane(tblDataRequestSaldo, 25, 190, 400, 220);
    kontenutama.add(labelSisaSaldoInfoSaldo);
    kontenutama.add(valueSisaSaldoInfoSaldo);
    kontenutama.add(labelRequestSaldoInfoSaldo);
    kontenutama.add(spDataRequestSaldo);
    kontenutama.add(labelDoRequestSaldoInfoSaldo);
    kontenutama.add(errorDoRequestSaldoInfoSaldo);
    kontenutama.add(btnRequestSaldo);
    setVisible(true);
  }

  private void initsRequestPulsa()
  {
    idSelected = null;
    resetSidebar();
    menuRequestPulsa.setBackground(cColor.BLUE);
    menuRequestPulsa.setForeground(cColor.WHITE);
    refreshContent();
    menuRequestPulsa.aturbilahsisiaktif();
    namabagian.setText("Request Pulsa Customer");
    String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
    String[][] dataUser = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
      {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
      {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
    };
    dmRequestPulsa = new DefaultTableModel(dataUser, dataUserHeader);
    tblDataRequestPulsa = new cTable(dmRequestPulsa);
    spDataRequestPulsa = new cScrollpane(tblDataRequestPulsa, 25, 76, 740, 190);
    kontenutama.add(labelDataRequestPulsa);
    kontenutama.add(spDataRequestPulsa);
    kontenutama.add(btnIsiPulsa);
    setVisible(true);
  }

  private void initsTransaksiSaya()
  {
    idSelected = null;
    resetSidebar();
    menuTransaksiSaya.setBackground(cColor.BLUE);
    menuTransaksiSaya.setForeground(cColor.WHITE);
    refreshContent();
    menuTransaksiSaya.aturbilahsisiaktif();
    namabagian.setText("Transaksi Pulsa Anda");
    String[] dataUserHeader = {"Header 1", "Header 2", "Header 3"};
    String[][] dataUser = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
      {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
      {"Row3 Col1", "Row3 Col2", "Row3 Col3"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3"}
    };
    dmTransaksiSaya = new DefaultTableModel(dataUser, dataUserHeader);
    tblDataTransaksiSaya = new cTable(dmTransaksiSaya);
    spDataTransaksiSaya = new cScrollpane(tblDataTransaksiSaya, 25, 76, 740, 310);
    kontenutama.add(labelDataTransaksiSaya);
    kontenutama.add(spDataTransaksiSaya);
    setVisible(true);
  }

  
}