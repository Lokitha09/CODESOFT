import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance = 10000.00;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class Atm implements ActionListener {
    private BankAccount account;
    private JTextField balancField;
    private JTextField amountField;
    private JTextArea outputArea;

    public Atm(BankAccount account) {
        this.account = account;

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("ATM MACHINE");
        frame.setSize(560, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createEtchedBorder());

        JLabel balancelabel = new JLabel("BALANCE: ");
        balancField = new JTextField(Double.toString(account.getBalance()));
        balancField.setEditable(false);

        JLabel amountlabel = new JLabel("AMOUNT: ");
        amountField = new JTextField();

        JButton checkBalanceButton = new JButton("CHECK BALANCE");
        checkBalanceButton.setFocusable(false);
        checkBalanceButton.setBorder(BorderFactory.createEtchedBorder());
        checkBalanceButton.addActionListener(this);


        JButton depositButton = new JButton("DEPOSIT");
        depositButton.setFocusable(false);
        depositButton.setBorder(BorderFactory.createEtchedBorder());
        depositButton.addActionListener(this);

        JButton withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setFocusable(false);
        withdrawButton.setBorder(BorderFactory.createEtchedBorder());
        withdrawButton.addActionListener(this);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(balancelabel);
        panel.add(balancField);
        panel.add(amountlabel);
        panel.add(amountField);
        panel.add(checkBalanceButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(outputArea);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("CHECK BALANCE")) {
            outputArea.setText("Your Balance is: Rs " + account.getBalance());
        } else if (command.equals("DEPOSIT")) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    account.deposit(amount);
                    balancField.setText(Double.toString(account.getBalance()));
                    outputArea.setText("Deposit successful.");
                } else {
                    outputArea.setText("Invalid deposit amount.");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input. Please enter a valid amount.");
            }
        } else if (command.equals("WITHDRAW")) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0 && account.withdraw(amount)) {
                    balancField.setText(Double.toString(account.getBalance()));
                    outputArea.setText("Withdrawal successful.");
                } else {
                    outputArea.setText("Invalid withdrawal amount or insufficient balance.");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input. Please enter a valid amount.");
            }
        }
    }
}

public class ATM_interface {
    public static void main(String[] args) {
        BankAccount user = new BankAccount();
        new Atm(user);
    }
}
