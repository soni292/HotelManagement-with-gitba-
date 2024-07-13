import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
        setSize(1366,565);
        setLocation(100,100);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));

        JLabel image =new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serit",Font.PLAIN,50));
        image.add(text);

        JButton next=new JButton("NEXT");
        next.setBounds(1150,450,150,50);
        image.add(next);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.GRAY);
        next.addActionListener(this);
        image.add(next);

        setVisible(true);

        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login() ;
    }
    }
