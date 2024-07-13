import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class AddCoustomer extends JFrame implements ActionListener {
    JComboBox comboId,combogender;
    JTextField tfdeposit,tfNumber,tfname,tfcountry;

    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;


    AddCoustomer(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("New Coustomer form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);

        JLabel lblId=new JLabel("ID");
        lblId.setBounds(35,80,100,20);
        lblId.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblId);

        String options[]={"Aadhar Card","Passport","Driving-License","Voter id"};
        comboId =new JComboBox(options);
        comboId.setBounds(200,80,150,25);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);

        tfNumber=new JTextField();
        tfNumber.setBounds(200,120,150,25);
        add(tfNumber);

        JLabel lblname=new JLabel("name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);

//        String Gender[]={"Male","Female"};
//        combogender =new JComboBox(Gender);
//        combogender.setBounds(200,200,150,25);
//        combogender.setBackground(Color.WHITE);
//        add(combogender);

        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);

        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);

        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);

        croom=new Choice();
        try {
            Conn conn=new Conn();
            String query="select * from room where roomavailablity='Available'";
//            conn.s.executeQuery(query);
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lbltime=new JLabel("Checkin Time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);

       Date date = new Date();
         checkintime=new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);

        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);

        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
       add.setBounds(50,410,120,30);
       add.addActionListener(this);
       add(add);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);


        setBounds(350,200,800,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddCoustomer();

        }
 //   public void actiomPreformed(ActionEvent ae){


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String id=(String) comboId.getSelectedItem();
            String number=tfNumber.getText();
            String name=tfname.getText();
            String gender=null;
            if (rmale.isSelected()) {
                gender = "male";
            }else {
                gender="female";
            }


            String country=tfcountry.getText();
            String roomno=croom.getSelectedItem();
            String time=checkintime.getText();
            String Deposit= tfdeposit.getText();

            try {
                String qurey="insert into coustomer values('"+id+"','"+ number+"','"+ name+"','"+gender+"','"+country+"','"+ roomno+"','"+time+"','"+Deposit+"')";

                String query2= "update room set roomavailablity = 'Occupied' where roomnumber= '"+roomno+"'";

                Conn conn=new Conn();
                conn.s.executeUpdate(qurey);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"new Customer Added successfully");
                setVisible(false);
                new Reception();
            }catch (Exception ae){
               ae.printStackTrace();
            }

        } else if (e.getSource()==back) {
            setVisible(false);
            new Reception();



    }

    }
}