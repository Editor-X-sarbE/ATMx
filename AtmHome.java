import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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

public class AtmHome implements ActionListener
{
    JFrame display;
    Container c;
    JPanel jp;
    JLabel bs,dp,wd,trn,sbi,eql,cardtxt,pintxt,photo,background,atm,square,exit1;
    JTextField cardfld;
    JButton btnbs,btndp,btnwd,btntrn,menuexit,enterbtn;
    JPasswordField pinfld;
    //Font f;

    public AtmHome()
    {
      display=new JFrame();
      display.setBounds(400, 130, 650, 550);
      display.setTitle("ATM_HOME");
      display.setLayout(null);
      display.setResizable(false);
      display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      c=display.getContentPane();
      //display.getContentPane().setBackground(Color.cyan);

    
      jp=screen();
      c.add(jp);


      display.setVisible(true);
    }


    public JPanel screen()
    {
      JPanel jp;
      jp = new JPanel();
      jp.setBounds(0, 0, 650, 550);
      //jp.setBackground(Color.blue);
      jp.setLayout(null);

      sbi=new JLabel();                   //STATE BANK OF INDIA
      sbi.setBounds(160, 90, 500, 40);
      sbi.setText("STATE BANK OF INDIA");
      sbi.setForeground(Color.black);
      sbi.setFont(new Font("null",Font.BOLD,35));
      jp.add(sbi);
      eql =new JLabel();
      eql.setBounds(140, 120, 500, 40);
      eql.setForeground(Color.black);
      eql.setFont(new Font("null",Font.BOLD,25));
      eql.setText("===========================");
      jp.add(eql);

      cardtxt = new JLabel();
      cardtxt.setBounds(160, 160, 400, 100);
      cardtxt.setText("ENTER  YOUR  ID :");
      cardtxt.setForeground(Color.black);
      cardtxt.setFont(new Font("null",Font.BOLD,16));
      jp.add(cardtxt);
      cardfld = new JTextField();
      cardfld.setBounds(380, 195, 200, 30);
      jp.add(cardfld);


      pintxt = new JLabel();
      pintxt.setBounds(160, 230, 400, 100);
      pintxt.setText("ENTER  YOUR  PIN :");
      pintxt.setForeground(Color.black);
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


      background = new JLabel();
      background.setIcon(new ImageIcon("background.png"));
      background.setBounds(0, 0, 650, 550);
      Dimension pix = photo.getPreferredSize();
      jp.add(background);

      return jp;
    }


    public void actionPerformed(ActionEvent ae)
    {
      try 
      {
        if(ae.getSource()==enterbtn)
        {
          /*int a,b;
          a=Integer.parseInt(cardfld.getText());
          b=Integer.parseInt(pinfld.getText());*/
          //if((a.isEmpty()==false)&&(b.isEmpty()==false))
          //{
            String data1 = cardfld.getText();  //FOR str/int

            String s=pinfld.getText();         //FOR int only 
            int i=Integer.parseInt(s);
            if((data1.isEmpty()==false)&&s.isEmpty()==false)
            {
            display.setVisible(false);
            new Atmfunctions();
          }
          else
          {
            JOptionPane.showMessageDialog(display,"ENTER  VALID  DETAILS  :","HELP",JOptionPane.WARNING_MESSAGE);
          }
        }
      } 
      catch (Exception e) 
      {
       JOptionPane.showMessageDialog(display,"PLEASE  INPUT  DIGITS :","HELP",JOptionPane.WARNING_MESSAGE);
      }
    } 
    public static void main(String[]args)
    {
        new AtmHome();
    }
}