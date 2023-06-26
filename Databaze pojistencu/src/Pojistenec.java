import java.util.Scanner;

public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private String telefon;
    private int vek;

    @Override
    public String toString() {
        return jmeno + ", " + prijmeni + ", " + telefon + ", " + vek;
    }

    public void pridejPojisteneho() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte jméno pojištěného:");
        jmeno = scanner.nextLine();

        System.out.println("Zadejte příjmení pojištěného:");
        prijmeni = scanner.nextLine();

        System.out.println("Zadejte telefonní číslo:");
        telefon = scanner.nextLine();

        System.out.println("Zadejte věk:");
        vek = Integer.parseInt(scanner.nextLine());
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getTelefon() {
        return Integer.parseInt(telefon);
    }

    public int getVek() {
        return vek;
    }

    public void pridej_pojisteneho() {
    }
}
