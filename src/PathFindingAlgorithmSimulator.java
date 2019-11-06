import java.awt.Color;
import java.io.File;
import java.util.Scanner;

import sun.rmi.runtime.Log;

public abstract class PathFindingAlgorithmSimulator extends AlgorithmSimulator {
	
	public static final int WALL = 1;
	public static final int BELONGS_TO_PATH = -1;
	public static final int SOURCE = -2;
	public static final int DEST = -3;
	public static final int OPENED = -4;	
	public static final int CLOSED= -5;
 
	protected int[] A;
	protected int[][] result;
	protected int
    	row, col, src_x, src_y, dst_x, dst_y;
	protected boolean[] isClose;
	
 	public void init (String fileName) throws Exception{
 		Scanner scanner = new Scanner(new File(fileName));
 		
        row = scanner.nextInt ();
        col = scanner.nextInt ();

        src_x = scanner.nextInt ();
        src_y = scanner.nextInt ();
        
        dst_x = scanner.nextInt ();
        dst_y = scanner.nextInt ();

        int cell_count = row * col;

        A       = new int [cell_count];
        isClose = new boolean [cell_count];
        result  = new int [row][col];

        for (int i = 0; i < cell_count; i++){
            A[i] = scanner.nextInt ();
            result[i/col][i%col] = (A[i] == 1 ? WALL : 0);

            if (A[i] == 1)
                isClose [i] = true;
            else 
            	isClose [i] = false;
        }
        
        result[dst_x][dst_y] = -3;
        result[src_x][src_y] = -2;
        scanner.close ();
        
        setContent (result);
        log("<html> Map size (Height, Width): ("+row+", "+col+") </html>");
        getPainter ().repaint();
	}
	
}
