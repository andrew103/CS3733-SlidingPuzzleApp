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
	}

	public void testMoveLeft() {
		PuzzleModel m = new PuzzleModel();

		assertTrue(m.moveLeft(3, 4));
		assertEquals(m.getGrid()[4][2], "panel_9");
		assertEquals(m.getGrid()[4][3], "none");
		assertFalse(m.moveLeft(0, 4));
		assertFalse(m.moveLeft(2, 2));
		assertFalse(m.moveLeft(2, 3));
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
	}

	public void testMoveDown() {
		PuzzleModel m = new PuzzleModel();
		
		assertTrue(m.moveDown(2, 3));
		assertEquals(m.getGrid()[3][2], "none");
		assertEquals(m.getGrid()[4][2], "panel_7");
		assertFalse(m.moveDown(0, 4));
		assertFalse(m.moveDown(1, 2));
		assertFalse(m.moveDown(0, 0));
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
