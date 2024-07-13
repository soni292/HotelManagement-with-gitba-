import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class Customerinfo extends JFrame implements ActionListener {
    JTable table1;
    JButton back;
    Customerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        JLabel l1=new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Number");
        l2.setBounds(160,10,100,20);
        add(l2);


        JLabel l3=new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        add(l4);

        JLabel l5=new JLabel("Country");
        l5.setBounds(510,10,100,20);
        add(l5);

        JLabel l6=new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);

        JLabel l7=new JLabel("Checkin Time");
        l7.setBounds(760,10,100,20);
        add(l7);

        JLabel l8=new JLabel("Deposit");
        l8.setBounds(900,10,100,20);
        add(l8);

        table1=new JTable();
        table1.setBounds(0,40,1000,400);
        add(table1);

        try {

            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from coustomer");
            table1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }


    public static void main(String[] args) {

        new Customerinfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();

    }
}