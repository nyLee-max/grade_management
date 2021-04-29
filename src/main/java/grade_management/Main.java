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
import grade_management.ui.StudentManagerUI;
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
	private JButton btnNewButton_1;

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

		btnScore = new JButton("학생정보입력");
		btnScore.addActionListener(this);
		pBtns.add(btnScore);

		btnAll = new JButton("분반별성적확인");
		btnAll.addActionListener(this);
		
		btnNewButton_1 = new JButton("학생성적관리");
		btnNewButton_1.addActionListener(this);
		pBtns.add(btnNewButton_1);
		pBtns.add(btnAll);

		btnNewButton = new JButton("전체성적확인");
		btnNewButton.addActionListener(this);
		pBtns.add(btnNewButton);

		pList = new StudentTablePanel();
		pList.loadData();
		contentPane.add(pList);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
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
		StudentManagerUI frame = new StudentManagerUI();
		frame.setVisible(true);

//		System.out.println("pList.getItem().getStdNo() " + pList.getItem().getStdNo());
		Student item = service.showStudentBystdNo(new Student(pList.getItem().getStdNo()));
		frame.getpLeftPanel().setItem(item);
		
		
//		frame.getpRightPanel().setItem(score);
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
	
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		ScoreManagerUI frame = new ScoreManagerUI();
		frame.setVisible(true);
		
		StudentScoreAll item = service.showStudentScoreByStdNo(new Student(pList.getItem().getStdNo()));
		frame.getScorePanel().setItem(item);
		frame.setTable(pList);
	}
}
