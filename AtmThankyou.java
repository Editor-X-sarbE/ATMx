import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import javax.swing.JOptionPane;

public class AtmThankyou implements ActionListener
{
    JFrame display;
    Container c;
    JPanel jp;
    JLabel background,sbi,eql,photo,atm,thankyou,res,resulttxt,restxt,cardtxt,pintxt,exit1,forusing,services;
    JButton enterbtn,homepng;

    public AtmThankyou()
    {
        display=new JFrame();
        display.setBounds(400, 130, 650, 550);
        display.setTitle("ATM_THANKYOU");
        display.setLayout(null);
        display.setResizable(false);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c=display.getContentPane();


        jp=screen();
        c.add(jp);
        display.setVisible(true);
    }

    public JPanel screen()
    {
        JPanel jp;
        jp= new JPanel();
        jp.setBounds(0, 0, 650, 550);
        //jp.setBackground(Color.blue);
        jp.setLayout(null);

        sbi=new JLabel();                   //STATE BANK OF INDIA
        sbi.setBounds(160, 60, 400, 40);
        sbi.setText("STATE  BANK  OF  INDIA");
        sbi.setForeground(Color.gray);
        sbi.setFont(new Font("null",Font.BOLD,30));
        jp.add(sbi);
        eql =new JLabel();
        eql.setBounds(140, 90, 400, 40);
        eql.setForeground(Color.gray);
        eql.setFont(new Font("null",Font.BOLD,25));
        eql.setText("==========================");
        jp.add(eql);


        photo = new JLabel();
        photo.setIcon(new ImageIcon("sbi.png"));
        photo.setBounds(0, -25, 100, 100);
        Dimension size = photo.getPreferredSize();
        jp.add(photo);
        atm= new JLabel();
        atm.setText("ATM");
        atm.setBounds(100, -20, 100, 100);
        atm.setForeground(Color.gray);
        atm.setFont(new Font("null",Font.CENTER_BASELINE,33));
        jp.add(atm);

       /* res = new JLabel();    //RES TXT 
             res.setBounds(80,150,500,100);
             res.setText("RES:-");
             res.setForeground(Color.gray);
             res.setFont(new Font("null",Font.BOLD,20));
             //jp.add(res);*/

          /*resulttxt = new JLabel();
          resulttxt.setText("AMOUNT OF WAS DIPOSITED");
          resulttxt.setBounds(150, 150, 500, 100);
          resulttxt.setFont(new Font("null",Font.BOLD,20));
          resulttxt.setForeground(Color.white);
          //jp.add(resulttxt);*/

        
        thankyou = new JLabel();
        thankyou.setText("THANK FOR");
        thankyou.setBounds(50, -20, 400, 400);
        thankyou.setFont(new Font("null",Font.BOLD,50));
        thankyou.setForeground(Color.gray);
        jp.add(thankyou);

        forusing = new JLabel();
        forusing.setText("USING THIS");
        forusing.setBounds(50, 40, 400, 400);
        forusing.setFont(new Font("null",Font.BOLD,45));
        forusing.setForeground(Color.gray);
        jp.add(forusing);

        services = new JLabel();
        services.setText("SERVICES");
        services.setBounds(50, 95, 400, 400);
        services.setFont(new Font("null",Font.BOLD,40));
        services.setForeground(Color.gray);
        jp.add(services);


        homepng = new JButton();
        homepng.setIcon(new ImageIcon("homecopyxx1.png"));
        homepng.setBounds(0, 420, 100, 100);
        Dimension siz = photo.getPreferredSize();
        homepng.addActionListener(this);
        jp.add(homepng);

        background = new JLabel();
        background.setIcon(new ImageIcon("thankyouxx.png"));
        background.setBounds(0, 0, 650, 550);
        Dimension pix = background.getPreferredSize();
        jp.add(background);

        return jp;
    }

    public void actionPerformed(ActionEvent ae)
    {
      try 
      {
        if(ae.getSource()==homepng)
        {
          display.setVisible(false);
          new Atmfunctions();
        }
      } 
      catch (Exception e) 
      {
        JOptionPane.showMessageDialog(display,"WRONG INPUT :","HELP",JOptionPane.WARNING_MESSAGE);
      }
    }
    public static void main(String[] args) 
    {
        new AtmThankyou();
    }
}
