import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LabActivity6SwingToDoList {

    // Main frames
    JFrame viewerFrame;
    JFrame formFrame;

    JTable taskTable;
    DefaultTableModel tableModel;

    public LabActivity6SwingToDoList() {
        initViewerFrame();
    }

    // Viewer Window Setup
    private void initViewerFrame() {
        viewerFrame = new JFrame("To-Do List Viewer");
        viewerFrame.setSize(600, 400);
        viewerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewerFrame.setLayout(new BorderLayout());

        // Table model and JTable
        String[] columns = {"Task Name", "Task Description", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        taskTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(taskTable);

        // Add Task Button
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setFont(new Font("Arial", Font.BOLD, 14));

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFormWindow();
            }
        });

        // Top panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(addTaskButton);

        // Add components to frame
        viewerFrame.add(topPanel, BorderLayout.NORTH);
        viewerFrame.add(scrollPane, BorderLayout.CENTER);
        viewerFrame.setLocationRelativeTo(null);
        viewerFrame.setVisible(true);
    }

    // Form Window Setup
    private void openFormWindow() {
        if (formFrame != null && formFrame.isShowing()) {
            formFrame.toFront();
            return;
        }

        formFrame = new JFrame("To-Do List Form");
        formFrame.setSize(400, 300);
        formFrame.setLayout(new GridBagLayout());
        formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formFrame.setLocationRelativeTo(viewerFrame);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Task Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        formFrame.add(new JLabel("Task Name:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        formFrame.add(nameField, gbc);

        // Task Description
        gbc.gridx = 0;
        gbc.gridy = 1;
        formFrame.add(new JLabel("Task Description:"), gbc);

        gbc.gridx = 1;
        JTextArea descArea = new JTextArea(3, 20);
        JScrollPane descScroll = new JScrollPane(descArea);
        formFrame.add(descScroll, gbc);

        // Status Dropdown
        gbc.gridx = 0;
        gbc.gridy = 2;
        formFrame.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        String[] statuses = {"Not Started", "Ongoing", "Completed"};
        JComboBox<String> statusBox = new JComboBox<>(statuses);
        formFrame.add(statusBox, gbc);

        // Save Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton saveButton = new JButton("Save Task");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String desc = descArea.getText().trim();
                String status = (String) statusBox.getSelectedItem();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(formFrame, "Please fill in Task Name and Status", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Add task to the table
                tableModel.addRow(new Object[]{name, desc, status});
                formFrame.dispose(); // Close the form after saving
            }
        });

        formFrame.add(saveButton, gbc);
        formFrame.setVisible(true);
    }

    // Entry point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LabActivity6SwingToDoList());
    }
}
