package com.views;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseEvent;
import com.partials.*;
import com.program.cController;
import com.templates.cDashboardframe;

public class cDashbordview extends cDashboardframe{
    Integer idCustomer = null;
    Integer idSelected = null;
    cSidebarmenu beranda = new cSidebarmenu("Beranda",70 );
    cSidebarmenu belipaket = new cSidebarmenu("Beli Paket", 70+50);
    cSidebarmenu belipulsa = new cSidebarmenu("Beli Pulsa", 70+50+50);
    cSidebarmenu jejakbelipulsa = new cSidebarmenu("Jejak Beli Pulsa", 70+50+50+50);
    cSidebarmenu jejakbelipaket = new cSidebarmenu("Jejak Beli Paket", 70+50+50+50+50);
    cSidebarmenu akun = new cSidebarmenu("Akun", 70+50+50+50+50+50);
    cSidebarmenu keluarakun = new cSidebarmenu("Keluar Akun", 70+50+50+50+50+50+50);

     cInfo labelSisaPulsaBeranda = new cInfo("Sisa Pulsa Anda", 25, 20);
     cInfonilai valueSisaPulsaBeranda = new cInfonilai("55.000", 25, 60);
     cInfo labelSisaKuotaBeranda = new cInfo("Sisa Kuota Anda", 25, 150);
     cInfonilai valueSisaKuotaBeranda = new cInfonilai("11GB", 25, 190);

   cInfo labelSisaPulsaBeliPulsa = new cInfo("Sisa Pulsa Anda", 25, 20);
   cInfonilai valueSisaPulsaBeliPulsa = new cInfonilai("55.000", 25, 60);
   cInfo labelPilihanBeliPulsa = new cInfo("Pilihan Beli Pulsa", 25, 150);
   cRadionbutton rd5k = new cRadionbutton("5K", "5000", 25, 190, 72);
   cRadionbutton rd10k = new cRadionbutton("10K", "10000", 102, 190, 72);
   cRadionbutton rd25k = new cRadionbutton("25K", "25000", 179, 190, 72);
   cRadionbutton rd50k = new cRadionbutton("50K", "50000", 256, 190, 72);
   cRadionbutton rd100k = new cRadionbutton("100K", "10000", 333, 190, 72);
   cBluebutton btnBeliPulsa = new cBluebutton("Beli Pulsa", 25, 220, 155);
   ButtonGroup rdPilihaPulsa = new ButtonGroup();

      cInfo labelSisaKuotaBeliPaket = new cInfo("Sisa Kuota Anda", 25, 20);
   cInfonilai valueSisaKuotaBeliPaket = new cInfonilai("11GB", 25, 60);
   cInfo labelPilihanBeliPaket = new cInfo("Pilihan Beli Paket Kuota", 25, 150);
   DefaultTableModel dmPaket;
   cTable dataPaket;
   cScrollpane spDataPaket;
   cBluebutton btnBeliPaket = new cBluebutton("Beli Paket", 25, 390, 155);
   cInfo labelDeskripsiPaket = new cInfo("DeskripsiPaket", 473, 190);
   cTeksarea valueDeskripsiPaket = new cTeksarea("", 473, 231, false);

    cInfo labelHistoryPulsa = new cInfo("Semua Pembelian Pulsa Saya", 25, 20);
    DefaultTableModel dmHistoryPulsa;
    cTable tblDataHistoryPulsa;
    cScrollpane spDataHistoryPulsa;

    cInfo labelHistoryPaket = new cInfo("Semua Pembelian Paket Saya", 25, 20);
    DefaultTableModel dmHistoryPaket;
    cTable tblDataHistoryPaket;
    cScrollpane spDataHistoryPaket;

