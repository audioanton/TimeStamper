package time_stamper;

public class RunTimer {
    public static void main(String[] args) {
        TimeList timer = new TimeList();

        timer.setFilename();
        timer.startTimer();
        timer.addTimeToList();
        timer.writeFile();
    }
}
