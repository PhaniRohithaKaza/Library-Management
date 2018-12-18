import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Booksearch extends Frame implements ActionListener
{
Label l1,l2,l3;
TextField t1;
Button b1;
RandomAccessFile r;
public Booksearch()
{
try
{
setBackground(Color.green);
setLayout(null);
r=new RandomAccessFile("Bookp.txt","rw");
l1=new Label("Bookid");
l2=new Label("Book is available!!");
l3=new Label("Sorry!Book is not available");
t1=new TextField(20);
b1=new Button("Search");
l1.setBounds(100,50,90,20);
t1.setBounds(210,50,90,20);
b1.setBounds(140,80,50,20);
l2.setBounds(130,120,200,20);
l3.setBounds(130,120,200,20);
add(l1);
add(t1);
add(b1);
add(l2);
add(l3);
b1.addActionListener(this);
l2.setVisible(false);
l3.setVisible(false);
this.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
setVisible(false);
}
});
}
catch(Exception ex)
{
}
}
public void actionPerformed(ActionEvent e)
{
try
{
if(e.getSource()==b1)
{
String s;
while((s=r.readUTF())!=null)
{
StringTokenizer str=new StringTokenizer(s,"|");
String s1=str.nextToken();
if(s1.equals(t1.getText()))
{
String s2=str.nextToken();
if(s2.equals("0"))
{
l2.setVisible(true);
break;
}
}
else
{
l3.setVisible(true);
break;
}
}
}
}
catch(Exception ee)
{
}
}
}