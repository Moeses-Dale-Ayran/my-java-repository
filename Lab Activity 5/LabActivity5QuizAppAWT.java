import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT {
    private Frame frame;
    private Label questionLabel, messageLabel;
    private CheckboxGroup choicesGroup;
    private Checkbox[] options;
    private Button nextButton;
    private Panel questionPanel, optionsPanel, bottomPanel;

    private String[] questions = {
        "What is the capital of France?",
        "Which language is used for Android development?",
        "What is the result of 2 + 2 * 2?"
    };

    private String[][] choices = {
        {"A. Paris", "B. Rome", "C. Berlin", "D. Madrid"},
        {"A. Swift", "B. Java", "C. Python", "D. Kotlin"},
        {"A. 6", "B. 8", "C. 4", "D. 10"}
    };

    private int[] correctAnswers = {0, 1, 0};

    private int currentQuestion = 0;
    private int score = 0;

    public LabActivity5QuizAppAWT() {
        frame = new Frame("Quiz App");
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        questionPanel = new Panel();
        questionLabel = new Label("", Label.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionPanel.add(questionLabel);
        frame.add(questionPanel, BorderLayout.NORTH);

        optionsPanel = new Panel();
        optionsPanel.setLayout(new GridLayout(2, 2));
        choicesGroup = new CheckboxGroup();
        options = new Checkbox[4];

        for (int i = 0; i < 4; i++) {
            options[i] = new Checkbox("", choicesGroup, false);
            options[i].setFont(new Font("Arial", Font.PLAIN, 14));
            options[i].setForeground(Color.BLUE);
            optionsPanel.add(options[i]);
        }

        frame.add(optionsPanel, BorderLayout.CENTER);

        bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        messageLabel = new Label("", Label.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        messageLabel.setForeground(Color.RED);
        nextButton = new Button("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setBackground(Color.LIGHT_GRAY);
        bottomPanel.add(messageLabel);
        bottomPanel.add(nextButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Checkbox selected = choicesGroup.getSelectedCheckbox();
                if (selected == null) {
                    messageLabel.setText("Please select an answer.");
                } else {
                    int selectedIndex = -1;
                    for (int i = 0; i < 4; i++) {
                        if (options[i] == selected) {
                            selectedIndex = i;
                            break;
                        }
                    }
                    if (selectedIndex == correctAnswers[currentQuestion]) {
                        score++;
                    }
                    currentQuestion++;
                    if (currentQuestion < questions.length) {
                        choicesGroup.setSelectedCheckbox(null); // Clear selection before loading next
                        loadQuestion();
                    } else {
                        showResult();
                    }
                }
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        loadQuestion();
        frame.setVisible(true);
    }

    private void loadQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        for (int i = 0; i < 4; i++) {
            options[i].setLabel(choices[currentQuestion][i]);
            options[i].setState(false);
            options[i].setEnabled(true);
        }
        choicesGroup.setSelectedCheckbox(null); // Ensure no selection is retained
        messageLabel.setText("");
    }

    private void showResult() {
        questionLabel.setText("You got " + score + " out of " + questions.length + " correct!");
        for (Checkbox option : options) {
            option.setEnabled(false);
        }
        messageLabel.setText("");
        nextButton.setEnabled(false);
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}
