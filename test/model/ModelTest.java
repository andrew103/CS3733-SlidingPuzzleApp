package model;

import junit.framework.TestCase;

public class ModelTest extends TestCase {
	
	private boolean compareArrays(String[][] array1, String[][] array2) {
		if (array1.length != array2.length) return false;
		for (int i = 0; i < array1.length; i++) {
			if (array1[i].length != array2[i].length) return false;
			for (int j = 0; j < array1[i].length; j++) {
				String str1 = array1[i][j];
				String str2 = array2[i][j];
				if (str1 != str2) return false;
			}
		}
		
		return true;
	}

	public void testReset() {
		String[][] desired = {
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "panel_6", "panel_7", "panel_5"},
				{"panel_8", "none", "none", "panel_9"}
		};
		String[][] start = {
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "panel_6", "panel_7", "panel_5"},
				{"panel_8", "none", "none", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};
		
		PuzzleModel m = new PuzzleModel(start);
		m.resetPuzzle();
		assertTrue(compareArrays(m.getGrid(), desired));
	}
	
	public void testMoveRight() {
		PuzzleModel m = new PuzzleModel();

		assertTrue(m.moveRight(0, 4));
		assertEquals(m.getGrid()[4][1], "panel_8");
		assertEquals(m.getGrid()[4][0], "none");
		assertFalse(m.moveRight(3, 4));
		assertFalse(m.moveRight(1, 2));
		assertFalse(m.moveRight(2, 3));
		
		String[][] start1 = {
				{"panel_1", "panel_1", "none", "panel_5"},
				{"panel_4", "panel_6", "panel_7", "panel_5"},
				{"panel_4", "panel_8", "none", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};
		PuzzleModel m1 = new PuzzleModel(start1);
		
		assertTrue(m1.moveRight(0, 0));
		assertEquals(m1.getGrid()[0][0], "none");
		assertEquals(m1.getGrid()[0][2], "panel_1");

		String[][] start2 = {
				{"panel_1", "panel_1", "panel_5", "none"},
				{"panel_4", "panel_6", "panel_5", "none"},
				{"panel_4", "panel_8", "panel_7", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};
		PuzzleModel m2 = new PuzzleModel(start2);
		
		assertTrue(m2.moveRight(2, 0));
		assertEquals(m2.getGrid()[0][2], "none");
		assertEquals(m2.getGrid()[1][2], "none");
		assertEquals(m2.getGrid()[0][3], "panel_5");
		assertEquals(m2.getGrid()[1][3], "panel_5");

		String[][] start3 = {
				{"panel_1", "panel_1", "panel_5", "panel_3"},
				{"panel_4", "panel_6", "panel_5", "panel_3"},
				{"panel_4", "panel_8", "panel_7", "panel_9"},
				{"panel_2", "target", "target", "none"},
				{"panel_2", "target", "target", "none"}
		};
		PuzzleModel m3 = new PuzzleModel(start3);
		
		assertTrue(m3.moveRight(1, 3));
		assertEquals(m3.getGrid()[3][1], "none");
		assertEquals(m3.getGrid()[4][1], "none");
		assertEquals(m3.getGrid()[3][3], "target");
		assertEquals(m3.getGrid()[4][3], "target");
	}

	public void testMoveLeft() {
		PuzzleModel m = new PuzzleModel();

		assertTrue(m.moveLeft(3, 4));
		assertEquals(m.getGrid()[4][2], "panel_9");
		assertEquals(m.getGrid()[4][3], "none");
		assertFalse(m.moveLeft(0, 4));
		assertFalse(m.moveLeft(2, 2));
		assertFalse(m.moveLeft(2, 3));

		String[][] start1 = {
				{"none", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "panel_6", "panel_7", "panel_5"},
				{"panel_4", "panel_8", "none", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};
		PuzzleModel m1 = new PuzzleModel(start1);
		
		assertTrue(m1.moveLeft(1, 0));
		assertEquals(m1.getGrid()[0][2], "none");
		assertEquals(m1.getGrid()[0][0], "panel_1");

		String[][] start2 = {
				{"panel_1", "panel_1", "none", "panel_5"},
				{"panel_4", "panel_6", "none", "panel_5"},
				{"panel_4", "panel_8", "panel_7", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};
		PuzzleModel m2 = new PuzzleModel(start2);
		
		assertTrue(m2.moveLeft(3, 0));
		assertEquals(m2.getGrid()[0][3], "none");
		assertEquals(m2.getGrid()[1][3], "none");
		assertEquals(m2.getGrid()[0][2], "panel_5");
		assertEquals(m2.getGrid()[1][2], "panel_5");

		String[][] start3 = {
				{"panel_1", "panel_1", "panel_5", "panel_3"},
				{"panel_4", "panel_6", "panel_5", "panel_3"},
				{"panel_4", "panel_8", "panel_7", "panel_9"},
				{"panel_2", "none", "target", "target"},
				{"panel_2", "none", "target", "target"}
		};
		PuzzleModel m3 = new PuzzleModel(start3);
		
		assertTrue(m3.moveLeft(2, 3));
		assertEquals(m3.getGrid()[3][3], "none");
		assertEquals(m3.getGrid()[4][3], "none");
		assertEquals(m3.getGrid()[3][1], "target");
		assertEquals(m3.getGrid()[4][1], "target");
	}

	public void testMoveUp() {
		String[][] start = {
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "panel_6", "panel_7", "panel_5"},
				{"panel_8", "none", "none", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};

		PuzzleModel m = new PuzzleModel(start);
		
		assertTrue(m.moveUp(1, 3));
		assertEquals(m.getGrid()[2][1], "target");
		assertEquals(m.getGrid()[2][2], "target");
		assertEquals(m.getGrid()[4][1], "none");
		assertEquals(m.getGrid()[4][2], "none");
		assertFalse(m.moveUp(1, 0));
		assertFalse(m.moveUp(0, 2));
		assertFalse(m.moveUp(0, 3));

		String[][] start1 = {
				{"panel_4", "none", "none", "panel_5"},
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_8", "panel_6", "panel_7", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};

		PuzzleModel m1 = new PuzzleModel(start1);
		
		assertTrue(m1.moveUp(1, 1));
		assertEquals(m1.getGrid()[1][1], "none");
		assertEquals(m1.getGrid()[1][2], "none");
		assertEquals(m1.getGrid()[0][1], "panel_1");
		assertEquals(m1.getGrid()[0][2], "panel_1");		

		String[][] start2 = {
				{"panel_4", "none", "panel_9", "none"},
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_8", "panel_6", "panel_7", "panel_5"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};

		PuzzleModel m2 = new PuzzleModel(start2);
		
		assertTrue(m2.moveUp(3, 1));
		assertEquals(m2.getGrid()[0][3], "panel_5");
		assertEquals(m2.getGrid()[2][3], "none");
	}

	public void testMoveDown() {
		PuzzleModel m = new PuzzleModel();
		
		assertTrue(m.moveDown(2, 3));
		assertEquals(m.getGrid()[3][2], "none");
		assertEquals(m.getGrid()[4][2], "panel_7");
		assertFalse(m.moveDown(0, 4));
		assertFalse(m.moveDown(1, 2));
		assertFalse(m.moveDown(0, 0));

		String[][] start1 = {
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "panel_6", "panel_7", "panel_5"},
				{"panel_8", "target", "target", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "none", "none", "panel_3"}
		};
		
		PuzzleModel m1 = new PuzzleModel(start1);
		
		assertTrue(m1.moveDown(1, 2));
		assertEquals(m1.getGrid()[2][1], "none");
		assertEquals(m1.getGrid()[2][2], "none");
		assertEquals(m1.getGrid()[4][1], "target");
		assertEquals(m1.getGrid()[4][2], "target");

		String[][] start2 = {
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "none", "none", "panel_5"},
				{"panel_8", "target", "target", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "panel_6", "panel_7", "panel_3"}
		};
		
		PuzzleModel m2 = new PuzzleModel(start2);
		
		assertTrue(m2.moveDown(1, 0));
		assertEquals(m2.getGrid()[0][1], "none");
		assertEquals(m2.getGrid()[0][2], "none");
		assertEquals(m2.getGrid()[1][1], "panel_1");
		assertEquals(m2.getGrid()[1][2], "panel_1");

		String[][] start3 = {
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "panel_8", "none", "panel_5"},
				{"none", "target", "target", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "panel_6", "panel_7", "panel_3"}
		};
		
		PuzzleModel m3 = new PuzzleModel(start3);
		
		assertTrue(m3.moveDown(0, 0));
		assertEquals(m3.getGrid()[0][0], "none");
		assertEquals(m3.getGrid()[2][0], "panel_4");
	}
	
	public void testMoveTargetOut() {
		String[][] start1 = {
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "panel_6", "panel_7", "panel_5"},
				{"panel_8", "none", "none", "panel_9"},
				{"panel_2", "target", "target", "panel_3"},
				{"panel_2", "target", "target", "panel_3"}
		};

		String[][] start2 = {
				{"panel_4", "panel_1", "panel_1", "panel_5"},
				{"panel_4", "panel_6", "panel_7", "panel_5"},
				{"panel_8", "none", "none", "panel_9"},
				{"target", "target", "panel_2", "panel_3"},
				{"target", "target", "panel_2", "panel_3"}
		};

		PuzzleModel m1 = new PuzzleModel(start1);
		assertTrue(m1.moveDown(1, 3));
		assertEquals(m1.getGrid()[3][1], "none");
		assertEquals(m1.getGrid()[4][1], "none");
		assertEquals(m1.getGrid()[3][2], "none");
		assertEquals(m1.getGrid()[4][2], "none");
		
		PuzzleModel m2 = new PuzzleModel(start2);
		assertFalse(m2.moveDown(0, 3));
	}
}
