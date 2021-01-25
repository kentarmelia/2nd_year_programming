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

class SimpleCalc2 extends JFrame implements ItemListener
{
   JLabel lnum1, lnum2;
   JTextField tnum1, tnum2, tres;
   JComboBox cbOptrs;
   Container c = getContentPane();
   double num1, num2, res;
   String optrs[] = {"+", "-", "*", "/"};
   
   //constructor serves as 1.Building the GUI Components
   public SimpleCalc2()
   {
      super("Simple Calculator v2.0");
      lnum1 = new JLabel("Input 1st number: ");
      lnum2 = new JLabel("Input 2nd number: ");
      
      tnum1 = new JTextField(10);
      tnum2 = new JTextField(10);
      tres = new JTextField(10); tres.setEditable(false);
      
      cbOptrs = new JComboBox(optrs);
      cbOptrs.addItemListener(this);
      
      c.setLayout(new GridLayout(3, 2));
      c.add(lnum1); c.add(tnum1);
      c.add(lnum2); c.add(tnum2);
      c.add(cbOptrs); c.add(tres);
      c.setBackground(Color.BLUE);
            
      setSize(300, 200);//to set the size of the frame
      setDefaultCloseOperation(EXIT_ON_CLOSE);//to use the x button to stop the program from running
      setResizable(false);
      setVisible(true);
    }

   //2. Provide a Listener Method
      public void	itemStateChanged(ItemEvent ie)   {
      try
      {
         num1 = Double.parseDouble(tnum1.getText());
         num2 = Double.parseDouble(tnum2.getText());
      
      if(cbOptrs.getSelectedIndex()==0)
         res = add();
      else if(cbOptrs.getSelectedItem().equals("-"))
         res = subtract();
      else if(cbOptrs.getSelectedIndex()==2)
         res = multiply();
      else if(cbOptrs.getSelectedIndex()==3)
         res = divide();
      tres.setText(res+"");
      //repaint();   
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
public class SimpleCalcTest2
{
   public static void main(String args[])
   {
      SimpleCalc2 scalc = new SimpleCalc2();
   }
}