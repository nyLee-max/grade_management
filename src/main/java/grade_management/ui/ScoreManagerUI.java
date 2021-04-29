package grade_management.ui;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.Subject;
import grade_management.service.InsertService;
import grade_management.ui.content.ScorePanel;
import grade_management.ui.list.StudentTablePanel;

public class ScoreManagerUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ScorePanel ScorePanel;
	private JButton btnUpdate;
	private InsertService service;
	private StudentTablePanel table;
	private JButton btnAdd;
	private JButton btnDelete;

	public ScoreManagerUI() {
		setService();
		initialize();
	}
	private void setService() {
		service = new InsertService();
		
	}
	private void initialize() {
		setTitle("학생성적관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ScorePanel = new ScorePanel();
		contentPane.add(ScorePanel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_1.add(btnAdd);
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		panel_1.add(btnDelete);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		Student stdNo = ScorePanel.getStdNo();
		int addKor = ScorePanel.getKor();
		System.out.println(addKor);
		int addeng = ScorePanel.getEng();
		int addmath = ScorePanel.getMath();
		int addSoc = ScorePanel.getSoc();
		int addSci = ScorePanel.getSci();
		
    	Score korInput = new Score(stdNo, new Subject(1), addKor);
    	service.modifyScore(korInput);
		Score engInput = new Score(stdNo, new Subject(2), addeng);
		service.modifyScore(engInput);
		Score mathInput = new Score(stdNo, new Subject(3), addmath);
		service.modifyScore(mathInput);
		Score socInput = new Score(stdNo, new Subject(4), addSoc);
		service.modifyScore(socInput);
		Score sciInput = new Score(stdNo, new Subject(5), addSci);
		service.modifyScore(sciInput);
		
		table.loadData();
		
		JOptionPane.showMessageDialog(null, "성적정보가 수정되었습니다.");

	}
	public void setTable(StudentTablePanel table) {
		this.table = table;
	}
	public ScorePanel getScorePanel() {
		return ScorePanel;
	}
	public void setScorePanel(ScorePanel scorePanel) {
		ScorePanel = scorePanel;
	}
	
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Student stdNo = ScorePanel.getStdNo();
		int kor = ScorePanel.getKor();
		int eng = ScorePanel.getEng();
		int math = ScorePanel.getMath();
		int sci = ScorePanel.getSci();
		int soc = ScorePanel.getSoc();
		Score korInput = new Score(stdNo, new Subject(1), kor);
		service.addScore(korInput);
		Score engInput = new Score(stdNo, new Subject(2), eng);
		service.addScore(engInput);
		Score mathInput = new Score(stdNo,new Subject(3), math);
		service.addScore(mathInput);
		Score socInput = new Score(stdNo, new Subject(4), soc);
		service.addScore(socInput);
		Score sciInput = new Score(stdNo, new Subject(5), sci);
		service.addScore(sciInput);
	}
	protected void actionPerformedBtnDelete(ActionEvent e) {
		ScorePanel.clearTf();
	}
}
