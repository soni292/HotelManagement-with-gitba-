import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Reception extends JFrame implements ActionListener {

    JButton newCoustomer,checkout,update,rooms,department,allEmployee,coustomer,managerinfo,searchRoom;
    Reception(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        newCoustomer =new JButton("New Coustomer Form");
        newCoustomer.setBounds(10,30,200,30);
        newCoustomer.setBackground(Color.black);
        newCoustomer.setForeground(Color.white);
        newCoustomer.addActionListener(this);
        add(newCoustomer);

         rooms =new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);

        add(rooms);

         department =new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

         allEmployee =new JButton("All Employee");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

         coustomer =new JButton("Coustomer Info");
        coustomer.setBounds(10,190,200,30);
        coustomer.setBackground(Color.BLACK);
        coustomer.setForeground(Color.WHITE);
        coustomer.addActionListener(this);
        add(coustomer);

         managerinfo =new JButton("Manager Info");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);

         checkout =new JButton("Check Out");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        update =new JButton("update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        JButton roomstatus =new JButton("update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        add(roomstatus);

        JButton pickup =new JButton("Pickup servces");
        pickup.setBounds(10,350,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);

         searchRoom =new JButton("Search Room");
        searchRoom.setBounds(10,390,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        JButton logout =new JButton("Logout");
        logout.setBounds(10,430,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);


        setBounds(350,200,800,570);
        setVisible(true);

}

    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==newCoustomer){
            setVisible(false);
            new AddCoustomer();
        }else if (e.getSource()==rooms){
            setVisible(false);
            new Room();
        } else if (e.getSource()==department) {
            setVisible(false);
            new Department();
        }else if (e.getSource()==allEmployee){
            setVisible(false);
            new Employeeinfo();
        } else if (e.getSource()==managerinfo) {
            setVisible(false);
            new Managerinfo();
        } else if (e.getSource()==coustomer) {
            setVisible(false);
            new Employeeinfo();
        } else if (e.getSource()==searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (e.getSource()==update) {
            setVisible(false);
            try {
                new updateCheck();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}

