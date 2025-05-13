package umbcs680.hw16.util;

import umbcs680.hw16.fs.Directory;
import umbcs680.hw16.fs.File;
import umbcs680.hw16.fs.Link;

public interface FSVisitor {
	
	public void visit(Link link);  
	public void visit(Directory dir); 
	public void visit(File file);

}
