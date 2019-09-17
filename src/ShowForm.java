import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShowForm extends JFrame {

    private
        int[][] A;
        
    public void updateView () {
    	this.getContentPane().repaint();
    }
    
    public void addMyContainer (MyContainer container) {
    	getContentPane() .add (container);
    	container.setBounds(0, 0, container.getWidth(), container.getHeight());    	
    }
    
    public ShowForm(String name, int width, int height){
        super(name);
        setSize(width, height);                   
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
        setLayout(new GridLayout(1, 1));
                
    }
}
