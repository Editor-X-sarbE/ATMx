import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JOptionPane;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AtmDiposite implements ActionListener
{
    JFrame display;
    Container c;
    JPanel jp;
    JLabel background,sbi,eql,photo,atm,res,restxt,cardtxt,pintxt,exit1;
    JTextField cardfld;
    JPasswordField pinfld;
    JButton enterbtn,homepng;
    public static double acbalance=0;
    static double amount;
    static ArrayList history =new ArrayList();
    

    public AtmDiposite()
    {
        display=new JFrame();
        display.setBounds(400, 130, 650, 550);
        display.setTitle("ATM_DIPOSITE");
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
        sbi.setText("STATE BANK OF INDIA");
        sbi.setForeground(Color.gray);
        sbi.setFont(new Font("null",Font.BOLD,30));
        jp.add(sbi);
        eql =new JLabel();
        eql.setBounds(140, 90, 400, 40);
        eql.setForeground(Color.gray);
        eql.setFont(new Font("null",Font.BOLD,25));
        eql.setText("=========================");
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


        cardtxt = new JLabel();     // AMOUNT TEXT 
      cardtxt.setBounds(160, 160, 400, 100);
      cardtxt.setText("ENTER  AMOUNT :");
      cardtxt.setForeground(Color.gray);
      cardtxt.setFont(new Font("null",Font.BOLD,16));
      jp.add(cardtxt);           //AMOUNT FIELD
      cardfld = new JTextField();
      cardfld.setBounds(380, 195, 200, 30);
      jp.add(cardfld);


      pintxt = new JLabel();
      pintxt.setBounds(160, 230, 400, 100);
      pintxt.setText("ENTER  YOUR  PIN :");
      pintxt.setForeground(Color.gray);
      pintxt.setFont(new Font("null",Font.BOLD,16));
      jp.add(pintxt);
      pinfld = new JPasswordField();
      pinfld.setBounds(380, 265, 200, 30);
      jp.add(pinfld);
      

      enterbtn = new JButton();
      enterbtn.setBounds(280, 380, 150, 30);
      enterbtn.setText("PLEASE ENTER");
      enterbtn.setBackground(Color.ORANGE);
      enterbtn.addActionListener(this);
      jp.add(enterbtn);


      homepng = new JButton();
      homepng.setIcon(new ImageIcon("homecopyxx1.png"));
      homepng.setBounds(0, 420, 100, 100);
      Dimension siz = photo.getPreferredSize();
      homepng.addActionListener(this);
      jp.add(homepng);

          


        background = new JLabel();
        background.setIcon(new ImageIcon("abstract.png"));
        background.setBounds(0, 0, 650, 550);
        Dimension pix = background.getPreferredSize();
        jp.add(background);

        return jp;
    }

    public void actionPerformed(ActionEvent ae)
    {
      try 
      {  
        if(ae.getSource()==enterbtn)
        { 
          
 

       
           String n=pinfld.getText();
           int b =Integer.parseInt(n);

             double amount;
             //double acbalance=0;
                
                String s=cardfld.getText();
                amount=Double.parseDouble(s);

                
                AtmDiposite.acbalance=AtmDiposite.acbalance+amount;


                

           if((s.isEmpty()==false)&&(n.isEmpty()==false))
           {
            
                JOptionPane.showMessageDialog(display, "AMOUNT OF ("+amount+") HAS DIPOSITED SUCCESFULLY", "RESULT :", JOptionPane.NO_OPTION);
                Data.transactionID = Data.transactionID+1;
                int id = Data.transactionID;
                double balance = AtmDiposite.acbalance;


                AtmHistory.setHistory(id,"Diposite",amount, balance,"Succuess" );


             
             display.setVisible(false);
             new AtmThankyou();
           } 
        }
        else if(ae.getSource()==homepng)
        {
          display.setVisible(false);
          new Atmfunctions();
        }
      } 
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(display,"INPUT  DIGITS :","HELP",JOptionPane.WARNING_MESSAGE);
        //e.printStackTrace();
      }
    }
    public static void main(String[] args)
    {
      new AtmDiposite();
    }
}

                       