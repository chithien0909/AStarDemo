import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class GreedySimulator extends PathFindingAlgorithmSimulator {

	static final int
//        VALUE_WALL = 100,
        VALUE_WALKABLE = 1,
        VALUE_INFINITY = 32000;

	final int[]
	    _x_ver = {-1, +1, 0, 0, -1, -1, +1, +1},
	    _y_hor = {0,  0,  -1, +1, -1, +1, -1, +1};
	
	
	    int[]
	        
	        H,
	        F,
	        G,
	        prev;
	
	private ArrayList<Integer> open_list = null;
	private int closed = 0;
	public boolean isInRange (int x, int y){
	    return  ((0<=x) && (x<row) && (0<=y) && (y<col));
	}
	
	public int getIndex (int x, int y){
	    return x * col + y;
	}
	
	public void init (String fileName) {
	    try {
	
	    	super.init (fileName);
	    	int cell_count = row * col;
	
	        H = new int [cell_count];
	        F = new int [cell_count];
	        G = new int [cell_count];
	        int x = 0, y = 0;
	        for (int i = 0; i<cell_count; i++) {
	            H[i] = Math.abs(x - dst_x) + Math.abs(y - dst_y) - 1; // Mahattan distance for heuristic evaluation
	            y++;
	            if (y>=col) {
	                y = 0;
	                x ++;
	            }
	            closed = 0;
	            G[i] = F[i] = VALUE_INFINITY;
	        }
	
	        prev = new int[cell_count];
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(-1); // exit immediately
	    }
	    
	    setContent(result);
	}
	
	public boolean deploy () throws Exception{
	
	    int src_index = getIndex(src_x, src_y);
	    int dst_index = getIndex(dst_x, dst_y);
	
	    open_list = new ArrayList<>();
	    open_list.add(src_index);
	
	    F [src_index] = H[src_index];
	    G [src_index] = 0;
	    int
	            min,
	            focus_index = 0;
	
	    while (open_list.size() > 0){ // con cai de xet
	
	        min = VALUE_INFINITY;
	        int where = 0;
	        
	        for (int i = 0; i<open_list.size(); i++){
	            int gVal = H[open_list.get(i)];
	
	            if (min > gVal) {
	                where = i;
	                focus_index = open_list.get (i);
	                min = gVal;
	            }
	        }
	
	        int srcX = focus_index / col;
	        int srcY = focus_index % col;
	        
	        if (focus_index == dst_index) {
	            return true;
	        }
	
	        open_list.remove(where);
	        isClose [focus_index] = true;	        
	        result [srcX][srcY] = -5;
	        ++closed;
	        this.log("<html> "
	        		+ "Total nodes: " + row*col + "<br>"
	        		+ "Closed list size: " + closed + "<br>" 
	        		+ "Open list size: " + open_list.size());
	        result[src_x][src_y] = -2;
	        simulate ();
	        	        
	        for (int i = 0; i</*_x_ver.length*/ 4; i++){
	            int X = srcX + _x_ver[i];
	            int Y = srcY + _y_hor[i];
	            if ((isInRange(X, Y))) {
	                int index = getIndex(X, Y);
	                if (!isClose[index]) {
	                    if (G[index] == VALUE_INFINITY) {	                    	
	                        open_list.add(index);  // add if it is unchecked
	                        result [X][Y] = -4;	                        
	//                        SwingUtilities.invokeLater(new Runnable() {				
	//							@Override
	//							public void run() {
	//								form.updateView();									
	//							}
	//						});
	//                                                    
	                    }
	                    
	                    if (G[focus_index] + 1 < G[index]){ // default walking value is 1                            
	                    	G[index] = G[focus_index] + 1;
	                        F[index] = G[index] + H[index];
	                        prev[index] = focus_index;                        
	                    }
	                }
	            }
	        }
	
	
	    }
	
	    return false;
	}
	
//	public void makeResult () {
//	    String s = "";
//	    int src_index = getIndex(src_x, src_y);
//	    int dst_index = getIndex(dst_x, dst_y);
//	
//	    s = "(" + (dst_index/col) + ", " + (dst_index % col) + ")" + "\n" + s;
//	    do {
//	        dst_index = prev[dst_index];
//	        s = "(" + (dst_index/col) + ", " + (dst_index % col) + ")" + "\n" + s;
//	    } while (dst_index != src_index);
//	}
	
	public void setPath () {
	
	    int src_index = getIndex(src_x, src_y);
	    int dst_index = getIndex(dst_x, dst_y);
	
	    result [dst_index/col][dst_index % col] = -3;
	    int len = 0;
	    do {
	    	++len;
	        dst_index = prev[dst_index];
	        result [dst_index/col][dst_index % col] = -1;
	        try {
	        	simulate ();
	        } catch (Exception e) {
	        	
	        }
	    } while (dst_index != src_index);
	    
    	++len;
        result [dst_index/col][dst_index % col] = -2;
	        
	    try {
	    	simulate ();
	    } catch (Exception e) {
	    	
	    }
	    this.log("<html>"
        		+ "Total nodes: " + row*col + "<br>"
        		+ "Closed list size: " + closed + "<br>" 
        		+ "Open list size: " + open_list.size() + "<br>"
        		+ "Path LENGTH: " + len);
	}

	
	public GreedySimulator () {		
		super ();	
	}
		
	@Override
	public void run () {
//		init ();
		try {
			deploy ();
			setPath ();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
