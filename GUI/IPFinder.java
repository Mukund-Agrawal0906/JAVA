import javax.swing.*;
import java.awt.event.*;
import java.net.*; 

public class IPFinder extends JFrame implements ActionListener
{
	JLabel l;  
	JLabel l2;
    JTextField tf; 
    JTextField tf2; 
    JButton b;
	JButton b2;
    
    IPFinder()
    {
    	super("IP Finder Tool - Javatpoint");  
    	
        l=new JLabel("Enter URL:");  
        l.setBounds(50,70,150,20);;  
        tf=new JTextField();  
        tf.setBounds(150,70,200,20);	
	
        b=new JButton("Find IP");  
        b.setBounds(50,150,80,30); 
        
        b.addActionListener(this); 
                    
        l2=new JLabel("IP is:");  
        l2.setBounds(50,270,150,20);;  
        tf2=new JTextField();  
        tf2.setBounds(150,270,200,20);  
        tf2.setEditable(false);
        
        b2=new JButton("Clear");  
        b2.setBounds(350,150,80,30);
		//b2.setVisible(false);
        
        b2.addActionListener(this); 
       
	   
        add(l);  
        add(tf);  
        add(b);
        add(l2);
        add(tf2);
        add(b2);
		
        setSize(600,700);  
        setLayout(null);  
        setVisible(true); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){ 
	
    	tf2.setText("");
		
        String url=tf.getText();  
        try {

			if(e.getSource() == b)
			{
				InetAddress ia=InetAddress.getByName(url);  
				String ip=ia.getHostAddress();
            
				tf2.setText(ip);
			}
			if(e.getSource() == b2)
			{
				tf.setText("");          
				tf2.setText("");
				
			}
           
        } catch (UnknownHostException e1) {  
            JOptionPane.showMessageDialog(this,e1.toString());  
        }  
    }  

	public static void main(String[] args) 
	{
		new IPFinder();

	}

}
