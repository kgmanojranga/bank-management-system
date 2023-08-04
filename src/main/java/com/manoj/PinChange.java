package com.manoj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinTextField, rePinTextField;
    JButton change, back;

    String pinnumber;
    public PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        this.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon("src/icons/atm.jpg");
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        JLabel image = new JLabel(imageIcon3);
        image.setBounds(0, 0, 900,900);
        this.add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(270, 280, 500, 35);
        image.add(text);

        JLabel pinText = new JLabel("New PIN");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);

        JLabel rePinText = new JLabel("Re-Enter New PIN");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        rePinText.setBounds(165, 360, 180, 25);
        image.add(rePinText);


        // TextFields

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        pinTextField.setBounds(330, 320, 180, 25);
        image.add(pinTextField);

        rePinTextField = new JPasswordField();
        rePinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        rePinTextField.setBounds(330, 360, 180, 25);
        image.add(rePinTextField);

        // Buttons

        change = new JButton("Change");
        change.setBounds(200, 485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 485,150,30);
        back.addActionListener(this);
        image.add(back);

        this.setSize(900, 900);
        this.setLocation(300, 0);
        this.setUndecorated(true);
        this.setVisible(false);

    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == change) {
            try{
                String newPin = pinTextField.getText();
                String confirmationNewPin = rePinTextField.getText();

                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter a new PIN");
                    return;
                }

                if (confirmationNewPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter the new PIN");
                    return;
                }

                if (!newPin.equals(confirmationNewPin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin doesn't match");
                    return;
                }

                DatabaseConnection connection = new DatabaseConnection();

                String query1 = "UPDATE bank SET pin = '" + newPin + "' WHERE pin ='" + pinnumber + "';";
                String query2 = "UPDATE login SET pin = '" + newPin + "' WHERE pin ='" + pinnumber + "';";;
                String query3 = "UPDATE signupthree SET pin = '" + newPin + "' WHERE pin ='" + pinnumber + "';";;

                connection.st.executeUpdate(query1);
                connection.st.executeUpdate(query2);
                connection.st.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Number was changed successfully");

                this.setVisible(false);
                new Transaction(newPin).setVisible(true);

            } catch (Exception exception) {
                System.out.println(exception);
            }
        } else {
            this.setVisible(false);
            new Transaction(pinnumber);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
