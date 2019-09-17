import java.awt.Dimension;

public class Main {
	
	static ShowForm form = null;

//    public void clearPath () {
//    	
//    }
    
    public static void main (String[] args){     
//        long time = System.currentTimeMillis();        
//        form = new ShowForm("Algorithm Simulate", 800, 600);
//        form.setVisible(true);
//        setPath();
    	
    	ShowForm form1 = new ShowForm ("Path finding comparator	 ", 800, 600);    	
    	form1.setVisible(true);
    	AlgorithmSimulator 
    		astar = 
				new AStarAlgorithmSimulator(),
			dijkstra =
				new DijkstraAlgorithmSimulator(),
			greedy =
				new GreedySimulator();
    	
    	
    	
    	form1.addMyContainer(astar.getPainter());
    	form1.addMyContainer(dijkstra.getPainter());
    	form1.addMyContainer(greedy.getPainter());
    	
    	astar.init();
    	dijkstra.init();
    	greedy.init();
    	    	
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
             
        thread1.start();
        thread2.start();
        thread3.start();
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