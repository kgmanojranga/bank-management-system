package com.manoj;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3,r4;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;

    JButton submit, cancel;

    String formno;
    public SignupThree(String formno) {

        this.formno = formno;
        this.setLayout(null);

        JLabel label1 = new JLabel("Page 3: Account Details");
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        label1.setBounds(280, 40, 400, 40);
        this.add(label1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        this.add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 20);
        this.add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        this.add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        this.add(r3);

        r4 = new JRadioButton("Reccuring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        this.add(r4);

        ButtonGroup account = new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        this.add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        this.add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 30);
        this.add(cardDetail);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        this.add(pin);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(330, 370, 300, 30);
        this.add(pinNumber);

        JLabel pinDetail = new JLabel("Your 4 digit pin");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 20);
        this.add(pinDetail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        this.add(services);

        checkBox1 = new JCheckBox("ATM CARD");
        checkBox1.setBackground(Color.WHITE);
        checkBox1.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox1.setBounds(200, 500, 200, 30);
        this.add(checkBox1);

        checkBox2 = new JCheckBox("Online Banking");
        checkBox2.setBackground(Color.WHITE);
        checkBox2.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox2.setBounds(450, 500, 200, 30);
        this.add(checkBox2);

        checkBox3 = new JCheckBox("Mobile Banking");
        checkBox3.setBackground(Color.WHITE);
        checkBox3.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox3.setBounds(200, 550, 200, 30);
        this.add(checkBox3);

        checkBox4 = new JCheckBox("E-mail & SMS alerts");
        checkBox4.setBackground(Color.WHITE);
        checkBox4.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox4.setBounds(450, 550, 200, 30);
        this.add(checkBox4);

        checkBox5 = new JCheckBox("Cheque Book");
        checkBox5.setBackground(Color.WHITE);
        checkBox5.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox5.setBounds(200, 600, 200, 30);
        this.add(checkBox5);

        checkBox6 = new JCheckBox("E-Statement");
        checkBox6.setBackground(Color.WHITE);
        checkBox6.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox6.setBounds(450, 600, 200, 30);
        this.add(checkBox6);

        checkBox7 = new JCheckBox("I here by declare that above entered details are accurate");
        checkBox7.setBackground(Color.WHITE);
        checkBox7.setFont(new Font("Raleway", Font.BOLD, 16));
        checkBox7.setBounds(100, 680, 200, 30);
        this.add(checkBox7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(420, 720, 100, 30);
        submit.addActionListener(this);
        this.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(540, 720, 100, 30);
        cancel.addActionListener(this);
        this.add(cancel);

        this.setSize(850, 820);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(350, 0);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Savings Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Reccuring Deposit Account";
            }

            Random random = new Random();
            long cardNumber = Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";

            if (checkBox1.isSelected()) {
                facility = facility + "ATM CARD";
            } else if(checkBox2.isSelected()) {
                facility = facility + " Online Banking";
            } else if (checkBox3.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (checkBox4.isSelected()) {
                facility = facility + " E-mail & SMS Alert";
            } else if (checkBox5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (checkBox6.isSelected()) {
                facility = facility + "E-Statement";
            }

            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    DatabaseConnection connection = new DatabaseConnection();
                    String query1 = "INSERT INTO signupthree VALUES('" + formno + "','" + accountType + "','" + cardNumber + "','" + pinNumber + "','" + facility + "')";
                    String query2 = "INSERT INTO login VALUES('" + formno + "','" + cardNumber + "','" + pinNumber + "')";
                    connection.st.executeUpdate(query1);
                    connection.st.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pinNumber);
                }

            } catch (Exception exception) {
                System.out.println(exception);
            }

        } else if(event.getSource() == cancel) {

        }
    }

    public static void main(String[] args) {

        new SignupThree("");
    }


}
