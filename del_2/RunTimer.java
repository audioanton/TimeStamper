package del_2;

public class RunTimer {
    public static void main(String[] args) {
        TimeList timer = new TimeList();

        timer.setFilename();
        timer.startTimer();
        timer.addTimeToList();
        timer.writeFile();
    }
}
