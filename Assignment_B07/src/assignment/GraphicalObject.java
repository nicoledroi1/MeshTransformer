package assignment;

public abstract class GraphicalObject {
	
	double matrix[][] = new double[3][3];
	
	public abstract void transform(double matrix[][]);
	
	public void rotateXAxis(double angle) {
		matrix[0][0] = 1;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = Math.cos(angle);
		matrix[1][2] = -Math.sin(angle);
		matrix[2][0] = 0;
		matrix[2][1] = Math.sin(angle);
		matrix[2][2] = Math.cos(angle);
		
		this.transform(matrix); 
		//not sure it this is correct
	}//end rotateXAxis
	
	public void rotateYAxis(double angle) {
		matrix[0][0] = Math.cos(angle);
		matrix[0][1] = 0;
		matrix[0][2] = Math.sin(angle);
		matrix[1][0] = 0;
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		matrix[2][0] = -Math.sin(angle);
		matrix[2][1] = 0;
		matrix[2][2] = Math.cos(angle);
		
		this.transform(matrix); 
	}//end rotateYAxis
	
	public void rotateZAxis(double angle) {
		matrix[0][0] = Math.cos(angle);
		matrix[0][1] = -Math.sin(angle);
		matrix[0][2] = 0;
		matrix[1][0] = Math.sin(angle);
		matrix[1][1] = Math.cos(angle);
		matrix[1][2] = 0;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 1;
		
		this.transform(matrix); 
	}//end rotateZAxis

}//end GraphicalObject
