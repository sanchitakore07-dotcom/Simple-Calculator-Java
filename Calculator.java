import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField textField;
    double num1, num2, result;
    char operator;
    String expression = "";

    Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 22));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0","C","=","+"
        };

        for (String b : buttons) {
            JButton btn = new JButton(b);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // Numbers
        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            expression += cmd;
            textField.setText(expression);
        }
        // Clear
        else if (cmd.equals("C")) {
            expression = "";
            textField.setText("");
        }
        // Equals
        else if (cmd.equals("=")) {
            num2 = Double.parseDouble(expression.substring(expression.indexOf(operator)+1));

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }

            expression = expression + "=" + result;
            textField.setText(expression);
        }
        // Operators
        else {
            operator = cmd.charAt(0);
            num1 = Double.parseDouble(expression);
            expression += cmd;
            textField.setText(expression);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
