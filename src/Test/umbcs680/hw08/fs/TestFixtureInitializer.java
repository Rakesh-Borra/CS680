package umbcs680.hw08.fs;

import java.time.LocalDateTime;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.File;
import umbcs680.hw08.fs.FileSystem;
import umbcs680.hw08.fs.Link;

public class TestFixtureInitializer {
	
	public static FileSystem createFS() {
		FileSystem fs=FileSystem.getFileSystem();
		Directory umbcs680=new Directory(null,"umbcs680",0,LocalDateTime.of(2025, 12, 12, 0, 0));
		Directory hw01=new Directory(umbcs680,"hw01",0,LocalDateTime.of(2025, 12, 12, 0, 0));
		Directory src=new Directory(hw01,"src",0,LocalDateTime.of(2025, 12, 12, 0, 0));
		File aJava=new File(src,"A.java",1,LocalDateTime.of(2025, 12, 12, 0, 0));
		File bJava=new File(src,"B.java",3,LocalDateTime.of(2025, 12, 12, 0, 0));
		File buildXml=new File(hw01,"build.xml",4,LocalDateTime.of(2025, 12, 12, 0, 0));
		File readmeMd=new File(umbcs680,"readme.md",2,LocalDateTime.of(2025, 12, 12, 0, 0));
		Link rmMdLink=new Link(hw01,"rm.md:Link",0,LocalDateTime.of(2025, 12, 12, 0, 0),readmeMd);
		
		src.appendChild(aJava);
        src.appendChild(bJava);

        hw01.appendChild(src);
        hw01.appendChild(buildXml);
        hw01.appendChild(rmMdLink);
        umbcs680.appendChild(hw01);
        umbcs680.appendChild(readmeMd);
        fs.appendRootDir(umbcs680);
		
		return fs;
		
	}

}
