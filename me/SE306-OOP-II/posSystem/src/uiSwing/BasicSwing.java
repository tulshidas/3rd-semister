package uiSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class BasicSwing {
	
	public BasicSwing() {
		
		JFrame mainframe= new JFrame("TextField Example");  
		mainframe.setSize(500, 500);
		mainframe.setLayout(new FlowLayout());
		
		JTextField nameField = new JTextField(30);
		mainframe.add(nameField);
		
		JButton clickButton = new JButton("Click Me");
		clickButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = nameField.getText();
				JOptionPane.showMessageDialog(null, "Welcome " + name);
				mainframe.setVisible(false);
				new BasicSwing2(name);
			}
		});
	
		
		
		mainframe.add(clickButton);
		mainframe.setVisible(true);
		
		
//	    JTextField t1,t2;  
//	    JLabel l1, l2;
//	    JTextArea ta1;
//	    JComboBox comb1;
//	    
	    
//	    l1 = new JLabel("Name");
//	    l1.setBounds(10, 100, 50, 30);
//	    
//	    t1=new JTextField("");  
//	    t1.setBounds(80,100, 200,30);  
//	    
//	    l2 = new JLabel("Email");
//	    l2.setBounds(10, 150, 50, 30);
//	    
//	    t2=new JTextField("");  
//	    t2.setBounds(80,150, 200,30);  
//	    
////	    ta1 = new JTextArea(100, 5);
////	    ta1.setBounds(80, 200, 200, 100);
//	    
//	    String batch[]={"BSSE05","BSSE06","BSSE07","BSSE08","BSSE09"};        
//	    comb1 = new JComboBox(batch);
//	    comb1.setBounds(80, 200, 100, 30);
	    
	    
//	    f.add(l1);
//	    f.add(l2);
//	    f.add(t1); 
//	    f.add(t2);  
//	    f.add(comb1);
	    
//	    DefaultListModel<String> dl1 = new DefaultListModel<>();  
//        dl1.addElement("Cricket");  
//        dl1.addElement("Ludu");  
//        dl1.addElement("Chess");  
//        dl1.addElement("Bridge");  
//        JList<String> list = new JList<>(dl1);  
//        list.setBounds(100,100, 75,75);  
//        
//        f.add(list);  
	    
	    
	    
//	    JMenu menu, menu2, submenu,submenu2 ;  
//        JMenuItem i1, i2, i3, i4, i5, i6, i7;  
//	    
//        JMenuBar mb=new JMenuBar();  
//        menu=new JMenu("File");  
//        
//        submenu=new JMenu("Others"); 
//        submenu2 = new JMenu("Moly");
//        
//        i1=new JMenuItem("New");  
//        i2=new JMenuItem("Save");  
//        i3=new JMenuItem("Open");  
//        i4=new JMenuItem("export");  
//        i5=new JMenuItem("import"); 
//        
//        i6 = new JMenuItem("Play");
//        i7 = new JMenuItem("Facebooking");
//        
//        menu.add(i1); menu.add(i2); menu.addSeparator(); menu.add(i3); 
//        
//        submenu.add(i4); submenu.add(i5); 
//        
//        submenu2.add(i6); 
//        submenu2.addSeparator(); 
//        submenu2.add(i7);
//        
//        submenu.add(submenu2);
//        menu.add(submenu);  
//        mb.add(menu);  
//        f.setJMenuBar(mb);  
	    
//	    JTextArea ta=new JTextArea(200,200);  
//	    JPanel p1=new JPanel();  
//	    p1.add(ta);  
//	    JPanel p2=new JPanel();  
//	    JButton p3=new JButton("IIT");  
//	    JTabbedPane tp=new JTabbedPane();  
//	    tp.setBounds(50,50,300,300);  
//	    tp.add("BSSE08",p1);  
//	    tp.add("BSSE09",p2);  
//	    tp.add("BSSE07",p3);   
//	    p3.setToolTipText("The End");
//	    f.add(tp);  
	    
//	    f.setSize(600,600);  
//	    f.setLayout(null);  
//	    f.setVisible(true);  
		
		
//		JFrame win = new JFrame( "Layout Demo" );
//		win.setSize(500, 500);
//		win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//		
//		JLabel east = new JLabel( "IIIT DU   EAST" );
//		east.setOpaque(true);
//		east.setBackground( Color.RED );
//		
//		JLabel west = new JLabel( "WEST" );
//		west.setOpaque( true );
//		west.setBackground( Color.BLUE );
//		
//		JLabel north = new JLabel( "NORTH" );
//		north.setOpaque( true );
//		north.setBackground( Color.GREEN );
//		
//		JLabel south = new JLabel( " SOUTH" );
//		south.setOpaque( true );
//		south.setBackground( Color.YELLOW );
//		
//		JLabel center = new JLabel( " CENTER" );
//		center.setOpaque( true );
//		center.setBackground( Color.ORANGE );
		
//		win.setLayout( new FlowLayout( ) );
//		win.add( east );
//		win.add( west );
//		win.add( center );
//		win.add( north );
//		win.add( south );
		
		//Border
//		win.setLayout(new BorderLayout());
//		win.add(east, BorderLayout.EAST);	
//		win.add(center, BorderLayout.WEST);
		
		
		//Grid
//		win.setLayout(new GridLayout(2, 3, 10, 20));
//		win.add(west);
//		win.add(east);
//		win.add(south);
//		win.add(north);
//		win.add(center);
		
//		Container box = win.getContentPane( );
//		box.setLayout( new BoxLayout( box, BoxLayout.Y_AXIS ) );
//		win.add( east );
//		win.add( west );
//		win.add( center );
//		win.add( north );
//		win.add( south );
//
//
//		
//		
//		win.setVisible(true);
		
//		JFileChooser fc = new JFileChooser();
//		int returnVal = fc.showOpenDialog(null);
//		JOptionPane.showMessageDialog(null, returnVal);	
//		
//		if(returnVal == JFileChooser.APPROVE_OPTION)
//			JOptionPane.showMessageDialog(null, "File: " + fc.getSelectedFile());
//		
		
//		String name = JOptionPane.showInputDialog("Enter your name");	
//		JOptionPane.showMessageDialog(null, "Hello "+name);
		
//		JFrame mainFrame = new JFrame();
//		mainFrame.setSize(300, 200);
//		mainFrame.setTitle("BSSE08 IIT");
//		
//		
////		JLabel l_name = new JLabel("IIT DU");
////		mainFrame.add(l_name);
////		
////		JButton b_clickMe = new JButton("Click Me");
////		b_clickMe.setSize(10, 20);
////		mainFrame.add(b_clickMe);
//		
//		
//		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mainFrame.setVisible(true);
	}

}





