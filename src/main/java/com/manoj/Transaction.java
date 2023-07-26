package com.manoj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawal, miniStatement, pinChange, fastCash, balanceInquiry, exit;
    String pinnumber;
    public Transaction(String pinnumber) {

        this.pinnumber = pinnumber;

        this.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon("src/icons/atm.jpg");
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        JLabel image = new JLabel(imageIcon3);
        image.setBounds(0,0, 900, 900);
        this.add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceInquiry = new JButton("Balance Inquiry");
        balanceInquiry.setBounds(355, 485, 150, 30);
        balanceInquiry.addActionListener(this);
        image.add(balanceInquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);


        this.setSize(900, 900);
        this.setLocation(300, 0);
        this.setUndecorated(true);
        this.setVisible(true);
    }

//    public static void main(String a[]) {
//        new Transaction();
//    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == exit) {
            System.exit(0);
        } else if (event.getSource() == deposit) {
            this.setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (event.getSource() == withdrawal) {
            this.setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (event.getSource() == fastCash) {
            this.setVisible(false);
            new FastCash(pinnumber);
        } else if (event.getSource() == pinChange) {
            this.setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (event.getSource() == balanceInquiry) {
            this.setVisible(false);
            new BalanceInquiry(pinnumber).setVisible(true);
        } else if (event.getSource() == miniStatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
}
