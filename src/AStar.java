
public class AStar {
	
	static ShowForm form = null;

//    public void clearPath () {
//    	
//    }
    
    public static void main (String[] args){     
//        long time = System.currentTimeMillis();        
//        form = new ShowForm("Algorithm Simulate", 800, 600);
//        form.setVisible(true);
//        setPath();        
    	ShowForm form1 = new ShowForm ("Dijkstra", 800, 600);
    	form1.setVisible(true);
        Thread thread1 = new Thread() {
        	public void run () {
        		DijkstraAlgorithmSimulator sim = 
        				new DijkstraAlgorithmSimulator();
        		form1.addMyContainer(sim.getPainter());
        		sim.setSimulating(true);
        		sim.run();
        	}
        };      
        
        thread1.start();      
        
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
