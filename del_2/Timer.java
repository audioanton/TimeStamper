package del_2;

import javax.swing.*;
import java.time.*;
import java.util.Scanner;

class Timer {
    private String startTime, endTime, totalTime, currentDate, filename;

    public void setFilename() {
        String input = "";
        int i = 0;

        while (i == 0) {
            input = JOptionPane.showInputDialog("Input filename");
            if (input == null) {
                exitMessage(0);
                System.exit(0);
            } else if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Filename can't be empty.");
            } else if (!input.matches("^[a-zA-Z_0-9]*$")) {
                JOptionPane.showMessageDialog(null, "Only letters A-Z, digits 0-9 and '_' are allowed in filename");
            } else
                i = 1;
        }
        this.filename = input + ".txt";
    }

    public String getFilename() {
        return filename;
    }

    public void startTimer() {
        Object[] options = {"Start Timer", "Exit"};
        int input = JOptionPane.showOptionDialog(null, "Timestamp Creator Tool", "Timestamp Tool", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (input == 0) {
            this.startTime = LocalTime.now().toString().substring(0, 8);
            setCurrentDate();
        } else {
            exitMessage(0);
            System.exit(0);
        }
    }

    public void setEndTime() {
        this.endTime = LocalTime.now().toString().substring(0, 8);
    }

    public String calculateTime() {
        Scanner scanner;
        scanner = new Scanner(startTime).useDelimiter(":");
        int startHours = scanner.nextInt();
        int startMinutes = scanner.nextInt();
        int startSeconds = scanner.nextInt();

        String currentTime = LocalTime.now().toString().substring(0, 8);

        scanner = new Scanner(currentTime).useDelimiter(":");
        int currentHours = scanner.nextInt();
        int currentMinutes = scanner.nextInt();
        int currentSeconds = scanner.nextInt();

        int resultHours = currentHours - startHours;
        int resultMinutes = currentMinutes - startMinutes;
        int resultSeconds = currentSeconds - startSeconds;
        if (resultSeconds < 0) {
            resultSeconds = 60 + resultSeconds;
            resultMinutes -= 1;
        }
        return String.format("%02d:%02d:%02d", resultHours, resultMinutes, resultSeconds);
    }

    public void setTotalTime() {
        this.totalTime = calculateTime();
    }

    public void setCurrentDate() {
        this.currentDate = LocalDate.now().toString();
    }

    public void exitMessage(int i) {
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Exiting program.");
        } else {
            JOptionPane.showMessageDialog(null, "Exiting program and writing file.");
        }
    }

    @Override
    public String toString() {
        return filename.substring(0, filename.length() - 4)
                + "\nDate: " + currentDate
                + "\n"
                + "\nStarting time: " + startTime
                + "\nEnding time: " + endTime
                + "\nTotal Runtime: " + totalTime
                + "\n";
    }
}

