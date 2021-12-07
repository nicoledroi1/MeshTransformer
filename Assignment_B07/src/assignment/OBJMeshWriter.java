package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class OBJMeshWriter implements MeshWriter{

	@Override
	public void write(String fileName, HashSet<Polygon> polygons) throws IOException {
		ArrayList<String> faces = new ArrayList<String>();
		int line_num = 0;
		FileWriter writer = new FileWriter(fileName, true);
		 
		for(Polygon polygon:polygons) {
			LinkedHashSet<Vertex> vertices = polygon.vertices;
			String face = "f";
			
			for(Vertex vertice: vertices) {
				int vertice_lineNum = dupeNum(fileName, vertice);
				
				if(vertice_lineNum == -1) {
					line_num++;
					String new_vertice = "v " + vertice.x + " " + vertice.y + " " + vertice.z;
					writer.write(new_vertice + "\n");
					face += " " + line_num;
				}//end if
				else {
					face += " " + vertice_lineNum;
				}//end else
				
			}//end for
			
			faces.add(face);
		}//end for
		
		for(String face:faces) {
			writer.write(face + "\n");
		}//end for
		
		writer.close();
	}//end write
	
	public int dupeNum(String fileName, Vertex vertice) throws FileNotFoundException { //return -1 if not dupe //return the line number if it's already in there
		int lineNum = 0;
		File curr_file = new File(fileName);
		Scanner scan = new Scanner(curr_file);
		
		while(scan.hasNextLine()) {
			lineNum++;
			String curr_vertice[] = scan.nextLine().split(" ");
			
			if(Double.parseDouble(curr_vertice[1]) == vertice.x && Double.parseDouble(curr_vertice[2]) == vertice.y && Double.parseDouble(curr_vertice[3]) == vertice.z) {
				scan.close();
				return lineNum;
			}//end if
			
		}//end while
		
		scan.close();
		return -1;
	}//end isDupe
	
}//end OBJMeshReader
