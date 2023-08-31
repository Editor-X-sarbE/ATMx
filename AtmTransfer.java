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
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AtmTransfer implements ActionListener
{
    JFrame display;
    Container c;
    JPanel jp;
    JLabel background,sbi,eql,photo,atm,holdername,acno,ifsc,amounttxt,pintxt,res,restxt;
    JPasswordField pinfld;
    JTextField holderfld,acnofld,ifscfld,amountfld;
    JButton enterbtn,homepng;
    double balance=0;
    double amount;

    public AtmTransfer()
    {
        display=new JFrame();
        display.setBounds(400, 130, 650, 550);
        display.setTitle("ATM_TRANSFER");
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


        holdername = new JLabel();
        holdername.setBounds(70, 150, 500, 40);
        holdername.setText("ENTER  A/C  HOLDER  NAME :");
        holdername.setForeground(Color.gray);
        holdername.setFont(new Font("null",Font.BOLD,16));
        jp.add(holdername);
        holderfld = new JTextField();
        holderfld.setBounds(350, 155, 190, 30);
        jp.add(holderfld);

        acno = new JLabel();
        acno.setBounds(70, 200, 500, 40);
        acno.setText("ENTER  ACCOUNT NO  :");
        acno.setForeground(Color.gray);
        acno.setFont(new Font("null",Font.BOLD,16));
        jp.add(acno);
        acnofld = new JTextField();
        acnofld.setBounds(350, 205, 190, 30);
        jp.add(acnofld);

        ifsc = new JLabel();
        ifsc.setBounds(70, 250, 500, 40);
        ifsc.setText("ENTER  IFSC CODE  :");
        ifsc.setForeground(Color.gray);
        ifsc.setFont(new Font("null",Font.BOLD,16));
        jp.add(ifsc);
        ifscfld = new JTextField();
        ifscfld.setBounds(350, 255, 190, 30);
        jp.add(ifscfld);

        amounttxt = new JLabel();  //AMOUNT TXT
        amounttxt.setBounds(70, 300, 500, 40);
        amounttxt.setText("ENTER  AMOUNT  :");
        amounttxt.setForeground(Color.gray);
        amounttxt.setFont(new Font("null",Font.BOLD,16));
        jp.add(amounttxt);
        amountfld = new JTextField();
        amountfld.setBounds(350, 305, 190, 30);
        jp.add(amountfld);

        pintxt = new JLabel();
        pintxt.setBounds(70, 350, 500, 40);
        pintxt.setText("ENTER  YOUR PIN  :");
        pintxt.setForeground(Color.gray);
        pintxt.setFont(new Font("null",Font.BOLD,16));
        jp.add(pintxt);
        pinfld = new JPasswordField();
        pinfld.setBounds(350, 355, 190, 30);
        jp.add(pinfld);

        enterbtn = new JButton();
        enterbtn.setBounds(280, 400, 150, 30);
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


       /* res = new JLabel();    //RES TXT 
        res.setBounds(130,410,500,100);
         res.setText("RES:-");
         res.setForeground(Color.gray);
         res.setFont(new Font("null",Font.BOLD,20));
         jp.add(res); 

      restxt = new JLabel();    //A/C  RESULT TXT
         restxt.setBounds(200,410,500,100);
         restxt.setText("AMOUNT  WITHDRAW  SUCCESFULLY..");
         restxt.setForeground(Color.cyan);
         restxt.setFont(new Font("null",Font.BOLD,20));
         jp.add(restxt);*/


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
          
          //String f=holderfld.getText();    //FOR  str/int
          //a=Integer.parseInt(f);
          String f=holderfld.getText();

          String g=acnofld.getText();
          long acn=Long.parseLong(g);

          //String h=holderfld.getText();   // FOR  str/int
          //c=Integer.parseInt(h);
          String h=ifscfld.getText();

          String i=amountfld.getText();
          amount=Double.parseDouble(i);

          String j=pinfld.getText();
          int e=Integer.parseInt(j);

          if((f.isEmpty()==false)&&(g.isEmpty()==false)&&(h.isEmpty()==false)&&(i.isEmpty()==false)&&(j.isEmpty()==false))
          
          if(amount<=AtmDiposite.acbalance)
          {
           JOptionPane.showMessageDialog(display, "AMOUNT OF ("+amount+") HAS TRANSFER SUCCESFULLY", "RESULT :", JOptionPane.NO_OPTION);
           AtmDiposite.acbalance=AtmDiposite.acbalance-amount;
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
        if(ae.getSource()==homepng)
        {
          display.setVisible(false);
          new Atmfunctions();
        }
      } 
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(display,"PLEASE  INPUT  DIGITS :","HELP",JOptionPane.WARNING_MESSAGE);
      }
    }
    public static void main(String[] args) 
    {
        new AtmTransfer();
    }
}
