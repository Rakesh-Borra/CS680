package umbcs680.hw14.fs;

import java.time.LocalDateTime;

import umbcs680.hw14.util.FSVisitor;

public class File extends FSElement {

	public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent,name, size, creationTime);
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public boolean isFile() {
		return true;
	}

	@Override
	public boolean isLink() {
		return false;
	}

	@Override
	public void accept(FSVisitor v) {
		v.visit(this);
	}
}
