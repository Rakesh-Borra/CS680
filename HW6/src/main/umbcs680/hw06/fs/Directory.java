package umbcs680.hw06.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
	
	private LinkedList<FSElement> children;
	private Directory parent;
	

	public Directory(Directory parent,String name, int size, LocalDateTime creationTime) {
		super(parent,name, size, creationTime);
		children=new LinkedList<FSElement>();
	}

	@Override
	public boolean isDirectory() {
		return true;
	}
	
	
	public LinkedList<FSElement> getChildren(){
		return children;
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return children.size();
	}
	
	public LinkedList<Directory> getSubDirectories() {

		LinkedList<Directory> subDirectories=new LinkedList<Directory>();
		for(FSElement element:  children) {
			if(element.isDirectory()) {
				subDirectories.add((Directory)element);
			}
		}
		return subDirectories;
	}


	public LinkedList<File> getFiles(){

		LinkedList<File> files=new LinkedList<File>();
		for(FSElement element: children) {
			if(!element.isDirectory()) {
				files.add((File)element);
			}
		}
		return files; 
	}
	
	public int getTotalSize() {

		int totalSize=this.getSize();
		for(FSElement element: children) {
			if(element.isDirectory()) totalSize+=((Directory)element).getTotalSize();
			else totalSize+=element.getSize();
		}
		return totalSize;
	}

}
