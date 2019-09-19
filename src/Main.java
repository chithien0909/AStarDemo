import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JOptionPane;

public class Main {
	
	static ShowForm form = null;
    
    public static void main (String[] args){     
    	
    	ShowForm form1 = new ShowForm ("Path finding comparator	 ", 800, 600);    	
    	form1.setVisible(true);
    	final PathFindingAlgorithmSimulator 
    		astar = 
				new AStarAlgorithmSimulator(),
			dijkstra =
				new DijkstraAlgorithmSimulator(),
			greedy =
				new GreedySimulator();
//			greed2 = new GreedySimulator ();
    
    	form1.addMyContainer(astar.getPainter(), "A Star");
    	form1.addMyContainer(dijkstra.getPainter(), "BFS");
    	form1.addMyContainer(greedy.getPainter(), "Best first search");
    	
    	
    	
    	try {
	    	astar.init    ("Map.inp");
	    	dijkstra.init ("Map.inp");
	    	greedy.init   ("Map.inp");
//	    	greed2.init   ("Map1.inp");	    	
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.exit(-1);
    	}
    	
                                            
        form1.setOnPlayClickListener(new ShowForm.MyShowFormOnClickListener() {
			
			@Override	
			public void onClick(Component comp) {
				comp.setEnabled(false);
			
				Thread thread1 = new Thread() {
		        	public void run () {
		        		
		        		astar.setSimulating(true);
		        		astar.run();        	
		        	}        
		        };
		        
		        Thread thread2 = new Thread() {
		        	public void run () {        		        		        	
		            	
		        		dijkstra.setSimulating(true);
		        		dijkstra.run();
		        	}
		        };
		        
		        Thread thread3 = new Thread() {
		        	public void run () {        		        		        	
		        		
		        		greedy.setSimulating(true);
		        		greedy.run();
		        	}
		        };
		        
		        thread1.start ();
		        thread2.start ();
		        thread3.start ();
			
				comp.setEnabled(true);
			}
		});
        
        form1.setOnInputClickListener(new ShowForm.MyShowFormOnInputListener() {
			
			@Override
			public void onInput(String fileName) {
				try {
					astar.init(fileName);
					dijkstra.init(fileName);
					greedy.init(fileName);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					JOptionPane.showMessageDialog(form1, e.toString());
				}
			}
		});
        
//        ShowForm form2 = new ShowForm ("A Star", 800, 600);
//        form2.setVisible(true);
//        Thread thread2 = new Thread() {
//        	public void run () {
//        		AStarAlgorithmSimulator sim = 
//        				new AStarAlgorithmSimulator();
//        		sim.getPainter().setSize(400, 300);
//        		form2.addMyContainer(sim.getPainter());
//        		
//        		sim.setSimulating(true);
//        		sim.run();
//        	}
//        };        
//        thread2.start();
    }
}
