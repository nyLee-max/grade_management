package grade_management.ui;

import java.awt.BorderLayout;
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
import grade_management.ui.content.StudentPanel;
import grade_management.ui.list.StudentTablePanel;

@SuppressWarnings("serial")
public class ScoreManagerUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private InsertService service;
	private JButton btnAdd;
	private StudentPanel pLeftPanel;
	private ScorePanel pRightPanel;
	private JButton btnClear;
	private JButton btnUpdate;
	
	private StudentTablePanel table;

	
	protected void setService() {
		service = new InsertService();
	}

	public ScoreManagerUI() {
		setService();
		initialize();
	}
	private void initialize() {
		setTitle("학생성적입력");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pLeftPanel = new StudentPanel();
		contentPane.add(pLeftPanel, BorderLayout.WEST);
		
		pRightPanel = new ScorePanel();
		contentPane.add(pRightPanel, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnAdd = new JButton("입력");
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);
		
		btnClear = new JButton("삭제");
		btnClear.addActionListener(this);
		panel_2.add(btnClear);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		panel_2.add(btnUpdate);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Student addStd = pLeftPanel.getItem();
		System.out.println(addStd);
		service.addStudent(addStd);
		
		Score addKor = pRightPanel.getKor();
		Score addeng = pRightPanel.getEng();
		Score addmath = pRightPanel.getMath();
		Score addSoc = pRightPanel.getSoc();
		Score addSci = pRightPanel.getSci();
		
    	Score korInput = new Score(addStd, new Subject(1), addKor.getStdScore());
		service.addScore(korInput);
		Score engInput = new Score(addStd, new Subject(2), addeng.getStdScore());
		service.addScore(engInput);
		Score mathInput = new Score(addStd, new Subject(3), addmath.getStdScore());
		service.addScore(mathInput);
		Score socInput = new Score(addStd, new Subject(4), addSoc.getStdScore());
		service.addScore(socInput);
		Score sciInput = new Score(addStd, new Subject(5), addSci.getStdScore());
		service.addScore(sciInput);

	
		
	
	}
	protected void actionPerformedBtnClear(ActionEvent e) {
		pLeftPanel.clearTf();
		pRightPanel.clearTf();
	}

	public StudentPanel getpLeftPanel() {
		return pLeftPanel;
	}

	public void setpLeftPanel(StudentPanel pLeftPanel) {
		this.pLeftPanel = pLeftPanel;
	}

	public ScorePanel getpRightPanel() {
		return pRightPanel;
	}

	public void setpRightPanel(ScorePanel pRightPanel) {
		this.pRightPanel = pRightPanel;
	}
	
	
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Student updateStd = pLeftPanel.getItem();
		service.modifyStudent(updateStd);
		
		table.loadData();
		
//		Score updateKor = pRightPanel.getKor();
//		Score updateEng = pRightPanel.getEng();
//		Score updateMath = pRightPanel.getMath();
//		Score updateSoc = pRightPanel.getSoc();
//		Score updateSci = pRightPanel.getSci();
//		service.modifyScore(updateKor);
//		service.modifyScore(updateEng);
//		service.modifyScore(updateMath);
//		service.modifyScore(updateSoc);
//		service.modifyScore(updateSci);
//		
//		table.loadData();
		
		JOptionPane.showMessageDialog(null, updateStd.getStdName() + " 정보가 수정되었습니다.");
	}
	
	public void setTable(StudentTablePanel table) {
		this.table = table;
	}
}
