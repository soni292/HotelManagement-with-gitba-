import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JRadioButton rbmale,rbFemale;
    JButton submit;
    JComboBox cbjob;

    AddEmployee(){
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

       tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        JLabel lblage=new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        JLabel lblGender=new JLabel("Gender");
        lblGender.setBounds(60,130,120,30);
        lblGender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblGender);

       rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbFemale=new JRadioButton("Female");
        rbFemale.setBounds(280,130,70,30);
        rbFemale.setFont(new Font("Tahoma",Font.PLAIN, 14));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);

        String str[]={"Front Desk","Porters","HouseKeeping","Kitchen Staff","Room services","Cheff","Waiter/Waitress","Manager","Accountant"};
      cbjob=new JComboBox<>(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lbljob=new JLabel("Job");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);

        JLabel lblsalary=new JLabel("Salary");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);

       tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel lblPhone=new JLabel("Phone Number");
        lblPhone.setBounds(60,280,120,30);
        lblPhone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblPhone);

         tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);

         tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbFemale);

        JLabel lblaadhar=new JLabel("Aadhar");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);

        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

          submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);



        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,200,850,540);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        String name=tfname.getName();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();

        String gender=null;
        if (Objects.equals(name, "")){
            JOptionPane.showMessageDialog(null,"Name shoud not be empty");
            return;
        } else if (age.equals("")) {
            JOptionPane.showMessageDialog(null,"age should not be empty");
        } else if (phone.equals("")) {
            JOptionPane.showMessageDialog(null,"phone shoud not be empty");

        } else if (email.equals("")) {
        JOptionPane.showMessageDialog(null,"email shoud not be empty");

    }  else if (aadhar.equals("")) {
        JOptionPane.showMessageDialog(null,"addhar shoud not be empty");

        }


        if (rbmale.isSelected()){
            gender="male";

        } else if (rbFemale.isSelected()) {
            gender="female";
        }
        String job=(String) cbjob.getSelectedItem();
        try {
            Conn conn=new Conn();
            String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"employee added Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args)
    {
        new AddEmployee();
    }
}
