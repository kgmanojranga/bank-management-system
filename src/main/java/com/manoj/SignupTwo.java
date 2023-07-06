package com.manoj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
    JComboBox religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    JTextField panTextField, idTextField;
    JRadioButton seniorRadioButton, notSeniorRadioButton, existingAccountRadioButton, notExistingAccountRadioButton;
    JButton next;

    String formno;

    public SignupTwo(String formno){

        this.formno = formno;

        this.setLayout(null);

        this.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        //Label Declaration and Assignments
        JLabel formLabel = new JLabel("APPLICATION FORM NO." + formno);
        formLabel.setFont(new Font("Raleway", Font.BOLD, 38));
        formLabel.setBounds(140, 20, 600, 40);
        this.add(formLabel);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        this.add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 140, 100, 30);
        this.add(religion);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100, 190, 200, 30);
        this.add(category);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 240, 200, 30);
        this.add(income);

        JLabel education = new JLabel("Education");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(100, 290, 200, 30);
        this.add(education);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(100, 315, 200, 30);
        this.add(qualification);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100, 390, 200, 30);
        this.add(occupation);

        JLabel panNo = new JLabel("PAN No:");
        panNo.setFont(new Font("Raleway", Font.BOLD, 22));
        panNo.setBounds(100, 440, 200, 30);
        this.add(panNo);

        JLabel identification = new JLabel("ID No:");
        identification.setFont(new Font("Raleway", Font.BOLD, 22));
        identification.setBounds(100, 490, 200, 30);
        this.add(identification);

        JLabel seniority = new JLabel("Senior Citizen:");
        seniority.setFont(new Font("Raleway", Font.BOLD, 22));
        seniority.setBounds(100, 540, 200, 30);
        this.add(seniority);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 22));
        existingAccount.setBounds(100, 590, 200, 30);
        this.add(existingAccount);




        //TextField Declaration and Assignments

        String valReligion[] = {"Sinhala", "Muslim", "Christian", "Other"};
        religionBox = new JComboBox(valReligion);
        religionBox.setFont(new Font("Railway", Font.BOLD, 14));
        religionBox.setBounds(300, 140, 400, 30);
        religionBox.setBackground(Color.WHITE);
        this.add(religionBox);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBackground(Color.WHITE);
        categoryBox.setBounds(300, 190, 400, 30);
        this.add(categoryBox);

        String valIncome[] = {"NULL", "< 150,000", "< 250,000", "< 500,000", "Upto 1,000,000"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBackground(Color.WHITE);
        incomeBox.setBounds(300, 240, 400, 30);
        this.add(incomeBox);

        String valEducation[] = {"Under-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educationBox = new JComboBox(valEducation);
        educationBox.setBackground(Color.WHITE);
        educationBox.setBounds(300, 290, 400, 30);
        this.add(educationBox);

        String valOccupation[] = {"Salaried", "Self-employed", "Bussiness", "Student", "Retired", "Other"};
        occupationBox = new JComboBox(valOccupation);
        occupationBox.setBackground(Color.WHITE);
        occupationBox.setBounds(300, 390, 400, 30);
        this.add(occupationBox);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Railway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        this.add(panTextField);

        idTextField = new JTextField();
        idTextField.setFont(new Font("Railway", Font.BOLD, 14));
        idTextField.setBounds(300, 490, 400, 30);
        this.add(idTextField);

        seniorRadioButton = new JRadioButton("Yes");
        seniorRadioButton.setBackground(Color.WHITE);
        seniorRadioButton.setBounds(300, 540, 100, 30);
        this.add(seniorRadioButton);

        notSeniorRadioButton = new JRadioButton("No");
        notSeniorRadioButton.setBackground(Color.WHITE);
        notSeniorRadioButton.setBounds(450, 540, 100, 30);
        this.add(notSeniorRadioButton);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorRadioButton);
        seniorGroup.add(notSeniorRadioButton);

        existingAccountRadioButton = new JRadioButton("Yes");
        existingAccountRadioButton.setBackground(Color.WHITE);
        existingAccountRadioButton.setBounds(300, 590, 100, 30);
        this.add(existingAccountRadioButton);

        notExistingAccountRadioButton = new JRadioButton("No");
        notExistingAccountRadioButton.setBackground(Color.WHITE);
        notExistingAccountRadioButton.setBounds(450, 590, 100, 30);
        this.add(notExistingAccountRadioButton);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingAccountRadioButton);
        existingAccountGroup.add(notExistingAccountRadioButton);

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
        String formno = "" + this.formno;
        String religion = (String)religionBox.getSelectedItem();
        String category = (String)categoryBox.getSelectedItem();
        String income = (String)incomeBox.getSelectedItem();
        String education = (String)educationBox.getSelectedItem();
        String occupation = (String)occupationBox.getSelectedItem();
        String pan = panTextField.getText();
        String id = idTextField.getText();
        String isSenior = null;

        if (seniorRadioButton.isSelected()) {
            isSenior = "Yes";
        } else if (notSeniorRadioButton.isSelected()) {
            isSenior = "No";
        }

        String existingAccount = null;

        if (existingAccountRadioButton.isSelected()) {
            existingAccount = "Yes";
        } else if (notSeniorRadioButton.isSelected()) {
            existingAccount = "No";
        }

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signupTwo VALUES('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" +  id + "','" + isSenior + "','" + existingAccount + "')";
            c.st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static void main(String[] a){
        new SignupTwo("");
    }
}

