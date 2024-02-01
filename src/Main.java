import servis.Vaqt;

import java.util.Scanner;

public class Main{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("1. Budulnik qo'shish");
        System.out.println("2. Budulniklarni ko'rsatish");
        System.out.println("3. Chiqish");

        System.out.print("Tanlang: ");
        int tanlov = scanner.nextInt();

        switch (tanlov) {
            case 1:
                Vaqt.addTimer();
                break;
            case 2:
                Vaqt.showTimers();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Noto'g'ri tanlov! Qayta kiriting.");
        }
    }
}
}