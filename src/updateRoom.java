import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.jar.JarFile;

public class updateRoom extends JFrame implements ActionListener {

    Choice ccustomer;
    TextField tfroom;
    updateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text =new JLabel("update room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid=new JLabel("coustomer Id");
        lblid.setBounds(30,80,100,20);
        add(lblid);

         ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from coustomer");
            while (rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel lblroom=new JLabel("Room Number");
        lblid.setBounds(30,120,100,20);
        add(lblroom);

        tfroom=new TextField();
        tfroom.setBounds(200,80,150,25);
        add(tfroom);
    }

    public static void main(String[] args) {
        new updateRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
