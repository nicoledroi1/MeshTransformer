package assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;

class Assignment_tester {

	//////////////////////////// VERTEX ////////////////////////////
	
	double matrix[][] = new double[3][3];
	
	//hashCode
	
	@Test
	void testV_hashcode0() {
		Vertex v = new Vertex(0,0,0);
		assertEquals(v.hashCode(), 0);
	}//test_code0
	
	@Test
	void testV_hashcode1() {
		Vertex v = new Vertex(1,0,0);
		assertEquals(v.hashCode(), 100);
	}//test_code1
	
	@Test
	void testV_hashcode2() {
		Vertex v = new Vertex(0,1,0);
		assertEquals(v.hashCode(), 10);
	}//test_code2
	
	@Test
	void testV_hashcode3() {
		Vertex v = new Vertex(0,0,1);
		assertEquals(v.hashCode(), 1);
	}//test_code3
	
	@Test
	void testV_hashcode4() {
		Vertex v = new Vertex(1,2,3);
		assertEquals(v.hashCode(), 123);
	}//test_code4
	
	//equals
	
	@Test
	void testV_equals0() {
		//test the null section
		Vertex v = new Vertex(0,0,0);
		assertEquals(v.equals(null), false);
	}//test_equals0
	
	@Test
	void testV_equals1() {
		//test different classes
		Vertex v = new Vertex(1,0,0);
		Object obj = new Object();
		assertEquals(v.equals(obj), false);
	}//test_equals1
	
	@Test
	void testV_equals2() {
		//test when they're the same
		Vertex v1 = new Vertex(0,1,0);
		Vertex v2 = new Vertex(0,1,0);
		assertEquals(v1.equals(v2), true);
	}//test_equals2
	
	@Test
	void testV_equals3() {
		//test same class but different coordinates
		Vertex v1 = new Vertex(0,0,1);
		Vertex v2 = new Vertex(0,0,0);
		assertEquals(v1.equals(v2), false);
	}//test_equals3
	
	//toString
	
	@Test
	void testV_toString0() {
		Vertex v = new Vertex(0,0,0);
		assertEquals(v.toString(), "x: 0.0, y: 0.0, z: 0.0");
	}//test_toString0
	
	@Test
	void testV_toString1() {
		Vertex v = new Vertex(1,2,30);
		assertEquals(v.toString(), "x: 1.0, y: 2.0, z: 30.0");
	}//test_toString1
	
	@Test
	void testV_toString2() {
		Vertex v = new Vertex(1.51,10.5,0.2);
		assertEquals(v.toString(), "x: 1.51, y: 10.5, z: 0.2");
	}//test_toString2
	
	//transform
	
