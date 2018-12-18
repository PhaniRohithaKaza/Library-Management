import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
class Membersearch extends Frame implements ActionListener
{
Label l1,l2,l3;
TextField t1;
Button b1;
 RandomAccessFile r2;
Membersearch()throws FileNotFoundException
{
try
{
setLayout(null);
setBackground(Color.blue);
 r2=new RandomAccessFile("Memberp.txt","rw");

l1=new Label("Memberid");
l2=new Label("Congratulations!You are a Member");
l3=new Label("Sorry! Not a Member");
t1=new TextField(20);
b1=new Button("Search");
l1.setBounds(70,50,90,20);
t1.setBounds(180,50,90,20);
b1.setBounds(150,80,50,20);b1.setVisible(true);
l2.setBounds(120,120,200,20);
l3.setBounds(120,120,200,20);
l1.setVisible(true);
add(l1);
add(t1);
add(b1);
add(l2);
add(l3);
b1.addActionListener(this);
l2.setVisible(false);
l3.setVisible(false);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
    setVisible(false);
}
});
}
catch(Exception ee)
{
System.out.println(ee);
}
}
public void actionPerformed(ActionEvent e)
{
try
{
if(e.getSource()==b1)
{
String s;
while((s=r2.readUTF())!=null)
{
StringTokenizer str=new StringTokenizer(s,"|");
String s1=str.nextToken();
if(s1.equals(t1.getText()))
l2.setVisible(true);
else
l3.setVisible(true);
}
}
}
catch(Exception ee)
{
}
}
}
