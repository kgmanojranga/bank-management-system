package com.manoj;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinnumber;
    public MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        this.setLayout(null);

        this.setTitle("Mini Statement");

        JLabel bank = new JLabel("Sri Lankan Bank");
        bank.setBounds(150, 20,100, 20);
        this.add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        this.add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        this.add(mini);

        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 400, 30);
        this.add(bal);

        DatabaseConnection connection = new DatabaseConnection();

        try {

            ResultSet result = connection.st.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "';");
            while(result.next()) {
                String cardnumber = result.getString("card_number");
                card.setText("Card Number: " + cardnumber.substring(0, 4) + "xxxxxxxx" + cardnumber.substring(12));
            }

            ResultSet result2 = connection.st.executeQuery("SELECT * FROM bank WHERE pin ='" + pinnumber + "';");

            int balance = 0;
            while(result2.next()) {
                System.out.println(result2.getString("type"));
                String date = result2.getString("date");
                String type = result2.getString("type");
                String amount = result2.getString("amount");

                mini.setText(mini.getText() + "<html>" + date + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + type + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + amount + "<br><br><html>");

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

            bal.setText("Your current account balance is Rs. " + balance);

        } catch (Exception exception) {
            System.out.println(exception);
        }

        this.setSize(400, 600);
        this.setLocation(20, 20);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(false);

    }

    public static void main(String[] args) {
    }
}
