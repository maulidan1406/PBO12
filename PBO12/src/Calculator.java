import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton clearButton;
    private JButton exitButton;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display text field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Create the number buttons panel
        JPanel numberButtonsPanel = new JPanel();
        numberButtonsPanel.setLayout(new GridLayout(4, 3, 5, 5));
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtonsPanel.add(numberButtons[i]);
        }
        add(numberButtonsPanel, BorderLayout.CENTER);

        // Create the operator buttons panel
        JPanel operatorButtonsPanel = new JPanel();
        operatorButtonsPanel.setLayout(new GridLayout(4, 1, 5, 5));
        operatorButtons = new JButton[] {new JButton("+"), new JButton("-"), new JButton("*"), new JButton("/")};
        for (JButton button : operatorButtons) {
            button.addActionListener(this);
            operatorButtonsPanel.add(button);
        }
        add(operatorButtonsPanel, BorderLayout.EAST);

        // Create the clear and exit buttons panel
        JPanel clearAndExitButtonsPanel = new JPanel();
        clearAndExitButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        clearAndExitButtonsPanel.add(clearButton);
        clearAndExitButtonsPanel.add(exitButton);
        add(clearAndExitButtonsPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (Character.isDigit(actionCommand.charAt(0))) {
            display.append(actionCommand);
        } else if ("+".equals(actionCommand) || "-".equals(actionCommand) || "*".equals(actionCommand) || "/".equals(actionCommand)) {
            // Handle operator actions
        } else if ("C".equals(actionCommand)) {
            display.setText("");
        } else if ("Exit".equals(actionCommand)) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
