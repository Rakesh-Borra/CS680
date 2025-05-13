package umbcs680.hw16.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import umbcs680.hw16.util.FSVisitor;

public class Directory extends FSElement{
	
	private LinkedList<FSElement> children;
	private Directory parent;
	private static Comparator<FSElement> comparator;


	public Directory(Directory parent,String name, int size, LocalDateTime creationTime) {
		super(parent,name, size, creationTime);
		children=new LinkedList<FSElement>();
		comparator=(FSElement o1, FSElement o2)->o1.getName().compareTo(o2.getName());
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
		return getChildren(comparator);
	}
	
	public void appendChild(FSElement child) {

		this.children.add(child);
		child.setParent(this);
		Collections.sort(children, comparator);

	}
	
	public int countChildren() {
		return children.size();
	}


	public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator){

		LinkedList<Directory> subDirectories=new LinkedList<Directory>();
		children.forEach(element ->{
            if (element.isDirectory())subDirectories.add((Directory)element);
        });
		LinkedList<Directory> sortedSubDirectories = new LinkedList<>(subDirectories);
		Collections.sort(sortedSubDirectories, comparator);
		return sortedSubDirectories;
	}
	
	public LinkedList<Directory> getSubDirectories() {
		return getSubDirectories(comparator);
	}
	
	public LinkedList<File> getFiles(Comparator<FSElement> comparator){

		LinkedList<File> files=new LinkedList<File>();
		children.forEach(element ->{
            if (element.isFile())files.add((File)element);
        });
		LinkedList<File> sortedFiles = new LinkedList<>(files);
		Collections.sort(sortedFiles, comparator);
		return sortedFiles;

	}
	
	public LinkedList<File> getFiles(){
		return getFiles(comparator);
	}
	
	public LinkedList<Link> getLinks(Comparator<FSElement> comparator){

		LinkedList<Link> links=new LinkedList<Link>();
		children.forEach(element ->{
            if (element.isLink())links.add((Link)element);
        });
		LinkedList<Link> sortedLinks = new LinkedList<>(links);
		Collections.sort(sortedLinks, comparator);
		return sortedLinks;
		
	}
	public LinkedList<Link> getLinks(){
		return getLinks(comparator); 
	}
	
	public int getTotalSize(){

		final int[] totalSize = {this.getSize()};
		children.forEach(element -> {
            if(element.isDirectory())totalSize[0]+=((Directory)element).getTotalSize();
            else totalSize[0]+=element.getSize();
        });
		return totalSize[0];
	}

	@Override
	public void accept(FSVisitor v) {
		v.visit(this);
        children.forEach(element -> element.accept(v));
		
	}

	

	
}