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
	
	public PuzzleModel(String[][] grid) {
		this.grid = grid;
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

	public boolean moveRight(int x_coord, int y_coord) {
		if (checkHorizontal(1, x_coord, y_coord)) {
			if (this.grid[y_coord][x_coord] == this.grid[y_coord][x_coord+1]) {
				this.grid[y_coord][x_coord+2] = this.grid[y_coord][x_coord];
			}
			else {
				this.grid[y_coord][x_coord+1] = this.grid[y_coord][x_coord];
			}

			this.grid[y_coord][x_coord] = "none";

			if (y_coord < 4 && this.grid[y_coord][x_coord] == this.grid[y_coord+1][x_coord]) {
				if (this.grid[y_coord+1][x_coord] == this.grid[y_coord+1][x_coord+1]) {
					this.grid[y_coord+1][x_coord+2] = this.grid[y_coord+1][x_coord];
				}
				else {
					this.grid[y_coord+1][x_coord+1] = this.grid[y_coord+1][x_coord];
				}

				this.grid[y_coord+1][x_coord] = "none";
			}

			return true;
		}

		return false;
	}

	public boolean moveLeft(int x_coord, int y_coord) {
		if (checkHorizontal(-1, x_coord, y_coord)) {
			if (x_coord < 3 && this.grid[y_coord][x_coord] == this.grid[y_coord][x_coord+1]) {
				this.grid[y_coord][x_coord-1] = this.grid[y_coord][x_coord];
				this.grid[y_coord][x_coord+1] = "none";
			}
			else {
				this.grid[y_coord][x_coord-1] = this.grid[y_coord][x_coord];
				this.grid[y_coord][x_coord] = "none";
			}

			if (y_coord < 4 && this.grid[y_coord][x_coord] == this.grid[y_coord+1][x_coord]) {
				if (x_coord < 3 && this.grid[y_coord+1][x_coord] == this.grid[y_coord+1][x_coord+1]) {
					this.grid[y_coord+1][x_coord-1] = this.grid[y_coord+1][x_coord];
					this.grid[y_coord+1][x_coord+1] = "none";
				}
				else {
					this.grid[y_coord+1][x_coord-1] = this.grid[y_coord+1][x_coord];
					this.grid[y_coord+1][x_coord] = "none";
				}
			}

			return true;
		}

		return false;
	}

	public boolean moveUp(int x_coord, int y_coord) {
		if (checkVertical(-1, x_coord, y_coord)) {
			if (y_coord < 4 && this.grid[y_coord][x_coord] == this.grid[y_coord+1][x_coord]) {
				this.grid[y_coord-1][x_coord] = this.grid[y_coord][x_coord];
				this.grid[y_coord+1][x_coord] = "none";
			}
			else {
				this.grid[y_coord-1][x_coord] = this.grid[y_coord][x_coord];
				this.grid[y_coord][x_coord] = "none";
			}

			if (x_coord < 3 && this.grid[y_coord][x_coord] == this.grid[y_coord][x_coord+1]) {
				if (y_coord < 4 && this.grid[y_coord][x_coord+1] == this.grid[y_coord+1][x_coord+1]) {
					this.grid[y_coord-1][x_coord+1] = this.grid[y_coord][x_coord+1];
					this.grid[y_coord+1][x_coord+1] = "none";
				}
				else {
					this.grid[y_coord-1][x_coord+1] = this.grid[y_coord][x_coord+1];
					this.grid[y_coord][x_coord+1] = "none";
				}
			}

			return true;
		}

		return false;
	}

	public boolean moveDown(int x_coord, int y_coord) {
		if (this.grid[y_coord][x_coord] == "target" && x_coord == 1 && y_coord == 3) {
			this.grid[3][1] = "none";
			this.grid[4][1] = "none";
			this.grid[3][2] = "none";
			this.grid[4][2] = "none";
			return true;
		}
		else if (checkVertical(1, x_coord, y_coord)) {
			if (this.grid[y_coord][x_coord] == this.grid[y_coord+1][x_coord]) {
				this.grid[y_coord+2][x_coord] = this.grid[y_coord][x_coord];
			}
			else {
				this.grid[y_coord+1][x_coord] = this.grid[y_coord][x_coord];
			}

			this.grid[y_coord][x_coord] = "none";

			if (x_coord < 3 && this.grid[y_coord][x_coord] == this.grid[y_coord][x_coord+1]) {
				if (this.grid[y_coord][x_coord+1] == this.grid[y_coord+1][x_coord+1]) {
					this.grid[y_coord+2][x_coord+1] = this.grid[y_coord][x_coord+1];
				}
				else {
					this.grid[y_coord+1][x_coord+1] = this.grid[y_coord][x_coord+1];
				}

				this.grid[y_coord][x_coord+1] = "none";
			}

			return true;
		}

		return false;
	}

	public void resetPuzzle() {
		this.grid = this.defaultSetup;
	}
	
	public String[][] getGrid() {
		return this.grid;
	}
}
