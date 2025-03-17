package ojek_pangkalan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    // Konfigurasi database
    private static final String URL = "jdbc:mysql://localhost:3308/ojek_pangkalan";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Variabel untuk menyimpan koneksi
    private static Connection koneksi;

    // Metode untuk mendapatkan koneksi
    public static Connection getKoneksi() {
        try {
            if (koneksi == null || koneksi.isClosed()) {
                // Memuat driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Membuat koneksi ke database
                koneksi = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi ke database berhasil!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
        }
        return koneksi;
    }

    // Metode untuk menutup koneksi
    public static void closeKoneksi() {
        try {
            if (koneksi != null && !koneksi.isClosed()) {
                koneksi.close();
                System.out.println("Koneksi ke database ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal menutup koneksi: " + e.getMessage());
        }
    }

    // Tes koneksi
    public static void main(String[] args) {
        Connection conn = getKoneksi();
        if (conn != null) {
            System.out.println("Tes koneksi berhasil!");
            closeKoneksi(); // Tutup koneksi setelah selesai
        }
    }
}
