//GUI-Graphical User Interface
//console programming vs. windowed programmimg
import java.awt.*;//older or deprecated version, heavyweight
import javax.swing.*;//newer but still deprecated, lightweight
import java.awt.event.*;
/*
3 Parts of a GUI Application
   1. Building the GUI Components
   2. Providing Listener Methods
   3. Developing Application Methods
*/

class SimpleCalc extends JFrame implements ActionListener
{
   JLabel lnum1, lnum2, lres;
   JTextField tnum1, tnum2, tres;
   JButton bAdd, bMinus, bTimes, bDiv;
   Container c = getContentPane();
   double num1, num2, res;
   JPanel p1, p2;
   
   //constructor serves as 1.Building the GUI Components
   SimpleCalc()
   {
      super("Simple Calculator v1.0");
      lnum1 = new JLabel("Input 1st number: ");
      lnum2 = new JLabel("Input 2nd number: ");
      lres = new JLabel("Result: ");
      
      tnum1 = new JTextField(10);
      tnum2 = new JTextField(10);
      tres = new JTextField(10); tres.setEditable(false);
      
      bAdd = new JButton("+"); bAdd.addActionListener(this);//register a listener to a click event
      bMinus = new JButton("-"); bMinus.addActionListener(this);
      bTimes = new JButton("*"); bTimes.addActionListener(this);
      bDiv = new JButton("/"); bDiv.addActionListener(this);
      
      p1 = new JPanel();
      p1.setLayout(new GridLayout(3, 2));
      p1.add(lnum1); p1.add(tnum1);
      p1.add(lnum2); p1.add(tnum2);
      p1.add(lres); p1.add(tres);
      
      p2 = new JPanel();
      p2.setLayout(new GridLayout(1,4));
      p2.add(bAdd); p2.add(bMinus); p2.add(bTimes); p2.add(bDiv);
      
      c.setLayout(new BorderLayout());
      c.add(p1, BorderLayout.CENTER);
      c.add(p2, BorderLayout.SOUTH);
      
      setSize(500, 400);//to set the size of the frame
      setDefaultCloseOperation(EXIT_ON_CLOSE);//to use the x button to stop the program from running
      setResizable(false);
      setVisible(true);
   }

   //2. Provide a Listener Method
   public void actionPerformed(ActionEvent ae)
   {
      try
      {
         num1 = Double.parseDouble(tnum1.getText());
         num2 = Double.parseDouble(tnum2.getText());
      
      if(ae.getSource()==bAdd)
         res = add();
      else if(ae.getSource()==bMinus)
         res = subtract();
      else if(ae.getSource()==bTimes)
         res = multiply();
      else if(ae.getSource()==bDiv)
         res = divide();
      tres.setText(res+"");   
      }
      catch(NumberFormatException nfe){
         tres.setText("Invalid input!");
      }   
   }
   
   //3. Develop Application Method(s)
   public double add(){
      return num1 + num2;
   }
   public double subtract(){
      return num1 - num2;
   }
   public double multiply(){
      return num1 * num2;
   }
   public double divide(){
      return num1 / num2;
   }


   
}

//---------------------------
public class SimpleCalcTest
{
   public static void main(String args[])
   {
      new SimpleCalc();
   }
}