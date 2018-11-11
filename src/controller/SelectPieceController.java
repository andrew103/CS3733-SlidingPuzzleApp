package controller;

import puzzle.Puzzle;
import model.PuzzleModel;

public class SelectPieceController {
	final Puzzle app;
	final PuzzleModel model;
	
	public SelectPieceController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
}
