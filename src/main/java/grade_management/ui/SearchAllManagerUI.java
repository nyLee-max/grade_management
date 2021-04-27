package grade_management.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import grade_management.ui.list.StudentScoreTablePanel;
import grade_management.ui.content.avgPanel;
import grade_management.dto.Score;
import grade_management.dto.StudentScoreAll;
import grade_management.dto.Subject;
import grade_management.service.SearchAllService;
import grade_management.service.SearchService;
import grade_management.ui.content.ScoreAllPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SearchAllManagerUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private SearchAllService service;
	private StudentScoreTablePanel pList;
	private JButton btnNewButton;
	private ScoreAllPanel pContent;
	
	private List<StudentScoreAll> list;
	private SearchService searchService;
	private avgPanel avgPanel;
	
	public SearchAllManagerUI() {
		searchService = new SearchService();
		list = searchService.showStudentScoreByAll();
		setService();
		initialize();
	}

	private void setService() {
		service = new SearchAllService();

	}

	private void initialize() {
		setTitle("전체성적확인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 556, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pList = new StudentScoreTablePanel();
		pList.loadData();
		contentPane.add(pList, BorderLayout.CENTER);

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
		pList.add(avgPanel, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		pContent = new ScoreAllPanel();
		pContent.getTextField().setText(list.size()+"");
		panel.add(pContent);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		btnNewButton = new JButton("조회");
		btnNewButton.addActionListener(this);
		panel_3.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		Subject subject = pContent.getSubject();
		
		if(subject != null) {
			List<StudentScoreAll> stdList = service.showStudentScoreBySubject(subject);
			pList.setInitList(stdList);
			pList.setList();
		}else {
			List<StudentScoreAll> stdList = service.showStudentScoreByAvg();
			pList.setInitList(stdList);
			pList.setList();
		}
				
	}
}
