import java.awt.*; 
import javax.swing.*; 
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.*;
import java.io.*; 
import java.time.LocalDate;
import java.text.DecimalFormat;

class ATMGUI extends JFrame implements ActionListener
{
   JLabel labelA, title, labelB, labels, output, openLabel, Label, Confirm; 
   JTextField firstIn, secondIn, openDepo, input;
   JButton login, openAcc, openOK, bBalanceInquiry, bDeposit, bWithdraw, bCloseAccount, bClose, bBackMenu, bOut, depositOK, withdrawOK, NO;
   JPanel p1, p2, p3, p4, p5, p6, p7, closeP, menuP;
   Container con = getContentPane();
   File accounts;
   String accountNumber, password;
   boolean isOpen = false;
   
   /**
    ===============================GUI==============================

    */
   public ATMGUI(){
      super("Armelia's Bank (BANKoo)");
      labelA = new JLabel("Account: "); labelB = new JLabel("Password: ");
      title = new JLabel("BANKoo");
      title.setForeground(new Color(0x0000ff));
      title.setFont(new Font("IMPACT",Font.ITALIC,80));
      title.setHorizontalAlignment(JLabel.CENTER);
      firstIn = new JTextField(10);
      secondIn = new JTextField(10);
      login = new JButton("Login");
      login.setFont(new Font("IMPACT",Font.PLAIN,18));
      login.addActionListener(this);
      login.setPreferredSize(new Dimension(100, 100));
      openAcc = new JButton("Open Account");
      openAcc.addActionListener(this);
      openAcc.setFont(new Font("IMPACT",Font.PLAIN,18));
      //===============PANEL 1 ==================
         p1 = new JPanel();
         p1.setLayout(new GridLayout(1,1,25,25));
         p1.add(title);
         p1.setVisible(true);
      //===============PANEL 2 ==================
         p2 = new JPanel(); 
         p2.setLayout(new GridLayout(2,2));
         p2.add(labelA);
         p2.add(firstIn);
         p2.add(labelB);
         p2.add(secondIn);
         p2.setVisible(true);
      //===============PANEL 3 ==================
         p3 = new JPanel();
         p3.setLayout(new GridLayout(3, 2));
         login.setPreferredSize(new Dimension(1,1));
         p3.add(login);
         p3.add(openAcc);
         p3.setVisible(true);
      //===============PANEL 4 ==================
         p4 = new JPanel();
         p4.setLayout(new GridLayout(3,2));
         openLabel = new JLabel("Enter deposit amount: ");
         openLabel.setFont(new Font("IMPACT",Font.PLAIN,50));
         openDepo = new JTextField(10);
         p4.add(openLabel);
         p4.add(openDepo);
         p4.setVisible(false);
      //===============PANEL 5 ==================
         p5 = new JPanel();
         p5.setLayout(new GridLayout(1,1));
         openOK = new JButton("OK");
         openOK.addActionListener(this);
         openOK.setFont(new Font("IMPACT",Font.PLAIN,20));
         p5.add(openOK);
         p5.setVisible(false);
      //===============PANEL 6 ==================
         p6 = new JPanel();
         p6.setLayout(new GridLayout(3,2));
         bBalanceInquiry = new JButton("Balance Inquiry");
         bBalanceInquiry.addActionListener(this);
         bBalanceInquiry.setFont(new Font("IMPACT",Font.PLAIN,20));
         bDeposit = new JButton("Deposit");
         bDeposit.addActionListener(this);
         bDeposit.setFont(new Font("IMPACT",Font.PLAIN,20));
         bWithdraw = new JButton("Withdraw");
         bWithdraw.addActionListener(this);
         bWithdraw.setFont(new Font("IMPACT",Font.PLAIN,20));
         bCloseAccount = new JButton("Close Account");
         bCloseAccount.addActionListener(this);
         bCloseAccount.setFont(new Font("IMPACT",Font.PLAIN,20));
         p6.add(bBalanceInquiry);
         p6.add(bDeposit);
         p6.add(bWithdraw);
         p6.add(bCloseAccount);
         p6.setVisible(false);
      //===============PANEL 7 ==================
         p7 = new JPanel();
         p7.setLayout(new GridLayout(2,1));
         p7.setVisible(false);
         depositOK = new JButton("OK");
         depositOK.addActionListener(this);
         depositOK.setFont(new Font("IMPACT",Font.PLAIN,20));
         withdrawOK = new JButton("OK");
         withdrawOK.addActionListener(this);
         withdrawOK.setFont(new Font("IMPACT",Font.PLAIN,20));
         Label = new JLabel("Enter Deposit Amount");
         Label.setFont(new Font("IMPACT",Font.PLAIN,20));
         Confirm = new JLabel("Click OK to confirm");
         input = new JTextField(10);
         Confirm.setFont(new Font("IMPACT",Font.PLAIN,20));
         p7.add(Label);
         p7.add(input);
         p7.add(Confirm);
         p7.add(depositOK);
         NO = new JButton("No");
     //=================================
         NO.addActionListener(this);
         JLabel sel = new JLabel("");
         JLabel sol = new JLabel("");
         closeP = new JPanel();
         closeP.setLayout(new GridLayout(2,2));
         bClose = new JButton("Close"); 
         bClose.addActionListener(this);
         bClose.setFont(new Font("IMPACT",Font.PLAIN,16));
         bBackMenu = new JButton("Back"); 
         bBackMenu.addActionListener(this);
         bBackMenu.setFont(new Font("IMPACT",Font.PLAIN,16));
         bOut = new JButton("Exit"); 
         bOut.addActionListener(this);
         bOut.setFont(new Font("IMPACT",Font.PLAIN,16));
         closeP.add(sel);closeP.add(sol);
         closeP.add(bBackMenu);
         closeP.add(bOut);
         closeP.setVisible(false);
         con.add(p1, BorderLayout.NORTH);
         con.add(p2, BorderLayout.CENTER);
         con.add(p3, BorderLayout.SOUTH);
              
      setSize(600, 300);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false); setVisible(true);
    }
    //-----------------------------------------------------
      public void	actionPerformed(ActionEvent e)   {
      ATM atm = new ATM();
         
   //------------------------------------------------------
      if(e.getSource()==bBackMenu)
      {
         con.removeAll();
         repaint();
         con.add(p1,BorderLayout.NORTH);
         con.add(p6,BorderLayout.CENTER);
         p1.setVisible(true);
         p6.setVisible(true); 
         repaint(); 
      }
      if(e.getSource()==bOut)
      {
        con.removeAll();
        repaint();
  
        con.add(p1, BorderLayout.NORTH); 
        con.add(p2, BorderLayout.CENTER);
        con.add(p3, BorderLayout.SOUTH); 
        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        repaint(); 
      }
      if(e.getSource()==bCloseAccount)
      {
        con.removeAll();
        p7.remove(depositOK); 
        p7.remove(Confirm);
        con.add(p7,BorderLayout.CENTER);
        p7.setVisible(true);
        repaint();
        input.setEditable(false);
        repaint();
         if(atm.closeAccount(accountNumber,input,accounts)){
         con.removeAll();
         p7.remove(Confirm);
         closeP.remove(bBackMenu);
         input.setText("Account closed!");
         con.add(p7, BorderLayout.CENTER);
         p7.remove(depositOK);
         con.add(closeP, BorderLayout.SOUTH);
         p7.setVisible(true);
         closeP.setVisible(true);
         repaint();
         }
         else
         {
            con.removeAll();
            p7.remove(Confirm);
            repaint();
            con.add(p7, BorderLayout.CENTER);
            con.add(closeP, BorderLayout.SOUTH);
            p7.setVisible(true);
            closeP.setVisible(true);
            repaint();
         }
      }
      if(e.getSource()==bBalanceInquiry)
      {
         con.removeAll();
         repaint();
         con.add(p7,BorderLayout.CENTER);
         p7.remove(depositOK); 
         p7.remove(Confirm);
         Label.setText("Remaining balance");
         input.setEditable(false);
         p7.setVisible(true);
         atm.balanceInquiry(input, firstIn);
         con.add(closeP, BorderLayout.SOUTH);
         closeP.setVisible(true);
         repaint();
      }
      if(e.getSource() == depositOK)
      {
         double temp = 0;
      try
      {
         temp = Double.parseDouble(input.getText());
      }
      catch (Exception ea) 
      { 
           input.setText("INCORRECT INPUT!");
      } 
      if(atm.deposit(accountNumber, input, accounts) == true){
        p7.remove(depositOK);
        repaint();
        input.setText("Deposit successful!");
        con.add(p7, BorderLayout.CENTER);
        con.add(closeP, BorderLayout.SOUTH);
        p7.setVisible(true);
        closeP.setVisible(true);
        repaint(); 
         }
      }
      if(e.getSource() == bDeposit){
         con.removeAll();
         p7.removeAll();
         repaint();
         p7.add(Label);
         p7.add(input);
         input.setText("");
         input.setEditable(true);
         repaint();
         p7.add(Confirm);
         p7.add(depositOK);
         p7.setVisible(true);
         con.add(p7,BorderLayout.CENTER);
         Label.setText("Enter deposit amount");
         Confirm.setText("Click OK to confirm deposit");
         Confirm.setFont(new Font("IMPACT",Font.PLAIN,20));
         p7.setVisible(true);
         con.add(closeP, BorderLayout.SOUTH);
         closeP.setVisible(true);
         repaint();
      }
      if(e.getSource()==bWithdraw){
          con.removeAll();
          p7.removeAll();
          repaint();
          p7.add(Label);
          p7.add(input);
          input.setText("");
          input.setEditable(true);
          p7.add(Confirm);
          p7.add(withdrawOK);
          repaint();
          con.add(p7,BorderLayout.CENTER);
          p7.setVisible(true);
          Label.setText("Enter withdrawal amount");
          Confirm.setText("Click OK to confirm withdrawal");
          Confirm.setFont(new Font("IMPACT",Font.PLAIN,20));
          con.add(closeP, BorderLayout.SOUTH);
          closeP.setVisible(true);
          repaint();
      }
      if(e.getSource()==withdrawOK)
      {
         double temp = 0;
      try
      {
         temp = Double.parseDouble(input.getText());
      }
      catch (Exception ea) 
      { 
           input.setText("INCORRECT INPUT!");
      } 
         if(atm.withdraw(accountNumber, input, accounts) == true)
         {
            p7.remove(withdrawOK);
            repaint();
            input.setText("Withdrawal successful!");
            con.add(p7, BorderLayout.CENTER);
            con.add(closeP, BorderLayout.SOUTH);
            p7.setVisible(true);
            closeP.setVisible(true);
            repaint();
         }
      }

      if(e.getSource() == login){
        accountNumber = firstIn.getText();
        password = secondIn.getText();
        String fName = "AC" + accountNumber + ".txt";
        File accounts = new File(fName);
         if (atm.Login(firstIn,secondIn,accounts)) 
         {
            con.removeAll();
            repaint();
            con.add(p1,BorderLayout.NORTH);
            p1.setVisible(true);
            con.add(p6,BorderLayout.CENTER);
            p6.setVisible(true);
            repaint();
         }  
      }
      if(e.getSource() == openOK)
      {
         double temp = 0;
      try
      { 
         temp = Double.parseDouble(openDepo.getText());
      }
      catch (Exception ea) 
      { 
         openDepo.setText("INCORRECT INPUT!");
      } 
        if(atm.openAccount(accountNumber,temp,accounts) == true)
        {
            con.remove(p4);
            con.remove(p5);
            repaint();
            con.add(p1,BorderLayout.NORTH);
            p1.setVisible(true);
            con.add(p6,BorderLayout.CENTER);
            p6.setVisible(true);
            repaint();
        }
      }
      
      if(e.getSource() == openAcc)
      {
         accountNumber = firstIn.getText();
         password = secondIn.getText();
         String fName = "AC" + accountNumber + ".txt";
         try {
            File accounts = new File(fName);
            if (accounts.createNewFile() && password.equals("1234")) 
            {
               con.removeAll();
               repaint();
               con.add(p4, BorderLayout.CENTER); 
               p4.setVisible(true);
               con.add(p5, BorderLayout.SOUTH);
               p5.setVisible(true);
                  if(!(password.equals("1234")))
                  {
                     secondIn.setText("PASSWORD INCORRECT");
                  }
            } 
      else 
      {
        firstIn.setText("ACCOUNT ALREADY EXISTS");
         if(!(password.equals("1234")))
         {
         secondIn.setText("PASSWORD INCORRECT");
         }
      }
    } 
    catch (IOException ae) {
      System.out.println("An error occurred.");
      ae.printStackTrace();
    }
            repaint();
         } 
      } 
   }
 
