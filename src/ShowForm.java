import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShowForm extends JFrame {

    private
        int[][] A;
    

    class MyContentPane extends  Container {
    	private
        	int each_width, each_height;
    	
        @Override
        public void paint (Graphics g) {
        	
            super.paint(g);
            each_height = getHeight()/ A.length;
            each_width = getWidth() / A[0].length;
            for (int i = 0; i < A.length; i++)
                for (int j = 0; j < A[0].length; j++) {
                    Color color = Color.WHITE;

                    switch (A[i][j]) {
                        case 1:
                            color = Color.GRAY;
                            break;
                        case -1:
                            color = Color.GREEN; // source
                            break;
                        case -2:
                            color = Color.BLUE;
                            break;
                        case -3:
                            color = Color.RED; // dest
                            break;                      
                        case -4:
                        	color = Color.CYAN;
                        	break;
                        case -5:
                        	color = Color.DARK_GRAY;
                        	break;
                    }

                    g.setColor(color);
                    g.fillRect(j * each_width, i * each_height, each_width - 1, each_height - 1);
                }
        }
    }
    
    
    public void setContent (int[][] content) {
    	A = content;
    }
    
    public void updateView () {
    	this.getContentPane().repaint();
    }
    
    public ShowForm(int[][] content, int width, int height){
        super("A* path finding");
        setSize(width, height);
        setContent (content);
        setBackground(Color.BLACK);

        MyContentPane pane = new MyContentPane();
        setContentPane(pane);
//        pane.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getButton() == MouseEvent.BUTTON1) {
//                    try {
//                        int x = e.getY() / each_height;
//                        int y = e.getX() / each_width;
//                        if (x > A.length)
//                            x = A.length;
//                        if (y > A[0].length)
//                            y = A[0].length;
//                        onClick(x, y);
//                    } catch (Exception exception){
//                    }
//                }
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
    }

//    public void onClick (int x, int y){ // x and y coordinate in table
//    }

}
