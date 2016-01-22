import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class SlidingPuzzle implements ActionListener
{
 JFrame f;
 JButton b[][]=new JButton[3][3];
 JButton b1;
 JLabel l;
  int arr[];
public SlidingPuzzle(String x)
 {
	// int arr[]=new int[9];
      // int k=0,flag,rand,n1,n2;
 f=new JFrame(x);
 for(int i=0;i<3;i++)
 {
 for(int j=0;j<3;j++)
 {
	 b[i][j]=new JButton();
	 b[i][j].setBounds(80+100*j,30+100*i,100,100);
	 b[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
     f.add(b[i][j]);
	 b[i][j].addActionListener(this);
 }
 }

 b1=new JButton("refresh");
 b1.addActionListener(this);
 b1.setBounds(160,360,100,50);
 l=new JLabel();
 l.setFont(new Font("Arial", Font.PLAIN, 60));
 l.setBounds(100,420,350,70);
 l.setOpaque(true);
 f.add(l);
 f.add(b1);
 f.setSize(500,700);
 f.setLayout(null);
     l.setText(" ");
	 f.setVisible(true);
	 
	 try{
		
	      this.make();
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }
 
 //MAKE FUNCTION
    public void make()
 {
	arr=new int[8];
       int k=0,flag,rand,n1,n2;
	   int par,inversions=0,count=0;
       Random r=new Random();
       
       n1=r.nextInt(3);
       n2=r.nextInt(3);
if(n1<0)
	n1*=-1;
if(n2<0)
	n2*=-1;
System.out.println("--"+n1+"  "+n2);
 for(int i=0;i<3;i++)
 {
 for(int j=0;j<3;j++)
 {
	 if(i==n1&&j==n2)
	 {
		b[n1][n2].setText(" ");
         continue;		
	 }
	 flag=0;
 rand=r.nextInt(9);
 
 if(rand<0)
	 rand=rand*-1;
 else if(rand==0)
	  rand=rand+1;
  
 
 if(i==0&&j==0)
	 arr[k]=rand;
 else
 {
	 for(int l=0;l<k;l++)
	 {
		 if(arr[l]==rand)
		 {
			 flag=1;
			 //j=j-1;
			 break;
		 }
	 }
	 if(flag==1)
	 {
		 j--;
		 continue;
	 }
	 arr[k]=rand;
 }
     k++;
	 
 //b[i][j].setText(Integer.toString(rand));
 }
 }
 
 //logic for inversions
 for(int u=0;u<k;u++)
 {
	 count=0;
	 for(int v=u+1;v<k;v++)
	 {
		 if(arr[v]>arr[u])
			 count++;
	 }
	 inversions+=count;
 }
 if(inversions%2==0)//solvable
 {
	 par=0;
 for(int i=0;i<3;i++)
 {
 for(int j=0;j<3;j++)
 {
	 if(i==n1&&j==n2)
	 {
		b[n1][n2].setText(" ");
		//par++;
         continue;		
	 }
	 else
	 {
		 b[i][j].setText(Integer.toString(arr[par]));
		 par++;
	 }
 }
 }
 }
 else
 {
	 try{
		
	  this.make();
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }
 
 for(int d=0;d<k;d++)
	 System.out.println(arr[d]);


 
 if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
 //f.setVisible(true);
 f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
 
 }
 public void actionPerformed(ActionEvent e)
 {
	 if(e.getSource()==b1)
	 {
		make();
  
}  
	 if(e.getSource()==b[0][0])
	 {
		 l.setText(" ");
		 if(b[0][1].getText()==" ")
		 {
			 b[0][1].setText(b[0][0].getText());
			 b[0][0].setText(" ");
		 }
		 if(b[1][0].getText()==" ")
		 {
			 b[1][0].setText(b[0][0].getText());
			 b[0][0].setText(" ");
		 }
		if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
	 }
	 if(e.getSource()==b[0][1])
	 {
		 l.setText(" ");
		 if(b[0][0].getText()==" ")
		 {
			 b[0][0].setText(b[0][1].getText());
			 b[0][1].setText(" ");
		 }
		 if(b[0][2].getText()==" ")
		 {
			 b[0][2].setText(b[0][1].getText());
			 b[0][1].setText(" ");
		 }
		 if(b[1][1].getText()==" ")
		 {
			 b[1][1].setText(b[0][1].getText());
			 b[0][1].setText(" ");
		 }
		if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
			  
		  //check();
	 }
	 if(e.getSource()==b[0][2])
	 {
		 l.setText(" ");
		 if(b[0][1].getText()==" ")
		 {
			 b[0][1].setText(b[0][2].getText());
			 b[0][2].setText(" ");
		 }
		 if(b[1][2].getText()==" ")
		 {
			 b[1][2].setText(b[0][2].getText());
			 b[0][2].setText(" ");
		 }
		 if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
		  
	 }
	 if(e.getSource()==b[1][0])
	 {
		 l.setText(" ");
		 if(b[0][0].getText()==" ")
		 {
			 b[0][0].setText(b[1][0].getText());
			 b[1][0].setText(" ");
		 }
		 if(b[1][1].getText()==" ")
		 {
			 b[1][1].setText(b[1][0].getText());
			 b[1][0].setText(" ");
		 }
		 if(b[2][0].getText()==" ")
		 {
			 b[2][0].setText(b[1][0].getText());
			 b[1][0].setText(" ");
		 }
		if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
		  
	 }
	 if(e.getSource()==b[1][1])
	 {
		 l.setText(" ");
		 if(b[0][1].getText()==" ")
		 {
			 b[0][1].setText(b[1][1].getText());
			 b[1][1].setText(" ");
		 }
		 if(b[1][0].getText()==" ")
		 {
			 b[1][0].setText(b[1][1].getText());
			 b[1][1].setText(" ");
		 }
		 if(b[1][2].getText()==" ")
		 {
			 b[1][2].setText(b[1][1].getText());
			 b[1][1].setText(" ");
		 }
		 if(b[2][1].getText()==" ")
		 {
			 b[2][1].setText(b[1][1].getText());
			 b[1][1].setText(" ");
		 }
		if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
	 }
	 if(e.getSource()==b[1][2])
	 {
		 l.setText(" ");
		 if(b[0][2].getText()==" ")
		 {
			 b[0][2].setText(b[1][2].getText());
			 b[1][2].setText(" ");
		 }
		 if(b[1][1].getText()==" ")
		 {
			 b[1][1].setText(b[1][2].getText());
			 b[1][2].setText(" ");
		 }
		 if(b[2][2].getText()==" ")
		 {
			 b[2][2].setText(b[1][2].getText());
			 b[1][2].setText(" ");
		 }
		  if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
	 }
	 if(e.getSource()==b[2][0])
	 {
		 l.setText(" ");
		 if(b[1][0].getText()==" ")
		 {
			 b[1][0].setText(b[2][0].getText());
			 b[2][0].setText(" ");
		 }
		 if(b[2][1].getText()==" ")
		 {
			 b[2][1].setText(b[2][0].getText());
			 b[2][0].setText(" ");
		 }
		 if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
		 
	 }
	 if(e.getSource()==b[2][1])
	 {
		 l.setText(" ");
		 if(b[2][0].getText()==" ")
		 {
			 b[2][0].setText(b[2][1].getText());
			 b[2][1].setText(" ");
		 }
		 if(b[1][1].getText()==" ")
		 {
			 b[1][1].setText(b[2][1].getText());
			 b[2][1].setText(" ");
		 }
		 if(b[2][2].getText()==" ")
		 {
			 b[2][2].setText(b[2][1].getText());
			 b[2][1].setText(" ");
		 }
		  if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  }
		  
	 }
	 if(e.getSource()==b[2][2])
	 {
		 l.setText(" ");
		 if(b[1][2].getText()==" ")
		 {
			 b[1][2].setText(b[2][2].getText());
			 b[2][2].setText(" ");
		 }
		 if(b[2][1].getText()==" ")
		 {
			 b[2][1].setText(b[2][2].getText());
			 b[2][2].setText(" ");
		 }
		 if(b[0][0].getText().equals("1") && b[0][1].getText().equals("2") && b[0][2].getText().equals("3")
			&& b[1][0].getText().equals("4") && b[1][1].getText().equals("5") &&
		  b[1][2].getText().equals("6") && b[2][0].getText().equals("7") && b[2][1].getText().equals("8"))
		  {
			   b[2][2].setText("9");
		       l.setText("YOU WON");
		  } 
	 }
 }
public static void main(String s[])
{
new SlidingPuzzle("Number Puzzle");
}
}
