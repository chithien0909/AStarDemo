import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.SwingUtilities;

public class AStarAlgorithmSimulator extends PathFindingAlgorithmSimulator {

	static final int
//        VALUE_WALL = 100,
        VALUE_WALKABLE = 1,
        VALUE_INFINITY = 3200000;

	final int[]
	    _x_ver = {-1, +1, 0, 0, -1, -1, +1, +1},
	    _y_hor = {0,  0,  -1, +1, -1, +1, -1, +1};
	
	    int[]	       
	        H,
	        F,
	        G,
	        prev;
	    
//	private PriorityQueue<PairII> open_list = null;
	SortedSet<PairII> open_list = null;
	
	int closed = 0;
	long startTime = 0;
	
	public boolean isInRange (int x, int y){
	    return  ((0<=x) && (x<row) && (0<=y) && (y<col));
	}
	
	public int getIndex (int x, int y){
	    return x * col + y;
	}
	
	public void init (String fileName) throws Exception {
	    
	    	super.init(fileName);	    	
	    	int cell_count = row * col;
	        H = new int [cell_count];
	        F = new int [cell_count];
	        G = new int [cell_count];
	        int x = 0, y = 0;
	        for (int i = 0; i<cell_count; i++) {
	        	// Tính trước giá trị Heuristic cho từng điểm mmootj
	            H[i] = (int) Math.sqrt(Math.pow(x - dst_x, 2) + Math.pow(y - dst_y, 2));//Math.abs(x - dst_x) + Math.abs(y - dst_y); // Mahattan distance for heuristic evaluation
//	        	H[i] = Math.max(Math.abs (x-dst_x), Math.abs(y-dst_y)); 	
	            y++;
	            if (y>=col) {
	                y = 0;
	                x ++;
	            }
//	            H[i] *= 6;
	            G[i] = F[i] = VALUE_INFINITY;
	        }
	        prev = new int[cell_count];
	        
	        closed = 0;	    	    	    
	}
	
	public boolean deploy () throws Exception{
		
		startTime = System.currentTimeMillis();
		
	    int src_index = getIndex(src_x, src_y);
	    int dst_index = getIndex(dst_x, dst_y);
		    
	    open_list = new TreeSet<> ();
	    
	    G [src_index] = 0;
	    F [src_index] = G [src_index] + H[src_index];	    
	    int
	            min,
	            focus_index = 0;
	    
	    open_list.add(new PairII (F[src_index], src_index));   
//	    System.out.println (src_index);
	    while (open_list.size() > 0){ // Còn một phần tử để xét	
	        min = VALUE_INFINITY;
//	        int where = 0;
	        PairII pivot = (PairII) open_list.first();	 
	        System.out.println ("Choose node: " +  pivot.second + ", value= " + pivot.first);
	        focus_index = pivot.second;
	        open_list.remove(pivot);
	        
	        int srcX = focus_index / col;
	        int srcY = focus_index % col;
	        
	        if (focus_index == dst_index) {
	            return true;
	        }
	
	        isClose [focus_index] = true;
	        ++closed;
	        
	        result [srcX][srcY] = PathFindingAlgorithmSimulator.CLOSED; // Gán result này chủ yếu để tô màu
	        result[src_x][src_y] = PathFindingAlgorithmSimulator.SOURCE;
	        
	        this.log("<html> <div style='margin-bottom: 16px'>"
	        		+ "Total nodes: " + row*col + "<br>"
	        		+ "Closed list size: " + closed + "<br>" 
	        		+ "Open list size: " + open_list.size() + "</div></html>");
	        
	        simulate ();  // Gọi thủ tục này để gửi lời yêu cầu cập nhật lên giao diện
	        	        
	        for (int i = 0; i</*_x_ver.length*/ 4; i++){ // đi được 4 hướng N, W, S, E
	        	
	            int X = srcX + _x_ver[i];
	            int Y = srcY + _y_hor[i];
	            if ((isInRange(X, Y))) {
	                int index = getIndex(X, Y);
	                if (A[index] == 1) // Đây là ô nó thực sự bị khóa (ô bức tường trong mê cung
	                	continue;
	                	                
                    if (G[focus_index] + 1 < G[index]){ // default walking value is 1
                    	// Với A*, dù nút đang nằm trong tập đóng, ta vẫn có thể mở nó ra sau này
                    	
                    	if (F[index] != VALUE_INFINITY) {
    	                	open_list.remove(new PairII (F[index], index));
    	                }                    	 
                    	                    	
                    	G[index] = G[focus_index] + 1;
                        F[index] = G[index] + H[index];
                        System.out.println ("==> Update to: " +  index + ", value= " + F[index] +" with g[idx] = " + G[index]);
                        prev[index] = focus_index;
                        open_list.add (new PairII (F[index], index));
                        
                        if (isClose[index]) {
                        	isClose[index] = false;
                        	--closed;
                        }
                        
                        result[X][Y] = PathFindingAlgorithmSimulator.OPENED;
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
	    
	    this.log("<html><div style='margin-bottom: 16px'>"
        		+ "Total nodes: " + row*col + "<br>"
        		+ "Closed list size: " + closed + "<br>" 
        		+ "Open list size: " + open_list.size() + "<br>"
        		+ "Path LENGTH: " + len + "<br>"
        		+ "Simulation time: " + (System.currentTimeMillis() - startTime) + "ms </div> </html>");
//	    System.out.println ("PATH LENGTH: " + len);
	}
	
	public void setNoPath () {
		this.log("<html> <div style='margin-bottom: 16px'>"
        		+ "Total nodes: " + row*col + "<br>"
        		+ "Closed list size: " + closed + "<br>" 
        		+ "Open list size: " + open_list.size() + "<br>"
        		+ "<p color=\"red\"> No PATH found </p><br>"
        		+ "Simulation time: " + (System.currentTimeMillis() - startTime) + "ms </div></html>");
	}

	
	public AStarAlgorithmSimulator () {		
		super ();	
	}
		
	@Override
	public void run() {		
		try {
			if (deploy ())
				setPath ();
			else 
				setNoPath ();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
