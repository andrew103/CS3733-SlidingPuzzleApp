package controller;

import puzzle.Puzzle;
import model.PuzzleModel;

public class ResetPuzzleController {
	final Puzzle app;
	final PuzzleModel model;
	
	public ResetPuzzleController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
}
