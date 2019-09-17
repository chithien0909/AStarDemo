import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ShowForm extends JFrame {
	
	public interface MyShowFormOnClickListener {
		public void onClick (Component comp);
	}
	
    private
        int[][] A;
    private 
    	JPanel showPanel;
    private MyShowFormOnClickListener onPlayClick = null;
    public void updateView () {
    	this.getContentPane().repaint();
    }
    
    public void setOnPlayClickListener (MyShowFormOnClickListener onclick) {
    	onPlayClick = onclick;
    }
    
    public void addMyContainer (MyContainer container) {
    	showPanel.add (container);
//    	container.setBounds(0, 0, container.getWidth(), container.getHeight());    	
    }
    
    public ShowForm(String name, int width, int height){
        super(name);
        setSize(width, height);                   
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);             
        getContentPane ().setLayout(new GridBagLayout());   
//        getContentPane ().setComponentOrientation(ComponentOrientation.);
        // add button for triggering simulations
        JButton button = new JButton ("Play");
        GridBagConstraints btnPlayCtr = new GridBagConstraints();
//        btnPlayCtr.gridx = btnPlayCtr.gridy ;
        btnPlayCtr.anchor = GridBagConstraints.NORTH;
        btnPlayCtr.fill = GridBagConstraints.HORIZONTAL;
        btnPlayCtr.weightx = 2;   
        btnPlayCtr.weighty = 0;   
        btnPlayCtr.insets = new Insets(10, 0, 10, 0);
        btnPlayCtr.ipady = 40;
        
        getContentPane ().add(button, btnPlayCtr);
        
               
//        getContentPane ().add(new JButton ("QUIT"), btnPlayCtr);     
        
        // add panel for displaying simulating algos
        showPanel = new JPanel ();
        showPanel.setLayout(new GridLayout(1, 3));        
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
        
        GridBagConstraints pnlShowCtr = new GridBagConstraints();
        pnlShowCtr.anchor = GridBagConstraints.NORTH;
        pnlShowCtr.fill = GridBagConstraints.BOTH;
        pnlShowCtr.weightx = 3;   
        pnlShowCtr.weighty = 1;   
        pnlShowCtr.gridy= 1;   
        
        getContentPane().add(showPanel, pnlShowCtr);        
    }
}
