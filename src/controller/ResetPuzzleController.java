package controller;

import puzzle.Puzzle;

import java.awt.Color;

import javax.swing.border.LineBorder;

import model.PuzzleModel;

public class ResetPuzzleController {
	final Puzzle app;
	final PuzzleModel model;
	
	public ResetPuzzleController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
	
	public void reset() {
		this.model.resetPuzzle();
		
		this.app.pieces[0].setLocation(105, 5);
		this.app.pieces[0].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[1].setLocation(105, 205);
		this.app.pieces[1].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[2].setLocation(5, 5);
		this.app.pieces[2].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[3].setLocation(305, 5);
		this.app.pieces[3].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[4].setLocation(5, 205);
		this.app.pieces[4].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[5].setLocation(305, 205);
		this.app.pieces[5].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[6].setLocation(105, 305);
		this.app.pieces[6].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[7].setLocation(205, 305);
		this.app.pieces[7].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[8].setLocation(5, 405);
		this.app.pieces[8].setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.app.pieces[9].setLocation(305, 405);
		this.app.pieces[9].setBorder(new LineBorder(new Color(0, 0, 0), 2));
	}
}
