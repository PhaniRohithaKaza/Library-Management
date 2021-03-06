import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.Object;
import java.awt.Image;
public class AwtControlDemo {

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;

   public AwtControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      AwtControlDemo  awtControlDemo = new AwtControlDemo();
      awtControlDemo.showImageDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Java AWT Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showImageDemo(){
      headerLabel.setText("Control in action: Image"); 

      controlPanel.add(new ImageComponent("libraryp/nitap.jpeg"));
      mainFrame.setVisible(true);  
   }
	
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
}