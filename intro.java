import java.io.*;
import java.awt.*;
import java.applet.*;
import java.net.*;
import java.awt.event.*;
import java.awt.Image.*;
import java.lang.Object;
import java.util.*;
/*
 class ImageComponent extends Component {

      BufferedImage img;

      public void paint(Graphics g) {
         g.drawImage(img, 0, 0, null);
      }

      public ImageComponent(String path) {
         try {
            img = ImageIO.read(new File(path));
         } catch (IOException e) {
            e.printStackTrace();
         }
}
public Dimension getPreferredSize() {
         if (img == null) {
            return new Dimension(100,100);
         } else {
            return new Dimension(img.getWidth(), img.getHeight());
         }
      }
      
 }
*/
class intro extends Frame implements ActionListener,Runnable
{
Thread t=null;
Button b1,b2;
TextField t1,t2;
Label l1,l2,l3;
Image image=null;
URL url=null;
Panel p;
intro()
{
setLayout(null);
setBackground(Color.cyan);
p=new Panel();
p.setLayout(new FlowLayout());
this.add(p);
b1=new Button("Login");
b2=new Button("Cancel");
l1=new Label("Username");
l2=new Label("Password");
t1=new TextField();
t2=new TextField();
l3=new Label();
l3.setFont(new Font("Verdana",Font.BOLD,25));
l3.setText("NIT AP LIBRARY");
l1.setBounds(100,50,90,20);
t1.setBounds(210,50,90,20);
l2.setBounds(100,80,90,20);
t2.setBounds(210,80,90,20);
b1.setBounds(170,110,50,30);
b2.setBounds(220,110,50,30);
l3.setBounds(120,150,200,30);
l3.setForeground(Color.blue);
t2.setEchoChar('*');
// p.add(new ImageComponent("libraryp/java.jpeg"));

add(l1);
add(t1);
add(l2);
add(t2);
add(b1);
add(b2);
add(l3);
b1.addActionListener(this);
b2.addActionListener(this);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
start();
}
public void start()
{
//url=getCodeBase();
//image=getImage(url,"nitap.jpeg");
t=new Thread(this);
t.start();
}
public void run()
{
image=getImage(url,"nitap.jpeg");
}
public void paint(Graphics g)
{
g.drawImage(image,200,100,this);
}
public void actionPerformed(ActionEvent e)
{
try
{
if(b1==e.getSource())
{
library l=new library();
l.setVisible(true);
l.setSize(300,450);
l.setTitle("Library Management");
}
if(b2==e.getSource())
{
t1.setText("");
t2.setText("");

}
}
catch(Exception ex)
{
}
}
public static void main(String args[])
{
intro li=new intro();
li.setSize(500,250);
li.setVisible(true);
li.setTitle("Library");
}
}
