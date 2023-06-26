import java.util.Scanner;
import java.sql.*;


public class Evidence {
    private Databaze db;
    private Pojistenec pojistenec;

    public Evidence() {
        db = new Databaze();
        pojistenec = new Pojistenec();
    }

    public void pracuj() {
        System.out.println("---------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("---------------------");

        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěnce");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");


        int vstup = 0;
        Scanner scanner = new Scanner(System.in);

        while (vstup != 4) {
            try {
                vstup = Integer.parseInt(scanner.nextLine());
                if (vstup == 1) {
                    pojistenec.pridej_pojisteneho();
                    db.pridej_pojisteneho(pojistenec);
                    System.out.println("Přidej nového pojištěného");
                } else if (vstup == 2) {
                    db.vrat_pojistene();
                    System.out.println("Vypsat všechny pojištěné");
                } else if (vstup == 3) {
                    db.vyhledej_pojisteneho();
                    System.out.println("Vyhledat pojištěného");
                } else if (vstup == 4) {
                    System.out.println("Sbohem!");
                    break;
                } else {
                    System.out.println("Zadejte validní volbu!\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Zadejte číslo!\n");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Evidence evidence = new Evidence();
        evidence.pracuj();
    }
}
