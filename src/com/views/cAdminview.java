package com.views;
import com.templates.cDashboardframe;
import com.partials.*;
import com.program.cController;
import com.program.cModel;

import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;


import java.awt.event.ActionListener;

public class cAdminview extends cDashboardframe{

  private boolean statusLogin = false;
  private Integer idSelected = null;

  
  private cSidebarmenu menuBeranda = new cSidebarmenu("Beranda", 70);
  private cSidebarmenu menuDataMitra = new cSidebarmenu("Data Mitra", 70+50);
  private cSidebarmenu menuDataCustomer = new cSidebarmenu("Data Customer", 70+50+50);
  private cSidebarmenu menuDataPaket = new cSidebarmenu("Data Paket", 70+50+50+50);
  private cSidebarmenu menuRequestSaldo = new cSidebarmenu("Request Saldo", 70+50+50+50+50);
  private cSidebarmenu menuCalonMitra = new cSidebarmenu("Calon Mitra", 70+50+50+50+50+50);
  private cSidebarmenu menuTransaksiPulsa = new cSidebarmenu("Transaksi Pulsa", 70+50+50+50+50+50+50);
  private cSidebarmenu menuTransaksiPaket = new cSidebarmenu("Transaksi Paket", 70+50+50+50+50+50+50+50);
  private cSidebarmenu menuLogout = new cSidebarmenu("Logout", 70+50+50+50+50+50+50+50+50);

private cInfo labelJmlDataMitraBeranda = new cInfo("Jumlah Data Mitra Terverifikasi", 25, 20);
private cInfonilai valueJmlDataMitraBeranda = new cInfonilai("0", 25, 60);
private cInfo labelJmlDataCustomerBeranda = new cInfo("Jumlah Data Customer Aktif", 25, 150);
private cInfonilai valueJmlDataCustomerBeranda = new cInfonilai("0", 25, 190);
private cInfo labelJmlTransaksiPulsaBeranda = new cInfo("Jumlah Transaksi Pulsa Berhasil", 25, 280);
private cInfonilai valueJmlTransaksiPulsaBeranda = new cInfonilai("0", 25, 320);
private cInfo labelJmlTransaksiPaketBeranda = new cInfo("Jumlah Transaksi Paket Berhasil", 495, 20);
private cInfonilai valueJmlTransaksiPaketBeranda = new cInfonilai("0", 495, 60);
private cInfo labelJmlCalonMitraBeranda = new cInfo("Jumlah Data Calon Mitra", 495, 150);
private cInfonilai valueJmlCalonMitraBeranda = new cInfonilai("0", 495, 190);
private cInfo labelJmlRequestSaldoBeranda = new cInfo("Jumlah Request Saldo Pending", 495, 280);
private cInfonilai valueJmlRequestSaldoBeranda = new cInfonilai("0", 495, 320);

 
  private cInfo labelDataMitra = new cInfo("Data Mitra Terverifikasi", 25, 20);
  private cFormlabel labelCariDataMitra = new cFormlabel("Cari", 25, 75, 55, false);
  private cTextfield txtCariDataMitra = new cTextfield(83, 70, 350, false);
  private cTable tblDataDataMitra;
  private cScrollpane spDataDataMitra;
  private cRedbutton btnHapusDataMitra = new cRedbutton("Hapus", 25, 446, 110);
  

  private cInfo labelDataCustomer = new cInfo("Data Customer Aktif", 25, 20);
  private cFormlabel labelCariDataCustomer = new cFormlabel("Cari", 25, 75, 55, false);
  private cTextfield txtCariDataCustomer = new cTextfield(83, 70, 350, false);
  private cTable tblDataDataCustomer;
  private cScrollpane spDataDataCustomer;
  private cRedbutton btnHapusDataCustomer = new cRedbutton("Hapus", 25, 446, 110);

