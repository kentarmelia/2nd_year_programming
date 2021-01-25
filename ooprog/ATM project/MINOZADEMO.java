import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.io.*; 
import java.time.LocalDate;



class ATMGUI extends JFrame implements ActionListener
{
   JLabel labelA, title, labelB, labels, output, openLabel, depositLabel, depositConfirm; 
   JTextField firstIn, secondIn, openDepo, inputDepo;
   JPanel p1, p2, p3, p4, p5, p6, p7;
   JButton login, openAcc, openOK, bBalanceInquiry, bDeposit, bWithdraw, bCloseAccount;
   JButton depositOK, NO;
   String accountNumber, password;
   File accounts;
   boolean isOpen = false;
   
   Container c = getContentPane();
   public ATMGUI(){
      super("BANK");
      labelA = new JLabel("Account Number: "); labelB = new JLabel("Password: ");
      title = new JLabel("BANK");
      firstIn = new JTextField(10);
      secondIn = new JTextField(10);
      login = new JButton("Login");
      login.addActionListener(this);
      openAcc = new JButton("Open Account");
      openAcc.addActionListener(this);
      //header
      p1 = new JPanel();
      p1.setLayout(new GridLayout(1, 1));
      p1.add(title);
      p1.setVisible(false);
      //start display
      p2 = new JPanel(); 
      p2.setLayout(new GridLayout(7, 1));
      p2.add(title);
      p2.add(labelA);
      p2.add(firstIn);
      p2.add(labelB);
      p2.add(secondIn);
      //start navigational
      p3 = new JPanel();
      p3.setLayout(new GridLayout(1, 2));
      p3.add(login);
      p3.add(openAcc);
      //new Account Input
      p4 = new JPanel();
      p4.setLayout(new GridLayout(7,1));
      openLabel = new JLabel("Enter deposit amount: ");
      openDepo = new JTextField(10);
      p4.add(openLabel);
      p4.add(openDepo);
      p4.setVisible(false);
      //
      p5 = new JPanel();
      p5.setLayout(new GridLayout(1,1));
      openOK = new JButton("OK");
      openOK.addActionListener(this);
      p5.add(openOK);
      p5.setVisible(false);
      //
      p6 = new JPanel();
      p6.setLayout(new GridLayout(2,2));
      bBalanceInquiry = new JButton("Balance Inquiry");
      bBalanceInquiry.addActionListener(this);
      bDeposit = new JButton("Deposit");
      bDeposit.addActionListener(this);
      bWithdraw = new JButton("Withdraw");
      bWithdraw.addActionListener(this);
      bCloseAccount = new JButton("Close Account");
      bCloseAccount.addActionListener(this);
      p6.add(bBalanceInquiry);
      p6.add(bDeposit);
      p6.add(bWithdraw);
      p6.add(bCloseAccount);
      p6.setVisible(false);
      //
      p7 = new JPanel();
      p7.setLayout(new GridLayout(4,1));
      p7.setVisible(false);
      depositOK = new JButton("OK");
      depositOK.addActionListener(this);
      depositLabel = new JLabel("Enter Deposit Amount");
      depositConfirm = new JLabel("Click OK to confirm deposit");
      inputDepo = new JTextField(10);
      p7.add(depositLabel);
      p7.add(inputDepo);
      p7.add(depositConfirm);
      p7.add(depositOK);
      NO = new JButton("No");
     //------------------
      NO.addActionListener(this);
 
      c.add(p1, BorderLayout.NORTH);
      c.add(p2, BorderLayout.CENTER);
      c.add(p3, BorderLayout.SOUTH);
           
      setSize(500, 500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false); setVisible(true);
    }
    //-----------------------------------------------------
      public void	actionPerformed(ActionEvent e)   {
      ATM atm = new ATM();
      
      //----------------------
      if(e.getSource() == depositOK){
         //accountNumber =  
         double temp = 0;
      try{
         
         temp = Double.parseDouble(inputDepo.getText());
      }
      catch (Exception ea) { 
           inputDepo.setText("INCORRECT INPUT!");
        } 
      if(atm.deposit(accountNumber, temp, accounts) == true){
         inputDepo.setText("Deposit successful!");
         }
      }
      if(e.getSource() == bDeposit){
         c.removeAll();
         c.add(p7,BorderLayout.CENTER);
         p7.setVisible(true);
         repaint(); 
      }

      if(e.getSource() == login){
        accountNumber = firstIn.getText();
        password = secondIn.getText();
         String fName = "SA" + accountNumber + ".txt";
      try {
      File accounts = new File(fName);
      if (accounts.exists() && password.equals("1234")) {
      
        c.removeAll();
         c.add(p1,BorderLayout.NORTH);
         p1.setVisible(true);
         c.add(p6,BorderLayout.CENTER);
         p6.setVisible(true);
         repaint();
         if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
        
      } else {
        firstIn.setText("ACCOUNT ALREADY EXISTS");
        if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
      }
    } catch (Exception ae) {
      System.out.println("An error occurred.");
      ae.printStackTrace();
    }
         repaint();
         
      }
      if(e.getSource() == openOK){
      double temp = 0;
      try{
         
         temp = Double.parseDouble(openDepo.getText());
      }
      catch (Exception ea) { 
           openDepo.setText("INCORRECT INPUT!");
        } 
    
        if(atm.openAccount(accountNumber,temp,accounts) == true){
         c.remove(p4);
         c.remove(p5);
         c.add(p1,BorderLayout.NORTH);
         p1.setVisible(true);
         c.add(p6,BorderLayout.CENTER);
         p6.setVisible(true);
         repaint();
        }
      }
      
      if(e.getSource() == openAcc){
         accountNumber = firstIn.getText();
         password = secondIn.getText();
         String fName = "SA" + accountNumber + ".txt";
      try {
      File accounts = new File(fName);
      if (accounts.createNewFile() && password.equals("1234")) {
      
         c.removeAll();
         c.add(p4, BorderLayout.CENTER); p4.setVisible(true);
         c.add(p5, BorderLayout.SOUTH); p5.setVisible(true);
         if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
        
      } else {
        firstIn.setText("ACCOUNT ALREADY EXISTS");
        if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
      }
    } catch (IOException ae) {
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
   String fName = "SA" + accountNumber + ".txt";
   accounts = new File(fName);
      FileWriter f2;
      LocalDate date = LocalDate.now();
   try {
      f2 = new FileWriter(accounts,true);
      f2.write(date + "\t" + "OpenAccount" + "?" + temp + "\t");
      
      f2.close();
} catch (IOException e) {
        e.printStackTrace();
}
   return true;
   
   }
   public boolean login(JTextField firstIn, JTextField secondIn, File accounts){
      
         boolean isLogin = false;
      
         String password = secondIn.getText();
      if (accounts.exists()==true && password.equals("1234")) {
         
         if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }
        isLogin = true;
        
      } else {
        firstIn.setText("ACCOUNT DOESN'T EXIST");
        
        if(!(password.equals("1234"))){
         secondIn.setText("PASSWORD INCORRECT");
        }

      }
    return isLogin;
   }
   //----------------------
   public void balanceInquiry(){
   
   }
   public boolean deposit(String accountNumber, double temp, File accounts){
      String fName = "SA" + accountNumber + ".txt";
   accounts = new File(fName);
      FileWriter f2;
      LocalDate date = LocalDate.now();
   try {
      f2 = new FileWriter(accounts,true);
      f2.write(date + "\t" + "Deposit" + "?" + temp + "\t");
      
      f2.close();
} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
   return true;
   }
   public void withdraw(){
   
   }
   public void closeAccount(){
   
   }
   }
   

public class MINOZADEMO
{
   public static void main(String []args)
   {
      ATMGUI atmgui = new ATMGUI();

   }
}