package assignment;

import java.util.LinkedHashSet;

public class Polygon extends GraphicalObject{
	LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
	
	public Polygon(LinkedHashSet<Vertex> v) {
		vertices = v;
	}//end constructor Polygon

	@Override
	public void transform(double matrix[][]) {
		
		for(Vertex vertice:vertices) {
			vertice.transform(matrix);
		}//end for
		
	}//end transform
	
	@Override
	public int hashCode() {
		int hashCode = 0;
		for(Vertex vertex: vertices) {
			hashCode += 1 + vertex.hashCode();
		}//end for
		return hashCode;
	}//end hashCode
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Polygon other = (Polygon)obj;
		if(other.vertices.toArray().length != vertices.toArray().length) {
			return false;
		}//end if
		int in = 0;
		for(Vertex vertice_o:other.vertices) {
			for(Vertex vertice_cur:vertices) {
				if(vertice_cur.equals(vertice_o)) {
					in++;
				}//end if
			}//end for
		}//end for
		if(in == vertices.toArray().length) {
			return true;
		}//end if
		return false;
	}//end equals
	
	
}//end class Polygon
