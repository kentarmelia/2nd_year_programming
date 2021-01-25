import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class LogicGatesGUI extends JFrame implements ItemListener{
   JLabel la, lb, label,result;
   JTextField tres;
   JComboBox cbOptrs,ta,tb;
   Container c = getContentPane();
   String optrs[] = {"Buffer", "Inverter(NOT Gate)", "AND Gate", "NAND Gate", "OR Gate", "NOR Gate", "EX OR Gate", "EX NOR Gate"};
   String aoption[] = {"true", "false"};
   String boption[] = {"true", "false"};
   boolean a,b;
   String res;
  
   LogicGatesGUI(){
      super("Logic Gates");
      la = new JLabel("Enter A: ");
      la.setFont(new Font("Impact",Font.BOLD,30));
      lb = new JLabel("Enter B: ");
      lb.setFont(new Font("Impact",Font.BOLD,30));
      label = new JLabel("Select an operation ");
      label.setFont(new Font("Impact",Font.BOLD,23));
      result = new JLabel("Result ");
      result.setFont(new Font("Impact",Font.BOLD,30));
      
      
      
      ta = new JComboBox(aoption); ta.addItemListener(this);
      ta.setBackground(Color.YELLOW);
      tb = new JComboBox(boption); tb.addItemListener(this);
      tb.setBackground(Color.YELLOW);
      tres = new JTextField(10); tres.setEditable(false);
      tres.setBackground(Color.PINK);
      cbOptrs = new JComboBox(optrs); cbOptrs.addItemListener(this);
      
      c.setLayout(new GridLayout(4, 2));
      c.add(label);
      c.add(cbOptrs);
      c.add(la); c.add(ta);
      c.add(lb); c.add(tb);
      c.add(result);
      c.add(tres);
      c.setBackground(Color.GREEN);
     
      setSize(450, 300);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      }

      public void	itemStateChanged(ItemEvent ie){
      LogicGates lg = new LogicGates();

      a = (ta.getSelectedIndex()==0)?true:false;   
      b = (tb.getSelectedIndex()==0)?true:false;
         
      if(cbOptrs.getSelectedIndex()==0 || cbOptrs.getSelectedIndex()==1){
         tb.setEnabled(false);

         if(cbOptrs.getSelectedIndex()==0){
            res = lg.buffer(a)+"";
         }
         else if(cbOptrs.getSelectedIndex()==1){
            res = lg.inverter(a)+"";
         }
        }
      else{
         tb.setEnabled(true);
        if(cbOptrs.getSelectedIndex()==2){
         res = lg.twoAND(a,b)+"";
        }
      else if(cbOptrs.getSelectedIndex()==3){
         res = lg.twoNAND(a,b)+"";
      }
      else if(cbOptrs.getSelectedIndex()==4){
         res = lg.twoOR(a,b)+"";
      }
      else if(cbOptrs.getSelectedIndex()==5){
         res = lg.twoNOR(a,b)+"";
      }
      else if(cbOptrs.getSelectedIndex()==6){
         res = lg.twoEXOR(a,b)+"";
      }
      else if(cbOptrs.getSelectedIndex()==7){
         res = lg.twoEXNOR(a,b)+"";
      }
       }
       tres.setText(res+"");
       repaint();   
      }
   }
 
class LogicGates{
   public boolean buffer(boolean a){
      return (a == false)?false:true; 
   }
   public boolean inverter(boolean a){
      return (a == false)?true:false;
   }
   public boolean twoAND(boolean a, boolean b){
      return (a == true && b == true)?true:false;     
   }
   public boolean twoNAND(boolean a, boolean b){ 
      return (a == true && b == true)?false:true;     
   }
   public boolean twoOR(boolean a, boolean b){ 
      return (a == false && b == false)?false:true;
   }
    public boolean twoNOR(boolean a, boolean b){
      return (a == false && b == false)?true:false; 
   }
    public boolean twoEXOR(boolean a, boolean b){
      return ((a == false && b == false) || (a == true && b == true))?false:true;  
   }
     public boolean twoEXNOR(boolean a, boolean b){
      return ((a == false && b == false) || (a == true && b == true))?true:false;
   }
 
}
public class LogicGatesDemo{
   public static void main(String args[]){
      LogicGatesGUI LG = new LogicGatesGUI();
   }
}