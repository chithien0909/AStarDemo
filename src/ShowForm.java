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
    	add (container);
    }
    
    public ShowForm(String name, int width, int height){
        super(name);
        setSize(width, height);                   
        setBackground(Color.BLACK);       
    }
}
