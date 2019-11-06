import java.util.TreeSet;

public class Test {
	public static void main (String[] args) {
		TreeSet<PairII> set = new TreeSet<> ();
		set.add(new PairII (4, 9));
		set.add(new PairII (5, 4));
		set.add(new PairII (1, 1));
		set.add(new PairII (2, 100));
		
		System.out.println(set.first());
		set.remove(new PairII (1, 1));
		System.out.println(set.first());
	}
}
