import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class AtmWithDraw  implements ActionListener
{
    JFrame display;
    Container c;
    JPanel jp;
    JLabel background,sbi,eql,photo,atm,cardtxt,pintxt,exit1,res,restxt;
    JTextField cardfld;
    JPasswordField pinfld;
    JButton enterbtn,homepng;
    double amount,balance;
    static ArrayList historyw= new ArrayList();

    public AtmWithDraw()
    {
        display=new JFrame();
        display.setBounds(400, 130, 650, 550);
        display.setTitle("ATM_WITHDRAW");
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


        cardtxt = new JLabel(); 
      cardtxt.setBounds(160, 160, 400, 100);
      cardtxt.setText("ENTER  AMOUNT :");
      cardtxt.setForeground(Color.gray);
      cardtxt.setFont(new Font("null",Font.BOLD,16));
      jp.add(cardtxt);
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
          
          String s=cardfld.getText();
          amount =Double.parseDouble(s);

          String n=pinfld.getText();
          int b=Integer.parseInt(n);
          
          AtmDiposite.acbalance=AtmDiposite.acbalance-amount;//ADDITIONAL UN NESESCARRY 

          if((s.isEmpty()==false)&&(n.isEmpty()==false))
          {
           if(amount<=AtmDiposite.acbalance)
           {
            JOptionPane.showMessageDialog(display, "AMOUNT OF ("+amount+") HAS WITHDRAW SUCCESFULLY", "RESULT :", JOptionPane.NO_OPTION);
            AtmDiposite.acbalance=AtmDiposite.acbalance-amount;

            /*if(enterbtn(amount))
            {
              Data.transactionID=Data.transactionID + 1;
              int id = Data.transactionID;
              double withdraw=enterbtn.amount;
              double diposite= AtmDiposite.acbalance;
            }
            */
            
            display.setVisible(false);
            new AtmThankyou();
           }
           else
           {
            JOptionPane.showMessageDialog(display,"INSUFFICENT  BALANCE ","RESULT :",JOptionPane.WARNING_MESSAGE);
            
            display.setVisible(false);
            new AtmThankyou();
           }
          }
        }  

        if(ae.getSource()==homepng)
        {
          display.setVisible(false);
          new Atmfunctions();
        }
        
      }  
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(display,"PLESE INPUTS DIGITS :","HELP",JOptionPane.WARNING_MESSAGE);
      }
    }
    public static void main(String[] args) 
    {
      new AtmWithDraw();    
    }
}

