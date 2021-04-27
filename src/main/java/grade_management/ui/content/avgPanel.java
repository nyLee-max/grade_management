package grade_management.ui.content;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class avgPanel extends JPanel {
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;
	private JTextField tfSoc;
	private JTextField tfSci;

	/**
	 * Create the panel.
	 */
	public avgPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("과목별평균점수");
		add(label);
		
		tfKor = new JTextField();
		tfKor.setColumns(5);
		add(tfKor);
		
		tfEng = new JTextField();
		tfEng.setColumns(5);
		add(tfEng);
		
		tfMath = new JTextField();
		tfMath.setColumns(5);
		add(tfMath);
		
		tfSoc = new JTextField();
		tfSoc.setColumns(5);
		add(tfSoc);
		
		tfSci = new JTextField();
		tfSci.setColumns(5);
		add(tfSci);
	}
	public JTextField getTfKor() {
		return tfKor;
	}
	public void setTfKor(JTextField tfKor) {
		this.tfKor = tfKor;
	}
	public JTextField getTfEng() {
		return tfEng;
	}
	public void setTfEng(JTextField tfEng) {
		this.tfEng = tfEng;
	}
	public JTextField getTfMath() {
		return tfMath;
	}
	public void setTfMath(JTextField tfMath) {
		this.tfMath = tfMath;
	}
	public JTextField getTfSoc() {
		return tfSoc;
	}
	public void setTfSoc(JTextField tfSoc) {
		this.tfSoc = tfSoc;
	}
	public JTextField getTfSci() {
		return tfSci;
	}
	public void setTfSci(JTextField tfSci) {
		this.tfSci = tfSci;
	}

	
}
