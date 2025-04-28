package umbcs680.hw07.fs;

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
	
	@Override
	public boolean isFile() {
		return false;
	}

	@Override
	public boolean isLink() {
		return false;
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
			if(element.isFile()) {
				files.add((File)element);
			}
		}
		return files; 
	}
	
	public LinkedList<Link> getLinks(){
		LinkedList<Link> links=new LinkedList<Link>();
		for(FSElement element: children) {
			if(element.isLink()) {
				links.add((Link)element);
			}
		}
		return links; 
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
