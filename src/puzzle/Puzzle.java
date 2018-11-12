package puzzle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

import model.PuzzleModel;
import controller.ClosePuzzleController;
import controller.MovePieceController;
import controller.ResetPuzzleController;
import controller.SelectPieceController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Puzzle extends JFrame {

	public JPanel contentPane;
	
	PuzzleModel model;
	public JPanel[] pieces;

	/**
	 * Create the frame.
	 */
	public Puzzle(PuzzleModel m) {
		this.model = m;
		this.pieces = new JPanel[10];
		
		setTitle("Sliding Puzzle App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 640);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmResetPuzzle = new JMenuItem("Reset Puzzle");
		mntmResetPuzzle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		menuBar.add(mntmResetPuzzle);
		mntmResetPuzzle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetPuzzleController(Puzzle.this, model).reset();
				contentPane.requestFocusInWindow();
			}
		});
		
		JMenuItem mntmClosePuzzle = new JMenuItem("Exit Puzzle");
		mntmClosePuzzle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		menuBar.add(mntmClosePuzzle);
		mntmClosePuzzle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ClosePuzzleController(Puzzle.this, model).close();
			}
		});
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				new SelectPieceController(Puzzle.this, model).selectPiece(e.getX(), e.getY());
			}
		});
		contentPane.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				new MovePieceController(Puzzle.this, model).move(e.getKeyChar());
			}
		});
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel target = new JPanel();
		target.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		target.setBackground(Color.RED);
		target.setBounds(105, 5, 200, 200);
		target.setName("target");
		contentPane.add(target);
		pieces[0] = target;
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(105, 205, 200, 100);
		panel_1.setName("panel_1");
		contentPane.add(panel_1);
		pieces[1] = panel_1;
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(5, 5, 100, 200);
		panel_2.setName("panel_2");
		contentPane.add(panel_2);
		pieces[2] = panel_2;
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(305, 5, 100, 200);
		panel_3.setName("panel_3");
		contentPane.add(panel_3);
		pieces[3] = panel_3;
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(5, 205, 100, 200);
		panel_4.setName("panel_4");
		contentPane.add(panel_4);
		pieces[4] = panel_4;
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBackground(Color.GRAY);
		panel_5.setBounds(305, 205, 100, 200);
		panel_5.setName("panel_5");
		contentPane.add(panel_5);
		pieces[5] = panel_5;

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setBounds(105, 305, 100, 100);
		panel_6.setName("panel_6");
		contentPane.add(panel_6);
		pieces[6] = panel_6;

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_7.setBackground(Color.GRAY);
		panel_7.setBounds(205, 305, 100, 100);
		panel_7.setName("panel_7");
		contentPane.add(panel_7);
		pieces[7] = panel_7;

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_8.setBackground(Color.GRAY);
		panel_8.setBounds(5, 405, 100, 100);
		panel_8.setName("panel_8");
		contentPane.add(panel_8);
		pieces[8] = panel_8;

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_9.setBackground(Color.GRAY);
		panel_9.setBounds(305, 405, 100, 100);
		panel_9.setName("panel_9");
		contentPane.add(panel_9);
		pieces[9] = panel_9;
		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(105, 510, 200, 5);
		contentPane.add(separator);
		
		JLabel lblNumberOfMoves = new JLabel("Number of Moves: 0");
		lblNumberOfMoves.setBounds(12, 537, 154, 27);
		contentPane.add(lblNumberOfMoves);
	}
}
