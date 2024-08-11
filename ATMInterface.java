import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMInterface extends JFrame implements ActionListener {

    private JButton depositButton, withdrawButton, checkBalanceButton, exitButton;
    private JTextField amountField;
    private JLabel balanceLabel;
    private double balance = 0.0;

    public ATMInterface() {
        setLayout(new FlowLayout());

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        checkBalanceButton = new JButton("Check Balance");
        exitButton = new JButton("Exit");

        balanceLabel = new JLabel("Balance: $0.00");

        add(amountLabel);
        add(amountField);
        add(depositButton);
        add(withdrawButton);
        add(checkBalanceButton);
        add(exitButton);
        add(balanceLabel);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);
        exitButton.addActionListener(this);

        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    balance += amount;
                    balanceLabel.setText("Balance: $" + String.format("%.2f", balance));
                    amountField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid amount");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount");
            }
        } else if (e.getSource() == withdrawButton) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    balanceLabel.setText("Balance: $" + String.format("%.2f", balance));
                    amountField.setText("");
                } else if (amount > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient balance");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid amount");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount");
            }
        } else if (e.getSource() == checkBalanceButton) {
            JOptionPane.showMessageDialog(this, "Balance: $" + String.format("%.2f", balance));
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ATMInterface();
    }
}