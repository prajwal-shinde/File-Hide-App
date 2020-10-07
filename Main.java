import javax.swing.*;    
import java.awt.event.*;    
import java.io.*;    
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main extends JFrame implements ActionListener{    
JMenuBar mb;    
JMenu file;    
JMenuItem open;    
JTextArea ta;
JButton b,b2; 
String filepath;
JLabel l1;
File f;  
 String s1="",s2="";
Main(){     
b=new JButton("Click Here");  
b.setBounds(10,50,140,30);  
b.addActionListener(this); 
ta=new JTextArea(800,800);    
ta.setBounds(0,90,800,800);
b2=new JButton("Hide File");
b2.addActionListener(this);
b2.setBounds(10,0,140,30);
l1=new JLabel();
l1.setBounds(0,0,280,80);
add(l1);
add(b);                
add(ta);
add(b2); 
          
}    
  
public void actionPerformed(ActionEvent e) {    
if(e.getSource()==b){    
    JFileChooser fc=new JFileChooser();    
    int i=fc.showOpenDialog(this);    
    b.setEnabled(false);
    if(i==JFileChooser.APPROVE_OPTION){    
         f=fc.getSelectedFile();    
         filepath=f.getPath();    
        try{  
        BufferedReader br=new BufferedReader(new FileReader(filepath));    
                                
        while((s1=br.readLine())!=null){    
        s2+=s1+"\n";    
        }    
        ta.setText(s2);    
        br.close();    
        }catch (Exception ex) {ex.printStackTrace();  }                 
    }    
}
if(e.getSource()==b2){
	try{
		Path path = Paths.get(filepath);
Files.setAttribute(path, "dos:hidden", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
ta.setText("");
l1.setText("File Hidden Successfully!!!!");
l1.setForeground(Color.ORANGE);
System.out.print("File Hide Successfully!!!");
}catch(Exception msg){
	l1.setText("File Failed to Hide!!!");
	l1.setForeground(Color.RED);
	System.out.print(msg);
}
  
}    
}          
public static void main(String[] args) {    
    Main om=new Main();    
             om.setSize(500,500);    
             om.setLayout(null);    
             om.setVisible(true);    
             om.setDefaultCloseOperation(EXIT_ON_CLOSE);    
}    
}  