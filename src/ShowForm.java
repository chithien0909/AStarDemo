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
        setLayout(new GridLayout(2, 1));        
        JButton button = new JButton ("Play");
        getContentPane ().add (button);     
        
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
        
        getContentPane().add(showPanel);        
    }
}
