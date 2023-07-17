package com.manoj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;

    String pinnumber;

    public Withdrawal(String pinnumber){

        this.pinnumber = pinnumber;
        this.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon("src/icons/atm.jpg");
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        JLabel image = new JLabel(imageIcon3);
        image.setBounds(0, 0, 900, 900);
        this.add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(195, 300, 400, 25);
        image.add(text);

        withdraw =new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(175, 350, 320, 20);
        image.add(amount);

        this.setSize(900, 900);
        this.setLocation(300, 0);
//        this.setUndecorated(true);
        this.setVisible(true);
    }

//    public static void main(String[] args) {
//        new Deposit("");
//    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == withdraw) {
            String withdrawAmount = amount.getText();
            Date date = new Date();
            if (withdrawAmount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                DatabaseConnection connection = new DatabaseConnection();
                String query1 = "INSERT INTO bank VALUES('" + pinnumber + "','" + date + "','Withdraw','" + withdrawAmount + "');";
                System.out.println("Deposit works until this");
                try {
                    connection.st.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs. " + withdrawAmount + " withdrawn successfully");
                    this.setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (SQLException exception) {
                    System.out.println(exception);
                }
            }
        } else if (event.getSource() == back) {
            this.setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
}
