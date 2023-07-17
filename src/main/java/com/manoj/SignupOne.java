package com.manoj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    JTextField nameTextField, fnameTextField, eMailTextField, addressTextField, cityTextField, provinceTextField, pincodeTextField;
    JDateChooser dateChooser;
    JRadioButton maleRadioButton, femaleRadioButton, married, unmarried, other;
    JButton next;
    long random;

    public SignupOne(){

        this.setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong()% 9000L) + 1000L);

        //Label Declaration and Assignments
        JLabel formno = new JLabel("APPLICATION FORM NO." + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        this.add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        this.add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        this.add(name);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        this.add(fname);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        this.add(dob);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        this.add(gender);

        JLabel eMail = new JLabel("Email Address:");
        eMail.setFont(new Font("Raleway", Font.BOLD, 22));
        eMail.setBounds(100, 340, 200, 30);
        this.add(eMail);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 22));
        maritalStatus.setBounds(100, 390, 200, 30);
        this.add(maritalStatus);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        this.add(address);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        this.add(city);

        JLabel province = new JLabel("Province:");
        province.setFont(new Font("Raleway", Font.BOLD, 22));
        province.setBounds(100, 540, 200, 30);
        this.add(province);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        this.add(pincode);

        //TextField Declaration and Assignments

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        this.add(nameTextField);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        this.add(fnameTextField);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        this.add(dateChooser);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(300, 290, 100, 30);
        maleRadioButton.setBackground(Color.WHITE);
        this.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(500, 290, 100, 30);
        femaleRadioButton.setBackground(Color.WHITE);
        this.add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        eMailTextField = new JTextField();
        eMailTextField.setFont(new Font("Railway", Font.BOLD, 14));
        eMailTextField.setBounds(300, 340, 400, 30);
        this.add(eMailTextField);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        this.add(married);

        unmarried = new JRadioButton("Unmarrried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        this.add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 30);
        other.setBackground(Color.WHITE);
        this.add(other);

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarried);
        maritalStatusGroup.add(other);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        this.add(addressTextField);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        this.add(cityTextField);

        provinceTextField = new JTextField();
        provinceTextField.setFont(new Font("Railway", Font.BOLD, 14));
        provinceTextField.setBounds(300, 540, 400, 30);
        this.add(provinceTextField);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Railway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        this.add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        this.add(next);

        this.getContentPane().setBackground(Color.WHITE);

        this.setSize(850, 800);
        this.setLocation(350, 10);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;

        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        }

        String eMail = eMailTextField.getText();
        String maritalStatus = null;

        if (married.isSelected()) {
            maritalStatus = "Married";
        } else if (unmarried.isSelected()) {
            maritalStatus = "Un Married";
        } else if (other.isSelected()) {
            maritalStatus = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String province = provinceTextField.getText();
        String pincode = pincodeTextField.getText();


        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                DatabaseConnection c = new DatabaseConnection();
                String query = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + eMail + "','" + maritalStatus + "','" +  address + "','" + city + "','" + province +"','" + pincode + "')";
                c.st.executeUpdate(query);

                this.setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
