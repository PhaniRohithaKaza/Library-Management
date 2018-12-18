import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
class Bookadd extends Frame implements ActionListener
{
Label l1,l2,l3;
TextField t1,t2;
Button b1;
Bookadd()
{
setLayout(null);
setBackground(Color.gray);
l1=new Label("BookId");
l2=new Label("Book Name");
l3=new Label("Successfully Added");
l3.setVisible(false);
t1=new TextField(10);
t2=new TextField(10);
b1=new Button("Add");
l1.setBounds(100,50,90,20);
t1.setBounds(210,50,90,20);
l2.setBounds(100,80,90,20);
t2.setBounds(210,80,90,20);
b1.setBounds(155,110,50,20);
l3.setBounds(140,140,200,20);
add(l1);
add(t1);
add(l2);
add(t2);
add(b1);
add(l3);
b1.addActionListener(this);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
setVisible(false);
}
});
}
public void actionPerformed(ActionEvent e)
{
try
{
if(b1==e.getSource())
{
RandomAccessFile raf=new RandomAccessFile("Bookp.txt","rw");
String s=t1.getText()+"|"+"0"+"|"+t2.getText()+"|";
raf.writeUTF(s);
l3.setVisible(true);
}
}
catch(Exception ex)
{
System.out.println(ex);
}
}
}