  private cInfo labelDataPaket = new cInfo("Data Request Request Saldo Pending", 25, 20);
  private cFormlabel labelCariDataPaket = new cFormlabel("Cari", 25, 75, 55, false);
  private cTextfield txtCariDataPaket = new cTextfield(83, 70, 317, false);
  private cBluebutton btnTambahDataPaket = new cBluebutton("Tambah Paket", 418, 70, 162);
  private cRadionbutton rdSemuaDataPaket = new cRadionbutton("Semua", "all", 25, 115, 97);
  private cRadionbutton rdAktifDataPaket = new cRadionbutton("Aktif", "active", 132, 115, 72);
  private cRadionbutton rdTidakAktifDataPaket = new cRadionbutton("Tidak Aktif", "nonactive", 214, 115, 112);
  private ButtonGroup groupActionDataPaket = new ButtonGroup();
  private cTable tblDataDataPaket;
  private cScrollpane spDataDataPaket;
  private cGreenbutton btnUbahDataPaket = new cGreenbutton("Ubah", 25, 410, 92);
  private cInfo labelDeskripsiPaketDataPaket = new cInfo("DeskripsiPaket", 600, 145);
  private cTeksarea valueDeskripsiPaketDataPaket = new cTeksarea("", 600, 186, false);
  
 
  private cInfo labelTambahDataPaket = new cInfo("Isi form data paket dengan lengkap", 25, 20);
  private cFormlabel labelNamaPaketTambahDataPaket = new cFormlabel("Nama Paket", 25, 65, 550, false);
  private cTextfield txtNamaPaketTambahDataPaket = new cTextfield(25, 90, 550, false);
  private cErrorlabel errorNamaPaketTambahDataPaket = new cErrorlabel("nama paket tidak boleh kosong!", 25, 125, 550, false);
  private cFormlabel labelKuotaPaketTambahDataPaket = new cFormlabel("Kuota Paket", 25, 150, 550, false);
  private cTextfield txtKuotaPaketTambahDataPaket = new cTextfield(25, 175, 550, false);
  private cErrorlabel errorKuotaPaketTambahDataPaket = new cErrorlabel("kuota paket tidak boleh kosong!", 25, 210, 550, false);
  private cFormlabel labelHargaPaketTambahDataPaket = new cFormlabel("Harga Paket", 25, 235, 550, false);
  private cTextfield txtHargaPaketTambahDataPaket = new cTextfield(25, 260, 550, false);
  private cErrorlabel errorHargaPaketTambahDataPaket = new cErrorlabel("harga paket tidak boleh kosong!", 25, 295, 550, false);
  private cCheckbox chAktifTambahDataPaket = new cCheckbox("Aktifkan", "1", 25, 316, 100);
  private cBluebutton btnTambahPaketTambahDataPaket = new cBluebutton("Tambah", 25, 348, 110);
  private cRedbutton btnBatalTambahDataPaket = new cRedbutton("Batal", 155, 348, 110);
  private cFormlabel labelDeskripsiPaketTambahDataPaket = new cFormlabel("Deskripsi Paket", 595, 65, 370, false);
  private cTeksarea txtDeskripsiPaketTambahDataPaket = new cTeksarea(true);
  private cScrollpane spTxtDeskripsiPaketTambahDataPaket = new cScrollpane(txtDeskripsiPaketTambahDataPaket, 595, 90, 370, 205);
  private cErrorlabel errorDeskripsiPaketTambahDataPaket = new cErrorlabel("deskripsi paket tidak boleh kosong!", 595, 295, 370, false);


