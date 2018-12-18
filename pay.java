import java.awt.*;
import java.awt.event.*;
class pay extends Frame implements ActionListener
{
Button b1,b2;
TextField t1;
Label l1,l2;
Bookreturn br;
pay(Bookreturn br)
{
setLayout(null);
setBackground(Color.yellow);
this.br=br;
b1=new Button("Pay");
b2=new Button("Cancel");
l1=new Label("Amount");
l2=new Label("Fine paid Successfully!!");
t1=new TextField(br.d10.getText());
l1.setBounds(100,50,90,20);
t1.setBounds(210,50,90,20);
b1.setBounds(170,110,50,30);
b2.setBounds(220,110,50,30);
l2.setBounds(150,150,100,20);
add(l1);
add(t1);
add(b1);
add(b2);
add(l2);
b1.addActionListener(this);
b2.addActionListener(this);
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
l2.setVisible(true);
}
if(b2==e.getSource())
{
t1.setText("");
}
}
catch(Exception ex)
{
}
}
}