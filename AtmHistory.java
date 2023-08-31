import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AtmHistory implements ActionListener
{
  int count = 0;
    JFrame display;
    Container c;
    JPanel jp;
    JLabel sbi,eql,photo,atm,transactiontxt,transactionforms;
    JTextField historytxt;
    JButton homepng, btnHistory;

    JTextField showBalance;
    static JTextArea historyArea;

    static ArrayList historylist = new ArrayList();

    public AtmHistory()
    {
        display=new JFrame();
        display.setBounds(400, 130, 650, 550);
        display.setTitle("ATM_HISTORY");
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
        jp.setBackground(Color.blue);
        jp.setLayout(null);

        showBalance = new JTextField();
        showBalance.setBounds(0,150,650,50);
        showBalance.setBackground(Color.BLACK);
        showBalance.setForeground(Color.WHITE);
        showBalance.setFont(new Font(null, Font.BOLD, 18));
        showBalance.setText("\t\tBalance = "+AtmDiposite.acbalance);
        jp.add(showBalance);

        btnHistory = new JButton("SHOW HISTORY");
        btnHistory.setBounds(510,202,130,38);
        btnHistory.setFont(new Font(null, Font.BOLD, 12));
        btnHistory.addActionListener(this);
        jp.add(btnHistory);

        historyArea = new JTextArea();
        historyArea.setBounds(0, 240, 650, 260);
        historyArea.setFont(new Font(null, Font.BOLD, 15));
        historyArea.setOpaque(false);
        historyArea.setForeground(Color.WHITE);
        historyArea.setText(null);
        historyArea.setEditable(false);

        jp.add(historyArea);


        


        sbi=new JLabel();                   //STATE BANK OF INDIA
        sbi.setBounds(160, 60, 400, 40);
        sbi.setText("STATE BANK OF INDIA");
        sbi.setForeground(Color.YELLOW);
        sbi.setFont(new Font("null",Font.BOLD,30));
        jp.add(sbi);
        eql =new JLabel();
        eql.setBounds(140, 90, 400, 40);
        eql.setForeground(Color.yellow);
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
        atm.setForeground(Color.yellow);
        atm.setFont(new Font("null",Font.CENTER_BASELINE,33));
        jp.add(atm);

        transactionforms =new JLabel();
        transactionforms.setText("ID      TYPE      AMOUNT      BALANCE      STATUS");
        transactionforms.setFont(new Font(null, Font.BOLD, 20));
        transactionforms.setForeground(Color.black);
        transactionforms.setBounds(10, 202,500, 30);
        jp.add(transactionforms);

        homepng = new JButton();
        homepng.setIcon(new ImageIcon("homecopy.png"));
        homepng.setBounds(0, 50, 100, 100);
        Dimension siz = photo.getPreferredSize();
        homepng.addActionListener(this);
        jp.add(homepng);

        transactiontxt = new JLabel();
        transactiontxt.setBounds(180, 110, 400, 50);
        transactiontxt.setText("TRANSACTION  HISTORY");
        transactiontxt.setForeground(Color.green);
        transactiontxt.setFont(new Font("null",Font.BOLD,25));
        jp.add(transactiontxt);

        return jp;
    }

    public void actionPerformed(ActionEvent ae)
    {
      try
      {
        if(ae.getSource()==homepng)
        {
          display.setVisible(false);
          new AtmThankyou();
        }

        if(ae.getSource()==btnHistory)
        {
          btnHistory.setVisible(false);
          Iterator ot = historylist.iterator();
          while(ot.hasNext())
          {
            ArrayList a = (ArrayList) ot.next();
            Iterator it = a.iterator();
            while(it.hasNext())
            {
              String data = it.next().toString();
              if(data.equals("Succuess") || data.equals("Failed"))
              {
                  historyArea.setText(historyArea.getText().concat(data+"\n------------------------------------------------------------------------------------------------------------------------------"));
              }
              else
              {
              historyArea.setText(historyArea.getText().concat(data+"\t"));
              }
            }
          }
        
          //historyArea.setText(""+historylist);
        }
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(display,"WRONG INPUT :","HELP",JOptionPane.WARNING_MESSAGE);
      }
    }
  public static void main(String[] args) 
  {
    new AtmHistory();  
  }

  public static void setHistory(int transactionID, String transType, double transAmount, double balance, String transStatus)
  {
    //historyArea.setText("hii");
    ArrayList list = new ArrayList();
    list.add(transactionID);
    list.add(transType);
    list.add(transAmount);
    list.add(balance);
    list.add(transStatus);
    historylist.add(list);
    System.out.println(historylist);

    
    //System.out.println(list);
  }
}
