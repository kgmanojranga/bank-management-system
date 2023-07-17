package com.manoj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.EventListener;

public class FastCash extends JFrame implements ActionListener {

    JButton hundred, fiveHundred, twoThousand, fiveThousand, thousand, tenThousand, back;
    String pinnumber;
    public FastCash(String pinnumber) {

        this.pinnumber = pinnumber;

        this.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon("src/icons/atm.jpg");
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        JLabel image = new JLabel(imageIcon3);
        image.setBounds(0,0, 900, 900);
        this.add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        hundred = new JButton("Rs. 100");
        hundred.setBounds(170, 415, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred = new JButton("Rs. 500");
        fiveHundred.setBounds(355, 415, 150, 30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thousand = new JButton("Rs. 1000");
        thousand.setBounds(170, 450, 150, 30);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand = new JButton("Rs. 2000");
        twoThousand.setBounds(355, 450, 150, 30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand = new JButton("Rs. 5000");
        fiveThousand.setBounds(170, 485, 150, 30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("Rs. 10000");
        tenThousand.setBounds(355, 485, 150, 30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        this.setSize(900, 900);
        this.setLocation(300, 0);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    public static void main(String a[]) {
        new FastCash("");
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == back) {
            this.setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)event.getSource()).getText().substring(4);
            DatabaseConnection connection = new DatabaseConnection();
            try {
                ResultSet resultSet = connection.st.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "';");
                int balance = 0;
                while(resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                System.out.println(balance);

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Account Balance");
                } else {
                    connection.st.executeUpdate("INSERT INTO bank VALUES('" + pinnumber + "','" + new Date() + "',' Withdraw','" + amount +"')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }

            } catch(Exception exception) {
                System.out.println(exception);
            }
        }
    }
}
