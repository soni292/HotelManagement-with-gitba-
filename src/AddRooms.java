import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JTextField tfroom,tfprice;

    JButton add,cancle;
    JLabel heading,lblroomno,lblprice,lblavailable,lbltype,image;
    JComboBox availablecombo,clean,typecombo;
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading =new JLabel("Add Rooms");
        heading.setFont(new Font("tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

       lblroomno =new JLabel("Room Number");
        lblroomno.setFont(new Font("tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);

        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

         lblavailable =new JLabel("Available");
        lblavailable.setFont(new Font("tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);

        String availableOptions[]={"Available","occupied"};
        availablecombo = new JComboBox<>(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);

        JLabel lblclean =new JLabel("Cleaning Status");
        lblclean.setFont(new Font("tahoma",Font.PLAIN,18));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String cleanOptions[]={"Clean","Dirty"};
        clean = new JComboBox<>(cleanOptions);
        clean.setBounds(200,180,150,30);
        clean.setBackground(Color.white);
        add(  clean);

         lblprice=new JLabel("Room Price");
        lblprice.setFont(new Font("tahoma",Font.PLAIN,18));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);


        lbltype =new JLabel("Bed Type");
        lbltype.setFont(new Font("tahoma",Font.PLAIN,18));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        String typeOptions[]={"Single Bed","Double Bed"};
        typecombo = new JComboBox<>(typeOptions);
        typecombo .setBounds(200,280,150,30);
        typecombo .setBackground(Color.white);
        add(   typecombo );

        add=new JButton("Add rooms");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        cancle=new JButton("Cancle ");
        cancle.setForeground(Color.WHITE);
        cancle.setBackground(Color.BLACK);
        cancle.setBounds(220,350,130,30);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);




        setBounds(330,200,940,470);
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
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==add){
                String roomnumber=tfroom.getText();
                String availablity=(String) availablecombo.getSelectedItem();
                String Status=(String) clean.getSelectedItem();
                String price=tfprice.getText();
                String type=(String) typecombo.getSelectedItem();

                try {
                    Conn conn=new Conn();
                    String str="insert into room values('"+roomnumber+"','"+availablity+"','"+Status+"','"+price+"','"+type+"')";
                    conn.s.executeUpdate(str);



                JOptionPane.showMessageDialog(null,"new Room Added Succesfully");
                setVisible(false);
                }catch (Exception ae){
                    ae.printStackTrace();

                }


            }else {
                setVisible(false);
            }
        }

    }

