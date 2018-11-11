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

public class Puzzle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzle frame = new Puzzle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Puzzle() {
		setTitle("Sliding Puzzle App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 640);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmResetPuzzle = new JMenuItem("Reset Puzzle");
		menuBar.add(mntmResetPuzzle);
		
		JMenuItem mntmClosePuzzle = new JMenuItem("Close Puzzle");
		menuBar.add(mntmClosePuzzle);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel target = new JPanel();
		target.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		target.setBackground(Color.RED);
		target.setBounds(105, 5, 200, 200);
		target.setName("target");
		contentPane.add(target);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(105, 205, 200, 100);
		panel_1.setName("panel_1");
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(5, 5, 100, 200);
		panel_2.setName("panel_2");
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(305, 5, 100, 200);
		panel_3.setName("panel_3");
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(5, 205, 100, 200);
		panel_4.setName("panel_4");
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBackground(Color.GRAY);
		panel_5.setBounds(305, 205, 100, 200);
		panel_5.setName("panel_5");
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setBounds(105, 305, 100, 100);
		panel_6.setName("panel_6");
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_7.setBackground(Color.GRAY);
		panel_7.setBounds(205, 305, 100, 100);
		panel_7.setName("panel_7");
		contentPane.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_8.setBackground(Color.GRAY);
		panel_8.setBounds(5, 405, 100, 100);
		panel_8.setName("panel_8");
		contentPane.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_9.setBackground(Color.GRAY);
		panel_9.setBounds(305, 405, 100, 100);
		panel_9.setName("panel_9");
		contentPane.add(panel_9);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(105, 510, 200, 5);
		contentPane.add(separator);
		
		JLabel lblNumberOfMoves = new JLabel("Number of Moves:");
		lblNumberOfMoves.setBounds(12, 537, 154, 27);
		contentPane.add(lblNumberOfMoves);

		System.out.println(contentPane.getComponentCount());
	}
}
