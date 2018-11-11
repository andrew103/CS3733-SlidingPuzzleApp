package controller;

import puzzle.Puzzle;
import model.PuzzleModel;

public class MovePieceController {
	final Puzzle app;
	final PuzzleModel model;
	
	public MovePieceController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
}
