package test;

import junit.framework.TestCase;
import java.util.List;
import comcast.PartOne;
import comcast.Coordinate;

public class PartTwo extends TestCase {

	private List<Coordinate> coordinates;
	protected void setUp() throws Exception {
		super.setUp();
		String jsonfile="src/comcast/coordinates.json";
		coordinates=PartOne.ReadCoordinates(jsonfile);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * test1 given (100, 100), expected id="x" is the closest, id="u" is the second
	 */
	public void test1() {
		List<Coordinate> clist=PartOne.SortWithOrigin(coordinates, 100, 100);
		Coordinate c0=clist.get(0);
		assertEquals(c0.id, "x");
		assertEquals(c0.x, 84);
		assertEquals(c0.y, 100);
		Coordinate c1=clist.get(1);
		assertEquals(c1.id, "u");
		assertEquals(c1.x, 88);
		assertEquals(c1.y, 79);
	}

	/**
	 * test1 given (20, 16), expected id="d" is the closest, id="o" is the second
	 */
	public void test2() {
		List<Coordinate> clist=PartOne.SortWithOrigin(coordinates, 20, 16);
		Coordinate c0=clist.get(0);
		assertEquals(c0.id, "d");
		assertEquals(c0.x, 20);
		assertEquals(c0.y, 16);
		Coordinate c1=clist.get(1);
		assertEquals(c1.id, "p");
		assertEquals(c1.x, 37);
		assertEquals(c1.y, 27);
	}


}


