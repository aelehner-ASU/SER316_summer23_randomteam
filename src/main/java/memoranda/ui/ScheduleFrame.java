package memoranda.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScheduleFrame extends JFrame {
    private SchedulePanel overallSchedulePanel;
    private SchedulePanel individualSchedulePanel;

    public ScheduleFrame() {
        setTitle("Schedule App");
        setSize(800, 600);
        setLocationRelativeTo(null);

        overallSchedulePanel = new SchedulePanel("Overall Schedule");
        individualSchedulePanel = new SchedulePanel("Individual Schedule");

        JButton overallScheduleButton = new JButton("View Overall Schedule");
        overallScheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showOverallSchedule();
            }
        });

        JButton individualScheduleButton = new JButton("View Individual Schedule");
        individualScheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showIndividualSchedule();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(overallScheduleButton);
        buttonPanel.add(individualScheduleButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(overallSchedulePanel, BorderLayout.CENTER);
    }

    private void showOverallSchedule() {
        remove(individualSchedulePanel);
        add(overallSchedulePanel, BorderLayout.CENTER);
        validate();
        repaint();
    }

    private void showIndividualSchedule() {
        remove(overallSchedulePanel);
        add(individualSchedulePanel, BorderLayout.CENTER);
        validate();
        repaint();
    }
}

class SchedulePanel extends JPanel {
    private String scheduleName;
    private JTextArea scheduleTextArea;

    public SchedulePanel(String name) {
        scheduleName = name;
        scheduleTextArea = new JTextArea(10, 30);
        scheduleTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(scheduleTextArea);

        setLayout(new BorderLayout());
        add(new JLabel(scheduleName), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setScheduleText(ArrayList<String> schedule) {
        StringBuilder sb = new StringBuilder();
        for (String entry : schedule) {
            sb.append(entry);
            sb.append("\n");
        }
        scheduleTextArea.setText(sb.toString());
    }
}