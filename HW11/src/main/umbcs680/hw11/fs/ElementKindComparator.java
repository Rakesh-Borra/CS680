package umbcs680.hw11.fs;

import java.util.Comparator;

public class ElementKindComparator  implements Comparator<FSElement> {

	@Override
	public int compare(FSElement o1, FSElement o2) {
		return getPriority(o1)-getPriority(o2);
	}

	private int getPriority(FSElement o) {

        if (o.isDirectory()){
            return 0; 
        } else if (o.isFile()){
            return 1; 
        } else if(o.isLink()){
            return 2; 
        } else{
            return 3; 
        }
    }
}
