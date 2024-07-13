import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {
    JTextField tfname,tflocation,tfcompany,tfage,tfmodel;

    JButton add,cancle;
    JLabel heading,lblroomno,lblprice,lblavailable,lbltype,image,lblage,lbllocation;
    JComboBox availablecombo,clean,typecombo,agecombo,gendercombo;
    AddDrivers(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading =new JLabel("Add Drivers");
        heading.setFont(new Font("tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);

         lblroomno=new JLabel("Name");
        lblroomno.setFont(new Font("tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,70,120,30);
        add(lblroomno);

        tfname=new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);

        lblage =new JLabel("Age");
        lblage.setFont(new Font("tahoma",Font.PLAIN,18));
        lblage.setBounds(60,110,120,30);
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);


        JLabel lblclean =new JLabel("Gender");
        lblclean.setFont(new Font("tahoma",Font.PLAIN,18));
        lblclean.setBounds(60,150,120,30);
        add(lblclean);

        String cleanOptions[]={"Male","Female"};
        gendercombo = new JComboBox<>(cleanOptions);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.white);
        add(  gendercombo);

        lblprice=new JLabel("Car Company");
        lblprice.setFont(new Font("tahoma",Font.PLAIN,18));
        lblprice.setBounds(60,190,120,30);
        add(lblprice);

        tfcompany=new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);


        lbltype =new JLabel("Car Model");
        lbltype.setFont(new Font("tahoma",Font.PLAIN,18));
        lbltype.setBounds(60,230,120,30);
        add(lbltype);

        tfmodel=new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);

        lblavailable =new JLabel("Available");
        lblavailable.setFont(new Font("tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,270,120,30);
        add(lblavailable);

        String driversOptions[]={"Available","busy"};
        availablecombo = new JComboBox<>(driversOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.white);
        add(  availablecombo);

        lbllocation =new JLabel("Location");
        lbllocation.setFont(new Font("tahoma",Font.PLAIN,18));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);

        tflocation=new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);


        add=new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);

        cancle=new JButton("Cancle ");
        cancle.setForeground(Color.WHITE);
        cancle.setBackground(Color.BLACK);
        cancle.setBounds(220,370,130,30);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);




        setBounds(300,200,980,470);
        setVisible(true);
    }



//    public void actionPreformed(ActionEvent ae){
//        if (ae.getSource()==add){
//
//
//        }else {
//            setVisible(false);
//        }
//
//    }


    public static void main(String[] args) {
        new AddDrivers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String) gendercombo.getSelectedItem();
            String company=tfcompany.getText();
            String brand=tfmodel.getText();
            String available=(String) availablecombo.getSelectedItem();
            String location=tflocation.getText();

            try {
                Conn conn=new Conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);



                JOptionPane.showMessageDialog(null,"new Driver Added Succesfully");
                setVisible(false);
            }catch (Exception ae){
                ae.printStackTrace();

            }


        }else {
            setVisible(false);
        }
    }

}