  private cInfo labelUbahDataPaket = new cInfo("Isi form data paket dengan lengkap", 25, 20);
  private cFormlabel labelNamaPaketUbahDataPaket = new cFormlabel("Nama Paket", 25, 65, 550, false);
  private cTextfield txtNamaPaketUbahDataPaket = new cTextfield(25, 90, 550, false);
  private cErrorlabel errorNamaPaketUbahDataPaket = new cErrorlabel("nama paket tidak boleh kosong!", 25, 125, 550, false);
  private cFormlabel labelKuotaPaketUbahDataPaket = new cFormlabel("Kuota Paket", 25, 150, 550, false);
  private cTextfield txtKuotaPaketUbahDataPaket = new cTextfield(25, 175, 550, false);
  private cErrorlabel errorKuotaPaketUbahDataPaket = new cErrorlabel("kuota paket tidak boleh kosong!", 25, 210, 550, false);
  private cFormlabel labelHargaPaketUbahDataPaket = new cFormlabel("Harga Paket", 25, 235, 550, false);
  private cTextfield txtHargaPaketUbahDataPaket = new cTextfield(25, 260, 550, false);
  private cErrorlabel errorHargaPaketUbahDataPaket = new cErrorlabel("harga paket tidak boleh kosong!", 25, 295, 550, false);
  private cCheckbox chAktifUbahDataPaket = new cCheckbox("Aktifkan", "1", 25, 316, 100);
  private cBluebutton btnUbahPaketUbahDataPaket = new cBluebutton("Ubah", 25, 348, 110);
  private cRedbutton btnBatalUbahDataPaket = new cRedbutton("Batal", 155, 348, 110);
  private cFormlabel labelDeskripsiPaketUbahDataPaket = new cFormlabel("Deskripsi Paket", 595, 65, 370, false);
  private cTeksarea txtDeskripsiPaketUbahDataPaket = new cTeksarea(true);
  private cScrollpane spTxtDeskripsiPaketUbahDataPaket = new cScrollpane(txtDeskripsiPaketUbahDataPaket, 595, 90, 370, 205);
  private cErrorlabel errorDeskripsiPaketUbahDataPaket = new cErrorlabel("deskripsi paket tidak boleh kosong!", 595, 295, 370, false);
  

  private cInfo labelRequestSaldo = new cInfo("Data Request Request Saldo Pending", 25, 20);
  private cFormlabel labelCariRequestSaldo = new cFormlabel("Cari", 25, 75, 55, false);
  private cTextfield txtCariRequestSaldo = new cTextfield(83, 70, 317, false);
  private cBluebutton btnLihatBerhasilRequestSaldo = new cBluebutton("Lihat Berhasil", 418, 70, 162);
  private cTable tblDataRequestSaldo;
  private cScrollpane spDataRequestSaldo;
  private cGreenbutton btnApproveRequestSaldo = new cGreenbutton("Setujui", 25, 446, 110);
  

  private cInfo labelRequestSaldoDone = new cInfo("Data Request Request Saldo Berhasil", 25, 20);
  private cFormlabel labelCariRequestSaldoDone = new cFormlabel("Cari", 25, 75, 55, false);
  private cTextfield txtCariRequestSaldoDone = new cTextfield(83, 70, 317, false);
  private cBluebutton btnLihatPendingRequestSaldoDone = new cBluebutton("Lihat Pending", 418, 70, 162);
  private cTable tblDataRequestSaldoDone;
  private cScrollpane spDataRequestSaldoDone;
  

  private cInfo labelCalonMitra = new cInfo("Data Request Calon Mitra", 25, 20);
  private cFormlabel labelCariCalonMitra = new cFormlabel("Cari", 25, 75, 55, false);
  private cTextfield txtCariCalonMitra = new cTextfield(83, 70, 350, false);
  private cTable tblDataCalonMitra;
  private cScrollpane spDataCalonMitra;
  private cGreenbutton btnApproveCalonMitra = new cGreenbutton("Setujui", 25, 446, 110);
  

  private cInfo labelTransaksiPulsa = new cInfo("Semua Data Transaksi Pulsa", 25, 20);
  private cFormlabel labelCariTransaksiPulsa = new cFormlabel("Cari", 25, 75, 55, false);
  private cTextfield txtCariTransaksiPulsa = new cTextfield(83, 70, 350, false);
  private cTable tblDataTransaksiPulsa;
  private cScrollpane spDataTransaksiPulsa;
  
  private cInfo labelTransaksiPaket = new cInfo("Semua Data Transaksi Paket", 25, 20);
  private cFormlabel labelCariTransaksiPaket = new cFormlabel("Cari", 25, 75, 55, false);
  private cTextfield txtCariTransaksiPaket = new cTextfield(83, 70, 350, false);
  private cTable tblDataTransaksiPaket;
  private cScrollpane spDataTransaksiPaket;




