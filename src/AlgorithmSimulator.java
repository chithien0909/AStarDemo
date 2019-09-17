import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public abstract class AlgorithmSimulator {
	
	private MyContainer painter = null;
	private boolean isSimulating = false;
	private int defaultSleepTime = 4;
	
	public AlgorithmSimulator () {				
		painter = new MyContainer ();			
	}
	
	public MyContainer getPainter () {
		return painter;
	}
	
	public void setContent (int[][] content) {
		getPainter ().setContent(content);
	}
	
	public int getDefaultSleepTime () {
		return defaultSleepTime;
	}
	
	public void log (String lg) {
		
		final String __lg = lg;
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JLabel lab = getPainter ().getLogger();
				if (lab == null) 
					return;
				lab.setText(__lg);				
			}
		});		
	}
	
	public void setDefaultSleepTime (int ms) {
		defaultSleepTime = ms;
	}
	public void simulate () throws Exception{
		if (!isSimulating) return; 
		Thread.sleep(defaultSleepTime);
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
	
//	abstract public void init ();
	abstract public void run ();
}