class ATM{
//-------------------------
   public boolean openAccount(String accountNumber, double temp, File accounts){
   String fName = "AC" + accountNumber + ".txt";
   
   accounts = new File(fName);
      FileWriter f2;
      LocalDate date = LocalDate.now();
      DecimalFormat f = new DecimalFormat("#.00"); 
   try 
   {
      f2 = new FileWriter(accounts,true);
      f2.write(date + "\t" + "OpenAccount" + "?" + f.format(temp) + "\t");
      f2.close(); f2 = null;
   } 
   catch (IOException e) 
   {
        e.printStackTrace();
   }
   return true;
   }
   public boolean Login(JTextField firstIn, JTextField secondIn, File accounts){
      
         boolean isLogin = false;
         String output = "";
         String temp = "";
         String f = "AC"+firstIn.getText() +".txt";
         try   
         {
         BufferedReader b = new BufferedReader(new FileReader(f));
         String line = null;   
         while((line = b.readLine()) != null) 
         {
            String tmp[] = line.split("\t");
            temp = tmp[tmp.length-1];
         }
         b.close(); b = null;
      }
      catch(IOException ae)  
      {
         ae.printStackTrace();
      }
       output = temp;
       if(output.equals("Closed Account"))
       {
         firstIn.setText("Account is already closed");
       }
      else
      {
         String password = secondIn.getText();
      if (accounts.exists()==true && password.equals("1234")) 
      {
         if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
      }
         isLogin = true;
      } 
      else 
      {
        if(!(accounts.exists()))
        {
        firstIn.setText("ACCOUNT DOESN'T EXIST");
        }
        if(!(password.equals("1234")))
        {
         secondIn.setText("PASSWORD INCORRECT");
        }
      }
   }
   return isLogin;
   }
   //----------------------
   public void balanceInquiry(JTextField input, JTextField firstIn ){
      String temp="";
      String f = "AC"+firstIn.getText() +".txt";
      String output="";
      String last = "";
      int num = 0;
         
      try   
      {
         BufferedReader b = new BufferedReader(new FileReader(f));
         String line = null;   
         while((line = b.readLine()) != null) {
            String tmp[] = line.split("\t");
            temp = tmp[tmp.length-1];
         }
         b.close(); b = null;
      } 
      catch(IOException ae)  
      {
         ae.printStackTrace();
      }
      output = temp;
      num = output.lastIndexOf("?");
      last = output.substring(num+1, output.length());
      if(last.length()==0)
      {
         last = "0.00";
      }
      if(last.length()!=0)
      {
         if(Double.parseDouble(last)==0)
         {
            last = "0.00";
         } 
      }
      input.setText("P "+last);
   }
   public boolean deposit(String accountNumber, JTextField input, File accounts){
      boolean isDeposit = false;
      String fName = "AC" + accountNumber + ".txt";
      String file = "";
      String tempa = "";
      double Prevb =0;
      accounts = new File(fName);
      FileWriter f2;
    
   try 
   {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       FileReader f1 = new FileReader(fName); 
       int x; 
       while ((x=f1.read()) != -1) 
       file+=(char) x;   
       f1.close();  f1=null;
      if(file.length()!=0)
       {
        Prevb = 0 ;
        tempa = "";
        int y = file.lastIndexOf('?'); 
        tempa = file.substring(y+1,file.length());
        Prevb = Double.parseDouble(tempa);
      }
    } 
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
    try 
    {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       double dep = Double.parseDouble(input.getText());
       if(dep<0)
       {
        input.setText("Do not enter negative digits");
       }
      else
      {
      f2 = new FileWriter(accounts,true);
         if(Prevb==0)
         {
         f2.write(date + "\t" + "Deposit" + "?" + f.format(dep) + "\t");
         }
            else{
               f2.write(date + "\t" + "Deposit" + "?" + f.format(dep+Prevb) + "\t"); 
            }
      f2.close(); f2 = null;
      isDeposit = true;
      }
} 
   catch (IOException e) 
   {
        e.printStackTrace();
   }
    catch(NumberFormatException nfe)
    {
            input.setText("Digits only");
    } 
   return isDeposit;

}
   public boolean withdraw(String accountNumber, JTextField input, File accounts){
    boolean isWithdraw = false;
      String fName = "AC" + accountNumber + ".txt";
      String file = "";
      String tempa = "";
      double Prevb =0;
      double with = 0;
      accounts = new File(fName);
      FileWriter f2;
   try {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       FileReader f1 = new FileReader(fName); 
       int x; 
       while ((x=f1.read()) != -1) 
       file+=(char) x;   
       f1.close();  f1=null;
       if(file.length()!=0)
       {
         Prevb = 0 ;
         tempa = "";
         int y = file.lastIndexOf('?'); 
         tempa = file.substring(y+1,file.length());
         Prevb = Double.parseDouble(tempa);
       }
    } 
    catch (IOException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
    try 
    {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       with = Double.parseDouble(input.getText());
      if(with<0)
      {
        input.setText("Do not enter negative digits");
      }
      else
      {
      f2 = new FileWriter(accounts,true);
         if(Prevb< with)
         {
            input.setText("Not enough funds");
         }
      else
      {
         f2.write(date + "\t" + "Withdraw" + "?" + f.format(Prevb - with) + "\t"); 
         f2.close(); f2 = null;
         isWithdraw = true;
      }
   }
} 
      catch (IOException e) 
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    catch(NumberFormatException nfe)
    {
        input.setText("Digits only");
    } 
   return isWithdraw;
   }
   
   public boolean closeAccount(String accountNumber, JTextField input, File accounts){
      boolean isClose = false;
      String fName = "AC" + accountNumber + ".txt";
      String file = "";
      String tempa = "";
      double Prevb =0;
      accounts = new File(fName);
      FileWriter f2;
    
   try {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       FileReader f1 = new FileReader(fName); 
       int x; 
       while ((x=f1.read()) != -1) 
       file+=(char) x;   
       f1.close();  f1=null;
       if(file.length()!=0)
       {
         Prevb = 0 ;
         tempa = "";
         int y = file.lastIndexOf('?'); 
         tempa = file.substring(y+1,file.length());
         Prevb = Double.parseDouble(tempa);
       }
    } 
    catch (IOException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
    try 
    {
       LocalDate date = LocalDate.now();
       DecimalFormat f = new DecimalFormat("#.00"); 
       if(Prevb==0)
       {
         f2 = new FileWriter(accounts,true);
         f2.write(date + "\t" + "Closed Account");
         f2.close(); f2 = null;
         isClose = true;
       }
      else
      {
      input.setText("Withdraw remaining balance");
      }
} 
   catch (IOException e) 
   {
        e.printStackTrace();
   }
      return isClose;
      }
   }
   

public class Armelia{
   public static void main(String args[]){
      ATMGUI log = new ATMGUI();
      
      try{
         for(LookAndFeelInfo  info:UIManager.getInstalledLookAndFeels())
         {
            if("Nimbus".equals(info.getName()))
            {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
     }catch(Exception e){
     }
     
      SwingUtilities.invokeLater( () ->{
           new ATMGUI();  
      });
   }
}