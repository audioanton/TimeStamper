package del_2;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class TimeList extends Timer {
    private int counter;
    private List<String> timeList = new ArrayList<>();

    public void addTimeToList() {
        int input;
        while (true) {
            Object[] options = {"Make new Timestamp", "Save & Exit"};
            if (counter == 0)
                input = JOptionPane.showOptionDialog(null, "Timer running, add Timestamp", "Timestamp Tool", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            else
                input = JOptionPane.showOptionDialog(null, "Timestamp created successfully, timer running.", "Timestamp Tool", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (input == 0) {
                String timeStamp = this.calculateTime();
                this.counter++;
                this.timeList.add(this.counter + ":     " + timeStamp);
            } else {
                this.setEndTime();
                this.setTotalTime();
                this.exitMessage(1);
                break;
            }
        }
    }

    public void writeFile() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(this.getFilename(), true)));
            writer.write(this.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file");
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Number of Timestamps: ").append(this.counter).append("\n");
        for (var timeStamp : timeList)
             output.append(timeStamp).append("\n");
        output.append("\n");
        output.append("*".repeat(50));
        output.append("\n\n");
        return super.toString() + output;
    }
}
