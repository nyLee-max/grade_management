package grade_management.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import grade_management.dto.Ban;
import grade_management.dto.Score;
import grade_management.dto.StudentScoreAll;
import grade_management.dto.Subject;
import grade_management.service.SearchService;
import grade_management.ui.content.SearchPanel;
import grade_management.ui.list.StudentScoreTablePanel;
import grade_management.ui.list.StudentTablePanel;
import grade_management.ui.content.avgPanel;

public class SearchManagerUI extends JFrame implements ActionListener {

	private SearchPanel contentPane;
	private SearchService service;
	private StudentScoreTablePanel pList;
	private JButton btnArray;
	private JPanel panel;
	private SearchPanel pContent;
	private JPanel panel_3;
	private JButton btnSel;
	private avgPanel avgPanel;
	

	public SearchManagerUI() {
		setService();
		initialize();
	}

	protected void setService() {
		service = new SearchService();
	}

	private void initialize() {
		setTitle("분반별성적확인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 470);
		contentPane = new SearchPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		pList = new StudentScoreTablePanel();
		pList.loadData();
		contentPane.add(pList, BorderLayout.CENTER);

		panel = new JPanel();
		pList.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		pContent = new SearchPanel();
		panel.add(pContent);

		panel_3 = new JPanel();
		panel.add(panel_3);

		btnSel = new JButton("정렬");
		btnSel.addActionListener(this);
		panel_3.add(btnSel);

		avgPanel = new avgPanel();
		List<Score> korlist = service.showStdScoreBySubNo(new Subject(1));
		int korsum = 0;
		for(int i = 0; i < korlist.size(); i++) {
			korsum += korlist.get(i).getStdScore();
		}
		
		avgPanel.getTfKor().setText(korsum/korlist.size()+"");
		
		List<Score> englist = service.showStdScoreBySubNo(new Subject(2));
		int engsum = 0;
		for(int i=0; i< englist.size(); i++) {
			engsum +=englist.get(i).getStdScore();
		}
		
		avgPanel.getTfEng().setText(engsum/englist.size()+"");
		
		List<Score> mathlist = service.showStdScoreBySubNo(new Subject(3));
		int mathsum = 0;
		for(int i=0; i< mathlist.size(); i++) {
			mathsum += mathlist.get(i).getStdScore();
		}
		
		avgPanel.getTfMath().setText(mathsum/mathlist.size()+"");
		
		List<Score> soclist = service.showStdScoreBySubNo(new Subject(4));
		int socsum = 0;
		for(int i=0; i<soclist.size();i++) {
			socsum +=soclist.get(i).getStdScore();
		}
		
		avgPanel.getTfSoc().setText(socsum/soclist.size()+"");
		
		List<Score> scilist = service.showStdScoreBySubNo(new Subject(5));
		int scisum = 0;
		for(int i=0; i<scilist.size();i++) {
			scisum +=scilist.get(i).getStdScore();
		}
		
		avgPanel.getTfSci().setText(scisum/scilist.size()+"");
		
		contentPane.add(avgPanel, BorderLayout.SOUTH);
		
		avgPanel.setLayout(new BoxLayout(avgPanel, BoxLayout.X_AXIS));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSel) {
			actionPerformedBtnSel(e);
		}
	}

	protected void actionPerformedBtnSel(ActionEvent e) {
		Ban ban = pContent.getBan();
		Subject subject = pContent.getSubject();
		if (ban != null && subject != null) {
			List<StudentScoreAll> stdList = service.showStudentScoreByBanSubject(ban, subject);
			pList.setInitList(stdList);
			pList.setList();
		} else if (ban == null && subject != null) {
			List<StudentScoreAll> stdList = service.showStudentScoreBySubject(subject);
			pList.setInitList(stdList);
			pList.setList();
		} else {
			List<StudentScoreAll> stdList = service.showStudentScoreByBan(ban);
			pList.setInitList(stdList);
			pList.setList();
		}

	}
}
