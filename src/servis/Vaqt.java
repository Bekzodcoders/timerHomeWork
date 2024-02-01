package servis;
import DB.DB;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Vaqt {

    public static void addTimer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Budulnik nomini kiriting: ");
        String budulnikNomi = scanner.nextLine();

        System.out.print("Soatni kiriting: ");
        int soat = scanner.nextInt();

        System.out.print("Daqiqani kiriting: ");
        int daqiqa = scanner.nextInt();

        Integer remainingTime = soat * 3600 + daqiqa * 60;
        DB.remainingTimes.add(remainingTime);

        Timer timer = new Timer();
        DB.TIMERS.add(timer);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(budulnikNomi + " budulnik ishgaList tushdi!");
                timer.cancel();
            }
        }, remainingTime * 1000L);
    }

    public static void showTimers() {
        if (DB.TIMERS.isEmpty()) {
            System.out.println("Budulniklar qo'shilmagan yoki vaqt tugagan!");
        } else {
            for (int i = 0; i < DB.remainingTimes.size(); i++) {
                int remainingTime = DB.remainingTimes.get(i);
                int soat = remainingTime / 3600;
                int daqiqa = (remainingTime % 3600) / 60;
                int soniya = remainingTime % 60;
                System.out.println("Budulnik #" + (i + 1) + ": " + soat + " soat " + daqiqa + " daqiqa " + soniya + " soniya");
            }
        }
    }
}
