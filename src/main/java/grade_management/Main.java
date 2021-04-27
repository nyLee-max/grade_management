package grade_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.StudentScoreAll;
import grade_management.service.SearchService;
import grade_management.ui.ScoreManagerUI;
import grade_management.ui.SearchAllManagerUI;
import grade_management.ui.SearchManagerUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import grade_management.ui.list.StudentTablePanel;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnScore;
	private StudentTablePanel pList;
	private SearchService service;
	private JButton btnAll;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		service = new SearchService();
		initialize();
	}

	private void initialize() {
		setTitle("Grade Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.NORTH);

		btnScore = new JButton("학생성적입력");
		btnScore.addActionListener(this);
		pBtns.add(btnScore);

		btnAll = new JButton("분반별성적확인");
		btnAll.addActionListener(this);
		pBtns.add(btnAll);

		btnNewButton = new JButton("전체성적확인");
		btnNewButton.addActionListener(this);
		pBtns.add(btnNewButton);

		pList = new StudentTablePanel();
		pList.loadData();
		contentPane.add(pList);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton_2(e);
		}
		if (e.getSource() == btnAll) {
			actionPerformedBtnAll(e);
		}
		if (e.getSource() == btnScore) {
			actionPerformedBtnNewButton(e);
		}

	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		ScoreManagerUI frame = new ScoreManagerUI();
		frame.setVisible(true);

//		System.out.println("pList.getItem().getStdNo() " + pList.getItem().getStdNo());
		Student item = service.showStudentBystdNo(new Student(pList.getItem().getStdNo()));
		frame.getpLeftPanel().setItem(item);
		
		StudentScoreAll score = service.showStudentScoreByStdNo(new Student(pList.getItem().getStdNo()));
		frame.getpRightPanel().setItem(score);
		frame.setTable(pList);

	}

	protected void actionPerformedBtnAll(ActionEvent e) {
		SearchManagerUI frame = new SearchManagerUI();
		frame.setVisible(true);
	}

	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		SearchAllManagerUI frame = new SearchAllManagerUI();
		frame.setVisible(true);
	}
}
