import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.*;
class Bookreturn extends Frame implements ActionListener
{
public long fp1[]=new long[10];
public long fp2[]=new long[10];
String s10;
int i=0,j=0;
Label l1,l2,l3,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d12;
TextField t1;
Button b1;
RandomAccessFile r5,r6;
Bookreturn()
{
try
{
setLayout(null);
setBackground(Color.cyan);
r5=new RandomAccessFile("Bookp.txt","rw");
r6=new RandomAccessFile("Transactionp.txt","rw");
l1=new Label("Bookid");
l2=new Label("Book is Returned!");
l3=new Label("Sorry!You need to pay Fine");
t1=new TextField(20);
b1=new Button("Return");
d1=new Label("Bookid");
d2=new Label();
d3=new Label("Transaction Id");
d4=new Label();
d5=new Label("IssueDate");
d6=new Label();
d7=new Label("ReturnDate");
d8=new Label();
d12=new Label();
d9=new Label("Fine");
d10=new Label();
l1.setBounds(100,50,90,20);
t1.setBounds(210,50,90,20);
b1.setBounds(140,80,50,20);
l2.setBounds(130,120,200,20);
l3.setBounds(130,120,200,20);
d1.setBounds(100,150,90,20);
d2.setBounds(210,150,90,20);
d3.setBounds(100,180,90,20);
d4.setBounds(210,180,90,20);
d5.setBounds(100,210,90,20);
d6.setBounds(210,210,90,20);
d7.setBounds(100,240,90,20);
d8.setBounds(210,240,90,20);
d9.setBounds(100,270,90,20);
d10.setBounds(210,270,90,20);
d12.setBounds(130,120,200,20);
d1.setVisible(false);
d3.setVisible(false);
d5.setVisible(false);
d7.setVisible(false);
d9.setVisible(false);
add(l1);
add(t1);
add(b1);
add(l2);
add(l3);
add(d1);
add(d2);
add(d3);
add(d4);
add(d5);
add(d6);
add(d7);
add(d8);
add(d9);
add(d10);
add(d12);
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
catch(Exception e)
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
int t=0;
i=1;
j=1;
fp1[0]=0;
fp2[0]=0;

Random ran=new Random(10);
while((s=r6.readUTF())!=null)
{
fp1[i]=r6.getFilePointer();
StringTokenizer str=new StringTokenizer(s,"|");
String s1=str.nextToken();
if(s1.equals(t1.getText()))
{
d1.setVisible(true);
d3.setVisible(true);
d5.setVisible(true);
d7.setVisible(true);
d9.setVisible(true);
String s2=str.nextToken();
String s3=str.nextToken();
SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
Date d1=new Date();
Date d21=formatter.parse(s3);
String q=formatter.format(d1);
long diff=d1.getTime()-d21.getTime();
int noofdays=(int) diff/(24*60*60*1000);
d2.setText(s1);
d4.setText(s2);
d6.setText(s3);
d8.setText(q);
String h="0"+"|"+"0"+"|"+"0"+"|";
if(noofdays>15)
{
d10.setText(Integer.toString(noofdays));
l3.setVisible(true);
pay p=new pay(this);
p.setVisible(true);
p.setSize(300,450);
p.setTitle("Fine");
break;
}
else if(noofdays<15)
{
d10.setText("No Fine");
l2.setVisible(true);
break;
}
while((s10=r5.readUTF())!=null)
{
System.out.println("DD");
fp2[j]=r5.getFilePointer();
StringTokenizer str1=new StringTokenizer(s10,"|");
String s11=str.nextToken();
String s12=str.nextToken();
String s13=str.nextToken();
if(s11.equals(t1.getText()))
{
System.out.println("DD");

r5.seek(fp2[j-1]);
String h1=s11+"|"+"0"+"|"+s13+"|";
r5.writeUTF(h1);
break;
}
j++;
}
r6.seek(fp1[i-1]);
r6.writeUTF(h);
}
else 
d12.setText("It is not issued by you to return!!");
}
i++;
}
}
catch(Exception y)
{
}
}
}