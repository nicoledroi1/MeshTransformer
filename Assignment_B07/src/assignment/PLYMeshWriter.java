package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class PLYMeshWriter implements MeshWriter{

	@Override
	public void write(String fileName, HashSet<Polygon> polygons) throws IOException {
		FileWriter writer = new FileWriter(fileName, true);
		ArrayList<String> faces = new ArrayList<String>();
		ArrayList<String> vertex = new ArrayList<String>();
		int line_num = 0, num_vertex = 0, num_face = 0;
		
		for(Polygon polygon:polygons) {
			num_face++;
			LinkedHashSet<Vertex> vertices = polygon.vertices;
			String face = null, temp_face = null;
			int numVer = 0;
			
			for(Vertex vertice:vertices) {
				int verticeLineNum = dupeNum(vertices,vertice);
				
				if(verticeLineNum == -1) {
					String new_vertice = vertice.x + " " + vertice.y + " " + vertice.z;
					vertex.add(new_vertice);
					temp_face += " " + line_num;
					line_num++;
					num_vertex++;
				}//end if
				else {
					temp_face+= " " + verticeLineNum;
				}//end else
				
				numVer++;
			}//end for loop
			
			face = numVer + temp_face;
			faces.add(face);
			num_face++;
		}//end for
		
		writer.write("ply\nformat ascii 1.0\nelement vertex " + num_vertex + "\nproperty float32 "
				+ "x\nproperty float32 y\nproperty float32 z\n element face " + num_face + "\n"
						+ "property list uint8 int32 vertex_indices\nend_header");
		
		for(String vertice:vertex) {
			writer.write(vertice);
		}//end for
		
		for(String face:faces) {
			writer.write(face);
		}//end for
		
		writer.close();
	}//end write

	public int dupeNum(LinkedHashSet<Vertex> vertices , Vertex vertice) throws FileNotFoundException { //return -1 if not dupe //return the line number if it's already in there
		int lineNum = 0;
		
		for(Vertex v:vertices) {
			if(v.x == vertice.x && v.y == vertice.y && v.z == vertice.z) {
				return lineNum;
			}//end if
			
			lineNum++;
		}//end for

		return -1;
	}//end isDupe
	
}//end PLYMeshWriter
