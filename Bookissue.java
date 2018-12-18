import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Bookissue extends Frame implements ActionListener
{
public long fp[]=new long[10];
int i=0;
Label l1,l2,l3,l4;
TextField t1;
Button b1;
Calendar c;
RandomAccessFile r3,r4;
Bookissue()
{
try
{
setLayout(null);
 c=Calendar.getInstance();
r3=new RandomAccessFile("Bookp.txt","rw");
r4=new RandomAccessFile("Transactionp.txt","rw");
l1=new Label("Bookid");
l2=new Label("Book is Available!Issued!!");
l3=new Label("Sorry!Book can't be issued");
l4=new Label("There is no Book with that Id");
t1=new TextField(20);
b1=new Button("Issue");
l1.setBounds(100,50,90,20);
t1.setBounds(210,50,90,20);
b1.setBounds(140,80,60,20);
l2.setBounds(130,120,200,20);
l3.setBounds(130,120,200,20);
setBackground(Color.yellow);
add(l1);
add(t1);
add(b1);
add(l2);
add(l3);
b1.addActionListener(this);
l2.setVisible(false);
l3.setVisible(false);
l4.setVisible(false);

addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
setVisible(false);
}
});
}
catch(Exception e)
{
System.out.println(e);
}
}
public void actionPerformed(ActionEvent ex)
{
try
{
if(ex.getSource()==b1)
{
String s;
int t=0;
i=1;
fp[0]=0;
Random ran=new Random();
while((s=r3.readUTF())!=null)
{
fp[i]=r3.getFilePointer();
StringTokenizer str=new StringTokenizer(s,"|");
String s1=str.nextToken();
if(s1.equals(t1.getText()))
{
String s2=str.nextToken();
if(s2.equals("0"))
{
SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy");
String d=f.format(c.getTime());
String s3=str.nextToken();
t=ran.nextInt(10);
String s5=Integer.toString(t+1);
String s4=s1+"|"+s5+"|"+d+"|";

r4.writeUTF(s4);
String s6=s1+"|"+"1"+"|"+s3+"|";
r3.seek(fp[i-1]);
r3.writeUTF(s6);
l2.setVisible(true);
break;
}
if(s2.equals("1"))
{
l3.setVisible(true);
break;
}
}
else
l4.setVisible(true);
i++;
}
}
}
catch(Exception w)
{
System.out.println(w);
}
}
}