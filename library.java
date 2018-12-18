import java.awt.*;
import java.awt.event.*;
class library extends Frame implements ActionListener
{
Button b1,b2,b3,b4,b5,b6;
library()
{
setLayout(null);
b1=new Button("Add Book");
b2=new Button("Search Book");
b3=new Button("Add Member");
b4=new Button("Search Member");
b5=new Button("Issue Book");
b6=new Button("Return Book");
b1.setBounds(100,50,90,30);
b2.setBounds(100,100,90,30);
b3.setBounds(100,150,90,30);
b4.setBounds(100,200,90,30);
b5.setBounds(100,250,90,30);
b6.setBounds(100,300,90,30);
setBackground(Color.pink);
add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
public void actionPerformed(ActionEvent e)
{
try
{
if(b1==e.getSource())
{
Bookadd b=new Bookadd();
b.setVisible(true);
b.setSize(500,300);
b.setTitle("Adding Book");
}
if(b2==e.getSource())
{
Booksearch a=new Booksearch();
a.setVisible(true);
a.setSize(500,300);
a.setTitle("Searching Book");
}
if(b3==e.getSource())
{
Memberadd b=new Memberadd();
b.setVisible(true);
b.setSize(500,300);
b.setTitle("Adding Member");
}
if(b4==e.getSource())
{
Membersearch b=new Membersearch();
b.setVisible(true);
b.setSize(500,300);
b.setTitle("Searching Member");
}
if(b5==e.getSource())
{
Bookissue b=new Bookissue();
b.setVisible(true);
b.setSize(500,300);
b.setTitle("Issuing Book");
}
if(b6==e.getSource())
{
Bookreturn b=new Bookreturn();
b.setVisible(true);
b.setSize(500,450);
b.setTitle("Returning Book");
}
}
catch(Exception ex)
{
}
}
}