    cInfo labelAkun = new cInfo("Data Akun Saya", 25, 20);
    cFormlabel labelNama = new cFormlabel("Nama", 25, 65, 360, false);
    cTextfield txtNama = new cTextfield(25, 90, 360, false);
    cErrorlabel errorNama = new cErrorlabel("nama tidak boleh kosong!", 25, 125, 360, false);
    cFormlabel labelNoHp = new cFormlabel("No Hp", 25, 150, 360, false);
    cFormlabel valueNoHp;
    cFormlabel labelEmail = new cFormlabel("Email", 25, 202, 360, false);
    cTextfield txtEmail = new cTextfield(25, 227, 360, false);
    cErrorlabel errorEmail = new cErrorlabel("email tidak boleh kosong!", 25, 262, 360, false);
    cBluebutton btnUbahAkun = new cBluebutton("Ubah Data Akun", 25, 292, 155);
    
    private void resetSidebar()
  {
    try {
      setVisible(false);

      beranda.setForeground(cColor.GRAY);
      beranda.setBackground(cColor.WHITE);
      beranda.aturbilahsisitidakaktif();

      belipulsa.aturbilahsisitidakaktif();
      belipulsa.setForeground(cColor.GRAY);
      belipulsa.setBackground(cColor.WHITE);

      belipaket.aturbilahsisitidakaktif();
      belipaket.setForeground(cColor.GRAY);
      belipaket.setBackground(cColor.WHITE);

      jejakbelipulsa.aturbilahsisitidakaktif();
      jejakbelipulsa.setForeground(cColor.GRAY);
      jejakbelipulsa.setBackground(cColor.WHITE);

      jejakbelipaket.aturbilahsisitidakaktif();
      jejakbelipaket.setForeground(cColor.GRAY);
      jejakbelipaket.setBackground(cColor.WHITE);

      akun.aturbilahsisitidakaktif();
      akun.setForeground(cColor.GRAY);
      akun.setBackground(cColor.WHITE);
      
    
      keluarakun.aturbilahsisitidakaktif();
    } catch (Exception e) {
      //TODO: handle exception
    }
  }


