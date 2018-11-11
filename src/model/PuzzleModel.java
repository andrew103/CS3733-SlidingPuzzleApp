package model;

public class PuzzleModel {
	
	String[][] defaultSetup = {
			{"panel_2", "target", "target", "panel_3"},
			{"panel_2", "target", "target", "panel_3"},
			{"panel_4", "panel_1", "panel_1", "panel_5"},
			{"panel_4", "panel_6", "panel_7", "panel_5"},
			{"panel_8", "none", "none", "panel_9"}
	};
	String[][] grid;
	String selected_piece = "none";
	
	public PuzzleModel() {
		this.grid = this.defaultSetup;
	}
	
	private boolean checkHorizontal(int step, int x_coord, int y_coord) {
		String object = this.grid[y_coord][x_coord];
		
		for (int y = 0; y < this.grid.length; y++) {
			for (int x = 0; x < this.grid[y].length; x++) {
				if (this.grid[y][x] == object) {
					if (step == 1 && x < 3) {
						if (this.grid[y][x+step] != "none" && this.grid[y][x+step] != object) {
							return false;
						}
					}
					else if (step == -1 && x > 0) {
						if (this.grid[y][x+step] != "none" && this.grid[y][x+step] != object) {
							return false;
						}						
					}
					else {
						return false;
					}
				}
			}
		}
		
		return true;
	}

	private boolean checkVertical(int step, int x_coord, int y_coord) {
		String object = this.grid[y_coord][x_coord];
		
		for (int y = 0; y < this.grid.length; y++) {
			for (int x = 0; x < this.grid[y].length; x++) {
				if (this.grid[y][x] == object) {
					if (step == 1 && y < 4) {
						if (this.grid[y+step][x] != "none" && this.grid[y+step][x] != object) {
							return false;
						}
					}
					else if (step == -1 && y > 0) {
						if (this.grid[y+step][x] != "none" && this.grid[y+step][x] != object) {
							return false;
						}						
					}
					else {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private int countOccurrences(String[] array, String value) {
		int occurrences = 0;
		
		for (String val:array) {
			if (val == value) {
				occurrences++;
			}
		}
		
		return occurrences;
	}
	
	public boolean moveRight(int x_coord, int y_coord) {
		if (checkHorizontal(1, x_coord, y_coord)) {
			
		}
		
		return true;
	}

	public boolean moveLeft(int x_coord, int y_coord) {
		if (checkHorizontal(-1, x_coord, y_coord)) {
			
		}
		
		return true;		
	}

	public boolean moveUp(int x_coord, int y_coord) {
		if (checkVertical(-1, x_coord, y_coord)) {
			
		}
		
		return true;		
	}

	public boolean moveDown(int x_coord, int y_coord) {
		if (checkVertical(1, x_coord, y_coord)) {
			
		}
		
		return true;		
	}
	
	public void resetPuzzle() {
		this.grid = this.defaultSetup;
	}
}
