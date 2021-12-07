package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OBJMeshReader implements MeshReader{

	@Override
	public HashSet<Polygon> read(String fileName) throws FileNotFoundException {
		HashSet<Polygon> polygons = new HashSet<Polygon>(); 
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
		List<String> line_list = new ArrayList<String>();
		
		File curr_file = new File(fileName);
		Scanner scan = new Scanner(curr_file);
		
		if(curr_file.exists() && curr_file.isDirectory()) {
			
			while(scan.hasNextLine()) {
				line_list.add(scan.nextLine());
			}//end while
			
			String file_arr[] = line_list.toArray(new String[0]);
			
			for(String line:line_list) {
				
				String vert_index[] = line.split(" ");
				if(vert_index[0] == "f") {
					
					for(int i = 1; i < vert_index.length; i++) {
						
						int index = Integer.parseInt(vert_index[i]);
						String curr_vertice[] = file_arr[index - 1].split(" ");
						
						Vertex new_vertice = new Vertex(Double.parseDouble(curr_vertice[1]), Double.parseDouble(curr_vertice[2]), Double.parseDouble(curr_vertice[3]));
						vertices.add(new_vertice);
						
					}//end for loop
					
					Polygon curr_polygon = new Polygon(vertices); //need HashSet of vertexes
					polygons.add(curr_polygon);
				}//end if statement
				
			}//end for
			
		}//end if
		
		scan.close();
		return polygons;
	}//end read
	
}//end OBJMeshReader