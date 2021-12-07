package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class PLYMeshReader implements MeshReader{

	@Override
	public HashSet<Polygon> read(String fileName) throws FileNotFoundException {
		HashSet<Polygon> polygons = new HashSet<Polygon>();
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
		List<String> line_list = new ArrayList<String>();
		int num_vertex;
		
		File curr_file = new File(fileName);
		Scanner scan = new Scanner(curr_file);
		
		if(curr_file.exists() && curr_file.isDirectory()) {
			
			while(scan.hasNextLine()) {
				line_list.add(scan.nextLine());
			}//end while
			
			String file_arr[] = line_list.toArray(new String[0]);
			num_vertex = Integer.parseInt(file_arr[2].split(" ")[2]);
			
			for(int j = 9 + num_vertex; j < file_arr.length; j++) {
				String face[] = file_arr[j].split(" ");
				
				for(int l = 0; l < Integer.parseInt(face[0]); l++) {
					String curr_vertice[] = file_arr[9 + Integer.parseInt(face[l])].split(" ");
					
					Vertex new_vertice = new Vertex(Double.parseDouble(curr_vertice[0]), Double.parseDouble(curr_vertice[1]), Double.parseDouble(curr_vertice[2]));
					vertices.add(new_vertice);
				}//end for
				
				Polygon curr_polygon = new Polygon(vertices); //need HashSet of vertexes
				polygons.add(curr_polygon);
			}//end for
			
		}//end if
		
		scan.close();
		return polygons;
	}//end read

}//end PLYMeshReader