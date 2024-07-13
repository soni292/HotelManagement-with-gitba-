import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener {
    JTable table1;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("Search Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel Bedtype=new JLabel("Bed Type");
        Bedtype.setBounds(50,100,100,20);
        add(Bedtype);

        bedType=new JComboBox<>(new String[]{"Single bed","Double bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available=new JCheckBox("only display available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel l1=new JLabel("room Number");
        l1.setBounds(50,160,100,20);
        add(l1);

        JLabel l2=new JLabel("Availibity");
        l2.setBounds(270,160,100,20);
        add(l2);

        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(450,160,100,20);
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);

        JLabel l5=new JLabel("Bed type");
        l5.setBounds(870,160,100,20);
        add(l5);

        table1=new JTable();
        table1.setBounds(0,200,1000,300);
        add(table1);

        try {

            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table1.setModel(DbUtils.resultSetToTableModel(rs));


        }catch (Exception e){
            e.printStackTrace();
        }

        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);

        back=new JButton("Back");
         back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }


    public static void main(String[] args) {

        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            try {
                String query1="select * from room where bed_type='"+bedType.getSelectedItem()+"'";
                String query2="select * from room where roomavailablity='Available' AND bed_type='"+bedType.getSelectedItem()+"'";

                Conn conn=new Conn();
                ResultSet rs;

                if (available.isSelected()){

                    rs=conn.s.executeQuery(query2);
                }else {
                    rs=conn.s.executeQuery(query1);
                }
                table1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception ae){
                ae.printStackTrace();

            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
}