    private void refreshContent()
  {
    try{
      kontenutama.removeAll();
    } catch(Exception e) {
    }
  }

  
    public cDashbordview (Integer id){
        super();
        idCustomer=id;
        namabagian.setText("Nama Pengguna | Dandy");
        beranda.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent br){
                beranda();
            }
        });
        belipaket.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent br){
                belipaket();
            }
        });
        belipulsa.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent br){
                belipulsa();
            }
        });
        jejakbelipaket.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent br){
                jejakbelipaket();
            }
        });
        jejakbelipulsa.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent br){
                jejakbelipulsa();
            }
        });
        akun.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent br){
                akun();
            }
        });
        keluarakun.addMouseListener(new MouseInputAdapter() {
            public void mouseClicked(MouseEvent br){
               Object [] pilihankeluar = {"Iya","Balik lagi!"};
               int menukeluar = JOptionPane.showOptionDialog
               (null, "Yakin Keluar?", "Permintaan Keluar", 
               JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                pilihankeluar, pilihankeluar[0]);
                if (menukeluar==0) {
                    idCustomer = null;
                    idSelected = null;
                    cController.tampilanmasukpengguna();
                }
            }
        });
        bilahsamping.add(beranda);
        bilahsamping.add(belipaket);
        bilahsamping.add(belipulsa);
        bilahsamping.add(jejakbelipaket);
        bilahsamping.add(jejakbelipulsa);
        bilahsamping.add(akun);
        bilahsamping.add(keluarakun);

        rdPilihaPulsa.add(rd5k);
        rdPilihaPulsa.add(rd10k);
        rdPilihaPulsa.add(rd25k);
        rdPilihaPulsa.add(rd50k);
        rdPilihaPulsa.add(rd100k);

        beranda();
    }
    private void beranda(){
        idSelected = null;
        resetSidebar();
        beranda.setBackground(cColor.BLUE);
        beranda.setForeground(cColor.WHITE);
        refreshContent();
        beranda.aturbilahsisiaktif();
        namamenu.setText("Beranda");
        kontenutama.add(labelSisaPulsaBeranda);
        kontenutama.add(valueSisaPulsaBeranda);
        kontenutama.add(labelSisaKuotaBeranda);
        kontenutama.add(valueSisaKuotaBeranda);
        setVisible(true);
    }
    private void belipaket(){
        idSelected = null;
    resetSidebar();
    belipaket.setBackground(cColor.BLUE);
    belipaket.setForeground(cColor.WHITE);
    refreshContent();
    belipaket.aturbilahsisiaktif();
    namamenu.setText("Beli Paket");
    String[] dataUserHeader = {"Nama", "Kuota", "Harga"};
    String[][] dataUser = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3"},
      {"Row2 Col1", "Row2 Col2", "Row2 Col3"},
      {"Hemat Mantap", "11GB", "76.000"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3"},
      {"Row6 Col1", "Row6 Col2", "Row6 Col3"}
    };
    dmPaket = new DefaultTableModel(dataUser, dataUserHeader);
    dataPaket = new cTable(dmPaket);
    spDataPaket = new cScrollpane(dataPaket, 25, 190, 428, 190);
    String textDeskripsiPaket = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam totam doloribus velit ipsa! Beatae tempore quod laborum porro optio aliquam voluptate commodi assumenda explicabo debitis accusamus obcaecati, quo nostrum esse!";
    valueDeskripsiPaket.setText(textDeskripsiPaket);
    kontenutama.add(labelSisaKuotaBeliPaket);
    kontenutama.add(valueSisaKuotaBeliPaket);
    kontenutama.add(labelPilihanBeliPaket);
    kontenutama.add(spDataPaket);
    kontenutama.add(btnBeliPaket);
    kontenutama.add(labelDeskripsiPaket);
    kontenutama.add(valueDeskripsiPaket);
    setVisible(true);
    }
    private void belipulsa(){
        idSelected = null;
        resetSidebar();
        belipulsa.setBackground(cColor.BLUE);
        belipulsa.setForeground(cColor.WHITE);
        refreshContent();
        belipulsa.aturbilahsisiaktif();
        namamenu.setText("Beli Pulsa");
        kontenutama.add(labelSisaPulsaBeliPulsa);
        kontenutama.add(valueSisaPulsaBeliPulsa);
        kontenutama.add(labelPilihanBeliPulsa);
        kontenutama.add(rd5k);
        kontenutama.add(rd10k);
        kontenutama.add(rd25k);
        kontenutama.add(rd50k);
        kontenutama.add(rd100k);
        kontenutama.add(btnBeliPulsa);
        setVisible(true);
    }
    private void jejakbelipulsa(){
        idSelected = null;
        resetSidebar();
        jejakbelipulsa.setBackground(cColor.BLUE);
        jejakbelipulsa.setForeground(cColor.WHITE);
        refreshContent();
        jejakbelipulsa.aturbilahsisiaktif();
        namamenu.setText("Transaksi Pulsa Saya");
        String[] dataHistoryPulsaHeader = {"Pulsa", "Mitra", "Waktu", "Status"};
        String[][] dataHistoryPulsa = {
          {"Row1 Col1", "Row1 Col2", "Row1 Col3", "Row1 Col4"},
          {"5.000", "-", "2021-08-19 15:30:21", "diproses"},
          {"25.000", "Yudi Cell", "2021-08-19 15:21:20", "selesai"},
          {"Row4 Col1", "Row4 Col2", "Row4 Col3", "Row4 Col4"},
          {"Row5 Col1", "Row5 Col2", "Row5 Col3", "Row5 Col4"},
          {"Row6 Col1", "Row6 Col2", "Row6 Col3", "Row6 Col4"},
          {"Row7 Col1", "Row7 Col2", "Row7 Col3", "Row7 Col4"},
          {"Row8 Col1", "Row8 Col2", "Row8 Col3", "Row8 Col4"},
          {"Row9 Col1", "Row9 Col2", "Row9 Col3", "Row9 Col4"},
          {"Row10 Col1", "Row10 Col2", "Row10 Col3", "Row10 Col4"}
        };
        dmHistoryPulsa = new DefaultTableModel(dataHistoryPulsa, dataHistoryPulsaHeader);
        tblDataHistoryPulsa = new cTable(dmHistoryPulsa);
        spDataHistoryPulsa = new cScrollpane(tblDataHistoryPulsa, 25, 65, 740, 310);
        kontenutama.add(labelHistoryPulsa);
        kontenutama.add(spDataHistoryPulsa);
        setVisible(true);
    }
    private void jejakbelipaket(){
        idSelected = null;
    resetSidebar();
    jejakbelipaket.setBackground(cColor.BLUE);
    jejakbelipaket.setForeground(cColor.WHITE);
    refreshContent();
    jejakbelipaket.aturbilahsisiaktif();
    namamenu.setText("Transaksi Paket Saya");
    String[] dataHistoryPaketHeader = {"Paket", "Kuota", "Harga", "Waktu", "Status"};
    String[][] dataHistoryPaket = {
      {"Row1 Col1", "Row1 Col2", "Row1 Col3", "Row1 Col4", "Row1 Col5"},
      {"Hemat Mantap", "11GB", "76.000", "2021-08-19 15:21:20", "selesai"},
      {"Row3 Col1", "Row3 Col2", "Row3 Col3", "Row3 Col4", "Row3 Col5"},
      {"Row4 Col1", "Row4 Col2", "Row4 Col3", "Row4 Col4", "Row4 Col5"},
      {"Row5 Col1", "Row5 Col2", "Row5 Col3", "Row5 Col4", "Row5 Col5"},
      {"Row6 Col1", "Row6 Col2", "Row6 Col3", "Row6 Col4", "Row6 Col5"},
      {"Row7 Col1", "Row7 Col2", "Row7 Col3", "Row7 Col4", "Row7 Col5"},
      {"Row8 Col1", "Row8 Col2", "Row8 Col3", "Row8 Col4", "Row8 Col5"},
      {"Row9 Col1", "Row9 Col2", "Row9 Col3", "Row9 Col4", "Row9 Col5"},
      {"Row10 Col1", "Row10 Col2", "Row10 Col3", "Row10 Col4", "Row10 Col5"}
    };
    dmHistoryPaket = new DefaultTableModel(dataHistoryPaket, dataHistoryPaketHeader);
    tblDataHistoryPaket = new cTable(dmHistoryPaket);
    spDataHistoryPaket = new cScrollpane(tblDataHistoryPaket, 25, 65, 924, 310);
    kontenutama.add(labelHistoryPaket);
    kontenutama.add(spDataHistoryPaket);
    setVisible(true);
    }
    private void akun(){
        
    idSelected = null;
    resetSidebar();
    akun.setBackground(cColor.BLUE);
    akun.setForeground(cColor.WHITE);
    refreshContent();
    akun.aturbilahsisiaktif();
    namamenu.setText("Akun Saya");
    valueNoHp = new cFormlabel("08123xxx", 25, 174, 360, false);
    valueNoHp.setFont(cFont.fontradiobutton);
    valueNoHp.setForeground(com.partials.cColor.RED);
    kontenutama.add(labelAkun);
    kontenutama.add(labelNama);
    kontenutama.add(txtNama);
    kontenutama.add(errorNama);
    kontenutama.add(labelNoHp);
    kontenutama.add(valueNoHp);
    kontenutama.add(labelEmail);
    kontenutama.add(txtEmail);
    kontenutama.add(errorEmail);
    kontenutama.add(btnUbahAkun);
    setVisible(true);
    }
    

}
