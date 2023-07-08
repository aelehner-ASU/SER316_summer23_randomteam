package main.java.memoranda.util;

import java.util.ArrayList;
import java.util.List;

public class RoomScheduler {
    private List<Room> rooms;

    public RoomScheduler() {
        // Initialize the rooms
        rooms = new ArrayList<>();
        rooms.add(new Room("Room 1"));
        rooms.add(new Room("Room 2"));
        rooms.add(new Room("Room 3"));
        rooms.add(new Room("Room 4"));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public boolean scheduleClass(String roomNumber, String timeSlot) {
        // Find the selected room
        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                selectedRoom = room;
                break;
            }
        }

        // Check if the room is already scheduled
        if (selectedRoom != null && selectedRoom.isAvailable()) {
            // Check for scheduling conflicts
            for (Room room : rooms) {
                if (!room.getRoomNumber().equals(roomNumber) && !room.isAvailable()) {
                    // Conflict detected
                    return false;
                }
            }

            // No conflicts, schedule the class
            selectedRoom.setAvailable(false);
            return true;
        }

        return false;
    }
}