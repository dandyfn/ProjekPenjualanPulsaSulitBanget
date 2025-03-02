package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class cModel {
    private static final String DB_URL = "jdbc:mysql://localhost:3006/dbbarang";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;
    private static ResultSet resultSet;
    private static Statement statement;
    
    private static void connection(){
        try {
             connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    };

    public static  DefaultTableModel ambilsemuamitra(){
        String tajuktabel [] = {"idSaldoMitra","idMitra","namaMitra","emailMitra","saldoMitra"};
        DefaultTableModel modeltabel = new DefaultTableModel(null, tajuktabel);
       

        try {
            connection();
            statement = connection.createStatement();
            String queri = "select * from vwsaldomitra";
            ResultSet isidata = statement.executeQuery(queri);

            while (isidata.next()) {
                Object [] data = {isidata.getInt("idSaldoMitra"),
                isidata.getInt("idMitra"),isidata.getString("namaMitra"),
                isidata.getString("emailMitra"),isidata.getInt("saldoMitra")};
                modeltabel.addRow(data);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

         return modeltabel;
    }


    public static int hitungsemuamitra()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connection.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwallmitra";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connection
      statement.close();
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel ambilmitratidakterferifikasi()
  {
    connection();
    String[] dataHeader = {"ID Mitra", "Nama", "Email"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object  yang ambil dari koneksi
      statement = connection.createStatement();

      // query select
      String query = "SELECT * FROM vwmitranonverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connectionion
      statement.close();
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  
  public static int hitungmitratidakterverifikasi()
  {
    connection();
    int count = 0;

    try {

      // buat object statement yang ambil dari koneksi
      statement = connection.createStatement();

      // query select
      String query = "SELECT COUNT(*) FROM vwmitranonverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      resultData.next();
      count = resultData.getInt(1);
      
      // close statement dan connectionion
      statement.close();
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static DefaultTableModel ambilmitraterverifikasi()
  {
    connection();
    
    String[] dataHeader = {"ID Mitra", "Nama Mitra", "Email Mitra"};
    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

    try {

      // buat object statement yang ambil dari koneksi
      statement = connection.createStatement();

      // query select
      String query = "SELECT * FROM vwmitraterverifikasi";

      // eksekusi query-nya
      ResultSet resultData = statement.executeQuery(query);
      
      // looping pengisian DefaultTableModel
      while( resultData.next() ){
        Object[] rowData = { resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra") };
        tm.addRow(rowData);
      }
      
      // close statement dan connectionion
      statement.close();
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return tm;

  }
  

    public static int hitungmitraterverifikasi(){
        connection();
        int hasilhitung = 0;
        try {

            statement = connection.createStatement();
            String query = "select count(*) from vwmitraterverifikasi";
            ResultSet isidata = statement.executeQuery(query);

            isidata.next();
            hasilhitung = isidata.getInt(1);
            connection.close();;
            statement.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return hasilhitung;
    }


    public static DefaultTableModel ambilsemuasaldomitra()
    {
      connection();
  
      String[] dataHeader = {"ID Saldo Mitra", "ID Mitra", "Nama", "Email", "Saldo"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwsaldomitra";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = { resultData.getInt("idSaldoMitra"), resultData.getInt("idMitra"), resultData.getString("namaMitra"), resultData.getString("emailMitra"), resultData.getInt("saldoMitra") };
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
    
    public static boolean verifikasiemailmitra( String email )
    {
      connection();
      boolean available = false;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwallmitra WHERE emailMitra = '" + email + "'";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        if ( resultData.getInt(1) == 0){
          available = true;
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return available;
    }
    
    public static boolean verifikasiakunmitra( String email, String password )
    {
      connection();
      boolean available = false;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwallmitra WHERE emailMitra = '" + email + "' AND passwordMitra = '" + password + "'";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        if ( resultData.getInt(1) == 1){
          available = true;
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return available;
    }
  
    public static int ambildetailsalodmitra( int idMitra )
    {
      connection();
  
      int saldo = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT saldoMitra FROM vwsaldomitra WHERE idMitra = " + idMitra;
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        saldo = resultData.getInt("saldoMitra");
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return saldo;
  
    }
    
  
    // Customer static function
    public static DefaultTableModel ambilpelanggan()
    {
      connection();
      
      String[] dataHeader = {"ID Customer", "Nama Customer", "No HP", "Email"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwcustomer";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idCustomer"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("emailCustomer")};
          tm.addRow(rowData);
        }
        
        // close statement dan connection
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static DefaultTableModel ambilpulsakuotpelanggan()
    {
      connection();
      String[] dataHeader = {"ID Pulsa Kuota", "ID Customer", "Nama Customer", "No. Hp", "Pulsa", "Kuota"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwpulsakuotacustomer";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idPulsaKuotaCustomer"), resultData.getInt("idCustomer"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("pulsaCustomer"), resultData.getInt("kuotaCustomer") + "GB"};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
    
    public static boolean verifikasinohppelanggan( String noHp )
    {
      connection();
      boolean available = false;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwcustomer WHERE nomorHpCustomer = '" + noHp + "'";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        if ( resultData.getInt(1) == 0){
          available = true;
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return available;
    }
  
    public static boolean verifikasiakunpelanggan( String noHp, String password )
    {
      connection();
      boolean available = false;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwcustomer WHERE nomorHpCustomer = '" + noHp + "' AND passwordCustomer = '" + password + "'";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        if ( resultData.getInt(1) == 1){
          available = true;
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return available;
    }
  
    public static int hitungpelanggan()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwcustomer";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
  
    // Paket static function
    public static DefaultTableModel ambilsemuapaket()
    {
      connection();
      
      String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwallpaket ORDER BY idPaket DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), (resultData.getString("statusAktif").toString().equalsIgnoreCase("1")) ? "Aktif" : "Tidak Aktif"};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungsemuapaket()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwallpaket";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel ambilpaketaktif()
    {
      connection();
      
      String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwpaketaktif ORDER BY idPaket DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), "Aktif"};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
    
    public static DefaultTableModel ambilpaketaktifdaripelanggan()
    {
      connection();
      
      String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwpaketaktif ORDER BY idPaket DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungpaketaktif()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwpaketaktif";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel ambilpakettidakaktif()
    {
      connection();
      
      String[] dataHeader = {"ID Paket", "Nama Paket", "Kuota", "Harga", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwpaketnonaktif ORDER BY idPaket DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idPaket"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), "Tidak Aktif"};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungpakettidakaktif()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwpaketnonaktif";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
  
    // Transaksi Paket function static
    public static DefaultTableModel ambilsemuatransaksipaket()
    {
      connection();
      String[] dataUHeader = {"ID Transaksi Paket", "Customer", "No HP", "Paket", "Kuota", "Harga", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataUHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwalltransaksipaket ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiPaket"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static DefaultTableModel ambilsemuatransaksipaketdaripelanggan( int idCustomer)
    {
      connection();
      
      String[] dataHeader = {"Nama Paket", "Kuota", "Harga", "Waktu Transaksi", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwalltransaksipaket WHERE idCustomer = " + idCustomer + " ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungsemuatransaksipaket()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwalltransaksipaket";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel selesaikantransaksipaket()
    {
      connection();
      
      String[] dataHeader = {"ID Transaksi Paket", "Nama Customer", "No HP", "Nama Paket", "Kuota", "Harga", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwdonetransaksipaket ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiPaket"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungtransaksipaketselesai()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwdonetransaksipaket";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel undurtransaksipaket()
    {
      connection();
      
      String[] dataHeader = {"ID Transaksi Paket", "Nama Customer", "No HP", "Nama Paket", "Kuota", "Harga", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwpendingtransaksipaket ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiPaket"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getString("namaPaket"), resultData.getInt("kuota") + "GB", "Rp." + resultData.getInt("hargaPaket"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungtransaksipaketundur()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwpendingtransaksipaket";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
  
    // Transaksi Pulsa function static
    public static DefaultTableModel ambilsemuatraksaksipulsa()
    {
      connection();
  
      String[] dataHeader = {"ID Transaksi Pulsa", "Customer", "No HP", "Pulsa", "Mitra", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwalltransaksipulsa ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiPulsa"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"), resultData.getString("namaMitra"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static DefaultTableModel ambilsemuatransaksipulsadaripelanggan( int idCustomer )
    {
      connection();
      
      String[] dataHeader = {"Jumlah Pulsa", "Mitra", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwalltransaksipulsa WHERE idCustomer = " + idCustomer + " ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("jumlahPulsa"), resultData.getString("namaMitra"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return tm;
    }
  
    public static int hitungsemuatransaksipulsa()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwalltransaksipulsa";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel selesaikantransaksipulsa()
    {
      connection();
      
      String[] dataHeader = {"ID Transaksi Pulsa", "Nama Customer", "No HP", "Jumlah Pulsa", "Mitra", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwdonetransaksipulsa ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiPulsa"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"), resultData.getString("namaMitra"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return tm;
  
    }
  
    public static int hitungtransaksipulsaselesai()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwdonetransaksipulsa";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel selesaikantransaksipulsaolehmitra( int idMitra )
    {
      connection();
      
      String[] dataHeader = {"Nama Customer", "No HP", "Jumlah Pulsa", "Waktu"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwdonetransaksipulsa WHERE idMitra = " + idMitra + " ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"),resultData.getString("waktuTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungtransaksipulsaselesaiolehmitra(int idMitra)
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwdonetransaksipulsa WHERE idMitra = " + idMitra;
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel undurtransaksipulsa()
    {
      connection();
      
      String[] dataHeader = {"ID Transaksi Pulsa", "Nama Customer", "No HP", "Jumlah Pulsa", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwpendingtransaksipulsa ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiPulsa"), resultData.getString("namaCustomer"), resultData.getString("nomorHpCustomer"), resultData.getInt("jumlahPulsa"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungtansaksipulsaundur()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwpendingtransaksipulsa";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
  
    // Transaksi Saldo function static
    public static DefaultTableModel ambilsemuatransaksisaldo()
    {
      connection();
      
      String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwalltransaksisaldo ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiSaldo"), resultData.getString("namaMitra"), resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      
      return tm;
  
    }
  
    public static DefaultTableModel ambilsemuatransaksisaldoolehmitra( int idMitra )
    {
      connection();
      
      String[] dataHeader = {"Jumlah Saldo", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwalltransaksisaldo WHERE idMitra = " + idMitra + " ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungsemuatransaksisaldo()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwalltransaksisaldo";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel selesaikantransaksisaldo()
    {
      connection();
      String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwdonetransaksisaldo ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiSaldo"), resultData.getString("namaMitra"), resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungtransaksisaldoselesai()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwdonetransaksisaldo";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
    public static DefaultTableModel undurtransaksisaldo()
    {
      connection();
      String[] dataHeader = {"ID Transaksi Saldo", "Nama Mitra", "Jumlah Saldo", "Waktu", "Status"};
      DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwpendingtransaksisaldo ORDER BY waktuTransaksi DESC";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        while( resultData.next() ){
          Object[] rowData = {resultData.getInt("idTransaksiSaldo"), resultData.getString("namaMitra"), resultData.getInt("jumlahSaldo"), resultData.getString("waktuTransaksi"), resultData.getString("statusTransaksi")};
          tm.addRow(rowData);
        }
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return tm;
  
    }
  
    public static int hitungtransaksisaldoundur()
    {
      connection();
      int count = 0;
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT COUNT(*) FROM vwpendingtransaksisaldo";
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        count = resultData.getInt(1);
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return count;
    }
  
  
    // Detail get Data
    public static Object[] ambildetailmitra( int idMitra )
    {
      connection();
  
      Object rowData[] = new Object[3];
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwallmitra WHERE idMitra = " + idMitra;
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        rowData[0] = resultData.getInt("idMitra");
        rowData[1] = resultData.getString("namaMitra");
        rowData[2] = resultData.getString("emailMitra");
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return rowData;
  
    }
    
    public static Object[] ambildetailpelanggan( int idCustomer )
    {
      connection();
  
      Object rowData[] = new Object[4];
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM vwcustomer WHERE idCustomer = " + idCustomer;
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        rowData[0] = resultData.getInt("idCustomer");
        rowData[1] = resultData.getString("namaCustomer");
        rowData[2] = resultData.getString("nomorHpCustomer");
        rowData[3] = resultData.getString("emailCustomer");
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return rowData;
  
    }
    
    public static Object[] ambildetailpulsakuotapelanggan( int idCustomer )
    {
      connection();
  
      Object[] pulsaKuota = new Object[2];
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT pulsaCustomer, kuotaCustomer FROM vwpulsakuotacustomer WHERE idCustomer = " + idCustomer;
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        pulsaKuota[0] = resultData.getInt("pulsaCustomer");
        pulsaKuota[1] = resultData.getInt("kuotaCustomer");
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
      return pulsaKuota;
    }
  
    public static Object[] aambildetailpaket( int idPaket )
    {
      connection();
  
      Object[] rowData = new Object[6];
  
      try {
  
        // buat object statement yang ambil dari koneksi
        statement = connection.createStatement();
  
        // query select
        String query = "SELECT * FROM tblpaket WHERE idPaket = " + idPaket;
  
        // eksekusi query-nya
        ResultSet resultData = statement.executeQuery(query);
        
        // looping pengisian DefaultTableModel
        resultData.next();
        rowData[0] = resultData.getInt("idPaket");
        rowData[1] = resultData.getString("namaPaket");
        rowData[2] = resultData.getString("deskripsiPaket");
        rowData[3] = resultData.getInt("kuota");
        rowData[4] = resultData.getInt("hargaPaket");
        rowData[5] = resultData.getString("statusAktif");
        
        // close statement dan connectionion
        statement.close();
        connection.close();
  
      } catch (Exception e) {
        e.printStackTrace();
      }
  
      return rowData;
  
    }


}
