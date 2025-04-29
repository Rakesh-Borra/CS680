package umbcs680.hw08.util;

import java.util.LinkedList;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.Link;

public class FileCrawlingVisitor implements FSVisitor{
	private LinkedList<File> files;
	
	FileCrawlingVisitor(){
		files=new LinkedList<File>();
	}
	

	public LinkedList<File> getFiles() {
		return files;
	}

	

	@Override
	public void visit(Link link) {
		return;
	}

	@Override
	public void visit(Directory dir) {
		return;
	}

	@Override
	public void visit(File file) {
		files.add(file);
	}

}
