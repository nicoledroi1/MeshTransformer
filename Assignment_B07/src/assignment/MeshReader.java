package assignment;

import java.io.FileNotFoundException;
import java.util.HashSet;

public interface MeshReader {
	
	public abstract HashSet<Polygon> read(String fileName) throws FileNotFoundException;

}//end interface MeshReader
