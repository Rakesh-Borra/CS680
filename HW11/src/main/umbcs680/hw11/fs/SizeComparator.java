package umbcs680.hw11.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {

	@Override
	public int compare(FSElement o1, FSElement o2) {
		return Integer.compare(o1.getSize(), o2.getSize());
	}

}