import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class Room extends JFrame implements ActionListener {
    JTable table1;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel l1=new JLabel("room Number");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Availibity");
        l2.setBounds(120,10,100,20);
        add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(340,10,100,20);
        add(l4);

        JLabel l5=new JLabel("Bed type");
        l5.setBounds(420,10,100,20);
        add(l5);

        table1=new JTable();
        table1.setBounds(0,40,500,400);
        add(table1);

        try {

            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");

            table1.setModel(DbUtils.resultSetToTableModel(rs));


        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);

        setBounds(300,200,1050,600);
        setVisible(true);
    }


    public static void main(String[] args) {

        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();

    }
}