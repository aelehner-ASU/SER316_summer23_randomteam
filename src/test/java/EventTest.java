import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Event;

import org.junit.jupiter.api.Test;

class EventTest {

    @Test
    void testGetId() {
        EventImpl event = new EventImpl("123");
        assertEquals("123", event.getId());
    }

       st
       d testGetHour() {
       ntImpl event = new EventImpl("123");
       nt.setHour(10);
       ertEquals(10, event.getHour());
       
    //
    // @Test
    // void testGetMinute() {
    // EventImpl event = new EventImpl("123");
    // event.setMinute(30);
    // assertEquals(30, event.getMinute());
    // }
    //
    // @Test
    // void testGetText() {
    // EventImpl event = new EventImpl("123");
    // event.setText("Sample text");
    // assertEquals("Sample text", event.getText());
    // }

    // Add more test methods for the remaining methods in the Event interface

    private static class EventImpl implements Event {
        private String id;
        private int hour;
        private int minute;
        private String text;

        public EventImpl(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

           lic int getHour() {
           urn hour;
           
        
           lic void setHour(int hour) {
           s.hour = hour;
           
        //
        // public int getMinute() {
        // return minute;
        // }
        //
        // public void setMinute(int minute) {
        // this.minute = minute;
        // }
        //
        // public String getText() {
        // return text;
        // }
        //
        // public void setText(String text) {
        // this.text = text;
        // }

        // Implement the remaining methods in the Event interface
    }
}
