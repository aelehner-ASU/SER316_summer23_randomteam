package src.main.java.memoranda.ui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomsControler extends JFrame {
    private JTree roomTree;
    private JTable roomTable;
    
    public RoomsControler() {
        setTitle(" Room controller for Gym Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create tree table panel
        JPanel treeTablePanel = new JPanel(new GridLayout(1, 2));
        
        // Create room tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Rooms");
        DefaultMutableTreeNode room1 = new DefaultMutableTreeNode("Room 1");
        DefaultMutableTreeNode room2 = new DefaultMutableTreeNode("Room 2");
        DefaultMutableTreeNode room3 = new DefaultMutableTreeNode("Room 3");
        DefaultMutableTreeNode room4 = new DefaultMutableTreeNode("Room 4");
        root.add(room1);
        root.add(room2);
        root.add(room3);
        root.add(room4);
        roomTree = new JTree(root);
        roomTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        treeTablePanel.add(new JScrollPane(roomTree));
        
        // Create room table
        String[] columnNames = {"Room", "Class"};
        Object[][] data = {
                {"Room 1", ""},
                {"Room 2", ""},
                {"Room 3", ""},
                {"Room 4", ""}
        };
        roomTable = new JTable(data, columnNames);
        treeTablePanel.add(new JScrollPane(roomTable));
        
        add(treeTablePanel, BorderLayout.CENTER);
        
        // Create button panel
        JPanel buttonPanel = new JPanel();
        
        // Create "Start Class" button
        JButton startClassButton = new JButton("Start Class");
        startClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected room from the tree
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) roomTree.getLastSelectedPathComponent();
                if (selectedNode != null && !selectedNode.isRoot()) {
                    String selectedRoom = selectedNode.toString();
                    // Update the table with the selected room and class
                    int selectedRow = roomTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        roomTable.setValueAt(selectedRoom, selectedRow, 0);
                        roomTable.setValueAt("Class X", selectedRow, 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(RoomsControler.this, "Please select a room from the tree.");
                }
            }
        });
        buttonPanel.add(startClassButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        setSize(80, 40);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}