	@Test
	void testV_transform0() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Vertex v = new Vertex(0,0,0);
		v.transform(matrix);
		assertEquals(v.x, 0);
		assertEquals(v.y, 0);
		assertEquals(v.z, 0);
	}//end test_transform0
	
	@Test
	void testV_transform1() {
		matrix[0][0] = 0;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = 0;
		matrix[1][2] = 0;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 0;
		
		Vertex v = new Vertex(1,2,3);
		v.transform(matrix);
		assertEquals(v.x, 0);
		assertEquals(v.y, 0);
		assertEquals(v.z, 0);
	}//end test_transform1
	
	@Test
	void testV_transform2() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Vertex v = new Vertex(1,0,0);
		v.transform(matrix);
		assertEquals(v.x, 1);
		assertEquals(v.y, 4);
		assertEquals(v.z, 7);
	}//end test_transform2
	
	@Test
	void testV_transform3() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Vertex v = new Vertex(0,1,0);
		v.transform(matrix);
		assertEquals(v.x, 2);
		assertEquals(v.y, 5);
		assertEquals(v.z, 8);
	}//end test_transform3
	
	@Test
	void testV_transform4() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Vertex v = new Vertex(0,0,1);
		v.transform(matrix);
		assertEquals(v.x, 3);
		assertEquals(v.y, 6);
		assertEquals(v.z, 9);
	}//end test_transform4
	
	@Test
	void testV_transform5() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Vertex v = new Vertex(1,1,1);
		v.transform(matrix);
		assertEquals(v.x, 6);
		assertEquals(v.y, 15);
		assertEquals(v.z, 24);
	}//end test_transform5
	
	@Test
	void testV_transform6() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Vertex v = new Vertex(2,3,7);
		v.transform(matrix);
		assertEquals(v.x, 29);
		assertEquals(v.y, 65);
		assertEquals(v.z, 101);
	}//end test_transform6
	
	//////////////////////////// Polygon ////////////////////////////
	
	LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
	LinkedHashSet<Vertex> vertices_test = new LinkedHashSet<Vertex>();
	LinkedHashSet<Vertex> vertices_test1 = new LinkedHashSet<Vertex>();
	
	//hashCode
	
	@Test
	void testP_hashcode0() {
		Polygon p = new Polygon(vertices);
		assertEquals(p.hashCode(), 0);
	}//test_code0
	
	@Test
	void testP_hashcode1() {
		Vertex v1 = new Vertex(0,0,0);
		vertices.add(v1);
		Polygon p = new Polygon(vertices);
		assertEquals(p.hashCode(), 1);
	}//test_code1
	
	@Test
	void testP_hashcode2() {
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);
		assertEquals(p.hashCode(), 2);
	}//test_code2
	
	@Test
	void testP_hashcode3() {
		Vertex v1 = new Vertex(1,0,0);
		Vertex v2 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);
		assertEquals(p.hashCode(), 102);
	}//test_code3
	
	@Test
	void testP_hashcode4() {
		Vertex v1 = new Vertex(1,0,0);
		Vertex v2 = new Vertex(0,1,0);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);
		assertEquals(p.hashCode(), 112);
	}//test_code4
	
	@Test
	void testP_hashcode5() {
		Vertex v1 = new Vertex(1,1,1);
		Vertex v2 = new Vertex(1,1,1);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);
		assertEquals(p.hashCode(), 224);
	}//test_code5
	
	@Test
	void testP_hashcode6() {
		Vertex v1 = new Vertex(1,0,1);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(2,3,4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		Polygon p = new Polygon(vertices);
		assertEquals(p.hashCode(), 348);
	}//test_code6
	
	//equals
	
	@Test 
	void testP_equals0() {
		//if obj is null
		Vertex v1 = new Vertex(1,0,1);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(2,3,4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		assertEquals(p.equals(null), false);
	}//end testP_equals
	
	@Test 
	void testP_equals1() {
		//if obj is from a different class
		Vertex v1 = new Vertex(1,0,1);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(2,3,4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		Object obj = new Object();
		assertEquals(p.equals(obj), false);
	}//end testP_equals1
	
	@Test 
	void testP_equals2() {
		//all different vertices
		Vertex v1 = new Vertex(1,0,1);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(2,3,4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		
		Vertex v1_test = new Vertex(0,0,0);
		Vertex v2_test = new Vertex(0,0,0);
		Vertex v3_test = new Vertex(0,0,0);
		vertices_test.add(v1_test);
		vertices_test.add(v2_test);
		vertices_test.add(v3_test);
		
		Polygon p2 = new Polygon(vertices_test);
		
		assertEquals(p1.equals(p2), false);
	}//end testP_equals2
	
	@Test 
	void testP_equals3() {
		//all different vertices
		Vertex v1 = new Vertex(1,0,1);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(2,3,4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		
		Vertex v1_test = new Vertex(0,0,0);
		Vertex v2_test = new Vertex(0,0,0);
		Vertex v3_test = new Vertex(0,0,0);
		vertices_test.add(v1_test);
		vertices_test.add(v2_test);
		vertices_test.add(v3_test);
		
		Polygon p2 = new Polygon(vertices_test);
		
		assertEquals(p1.equals(p2), false);
	}//end testP_equals3
	
	@Test 
	void testP_equals4() {
		//one different vertex
		Vertex v1 = new Vertex(1,0,1);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(2,3,4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		
		Vertex v1_test = new Vertex(1,0,1);
		Vertex v2_test = new Vertex(0,0,0);
		Vertex v3_test = new Vertex(0,0,0);
		vertices_test.add(v1_test);
		vertices_test.add(v2_test);
		vertices_test.add(v3_test);
		
		Polygon p2 = new Polygon(vertices_test);
		
		assertEquals(p1.equals(p2), false);
	}//end testP_equals4
	
	@Test 
	void testP_equals5() {
		//two different vertices
		Vertex v1 = new Vertex(1,0,1);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(2,3,4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		
		Vertex v1_test = new Vertex(1,0,1);
		Vertex v2_test = new Vertex(0,1,0);
		Vertex v3_test = new Vertex(0,0,0);
		vertices_test.add(v1_test);
		vertices_test.add(v2_test);
		vertices_test.add(v3_test);
		
		Polygon p2 = new Polygon(vertices_test);
		
		assertEquals(p1.equals(p2), false);
	}//end testP_equals5
	
	@Test 
	void testP_equals6() {
		//all the same
		Vertex v1 = new Vertex(1,0,1);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(2,3,4);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		
		Vertex v1_test = new Vertex(1,0,1);
		Vertex v2_test = new Vertex(0,1,0);
		Vertex v3_test = new Vertex(2,3,4);
		vertices_test.add(v1_test);
		vertices_test.add(v2_test);
		vertices_test.add(v3_test);
		
		Polygon p2 = new Polygon(vertices_test);
		
		assertEquals(p1.equals(p2), true);
	}//end testP_equals5
	
	//transform
	
	@Test
	void testP_transform0() {
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		p.transform(matrix);
		assertEquals(v1.x, 0);
		assertEquals(v1.y, 0);
		assertEquals(v1.z, 0);
		assertEquals(v2.x, 0);
		assertEquals(v2.y, 0);
		assertEquals(v2.z, 0);
		assertEquals(v3.x, 0);
		assertEquals(v3.y, 0);
		assertEquals(v3.z, 0);
	}//end testP_transform0
	
	@Test
	void testP_transform1() {
		Vertex v1 = new Vertex(1,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		p.transform(matrix);
		assertEquals(v1.x, 1);
		assertEquals(v1.y, 4);
		assertEquals(v1.z, 7);
		assertEquals(v2.x, 0);
		assertEquals(v2.y, 0);
		assertEquals(v2.z, 0);
		assertEquals(v3.x, 0);
		assertEquals(v3.y, 0);
		assertEquals(v3.z, 0);
	}//end testP_transform1
	
	@Test
	void testP_transform2() {
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		p.transform(matrix);
		assertEquals(v1.x, 0);
		assertEquals(v1.y, 0);
		assertEquals(v1.z, 0);
		assertEquals(v2.x, 2);
		assertEquals(v2.y, 5);
		assertEquals(v2.z, 8);
		assertEquals(v3.x, 0);
		assertEquals(v3.y, 0);
		assertEquals(v3.z, 0);
	}//end testP_transform1
	
	@Test
	void testP_transform3() {
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,1);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		p.transform(matrix);
		assertEquals(v1.x, 0);
		assertEquals(v1.y, 0);
		assertEquals(v1.z, 0);
		assertEquals(v2.x, 0);
		assertEquals(v2.y, 0);
		assertEquals(v2.z, 0);
		assertEquals(v3.x, 3);
		assertEquals(v3.y, 6);
		assertEquals(v3.z, 9);
	}//end testP_transform3
	
	@Test
	void testP_transform4() {
		Vertex v1 = new Vertex(0,1,0);
		Vertex v2 = new Vertex(0,0,1);
		Vertex v3 = new Vertex(1,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		p.transform(matrix);
		assertEquals(v1.x, 2);
		assertEquals(v1.y, 5);
		assertEquals(v1.z, 8);
		assertEquals(v2.x, 3);
		assertEquals(v2.y, 6);
		assertEquals(v2.z, 9);
		assertEquals(v3.x, 1);
		assertEquals(v3.y, 4);
		assertEquals(v3.z, 7);
	}//end testP_transform4
	
	@Test
	void testP_transform5() {
		Vertex v1 = new Vertex(1,1,1);
		Vertex v2 = new Vertex(1,0,1);
		Vertex v3 = new Vertex(0,1,1);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		p.transform(matrix);
		assertEquals(v1.x, 6);
		assertEquals(v1.y, 15);
		assertEquals(v1.z, 24);
		assertEquals(v2.x, 4);
		assertEquals(v2.y, 10);
		assertEquals(v2.z, 16);
		assertEquals(v3.x, 5);
		assertEquals(v3.y, 11);
		assertEquals(v3.z, 17);
	}//end testP_transform5
	
//////////////////////////// MESH ////////////////////////////
	
	
	//hashCode
	
	HashSet<Polygon> polygons = new HashSet<Polygon>();
	
	@Test
	void testM_hashCode0() {
		Mesh m = new Mesh();
		assertEquals(m.hashCode(), 0);
	}//end test_hashCode0
	
	@Test
	void testM_hashCode1() {
		polygons.clear();
		vertices.clear();
		
		Mesh m = new Mesh();
	
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		polygons.add(p);
		
		
		assertEquals(m.hashCode(), 4);
	}//end test_hashCode1
	
	@Test
	void testM_hashCode2() {
		polygons.clear();
		vertices.clear();
		vertices_test.clear();
		
		Mesh m = new Mesh();
	
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		polygons.add(p1);
		
		Vertex v4 = new Vertex(0,0,0);
		Vertex v5 = new Vertex(0,0,0);
		Vertex v6 = new Vertex(0,0,0);
		vertices_test.add(v1);
		vertices_test.add(v2);
		vertices_test.add(v3);
		
		Polygon p2 = new Polygon(vertices_test);
		polygons.add(p2);
		
		
		assertEquals(m.hashCode(), 8);
	}//end test_hashCode2
	
	@Test
	void testM_hashCode3() {
		polygons.clear();
		vertices.clear();
		vertices_test.clear();
		vertices_test1.clear();
		
		Mesh m = new Mesh();
	
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		polygons.add(p1);
		
		Vertex v4 = new Vertex(0,0,0);
		Vertex v5 = new Vertex(0,0,0);
		Vertex v6 = new Vertex(0,0,0);
		vertices_test.add(v1);
		vertices_test.add(v2);
		vertices_test.add(v3);
		
		Polygon p2 = new Polygon(vertices_test);
		polygons.add(p2);
		
		Vertex v7 = new Vertex(0,0,0);
		Vertex v8 = new Vertex(0,0,0);
		Vertex v9 = new Vertex(0,0,0);
		
		vertices_test1.add(v1);
		vertices_test1.add(v2);
		vertices_test1.add(v3);
		
		Polygon p3 = new Polygon(vertices_test1);
		polygons.add(p3);
		
		
		assertEquals(m.hashCode(), 12);
	}//end test_hashCode3
	
	@Test
	void testM_hashCode4() {
		polygons.clear();
		vertices.clear();
		vertices_test.clear();
		vertices_test1.clear();
		
		Mesh m = new Mesh();
	
		Vertex v1 = new Vertex(1,0,0);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(0,0,1);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p = new Polygon(vertices);
		polygons.add(p);
		
		assertEquals(m.hashCode(), 115);
	}//end test_hashCode4
	
	@Test
	void testM_hashCode5() {
		polygons.clear();
		vertices.clear();
		vertices_test.clear();
		vertices_test1.clear(); 
		
		Mesh m = new Mesh();
	
		Vertex v1 = new Vertex(0,1,0);
		Vertex v2 = new Vertex(1,1,0);
		Vertex v3 = new Vertex(0,0,1);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		polygons.add(p1);
		
		Vertex v4 = new Vertex(1,0,0);
		Vertex v5 = new Vertex(1,0,0);
		Vertex v6 = new Vertex(1,0,0);
		vertices_test.add(v1);
		vertices_test.add(v2);
		vertices_test.add(v3);
		
		Polygon p2 = new Polygon(vertices_test);
		polygons.add(p2);
		
		
		assertEquals(m.hashCode(), 429);
	}//end test_hashCode5
	
	@Test
	void testM_hashCode6() {
		polygons.clear();
		vertices.clear();
		vertices_test.clear();
		vertices_test1.clear(); 
		
		Mesh m = new Mesh();
	
		Vertex v1 = new Vertex(1,0,2);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(1,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		polygons.add(p1);
		
		Vertex v4 = new Vertex(3,3,0);
		Vertex v5 = new Vertex(0,2,0);
		Vertex v6 = new Vertex(0,0,5);
		vertices_test.add(v1);
		vertices_test.add(v2);
		vertices_test.add(v3);
		
		Polygon p2 = new Polygon(vertices_test);
		polygons.add(p2);
		
		Vertex v7 = new Vertex(4,0,1);
		Vertex v8 = new Vertex(0,3,2);
		Vertex v9 = new Vertex(6,0,3);
		vertices_test1.add(v1);
		vertices_test1.add(v2);
		vertices_test1.add(v3);
		
		Polygon p3 = new Polygon(vertices_test1);
		polygons.add(p3);
		
		
		assertEquals(m.hashCode(), 1615);
	}//end test_hashCode6
	
	//equals
	
	@Test
	void testM_equals0() {
		Mesh m = new Mesh();
		assertEquals(m.equals(null), false);
	}//end testM_equals0
	
	@Test
	void testM_equals1() {
		Mesh m = new Mesh();
		Object obj = new Object();
		assertEquals(m.equals(obj), false);
	}//end testM_equals1
	
	@Test
	void testM_equals2() {
		Mesh m1 = new Mesh();
		Polygon p = new Polygon(vertices);
		m1.polygons.add(p);
		
		Mesh m2 = new Mesh();
		assertEquals(m2.equals(m1), false);
	}//end testM_equals2
	
	@Test
	void testM_equals3() {
		Mesh m1 = new Mesh();
		Vertex v = new Vertex(0,0,0);
		vertices.add(v);
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		
		Mesh m2 = new Mesh();
		Polygon p2 = new Polygon(vertices_test);
		assertEquals(m2.equals(m1), false);
	}//end testM_equals3
	
	@Test
	void testM_equals4() {
		Mesh m1 = new Mesh();
		Vertex v1 = new Vertex(0,0,0);
		vertices.add(v1);
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		
		Mesh m2 = new Mesh();
		Vertex v2 = new Vertex(1,1,1);
		vertices_test.add(v2);
		Polygon p2 = new Polygon(vertices_test);
		assertEquals(m2.equals(m1), false);
	}//end testM_equals3
	
	@Test
	void testM_equals5() {
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(0,3,0);
		Vertex v2 = new Vertex(1,0,0);
		Vertex v3 = new Vertex(0,2,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		
		Mesh m2 = new Mesh();
		
		Vertex v4 = new Vertex(1,1,1);
		Vertex v5 = new Vertex(1,0,1);
		Vertex v6 = new Vertex(0,0,1);
		
		vertices_test.add(v4);
		vertices_test.add(v5);
		vertices_test.add(v6);
		Polygon p2 = new Polygon(vertices_test);
		m2.polygons.add(p2);
		
		assertEquals(m2.equals(m1), false);
	}//end testM_equals5
	
	@Test
	void testM_equals6() {
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(0,3,0);
		Vertex v2 = new Vertex(1,0,0);
		Vertex v3 = new Vertex(0,2,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		Vertex v4 = new Vertex(0,4,0);
		Vertex v5 = new Vertex(1,1,0);
		Vertex v6 = new Vertex(0,2,0);
		vertices.clear();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p2 = new Polygon(vertices);
		m1.polygons.add(p2);
		
		
		Mesh m2 = new Mesh();
		
		Vertex v7 = new Vertex(1,1,1);
		Vertex v8 = new Vertex(1,0,1);
		Vertex v9 = new Vertex(0,0,1);
		
		vertices_test.add(v7);
		vertices_test.add(v8);
		vertices_test.add(v9);
		Polygon p3 = new Polygon(vertices_test);
		m2.polygons.add(p3);
		
		Vertex v10 = new Vertex(1,1,1);
		Vertex v11 = new Vertex(3,0,1);
		Vertex v12 = new Vertex(1,0,1);
		
		vertices_test.add(v10);
		vertices_test.add(v11);
		vertices_test.add(v12);
		Polygon p4 = new Polygon(vertices_test);
		m2.polygons.add(p4);
		
		assertEquals(m2.equals(m1), false);
	}//end testM_equals6
	
	@Test
	void testM_equals7() {
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(0,3,0);
		Vertex v2 = new Vertex(1,0,0);
		Vertex v3 = new Vertex(0,2,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		Mesh m2 = new Mesh();
		
		Vertex v7 = new Vertex(0,3,0);
		Vertex v8 = new Vertex(1,0,0);
		Vertex v9 = new Vertex(0,2,0);
		
		vertices_test.add(v7);
		vertices_test.add(v8);
		vertices_test.add(v9);
		Polygon p3 = new Polygon(vertices_test);
		m2.polygons.add(p3);
		
		assertEquals(m2.equals(m1), true);
	}//end testM_equals7
	
	@Test
	void testM_equals8(){
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(0,1,1);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		Mesh m2 = new Mesh();
		
		Vertex v4 = new Vertex(0,0,0);
		Vertex v5 = new Vertex(0,1,0);
		Vertex v6 = new Vertex(0,1,1);
		vertices_test.add(v4);
		vertices_test.add(v5);
		vertices_test.add(v6);
		
		Polygon p2 = new Polygon(vertices_test);
		m2.polygons.add(p2);
		
		Vertex v7 = new Vertex(0,4,0);
		Vertex v8 = new Vertex(0,1,0);
		Vertex v9 = new Vertex(0,2,3);
		vertices_test.clear();
		vertices_test.add(v7);
		vertices_test.add(v8);
		vertices_test.add(v9);
		
		Polygon p3 = new Polygon(vertices_test);
		m2.polygons.add(p3);
		
		assertEquals(m2.equals(m1), false);
	}//end testM_equals8
	
	//transform
	@Test
	void testM_transform0() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		m1.transform(matrix);
		
		assertEquals(v1.x, 0);
		assertEquals(v1.y, 0);
		assertEquals(v1.z, 0);
		assertEquals(v2.x, 0);
		assertEquals(v2.y, 0);
		assertEquals(v2.z, 0);
		assertEquals(v3.x, 0);
		assertEquals(v3.y, 0);
		assertEquals(v3.z, 0);
	}//end testM_transform0
	
	@Test
	void testM_transform1() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(1,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		m1.transform(matrix);
		
		assertEquals(v1.x, 1);
		assertEquals(v1.y, 4);
		assertEquals(v1.z, 7);
		assertEquals(v2.x, 0);
		assertEquals(v2.y, 0);
		assertEquals(v2.z, 0);
		assertEquals(v3.x, 0);
		assertEquals(v3.y, 0);
		assertEquals(v3.z, 0);
	}//end testM_transform1
	
	@Test
	void testM_transform2() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,1,0);
		Vertex v3 = new Vertex(0,0,0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		m1.transform(matrix);
		
		assertEquals(v1.x, 0);
		assertEquals(v1.y, 0);
		assertEquals(v1.z, 0);
		assertEquals(v2.x, 2);
		assertEquals(v2.y, 5);
		assertEquals(v2.z, 8);
		assertEquals(v3.x, 0);
		assertEquals(v3.y, 0);
		assertEquals(v3.z, 0);
	}//end testM_transform2
	
	@Test
	void testM_transform3() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(0,0,0);
		Vertex v2 = new Vertex(0,0,0);
		Vertex v3 = new Vertex(0,0,1);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		m1.transform(matrix);
		
		assertEquals(v1.x, 0);
		assertEquals(v1.y, 0);
		assertEquals(v1.z, 0);
		assertEquals(v2.x, 0);
		assertEquals(v2.y, 0);
		assertEquals(v2.z, 0);
		assertEquals(v3.x, 3);
		assertEquals(v3.y, 6);
		assertEquals(v3.z, 9);
	}//end testM_transform3
	
	@Test
	void testM_transform4() {
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		Mesh m1 = new Mesh();
		
		Vertex v1 = new Vertex(1,1,1);
		Vertex v2 = new Vertex(0,2,0);
		Vertex v3 = new Vertex(0,4,3);
		vertices.clear();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		Polygon p1 = new Polygon(vertices);
		m1.polygons.add(p1);
		
		Vertex v4 = new Vertex(0,0,0);
		Vertex v5 = new Vertex(1,2,1);
		Vertex v6 = new Vertex(3,0,1);
		vertices_test.add(v4);
		vertices_test.add(v5);
		vertices_test.add(v6);
		
		Polygon p2 = new Polygon(vertices_test);
		m1.polygons.add(p2);
		
		m1.transform(matrix);
		
		assertEquals(v1.x, 6);
		assertEquals(v1.y, 15);
		assertEquals(v1.z, 24);
		assertEquals(v2.x, 4);
		assertEquals(v2.y, 10);
		assertEquals(v2.z, 16);
		assertEquals(v3.x, 17);
		assertEquals(v3.y, 38);
		assertEquals(v3.z, 59);
		assertEquals(v4.x, 0);
		assertEquals(v4.y, 0);
		assertEquals(v4.z, 0);
		assertEquals(v5.x, 8);
		assertEquals(v5.y, 20);
		assertEquals(v5.z, 32);
		assertEquals(v6.x, 6);
		assertEquals(v6.y, 18);
		assertEquals(v6.z, 30);
	}//end testM_transform4
	
	//readFromFile
	
	@Test
	void testM_readFromFile0() throws IOException {
		Mesh m = new Mesh();
		File new_file = new File("/Users/nicoledroi/Documents/car.obj");
		new_file.createNewFile();
		OBJMeshReader obj = new OBJMeshReader();
		
		m.readFromFile("/Users/nicoledroi/Documents/car.obj");
		assertEquals(m.reader.getClass(), obj.getClass());
	}//end testM_readFromFile0
	
	@Test
	void testM_readFromFile1() throws IOException {
		Mesh m = new Mesh();
		File new_file = new File("/Users/nicoledroi/Documents/car.ply");
		new_file.createNewFile();
		PLYMeshReader ply = new PLYMeshReader();
		
		m.readFromFile("/Users/nicoledroi/Documents/car.ply");
		assertEquals(m.reader.getClass(), ply.getClass());
	}//end testM_readFromFile0
	
	//writeToFile
	
	@Test
	void testM_writeToFile0() throws IOException {
		Mesh m = new Mesh();
		File new_file = new File("/Users/nicoledroi/Documents/car.obj");
		new_file.createNewFile();
		OBJMeshWriter obj = new OBJMeshWriter();
		
		m.writeToFile("/Users/nicoledroi/Documents/car.obj");
		assertEquals(m.writer.getClass(), obj.getClass());
	}//end testM_writeFromFile0
	
	@Test
	void testM_writeToFile1() throws IOException {
		Mesh m = new Mesh();
		File new_file = new File("/Users/nicoledroi/Documents/car.ply");
		new_file.createNewFile();
		PLYMeshWriter ply = new PLYMeshWriter();
		
		m.writeToFile("/Users/nicoledroi/Documents/car.ply");
		assertEquals(m.writer.getClass(), ply.getClass());
	}//end testM_writeFromFile0
	
	//GraphicalObject
	
	@Test 
	void test_rotateXAxis0() {
		Vertex v = new Vertex(0,0,0);
		v.rotateXAxis(0);
		assertEquals(v.x, 0);
		assertEquals(v.y, 0);
		assertEquals(v.z, 0);
	}//end test_rotateXAxis0
	
	@Test 
	void test_rotateYAxis0() {
		Vertex v = new Vertex(0,0,0);
		v.rotateYAxis(0);
		assertEquals(v.x, 0);
		assertEquals(v.y, 0);
		assertEquals(v.z, 0);
	}//end test_rotateYAxis0
	
	@Test 
	void test_rotateZAxis0() {
		Vertex v = new Vertex(0,0,0);
		v.rotateZAxis(0);
		assertEquals(v.x, 0);
		assertEquals(v.y, 0);
		assertEquals(v.z, 0);
	}//end test_rotateZAxis0
	

}//end Assignment_tester
