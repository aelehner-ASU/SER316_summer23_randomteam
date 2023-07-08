package main.java.memoranda.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.java.memoranda.util.RoomScheduler;
import main.java.memoranda.util.Room;

public class RoomUI {
    private RoomScheduler roomScheduler;

    private JFrame frame;
    private JComboBox<String> roomComboBox;
    private JComboBox<String> timeSlotComboBox;
    private JButton scheduleButton;

    public RoomUI() {
        roomScheduler = new RoomScheduler();
        initializeUI();
    }

    private void initializeUI() {
        // Create the main frame
        frame = new JFrame("Room Scheduler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create UI components
        JLabel roomLabel = new JLabel("Room:");
        JLabel timeSlotLabel = new JLabel("Time Slot:");
        roomComboBox = new JComboBox<>();
        timeSlotComboBox = new JComboBox<>();
        scheduleButton = new JButton("Schedule Class");

        // Set layout
        frame.setLayout(new FlowLayout());

        // Add components to the frame
        frame.add(roomLabel);
        frame.add(roomComboBox);
        frame.add(timeSlotLabel);
        frame.add(timeSlotComboBox);
        frame.add(scheduleButton);

        // Set event listeners
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleClass();
            }
        });
    }

    public void display() {
        // Populate roomComboBox with available rooms
        for (Room room : roomScheduler.getRooms()) {
            roomComboBox.addItem(room.getRoomNumber());
        }

        // Populate timeSlotComboBox with available time slots
        String[] timeSlots = { "8:00 AM - 10:00 AM", "10:00 AM - 12:00 PM", "1:00 PM - 3:00 PM", "3:00 PM - 5:00 PM" };
        for (String timeSlot : timeSlots) {
            timeSlotComboBox.addItem(timeSlot);
        }

        // Set frame properties and display
        frame.setSize(60, 50);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void scheduleClass() {
        // Get the selected room and time slot
        String selectedRoom = (String) roomComboBox.getSelectedItem();
        String selectedTimeSlot = (String) timeSlotComboBox.getSelectedItem();

        // Schedule the class and handle conflicts
        boolean isScheduled = roomScheduler.scheduleClass(selectedRoom, selectedTimeSlot);
        if (isScheduled) {
            JOptionPane.showMessageDialog(frame, "Class scheduled successfully!");
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Scheduling conflict detected. Please choose a different room or time slot.");
        }
    }

    public RoomScheduler getRoomScheduler() {
        return roomScheduler;
    }

    public void setRoomScheduler(RoomScheduler roomScheduler) {
        this.roomScheduler = roomScheduler;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JComboBox<String> getRoomComboBox() {
        return roomComboBox;
    }

    public void setRoomComboBox(JComboBox<String> roomComboBox) {
        this.roomComboBox = roomComboBox;
    }

    public JComboBox<String> getTimeSlotComboBox() {
        return timeSlotComboBox;
    }

    public void setTimeSlotComboBox(JComboBox<String> timeSlotComboBox) {
        this.timeSlotComboBox = timeSlotComboBox;
    }

    public JButton getScheduleButton() {
        return scheduleButton;
    }

    public void setScheduleButton(JButton scheduleButton) {
        this.scheduleButton = scheduleButton;
    }
}
