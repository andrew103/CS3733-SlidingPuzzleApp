package controller;

import puzzle.Puzzle;
import model.PuzzleModel;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Point;

public class SelectPieceController {
	final Puzzle app;
	final PuzzleModel model;
	
	public SelectPieceController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
	
	public void selectPiece(int mouseX, int mouseY) {
		if (this.model.selected_piece != "none") {
			for (JPanel piece:this.app.pieces) {
				if (piece.getName() == this.model.selected_piece) {
					piece.setBorder(new LineBorder(new Color(0, 0, 0), 2));
					this.model.selected_piece = "none";					
				}
			}
		}
		for (JPanel piece:this.app.pieces) {
			int pieceX = piece.getX();
			int pieceY = piece.getY();
			if (pieceX <= mouseX && pieceX + piece.getWidth() > mouseX && pieceY <= mouseY && pieceY + piece.getHeight() > mouseY) {
				piece.setBorder(new LineBorder(new Color(0, 0, 200), 2));
				this.model.selected_piece = piece.getName();
			}
		}
	}
}
