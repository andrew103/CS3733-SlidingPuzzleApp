package controller;

import puzzle.Puzzle;
import model.PuzzleModel;

public class ClosePuzzleController {
	final Puzzle app;
	final PuzzleModel model;
	
	public ClosePuzzleController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
}
