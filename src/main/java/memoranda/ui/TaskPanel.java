
package memoranda.ui;


import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TaskPanel<tasksToolBar> extends JPanel {
    public JTable taskTable;
    BorderLayout borderLayout1 = new BorderLayout();
    JButton historyBackB = new JButton();
    JToolBar tasksToolBar = new JToolBar();
    JButton historyForwardB = new JButton();
    JButton newTaskB = new JButton();
    JButton subTaskB = new JButton();
    JButton editTaskB = new JButton();
    JButton removeTaskB = new JButton();
    JButton completeTaskB = new JButton();

    JCheckBoxMenuItem ppShowActiveOnlyChB = new JCheckBoxMenuItem();

    JTextArea overallScheduleTextArea = new JTextArea();
    JTextArea individualScheduleTextArea = new JTextArea();

    // Additional fields for overall and individual schedule
    JButton overallScheduleB = new JButton();
    JButton individualScheduleB = new JButton();
    private main.java.memoranda.ui.App taskPPMenu;

    JButton viewOverallButton = new JButton("View Overall Schedule");
    JButton viewIndividualButton = new JButton("View Individual Schedule");

        viewOverallButton.addActionListener(new

    void ActionListener() {
        public void actionPerformed Object ActionEvent;
        (ActionEvent e){
            // Replace with your logic to fetch overall schedule
            String overallSchedule = getOverallSchedule();
            overallScheduleTextArea.setText(overallSchedule);
        }
    }


    private String getOverallSchedule() {
        return "Individual Schedule:\n- Coding task at 10 AM\n- Review meeting at 3 PM\n- Training session at 5 PM";
    });

    public void mousePressed(MouseEvent e) {
        maybeShowPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
        maybeShowPopup(e);
    }

    private void maybeShowPopup(MouseEvent e) {
    }

    private String showTaskPopup(MouseEvent e) {
        int row = taskTable.rowAtPoint(e.getPoint());
        if (row >= 0 && row < taskTable.getRowCount()) {
            taskTable.setRowSelectionInterval(row, row);
        } else {
            taskTable.clearSelection();
        }
        return null;
    }
}




        // Add other listeners and code here

//    private String showTaskPopup(MouseEvent e) {
//        int row = taskTable.rowAtPoint(e.getPoint());
//        if (row >= 0 && row < taskTable.getRowCount()) {
//            taskTable.setRowSelectionInterval(row, row);
//        } else {
//            taskTable.clearSelection();
//        }
//
//        //private String getIndividualSchedule {
//        // Replace with your logic to fetch individual schedule
//        // For demonstration purposes, returning a hardcoded schedule
//        return "Individual Schedule:\n- Coding task at 10 AM\n- Review meeting at 3 PM\n- Training session at 5 PM";
//    }
//}
//





