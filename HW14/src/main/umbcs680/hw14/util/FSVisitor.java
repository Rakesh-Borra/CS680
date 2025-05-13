package umbcs680.hw14.util;

import umbcs680.hw14.fs.Directory;
import umbcs680.hw14.fs.File;
import umbcs680.hw14.fs.Link;

public interface FSVisitor {
	
	public void visit(Link link);  
	public void visit(Directory dir); 
	public void visit(File file);

}