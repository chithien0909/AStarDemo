
public class PairII implements Comparable {
	public int first, second;
	
	public PairII () {
		first = second = 0;
	}
	
	public PairII (int k, int v) {
		first = k;
		second = v;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		PairII obj = (PairII) o;
		if (first < obj.first) 
			return -1;
		if (first > obj.first)
			return 1;
		if (second > obj.second)
			return 1;
		if (second < obj.second)
			return -1;
		return 0;
	}
}
