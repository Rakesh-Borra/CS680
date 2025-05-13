package umbcs680.hw14.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import umbcs680.hw14.fs.Directory;
import umbcs680.hw14.fs.File;
import umbcs680.hw14.fs.FileSystem;
import umbcs680.hw14.fs.TestFixtureInitializer;
import umbcs680.hw14.util.CountingVisitor;
import umbcs680.hw14.util.FileCrawlingVisitor;
import umbcs680.hw14.util.FileSearchVisitor;

class FSVisitorTest {

	private static FileSystem fs;

	@BeforeAll
    public static void setUpFS(){
		FileSystem.resetFileSystem();
        fs = TestFixtureInitializer.createFS();

    }


	@Test
	void FileSearchVisitorTest(){
		FileSearchVisitor visitor= new FileSearchVisitor("A.java");
		Directory root = fs.getRootDirs().get(0);
		root.accept( visitor );
		 assertEquals(1, visitor.getFoundFiles().size());

	}
	
	@Test
	void CountingVisitorTest(){

		CountingVisitor visitor = new CountingVisitor(); 
		Directory root = fs.getRootDirs().get(0);
		root.accept( visitor );
		assertEquals(3, visitor.getDirectories_counter() );
		assertEquals(4, visitor.getFiles_counter() );
		assertEquals(1, visitor.getLinks_counter() );

	}
	
	@Test
	void FileCrawlingVisitorTest(){

		FileCrawlingVisitor visitor = new FileCrawlingVisitor(); 
		Directory root = fs.getRootDirs().get(0);
		root.accept( visitor );
		LinkedList<File> collectedFiles = visitor.getFiles();
		String[] actualFileNames = new String[collectedFiles.size()];

	    for (int i = 0; i < collectedFiles.size(); i++) {
	        actualFileNames[i] = collectedFiles.get(i).getName();
	    }

	    String[] expectedFileNames = {"build.xml", "A.java", "B.java", "readme.md"};
	    assertEquals(4, collectedFiles.size());
	    assertArrayEquals(expectedFileNames, actualFileNames);

	}
	
	

}