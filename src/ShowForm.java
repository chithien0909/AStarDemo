import javax.swing.*;
import javax.swing.filechooser.FileSystemView;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;


public class ShowForm extends JFrame {
	
//	private Map<MyContainer, JLabel> loggerMap = new HashMap<> ();
	public interface MyShowFormOnClickListener {
		public void onClick (Component comp);
	}
	
	public interface MyShowFormOnInputListener {
		public void onInput (String fileName);
	}
	
    private 
    	JPanel showPanel;
    private MyShowFormOnClickListener onPlayClick = null;
    private MyShowFormOnInputListener onInputClick = null;
    
    public void updateView () {
    	this.getContentPane().repaint();
    }
    
    public void setOnPlayClickListener (MyShowFormOnClickListener onClick) {
    	onPlayClick = onClick;
    }
    
    public void setOnInputClickListener (MyShowFormOnInputListener onClick) {
    	onInputClick = onClick;
    }
//    public void setOnInputClickListener (MyShowFormOnClickListener onclick) {
//    	
//    }
    
    
//    public JLabel getLogger (MyContainer container) {
//    	JLabel logger = loggerMap.getOrDefault(container, null); 
//    	return logger;
//    }
    
//    public JLabel getLogging () {
//    	
//    }
    
    public void addMyContainer (MyContainer container, String label) {
    	
    	JPanel sub = new JPanel ();
    	sub.setLayout(new GridBagLayout());
    	
    	GridBagConstraints c = new GridBagConstraints();    	
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.anchor = GridBagConstraints.NORTH;    	
    	c.weightx = 2;
    	c.weighty = 0;
    	c.gridx = c.gridy = 0;    	
    	JLabel lbName = new JLabel (label);
    	lbName.setHorizontalAlignment(SwingConstants.CENTER);
    	sub.add (lbName, c);
    	
    	JLabel lbLogger = new JLabel ("<html>Logging: <br> For instances</html>");
//    	lbLogger.setMu
    	c.anchor = GridBagConstraints.NORTH;
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridy = 1;
    	c.weighty = 0;
    	sub.add(lbLogger, c);
    	
    	c.anchor = GridBagConstraints.NORTH;
    	c.fill = GridBagConstraints.BOTH;
    	c.gridy = 2;    
    	c.weighty = 1;
//    	c.ipadx = 200;
//    	c.ipady = 200;
    	sub.add (container, c);
    	container.setLogger(lbLogger);
//    	loggerMap.put(container, lbLogger); 	    	
    	showPanel.add (sub);
    	
    }
    
    public ShowForm(String name, int width, int height){
        super(name);
        setSize(width, height);                   
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);             
        getContentPane ().setLayout(new GridBagLayout());   
//        getContentPane ().setComponentOrientation(ComponentOrientation.);
        // add button for triggering simulations
        JButton input = new JButton ("Input");
        GridBagConstraints btnInpCtr = new GridBagConstraints();
        btnInpCtr.anchor = GridBagConstraints.NORTH;
        btnInpCtr.weighty = 0;
        btnInpCtr.gridy = 0;
        getContentPane ().add(input, btnInpCtr);
        
        JButton button = new JButton ("Simulate");
        GridBagConstraints btnPlayCtr = new GridBagConstraints();
//        btnPlayCtr.gridx = btnPlayCtr.gridy ;
        btnPlayCtr.anchor = GridBagConstraints.NORTHWEST;
        btnPlayCtr.fill = GridBagConstraints.HORIZONTAL;
        btnPlayCtr.weightx = 2;   
        btnPlayCtr.weighty = 0;   
        btnPlayCtr.gridy = 1;
        btnPlayCtr.insets = new Insets(10, 0, 10, 0);
        btnPlayCtr.ipady = 40;
        
        getContentPane ().add(button, btnPlayCtr);
        
               
//        getContentPane ().add(new JButton ("QUIT"), btnPlayCtr);     
        
        // add panel for displaying simulating algos
        showPanel = new JPanel ();
        showPanel.setLayout(new GridLayout(1, 3));        
                
//        showPanel.setLayout(new GridBagLayout());
        GridBagConstraints pnlShowCtr = new GridBagConstraints();
        pnlShowCtr.anchor = GridBagConstraints.NORTH;
        pnlShowCtr.fill = GridBagConstraints.BOTH;
        pnlShowCtr.weightx = 3;   
        pnlShowCtr.weighty = 1;   
        pnlShowCtr.gridy= 2;   
        
        getContentPane().add(showPanel, pnlShowCtr);
        
        
        button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (onPlayClick != null)
					onPlayClick.onClick(e.getComponent());
			}
		});
        input.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));

				int returnValue = jfc.showOpenDialog(ShowForm.this);
				// int returnValue = jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					java.io.File selectedFile = jfc.getSelectedFile();
					if (onInputClick != null)
						onInputClick.onInput(selectedFile.getAbsolutePath());
//					System.out.println(selectedFile.getAbsolutePath());
				}
				
				
			}
		});
    }
    
    
}
