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
	
	public void moveRight(int x_coord, int y_coord) {
		
	}

	public void moveLeft(int x_coord, int y_coord) {
		
	}

	public void moveUp(int x_coord, int y_coord) {
		
	}

	public void moveDown(int x_coord, int y_coord) {
		
	}
	
	public void resetPuzzle() {
		this.grid = this.defaultSetup;
	}
}
