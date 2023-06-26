import java.sql.*;
import java.util.Scanner;
import java.sql.DriverManager;
public class Databaze {
    private Connection conn;
    private Statement stmt;

    public Databaze() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:uzivatele.db");
            stmt = conn.createStatement();

            ResultSet tables = conn.getMetaData().getTables(null, null, "pojistenci", null);
            if (!tables.next()) {
                stmt.execute("CREATE TABLE pojistenci (pojistenec_id INTEGER PRIMARY KEY AUTOINCREMENT, jmeno TEXT, " +
                        "prijmeni TEXT, telefon INTEGER, vek INTEGER);");
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pridejPojisteneho(Pojistenec pojistenec) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO pojistenci (jmeno, prijmeni, telefon, vek) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, pojistenec.getJmeno());
            pstmt.setString(2, pojistenec.getPrijmeni());
            pstmt.setInt(3, pojistenec.getTelefon());
            pstmt.setInt(4, pojistenec.getVek());

            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void vratPojistene() {
        try {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM pojistenci");
            System.out.println("ID | Jmeno | Prijmeni | Tel. Cislo | Vek");
            System.out.println("========================================");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("pojistenec_id") + " | ");
                System.out.print(resultSet.getString("jmeno") + " | ");
                System.out.print(resultSet.getString("prijmeni") + " | ");
                System.out.print(resultSet.getString("telefon") + " | ");
                System.out.println(resultSet.getString("vek"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void vyhledejPojisteneho() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte jméno pojistného:");
        String vyhledavaniJmeno = scanner.nextLine();

        System.out.println("Zadejte příjmení pojistného:");
        String vyhledavaniPrijmeni = scanner.nextLine();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM pojistenci WHERE jmeno LIKE ? AND prijmeni LIKE ?");
            pstmt.setString(1, "%" + vyhledavaniJmeno + "%");
            pstmt.setString(2, "%" + vyhledavaniPrijmeni + "%");
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("pojistenec_id") + " | " +
                        resultSet.getString("jmeno") + " | " +
                        resultSet.getString("prijmeni") + " | " +
                        resultSet.getString("telefon") + " | " +
                        resultSet.getString("vek"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void vyhledej_pojisteneho() {
    }

    public void pridej_pojisteneho(Pojistenec pojistenec) {
    }

    public void vrat_pojistene() {
    }
}
