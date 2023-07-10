package coolGYM.rooms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomScheduler {
    private RoomScheduler roomScheduler;

    private JFrame frame;
    private JComboBox<String> roomComboBox;
    private JComboBox<String> timeSlotComboBox;
    private JButton scheduleButton;

    public RoomScheduler() {
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
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Room[] getRooms() {
        return null;
    }

    private boolean scheduleClass() {
        // Get the selected room and time slot
        String selectedRoom = (String) roomComboBox.getSelectedItem();
        String selectedTimeSlot = (String) timeSlotComboBox.getSelectedItem();

        // Schedule the class and handle conflicts
        boolean isScheduled = roomScheduler.scheduleClass();
        if (isScheduled) {
            JOptionPane.showMessageDialog(frame, "Class scheduled successfully!");
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Scheduling conflict detected. Please choose a different room or time slot.");
        }
        return isScheduled;
    }
}
