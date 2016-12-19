package co.za.ktpsolutions.juniormathapplication.Version_01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class JuniorMathApplication_V01_MainApplication {

	private JFrame frmMathApplication;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuniorMathApplication_V01_MainApplication window = new JuniorMathApplication_V01_MainApplication();
					window.frmMathApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JuniorMathApplication_V01_MainApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMathApplication = new JFrame();
		frmMathApplication.setTitle("Math Application - Version_01");
		frmMathApplication.setBounds(100, 100, 450, 300);
		frmMathApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMathApplication.setJMenuBar(menuBar);
		
		JMenu DifficultyMenu = new JMenu("Difficulty");
		menuBar.add(DifficultyMenu);
		
		JMenuItem HardQuizMenuItem = new JMenuItem("Hard Quiz");
		HardQuizMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JuniorMathApplication_V01_Quiz.HardQuiz(frmMathApplication);
			}
		});
		
		JMenuItem EasyQuizMenuItem = new JMenuItem("Easy Quiz");
		DifficultyMenu.add(EasyQuizMenuItem);
		
		JMenuItem MediumQuizMenuItem = new JMenuItem("Medium Quiz\r\n");
		DifficultyMenu.add(MediumQuizMenuItem);
		DifficultyMenu.add(HardQuizMenuItem);
		
		JMenu AboutMenu = new JMenu("About");
		menuBar.add(AboutMenu);
		
		JMenuItem TermsAndConditionsMenuItem = new JMenuItem("Terms And Conditions");
		AboutMenu.add(TermsAndConditionsMenuItem);
		
		JMenu HelpMenu = new JMenu("Help");
		menuBar.add(HelpMenu);
		
		JMenu QuizRulesSubMenu = new JMenu("Quiz Rules");
		HelpMenu.add(QuizRulesSubMenu);
		
		JMenuItem QuizSetupGuideMenuItem = new JMenuItem("Quiz setup guide");
		QuizRulesSubMenu.add(QuizSetupGuideMenuItem);
		frmMathApplication.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmMathApplication.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
	}

}