  private void resetSidebar()
  {
    try {
      setVisible(false);
      
      menuBeranda.setForeground(cColor.GRAY);
      menuBeranda.setBackground(cColor.WHITE);
      menuBeranda.aturbilahsisitidakaktif();

      menuDataMitra.setForeground(cColor.GRAY);
      menuDataMitra.setBackground(cColor.WHITE);
      menuDataMitra.aturbilahsisitidakaktif();

      menuDataCustomer.setForeground(cColor.GRAY);
      menuDataCustomer.setBackground(cColor.WHITE);
      menuDataCustomer.aturbilahsisitidakaktif();

      menuDataPaket.setForeground(cColor.GRAY);
      menuDataPaket.setBackground(cColor.WHITE);
      menuDataPaket.aturbilahsisitidakaktif();

      menuRequestSaldo.setForeground(cColor.GRAY);
      menuRequestSaldo.setBackground(cColor.WHITE);
      menuRequestSaldo.aturbilahsisitidakaktif();

      menuCalonMitra.setForeground(cColor.GRAY);
      menuCalonMitra.setBackground(cColor.WHITE);
      menuCalonMitra.aturbilahsisitidakaktif();

      menuTransaksiPulsa.setForeground(cColor.GRAY);
      menuTransaksiPulsa.setBackground(cColor.WHITE);
      menuTransaksiPulsa.aturbilahsisitidakaktif();

      menuTransaksiPaket.setForeground(cColor.GRAY);
      menuTransaksiPaket.setBackground(cColor.WHITE);
      menuTransaksiPaket.aturbilahsisitidakaktif();

      
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

  public cAdminview( boolean statusLogin )
  {
    super("Dashboard Admin");
    this.statusLogin = statusLogin;
    this.idSelected = null;
    namabagian.setText("Admin");
    menuBeranda.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsBeranda();
      }
    });
    menuDataMitra.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataMitra();
      }
    });
    menuDataCustomer.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataCustomer();
      }
    });
    menuDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsDataPaket();
      }
    });
    menuRequestSaldo.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsRequestSaldo();
      }
    });
    menuCalonMitra.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsCalonMitra();
      }
    });
    menuTransaksiPulsa.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsTransaksiPulsa();
      }
    });
    menuTransaksiPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsTransaksiPaket();
      }
    });


    menuLogout.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        initsLogout();
      }
    });


    // add component default
    bilahsamping.add(menuBeranda);
    bilahsamping.add(menuDataMitra);
    bilahsamping.add(menuDataCustomer);
    bilahsamping.add(menuDataPaket);
    bilahsamping.add(menuRequestSaldo);
    bilahsamping.add(menuCalonMitra);
    bilahsamping.add(menuTransaksiPulsa);
    bilahsamping.add(menuTransaksiPaket);
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
    valueJmlDataMitraBeranda.setText(String.valueOf(cModel.hitungmitraterverifikasi()));
    valueJmlDataCustomerBeranda.setText(String.valueOf(cModel.hitungpelanggan()));
    valueJmlTransaksiPulsaBeranda.setText(String.valueOf(cModel.hitungsemuatransaksipulsa()));
    valueJmlTransaksiPaketBeranda.setText(String.valueOf(cModel.hitungsemuatransaksipaket()));
    valueJmlCalonMitraBeranda.setText(String.valueOf(cModel.hitungmitratidakterverifikasi()));
    valueJmlRequestSaldoBeranda.setText(String.valueOf(cModel.hitungtransaksisaldoundur()));;
    kontenutama.add(labelJmlDataMitraBeranda);
    kontenutama.add(valueJmlDataMitraBeranda);
    kontenutama.add(labelJmlDataCustomerBeranda);
    kontenutama.add(valueJmlDataCustomerBeranda);
    kontenutama.add(labelJmlTransaksiPulsaBeranda);
    kontenutama.add(valueJmlTransaksiPulsaBeranda);
    kontenutama.add(labelJmlTransaksiPaketBeranda);
    kontenutama.add(valueJmlTransaksiPaketBeranda);
    kontenutama.add(labelJmlCalonMitraBeranda);
    kontenutama.add(valueJmlCalonMitraBeranda);
    kontenutama.add(labelJmlRequestSaldoBeranda);
    kontenutama.add(valueJmlRequestSaldoBeranda);
    setVisible(true);
  }

  private void initsDataMitra()
  {
    idSelected = null;
    resetSidebar();
    menuDataMitra.setBackground(cColor.BLUE);
    menuDataMitra.setForeground(cColor.WHITE);
    refreshContent();
    menuDataMitra.aturbilahsisiaktif();
    namamenu.setText("Data Mitra");
    
    tblDataDataMitra = new cTable(cModel.ambilsemuasaldomitra());
    tblDataDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(0).setWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataDataMitra.getColumnModel().getColumn(1).setWidth(0);
    spDataDataMitra = new cScrollpane(tblDataDataMitra, 25, 120, 555, 310);
    kontenutama.add(labelDataMitra);
    kontenutama.add(labelCariDataMitra);
    kontenutama.add(txtCariDataMitra);
    kontenutama.add(spDataDataMitra);
    kontenutama.add(btnHapusDataMitra);
    setVisible(true);
  }

  private void initsDataCustomer()
  {
    idSelected = null;
    resetSidebar();
    menuDataCustomer.setBackground(cColor.BLUE);
    menuDataCustomer.setForeground(cColor.WHITE);
    refreshContent();
    menuDataCustomer.aturbilahsisiaktif();
    namamenu.setText("Data Customer");

   tblDataDataCustomer = new cTable(cModel.ambilpulsakuotpelanggan());
    tblDataDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataCustomer.getColumnModel().getColumn(0).setWidth(0);
    spDataDataCustomer = new cScrollpane(tblDataDataCustomer, 25, 120, 925, 310);
    kontenutama.add(labelDataCustomer);
    kontenutama.add(labelCariDataCustomer);
    kontenutama.add(txtCariDataCustomer);
    kontenutama.add(spDataDataCustomer);
    kontenutama.add(btnHapusDataCustomer);
    setVisible(true);
  }

  private void initsDataPaket()
  {
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.BLUE);
    menuDataPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuDataPaket.aturbilahsisiaktif();
    namamenu.setText("Data Paket");
  
    tblDataDataPaket = new cTable(cModel.ambilsemuapaket());
    tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
    tblDataDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mousePressed( java.awt.event.MouseEvent me )
      {
        int selectedIndex = tblDataDataPaket.getSelectedRow();
        // int idPaket = Integer.parseInt(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());
        int idPaket = Integer.valueOf(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());

        String deskripsiPaket = cModel.aambildetailpaket(idPaket)[2].toString();
        valueDeskripsiPaketDataPaket.setText(deskripsiPaket);
      }
    } );
    spDataDataPaket = new cScrollpane(tblDataDataPaket, 25, 145, 555, 250);
    rdSemuaDataPaket.setSelected(true);
    groupActionDataPaket.add(rdSemuaDataPaket);
    groupActionDataPaket.add(rdAktifDataPaket);
    groupActionDataPaket.add(rdTidakAktifDataPaket);

    rdSemuaDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked( java.awt.event.MouseEvent me )
      {
        tblDataDataPaket.setModel(cModel.ambilsemuapaket());
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    } );

    rdAktifDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked( java.awt.event.MouseEvent me )
      {
        tblDataDataPaket.setModel(cModel.ambilpaketaktif());
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    } );

    rdTidakAktifDataPaket.addMouseListener( new java.awt.event.MouseAdapter(){
      @Override
      public void mouseClicked( java.awt.event.MouseEvent me )
      {
        tblDataDataPaket.setModel(cModel.ambilpakettidakaktif());
        tblDataDataPaket.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataDataPaket.getColumnModel().getColumn(0).setWidth(0);
        valueDeskripsiPaketDataPaket.setText(null);
      }
    } );
    btnTambahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsTambahPaket();
      }
    });

    btnUbahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsUbahPaket();
      }
    });

    String textDeskripsiPaket = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam totam doloribus velit ipsa! Beatae tempore quod laborum porro optio aliquam voluptate commodi assumenda explicabo debitis accusamus obcaecati, quo nostrum esse!";
    valueDeskripsiPaketDataPaket.setText(textDeskripsiPaket);
    kontenutama.add(labelDataPaket);
    kontenutama.add(labelCariDataPaket);
    kontenutama.add(txtCariDataPaket);
    kontenutama.add(btnTambahDataPaket);
    kontenutama.add(rdSemuaDataPaket);
    kontenutama.add(rdAktifDataPaket);
    kontenutama.add(rdTidakAktifDataPaket);
    kontenutama.add(spDataDataPaket);
    kontenutama.add(btnUbahDataPaket);
    kontenutama.add(labelDeskripsiPaketDataPaket);
    kontenutama.add(valueDeskripsiPaketDataPaket);
    setVisible(true);
  }

  private void initsTambahPaket()
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.BLUE);
    menuDataPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuDataPaket.aturbilahsisiaktif();
    namamenu.setText("Tambah Data Paket");
    btnBatalTambahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsDataPaket();
      }
    });
    kontenutama.add(labelTambahDataPaket);
    kontenutama.add(labelNamaPaketTambahDataPaket);
    kontenutama.add(txtNamaPaketTambahDataPaket);
    kontenutama.add(errorNamaPaketTambahDataPaket);
    kontenutama.add(labelKuotaPaketTambahDataPaket);
    kontenutama.add(txtKuotaPaketTambahDataPaket);
    kontenutama.add(errorKuotaPaketTambahDataPaket);
    kontenutama.add(labelHargaPaketTambahDataPaket);
    kontenutama.add(txtHargaPaketTambahDataPaket);
    kontenutama.add(errorHargaPaketTambahDataPaket);
    kontenutama.add(chAktifTambahDataPaket);
    kontenutama.add(btnTambahPaketTambahDataPaket);
    kontenutama.add(btnBatalTambahDataPaket);
    kontenutama.add(labelDeskripsiPaketTambahDataPaket);
    kontenutama.add(spTxtDeskripsiPaketTambahDataPaket);
    kontenutama.add(errorDeskripsiPaketTambahDataPaket);
    setVisible(true);
  }
  private void initsUbahPaket()
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuDataPaket.setBackground(cColor.BLUE);
    menuDataPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuDataPaket.aturbilahsisiaktif();
    namamenu.setText("Ubah Data Paket");
    btnBatalUbahDataPaket.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsDataPaket();
      }
    });
    kontenutama.add(labelUbahDataPaket);
    kontenutama.add(labelNamaPaketUbahDataPaket);
    kontenutama.add(txtNamaPaketUbahDataPaket);
    kontenutama.add(errorNamaPaketUbahDataPaket);
    kontenutama.add(labelKuotaPaketUbahDataPaket);
    kontenutama.add(txtKuotaPaketUbahDataPaket);
    kontenutama.add(errorKuotaPaketUbahDataPaket);
    kontenutama.add(labelHargaPaketUbahDataPaket);
    kontenutama.add(txtHargaPaketUbahDataPaket);
    kontenutama.add(errorHargaPaketUbahDataPaket);
    kontenutama.add(chAktifUbahDataPaket);
    kontenutama.add(btnUbahPaketUbahDataPaket);
    kontenutama.add(btnBatalUbahDataPaket);
    kontenutama.add(labelDeskripsiPaketUbahDataPaket);
    kontenutama.add(spTxtDeskripsiPaketUbahDataPaket);
    kontenutama.add(errorDeskripsiPaketUbahDataPaket);
    setVisible(true);
  }

  private void initsRequestSaldo()
  {
    idSelected = null;
    resetSidebar();
    menuRequestSaldo.setBackground(cColor.BLUE);
    menuRequestSaldo.setForeground(cColor.WHITE);
    refreshContent();
    menuRequestSaldo.aturbilahsisiaktif();
    namamenu.setText("Request Saldo Pending");
 
    tblDataRequestSaldo = new cTable(cModel.undurtransaksisaldo());
    tblDataRequestSaldo.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataRequestSaldo.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataRequestSaldo.getColumnModel().getColumn(0).setWidth(0);
    spDataRequestSaldo = new cScrollpane(tblDataRequestSaldo, 25, 120, 555, 310);

    btnLihatBerhasilRequestSaldo.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsRequestSaldoDone();
      }
    });

    kontenutama.add(labelRequestSaldo);
    kontenutama.add(labelCariRequestSaldo);
    kontenutama.add(txtCariRequestSaldo);
    kontenutama.add(btnLihatBerhasilRequestSaldo);
    kontenutama.add(spDataRequestSaldo);
    kontenutama.add(btnApproveRequestSaldo);
    setVisible(true);
  }

  private void initsRequestSaldoDone()
  {
    // setVisible(false);
    idSelected = null;
    resetSidebar();
    menuRequestSaldo.setBackground(cColor.BLUE);
    menuRequestSaldo.setForeground(cColor.WHITE);
    refreshContent();
    menuRequestSaldo.aturbilahsisiaktif();
    namamenu.setText("Permintaan Saldo Berhasil");

    tblDataRequestSaldoDone = new cTable(cModel.selesaikantransaksisaldo());
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataRequestSaldoDone.getColumnModel().getColumn(0).setWidth(0);

    spDataRequestSaldoDone = new cScrollpane(tblDataRequestSaldoDone, 25, 120, 555, 310);

    btnLihatPendingRequestSaldoDone.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        initsRequestSaldo();
      }
    });

    kontenutama.add(labelRequestSaldoDone);
    kontenutama.add(labelCariRequestSaldoDone);
    kontenutama.add(txtCariRequestSaldoDone);
    kontenutama.add(btnLihatPendingRequestSaldoDone);
    kontenutama.add(spDataRequestSaldoDone);
    setVisible(true);
  }

  private void initsCalonMitra()
  {
    idSelected = null;
    resetSidebar();
    menuCalonMitra.setBackground(cColor.BLUE);
    menuCalonMitra.setForeground(cColor.WHITE);
    refreshContent();
    menuCalonMitra.aturbilahsisiaktif();
    namamenu.setText("Calon Mitra");
 
    tblDataCalonMitra = new cTable(cModel.ambilmitratidakterferifikasi());
    tblDataCalonMitra.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataCalonMitra.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataCalonMitra.getColumnModel().getColumn(0).setWidth(0);
    spDataCalonMitra = new cScrollpane(tblDataCalonMitra, 25, 120, 555, 310);
    kontenutama.add(labelCalonMitra);
    kontenutama.add(labelCariCalonMitra);
    kontenutama.add(txtCariCalonMitra);
    kontenutama.add(spDataCalonMitra);
    kontenutama.add(btnApproveCalonMitra);
    setVisible(true);
  }

  private void initsTransaksiPulsa()
  {
    idSelected = null;
    resetSidebar();
    menuTransaksiPulsa.setBackground(cColor.BLUE);
    menuTransaksiPulsa.setForeground(cColor.WHITE);
    refreshContent();
    menuTransaksiPulsa.aturbilahsisiaktif();
    namamenu.setText("Transaksi Pulsa");
    
    tblDataTransaksiPulsa = new cTable(cModel.ambilsemuatraksaksipulsa());
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataTransaksiPulsa.getColumnModel().getColumn(0).setWidth(0);
    spDataTransaksiPulsa = new cScrollpane(tblDataTransaksiPulsa, 25, 120, 930, 310);
    kontenutama.add(labelTransaksiPulsa);
    kontenutama.add(labelCariTransaksiPulsa);
    kontenutama.add(txtCariTransaksiPulsa);
    kontenutama.add(spDataTransaksiPulsa);
    setVisible(true);
  }

  private void initsTransaksiPaket()
  {
    idSelected = null;
    resetSidebar();
    menuTransaksiPaket.setBackground(cColor.BLUE);
    menuTransaksiPaket.setForeground(cColor.WHITE);
    refreshContent();
    menuTransaksiPaket.aturbilahsisiaktif();
    namamenu.setText("Transaksi Paket");
  
    tblDataTransaksiPaket = new cTable(cModel.ambilsemuatransaksipaket());
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataTransaksiPaket.getColumnModel().getColumn(0).setWidth(0);
    spDataTransaksiPaket = new cScrollpane(tblDataTransaksiPaket, 25, 120, 930, 310);
    kontenutama.add(labelTransaksiPaket);
    kontenutama.add(labelCariTransaksiPaket);
    kontenutama.add(txtCariTransaksiPaket);
    kontenutama.add(spDataTransaksiPaket);
    setVisible(true);
  }

  private void initsLogout()
  {
    Object[] options = { "YA", "BATAL" };
    int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
    null, options, options[0]);
    if(confirm == 0 ){
      this.statusLogin = false;
      this.idSelected = null;
      cController.tampilanmasukadmin();
    }
  }


  
}