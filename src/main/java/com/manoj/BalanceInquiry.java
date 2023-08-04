package com.manoj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceInquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    public BalanceInquiry(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon imageIcon = new ImageIcon("src/icons/atm.jpg");
        Image imageIcon2 = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        JLabel image = new JLabel(imageIcon3);
        this.add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;

        DatabaseConnection connection = new DatabaseConnection();
        try {
            ResultSet resultSet = connection.st.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "';");

            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }

        JLabel text = new JLabel("Your current account balance is Rs. "+ balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        this.setSize(900, 900);
        this.setLocation(300, 0);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        this.setVisible(false);
        new Transaction(pinnumber);
    }

    public static void main(String[] args) {
        new BalanceInquiry("");
    }
}
