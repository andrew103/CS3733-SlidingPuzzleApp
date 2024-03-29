package controller;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;

import puzzle.Puzzle;
import model.PuzzleModel;

public class MovePieceController {
	final Puzzle app;
	final PuzzleModel model;
	JPanel selected;
	
	public MovePieceController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
	
	public void move(char direction) {
		if (this.model.selected_piece != "none") {
			getSelected();
			int x_coord = this.selected.getX();
			int y_coord = this.selected.getY();
			switch (direction) {
				case 'w':
					if (this.model.moveUp((x_coord - 5)/100, (y_coord - 5)/100)) {
						this.selected.setLocation(x_coord, y_coord - 100);
						this.selected.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						this.model.selected_piece = "none";
						
						this.model.move_counter++;
						this.app.counter.setText("Number of Moves: " + this.model.move_counter);
					}
					break;
				case 'a':
					if (this.model.moveLeft((x_coord - 5)/100, (y_coord - 5)/100)) {
						this.selected.setLocation(x_coord - 100, y_coord);
						this.selected.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						this.model.selected_piece = "none";
						
						this.model.move_counter++;
						this.app.counter.setText("Number of Moves: " + this.model.move_counter);
					}
					break;
				case 's':
					if (this.model.moveDown((x_coord - 5)/100, (y_coord - 5)/100)) {
						if (this.model.user_won) {
							this.app.contentPane.remove(this.app.pieces[0]);
							this.model.move_counter++;
							this.app.counter.setText("Number of Moves: " + this.model.move_counter);
							
							JOptionPane.showMessageDialog(this.app, "Congratulations! You solved the puzzle!");
						}
						else {
							this.selected.setLocation(x_coord, y_coord + 100);
							this.selected.setBorder(new LineBorder(new Color(0, 0, 0), 2));
							this.model.selected_piece = "none";
							
							this.model.move_counter++;
							this.app.counter.setText("Number of Moves: " + this.model.move_counter);							
						}
					}
					break;
				case 'd':
					if (this.model.moveRight((x_coord - 5)/100, (y_coord - 5)/100)) {
						this.selected.setLocation(x_coord + 100, y_coord);
						this.selected.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						this.model.selected_piece = "none";
						
						this.model.move_counter++;
						this.app.counter.setText("Number of Moves: " + this.model.move_counter);
					}
					break;
			}
		}
	}
	
	private void getSelected() {
		for (JPanel piece:this.app.pieces) {
			if (piece.getName() == this.model.selected_piece) {
				this.selected = piece;
				break;
			}
		}
	}
}
