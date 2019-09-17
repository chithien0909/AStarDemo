import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JComponent;

class MyContainer extends JComponent {
	
		private 
			int[][] A = null;
    	private
        	int each_width, each_height;
    	public static Color LIGHT_BLUE = new Color (51, 204, 255);
    	
    	public void setContent (int[][] content) {
    		A = content;
//    		setBackground (Color.BLACK);
    	}
    	
        @Override
        public void paint (Graphics g) {
            super.paint(g);
            
            if (A == null)
            	return;
            
            each_height = getHeight()/ A.length;
            each_width = getWidth() / A[0].length;
            int sync = Math.min(each_height, each_width);
            each_height = each_width = sync;
            for (int i = 0; i < A.length; i++)
                for (int j = 0; j < A[0].length; j++) {
                    Color color = Color.WHITE;

                    switch (A[i][j]) {
                        case 1:
                            color = Color.GRAY; // block
                            break;
                        case -1:
                            color = Color.GREEN; // retrieved path
                            break;
                        case -2:
                            color = Color.BLUE; // source
                            break;
                        case -3:
                            color = Color.RED; // dest
                            break;                      
                        case -4:
                        	color = Color.MAGENTA; // on checking
                        	break;
                        case -5:
                        	color = LIGHT_BLUE; // 
                        	break;
                    }

                    g.setColor(color);
                    g.fillRect(j * each_width, i * each_height, each_width - 1, each_height - 1);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * each_width, i * each_height, each_width - 1, each_height - 1);
                }
        }
    }