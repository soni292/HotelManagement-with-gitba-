import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashbord extends JFrame implements ActionListener {
    String head ="A hotel is a place where bonafide traveller can receive food and shelter, provided she/he is in a position to pay for it and is in fit condition to be received. Inns –Public houses in early times in England were called inns.";
    Dashbord(){
        setBounds(0,0,1550,1000);


        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2= i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel heading=new JLabel(head);
        heading.setBounds(50,200,300,30);
        heading.setFont(new Font("tahoma",Font.PLAIN,20));
        heading.setForeground(Color.BLACK);
        image.add(heading);

       JLabel text=new JLabel("The Sharmas groups Welcome you");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("tahoma",Font.ITALIC,46));
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

      JMenu hotel=new JMenu("HOTEL MANAGMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);

        JMenu admin=new JMenu("Admins");
        admin.setForeground(Color.red);
     mb.add(admin);

        JMenu Demo=new JMenu("Demo");
        Demo.setForeground(Color.red);
        mb.add(Demo);

     JMenuItem reception =new JMenuItem("Reception");
     reception.addActionListener(this);
     hotel.add(reception);

     JMenuItem AddEmployee=new JMenuItem("ADD EMPLOYEE");
     AddEmployee.addActionListener(this);
     admin.add(AddEmployee);
        JMenuItem addrooms=new JMenuItem("ADD ROOMES");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        JMenuItem AddDrivers=new JMenuItem("ADD DRIVERS");
        AddDrivers.addActionListener(this);
        admin.add(AddDrivers);
        JMenuItem AddStaff=new JMenuItem("ADD STAFF");
       admin.add(AddStaff);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMES")) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("ADD DRIVERS")) {
            new AddDrivers();
        } else if (ae.getActionCommand().equals("Reception")) {
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Dashbord();

    }
}

