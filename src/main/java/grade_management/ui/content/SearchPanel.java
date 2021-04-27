package grade_management.ui.content;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import grade_management.dto.Ban;
import grade_management.dto.Subject;
import grade_management.service.SearchService;

@SuppressWarnings("serial")
public class SearchPanel extends JPanel {
	private SearchService service;
	private JComboBox cmbBan;
//	private List<Subject> subList;
	private JComboBox cmbSub;

	public SearchPanel() {
		setService();
		

		initialize();
		cmbBan.setSelectedIndex(-1);
		cmbSub.setSelectedIndex(-1);
		
	}

	public void setService() {
		service = new SearchService();
	}

	public Ban getBan() {
		Ban ban = null;
		if (cmbBan.getSelectedIndex() == -1) {
			return ban;
		}
		if (cmbBan.getSelectedIndex() != -1) {
			ban = (Ban) cmbBan.getSelectedItem();
		}
		return ban;
	}

	public Subject getSubject() {
		Subject subject = null;
		int subNo = 0;
		String subName = null;

		if (cmbSub.getSelectedIndex() == -1) {
			return subject;
		}
		if (cmbSub.getSelectedIndex() != -1) {
			subject = (Subject) cmbSub.getSelectedItem();
		}
		return subject;
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
		
		
		List<Ban> banList = service.showBanList();
		cmbBan.setModel(new DefaultComboBoxModel<Ban>(new Vector<>(banList)));
		
		List<Subject> subList = service.showSubList();
		cmbSub.setModel(new DefaultComboBoxModel<Subject>(new Vector<>(subList)));
		

	}

}
