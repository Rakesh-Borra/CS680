package umbcs680.hw11.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import umbcs680.hw11.util.FSVisitor;

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


	public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator){

		LinkedList<FSElement> sortedChildren = new LinkedList<>(children);
		Collections.sort(sortedChildren, comparator);
		return sortedChildren;
				
	}
	
	
	public LinkedList<FSElement> getChildren(){
		return getChildren(new AlphabeticalComparator());
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
		child.setParent(this);
		Collections.sort(children, new AlphabeticalComparator() );
	}
	
	public int countChildren() {
		return children.size();
	}
	
	public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {

		LinkedList<Directory> subDirectories=new LinkedList<Directory>();
		for(FSElement element:  children) {
			if(element.isDirectory()) {
				subDirectories.add((Directory)element);
			}
		}

		LinkedList<Directory> sortedSubDirectories = new LinkedList<>(subDirectories);
		Collections.sort(sortedSubDirectories, comparator);
		return sortedSubDirectories;
	}
	
	public LinkedList<Directory> getSubDirectories() {
		return getSubDirectories(new AlphabeticalComparator());
	}


	public LinkedList<File> getFiles(Comparator<FSElement> comparator){

		LinkedList<File> files=new LinkedList<File>();
		for(FSElement element: children) {
			if(element.isFile()) {
				files.add((File)element);
			}
		}
		LinkedList<File> sortedFiles = new LinkedList<>(files);
		Collections.sort(sortedFiles, comparator);
		return sortedFiles;
	}
	
	public LinkedList<File> getFiles(){
		return getFiles(new AlphabeticalComparator());
	}
	
	public LinkedList<Link> getLinks(Comparator<FSElement> comparator){

		LinkedList<Link> links=new LinkedList<Link>();
		for(FSElement element: children) {
			if(element.isLink()) {
				links.add((Link)element);
			}
		}

		LinkedList<Link> sortedLinks = new LinkedList<>(links);
		Collections.sort(sortedLinks, comparator);
		return sortedLinks;
		
	}
	public LinkedList<Link> getLinks(){
		return getLinks(new AlphabeticalComparator()); 
	}
	
	public int getTotalSize() {

		int totalSize=this.getSize();
		for(FSElement element: children) {
			if(element.isDirectory()) totalSize+=((Directory)element).getTotalSize();
			else totalSize+=element.getSize();
		}
		return totalSize;
	}


	@Override
	public void accept(FSVisitor v) {
		v.visit(this);
        for(FSElement e: children){
          e.accept(v); 
         }
		
	}

	

	
}
