import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI extends Frame implements ActionListener {
    TextField tfFirstName, tfLastName, tfAge, tfHoursWorked, tfHourlyRate;
    TextArea taOutput;

    public LabActivity4EmpInfoSystemGUI() {
        setTitle("Laboratory Activity 4");
        setSize(450, 360);
        setLayout(null); // Absolute layout

        Label lblFirstName = new Label("First Name");
        lblFirstName.setBounds(20, 50, 100, 20);
        add(lblFirstName);
        tfFirstName = new TextField();
        tfFirstName.setBounds(130, 50, 120, 20);
        add(tfFirstName);

        Label lblLastName = new Label("Last Name");
        lblLastName.setBounds(20, 80, 100, 20);
        add(lblLastName);
        tfLastName = new TextField();
        tfLastName.setBounds(130, 80, 120, 20);
        add(tfLastName);

        Label lblAge = new Label("Age");
        lblAge.setBounds(20, 110, 100, 20);
        add(lblAge);
        tfAge = new TextField();
        tfAge.setBounds(130, 110, 120, 20);
        add(tfAge);

        Label lblHours = new Label("Hours Worked");
        lblHours.setBounds(20, 140, 100, 20);
        add(lblHours);
        tfHoursWorked = new TextField();
        tfHoursWorked.setBounds(130, 140, 120, 20);
        add(tfHoursWorked);

        Label lblRate = new Label("Hourly Rate");
        lblRate.setBounds(20, 170, 100, 20);
        add(lblRate);
        tfHourlyRate = new TextField();
        tfHourlyRate.setBounds(130, 170, 120, 20);
        add(tfHourlyRate);

        Button btnSubmit = new Button("Submit");
        btnSubmit.setBounds(160, 200, 80, 30);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        Label lblOutput = new Label("Output:");
        lblOutput.setBounds(20, 240, 100, 20);
        add(lblOutput);

        taOutput = new TextArea("", 3, 40, TextArea.SCROLLBARS_NONE);
        taOutput.setBounds(20, 260, 400, 55); // Adjusted to fit exactly 3 lines
        taOutput.setEditable(false);
        add(taOutput);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        String ageText = tfAge.getText().trim();
        String hoursText = tfHoursWorked.getText().trim();
        String rateText = tfHourlyRate.getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() ||
                hoursText.isEmpty() || rateText.isEmpty()) {
            taOutput.setText("Error: All fields must be filled out.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 0) {
                taOutput.setText("Error: Age must be a positive integer.");
                return;
            }
        } catch (NumberFormatException ex) {
            taOutput.setText("Error: Age must be a valid integer.");
            return;
        }

        double hours, rate;
        try {
            hours = Double.parseDouble(hoursText);
            rate = Double.parseDouble(rateText);
            if (hours <= 0 || rate <= 0) {
                taOutput.setText("Error: Hours worked and hourly wage must be positive.");
                return;
            }
        } catch (NumberFormatException ex) {
            taOutput.setText("Error: Hours worked and hourly wage must be valid numbers.");
            return;
        }

        String fullName = firstName + " " + lastName;
        double dailySalary = hours * rate;

        taOutput.setText("Full Name: " + fullName +
                "\nAge: " + age + " years old" +
                "\nDaily Salary: PHP " + String.format("%.2f", dailySalary));
    }

    public static void main(String[] args) {
        new LabActivity4EmpInfoSystemGUI();
    }
}
