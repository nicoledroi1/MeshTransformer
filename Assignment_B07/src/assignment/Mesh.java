package assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class Mesh extends GraphicalObject{

	HashSet<Polygon> polygons = new HashSet<Polygon>();
	MeshReader reader;
	MeshWriter writer;
	
	public void setReader(MeshReader mR) {
		this.reader = mR;
	}//end setReader
	
	public void setWriter(MeshWriter mW) {
		this.writer = mW;
	}//end setReader
	
	public void readFromFile(String fileName) throws FileNotFoundException {
		if(fileName.charAt(fileName.length()-1) == 'j') {
			OBJMeshReader read = new OBJMeshReader();
			setReader(read);
			reader.read(fileName);
		}//end if
		else {
			PLYMeshReader read = new PLYMeshReader();
			setReader(read);
			reader.read(fileName);
		}//end else
	}//end readFromFile
	
	public void writeToFile(String fileName) throws IOException {
		if(fileName.charAt(fileName.length()-1) == 'j') {
			OBJMeshWriter write = new OBJMeshWriter();
			setWriter(write);
			writer.write(fileName, polygons);
		}//end if
		else {
			PLYMeshWriter write = new PLYMeshWriter();
			setWriter(write);
			writer.write(fileName, polygons);
		}//end else
	}//end writeToFile

	@Override
	public void transform(double matrix[][]) {
		
		for(Polygon polygon: polygons) {
			polygon.transform(matrix);
		}//end for
		
	}//end transform
	
	@Override
	public int hashCode() {
		int hashCode = 0;
		for(Polygon polygon:polygons) {
			 hashCode += polygon.hashCode() + 1;
		}//end 
		return hashCode;
	}//end hashCode
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Mesh other = (Mesh)obj;
		if(other.polygons.toArray().length != polygons.toArray().length) {
			return false;
		}//end if
		int in = 0;
		for(Polygon polygon_cur:polygons) {
			for(Polygon polygon_o:other.polygons) {
				if(polygon_cur.equals(polygon_o)){
					in++;
				}//end if
			}//end for
		}//end for
		if(in == polygons.toArray().length) {
			return true;
		}//end if 
		return false;
	}//end equals
	
}//end Mesh
