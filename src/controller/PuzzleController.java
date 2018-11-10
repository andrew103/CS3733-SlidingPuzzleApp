package controller;

import model.PuzzleModel;
import puzzle.Puzzle;

public class PuzzleController {
	
	Puzzle puzzleView;
	PuzzleModel puzzleModel;

	public PuzzleController(Puzzle app, PuzzleModel model) {
		this.puzzleModel = model;
		this.puzzleView = app;
	}
}
