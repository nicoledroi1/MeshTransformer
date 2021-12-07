package assignment;

public class Vertex extends GraphicalObject{
	
	double x,y,z;
	
	public Vertex(double xcor, double ycor, double zcor) {
		x = xcor;
		y = ycor;
		z = zcor;
	}//end constructor Vertex
	
	@Override
	public int hashCode() {
		return Integer.parseInt(String.valueOf((int)x) + String.valueOf((int)y) + String.valueOf((int)z));  
	}//end hashCode
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex)obj;
		if(other.x == this.x && other.y == this.y && other.z == this.z) { 
			return true;
		}//end if
		else {
			return false;
		}//end else
	}//end equals
	
	@Override
	public String toString() {
		return "x: " + this.x + ", y: " + " " + this.y + ", z: " + " " + this.z;
	}//end toString
	
	@Override
	public void transform(double matrix[][]) {
		double temp_x = x, temp_y = y, temp_z = z;
		x = temp_x*matrix[0][0] + temp_y*matrix[0][1] + temp_z*matrix[0][2]; //transform the x coor
		y = temp_x*matrix[1][0] + temp_y*matrix[1][1] + temp_z*matrix[1][2]; //transform the y coor
		z = temp_x*matrix[2][0] + temp_y*matrix[2][1] + temp_z*matrix[2][2]; //transform the z coor
	}//end transform

}//end class Vertex
