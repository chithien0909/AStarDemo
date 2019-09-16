
public class AStar {
	
	static ShowForm form = null;

//    public void clearPath () {
//    	
//    }
    
    public static void main (String[] args){     
//        long time = System.currentTimeMillis();        
        form = new ShowForm("Algorithm Simulate", 800, 600);
        form.setVisible(true);
//        setPath();
        
        Thread thread = new Thread() {
        	public void run () {
        		AStarAlgorithmSimulator sim = 
        				new AStarAlgorithmSimulator();
        		form.addMyContainer(sim.getPainter());
        		sim.setSimulating(true);
        		sim.run();
        	}
        };        
        thread.start();      
    }
}
