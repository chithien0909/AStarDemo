import javax.swing.SwingUtilities;

public abstract class AlgorithmSimulator {
	
	private MyContainer painter = null;
	private boolean isSimulating = false;
	
	public AlgorithmSimulator () {				
		painter = new MyContainer ();			
	}
	
	public MyContainer getPainter () {
		return painter;
	}
	
	public void setContent (int[][] content) {
		getPainter ().setContent(content);
	}
	
	public void simulate () throws Exception{
		if (!isSimulating) return; 
		Thread.sleep(5);
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				painter.repaint();
			}
		});
	}
	
	public void setSimulating (boolean is) {
		isSimulating = is;
	}
	
	abstract public void run ();
}
