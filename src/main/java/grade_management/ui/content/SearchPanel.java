package grade_management.ui.content;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import grade_management.dto.Ban;
import grade_management.dto.Subject;
import grade_management.service.SearchService;

public class SearchPanel extends JPanel {
	private SearchService service;
	private JComboBox cmbSub;
	private JComboBox cmbBan;

	public SearchPanel() {
		setService();
		initialize();
		
		List<Ban> banList = service.showBanList();
		cmbBan.setModel(new DefaultComboBoxModel<Ban>(new Vector<>(banList)));
	
		List<Subject> subList = service.showSubList();
		cmbSub.setModel(new DefaultComboBoxModel<Subject>(new Vector<>(subList)));
	}
	public void setService() {
		service = new SearchService();
	}
	private void initialize() {
		
		
		JLabel lblBan = new JLabel("분반");
		add(lblBan);
		
		cmbBan = new JComboBox();
		add(cmbBan);
		
		JLabel lblSub = new JLabel("과목명");
		add(lblSub);
		
		cmbSub = new JComboBox();
		add(cmbSub);
		
		JButton btnArray = new JButton("정렬");
		add(btnArray);
	}

}
