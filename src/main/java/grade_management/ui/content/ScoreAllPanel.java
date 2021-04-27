package grade_management.ui.content;

import javax.swing.JPanel;

import grade_management.dto.Subject;
import grade_management.service.SearchAllService;

import javax.swing.JLabel;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ScoreAllPanel extends JPanel {
	private SearchAllService service;
	private JComboBox cmbSub;
	private List<Subject> subList;
	private JTextField textField;
	private JLabel lblAll;

	public ScoreAllPanel() {
		setService();
		initialize();
		cmbSub.setSelectedIndex(-1);
	}

	private void setService() {
		service = new SearchAllService();

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
		lblAll = new JLabel("전체인원수");
		add(lblAll);

		textField = new JTextField();
		add(textField);
		textField.setColumns(5);

		JLabel lblSub = new JLabel("과목명");
		add(lblSub);

		cmbSub = new JComboBox();
		add(cmbSub);

		subList = service.showSubList();

		cmbSub.setModel(new DefaultComboBoxModel<Subject>(new Vector<>(subList)));

	}

	public JTextField getTextField() {
		return textField;
	}

}
