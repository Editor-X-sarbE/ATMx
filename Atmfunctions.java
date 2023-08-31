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
//import javax.swing.JTextField;
//import javax.swing.JOptionPane;

public class Atmfunctions implements ActionListener
{
    JFrame display;
    Container c;
    JPanel jp;
    JLabel background,sbi,eql,photo,atm,rotatepng,rotatepng1,s100,s500,s200,noteeql;
    JButton diposite,withdraw,transaction,history,quit,homepng;
    

    public Atmfunctions()
    {
        display=new JFrame();
        display.setBounds(400, 130, 650, 550);
        display.setTitle("ATM_FUNCTION");
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
        sbi.setBounds(180, 60, 500, 40);
        sbi.setText("STATE BANK OF INDIA");
        sbi.setForeground(Color.black);
        sbi.setFont(new Font("null",Font.BOLD,35));
        jp.add(sbi);
        eql =new JLabel();
        eql.setBounds(160, 90, 500, 40);
        eql.setForeground(Color.black);
        eql.setFont(new Font("null",Font.BOLD,25));
        eql.setText("============================");
        jp.add(eql);


        photo = new JLabel();
        photo.setIcon(new ImageIcon("sbi.png"));
        photo.setBounds(0, -25, 100, 100);
        Dimension size = photo.getPreferredSize();
        jp.add(photo);
        atm= new JLabel();
        atm.setText("ATM");
        atm.setBounds(100, -20, 100, 100);
        atm.setForeground(Color.black);
        atm.setFont(new Font("null",Font.CENTER_BASELINE,33));
        jp.add(atm);


        diposite = new JButton();
        diposite.setBounds(200, 200, 170, 50);
        diposite.setText("DIPOSITE");
        diposite.setFont(new Font("null",Font.BOLD,23));
        diposite.setBackground(Color.ORANGE);
        diposite.addActionListener(this);
        jp.add(diposite);

        withdraw = new JButton();
        withdraw.setBounds(450, 200, 170, 50);
        withdraw.setText("WITHDRAW");
        withdraw.setFont(new Font("null",Font.BOLD,23));
        withdraw.setBackground(Color.ORANGE);
        withdraw.addActionListener(this);
        jp.add(withdraw);

        transaction = new JButton();
        transaction.setBounds(200, 320, 170, 50);
        transaction.setText("TRANSFER");
        transaction.setFont(new Font("null",Font.BOLD,23));
        transaction.setBackground(Color.ORANGE);
        transaction.addActionListener(this);
        jp.add(transaction);

        history = new JButton();
        history.setBounds(450, 320, 170, 50);
        history.setText("HISTORY");
        history.setFont(new Font("null",Font.BOLD,23));
        history.setBackground(Color.ORANGE);
        history.addActionListener(this);
        jp.add(history);

        quit = new JButton();
        quit.setBounds(330, 420, 170, 50);
        quit.setText("QUIT");
        quit.setFont(new Font("null",Font.BOLD,23));
        quit.setBackground(Color.orange);
        quit.addActionListener(this);
        jp.add(quit);


        rotatepng = new JLabel();               //AVILABLE 
        //rotatepng.setIcon(new ImageIcon("rotate.png"));
        rotatepng.setBounds(30, 120, 200, 100);
        //Dimension png = rotatepng.getPreferredSize();
        rotatepng.setText("AVILABLE");
        rotatepng.setFont(new Font("null",Font.BOLD,20));
        rotatepng.setForeground(Color.gray);
        jp.add(rotatepng);   
        rotatepng1 = new JLabel();               // NOTES
        //rotatepng.setIcon(new ImageIcon("rotate.png"));
        rotatepng1.setBounds(40, 140, 200, 100);
        //Dimension png = rotatepng.getPreferredSize();
        rotatepng1.setText("NOTES");
        rotatepng1.setFont(new Font("null",Font.BOLD,18));
        rotatepng1.setForeground(Color.gray);
        jp.add(rotatepng1);
        noteeql = new JLabel();
        noteeql.setBounds(25, 150, 200, 100);
        noteeql.setText("-----------------");
        noteeql.setFont(new Font("null",Font.BOLD,18));
        noteeql.setForeground(Color.gray);
        jp.add(noteeql);


        s100 = new JLabel();
        s100.setBounds(50, 220, 100, 30);
        s100.setText("100");
        s100.setForeground(Color.white);
        s100.setFont(new Font("null",Font.BOLD,18));
        jp.add(s100);

        s500 = new JLabel();
        s500.setBounds(50, 260, 100, 30);
        s500.setText("500");
        s500.setForeground(Color.white);
        s500.setFont(new Font("null",Font.BOLD,18));
        jp.add(s500);

        s200 = new JLabel();
        s200.setBounds(50, 300, 100, 30);
        s200.setText("200");
        s200.setForeground(Color.white);
        s200.setFont(new Font("null",Font.BOLD,18));
        jp.add(s200);

        homepng = new JButton();
        homepng.setIcon(new ImageIcon("homecopy.png"));
        homepng.setBounds(0, 420, 100, 100);
        Dimension siz = photo.getPreferredSize();
        homepng.addActionListener(this);
        jp.add(homepng);


        background = new JLabel();
        background.setIcon(new ImageIcon("background.png"));
        background.setBounds(0, 0, 650, 550);
        Dimension pix = background.getPreferredSize();
        jp.add(background);

        return jp;
    }

    public void actionPerformed(ActionEvent ae)
    {
        try 
        {
            if(ae.getSource()==diposite)
            {
                display.setVisible(false);
                new AtmDiposite();
            }
            if(ae.getSource()==withdraw)
            {
                display.setVisible(false);
                new AtmWithDraw();
            }
            if(ae.getSource()==transaction)
            {
                display.setVisible(false);
                new AtmTransfer();
            }
            if(ae.getSource()==history)
            {
                display.setVisible(false);
                new AtmHistory();
            }
            if(ae.getSource()==homepng)
            {
                display.setVisible(false);
                new AtmHome();
            }
            if(ae.getSource()==quit)
            {
                System.exit(0);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(display,"WRONG INPUT :","HELP",JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[] args) 
    {
        new Atmfunctions();
    }
}
