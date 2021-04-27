package grade_management.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.StudentScoreAll;
import grade_management.service.SearchService;

public class ScorePanel extends JPanel {
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;
	private JTextField tfSoc;
	private JTextField tfSci;

	private SearchService service;


	public ScorePanel() {
		service = new SearchService();
		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblKor = new JLabel("국어");
		add(lblKor);

		tfKor = new JTextField();
		add(tfKor);
		tfKor.setColumns(10);

		JLabel lblEng = new JLabel("영어");
		add(lblEng);

		tfEng = new JTextField();
		tfEng.setColumns(10);
		add(tfEng);

		JLabel lblMath = new JLabel("수학");
		add(lblMath);

		tfMath = new JTextField();
		tfMath.setColumns(10);
		add(tfMath);

		JLabel lblSoc = new JLabel("사회");
		add(lblSoc);

		tfSoc = new JTextField();
		tfSoc.setColumns(10);
		add(tfSoc);

		JLabel lblSci = new JLabel("과학");
		add(lblSci);

		tfSci = new JTextField();
		tfSci.setColumns(10);
		add(tfSci);
	}

	public void clearTf() {
		tfKor.setText("");
		tfEng.setText("");
		tfMath.setText("");
		tfSoc.setText("");
		tfSci.setText("");
	}

	public void setItem(StudentScoreAll item) {
		tfKor.setText(item.getKor()+"");
		tfEng.setText(item.getEng()+"");
		tfMath.setText(item.getMath()+"");
		tfSoc.setText(item.getSoc()+"");
		tfSci.setText(item.getSci()+"");
	
	}

	public Score getKor() {
		int kor = Integer.parseInt(tfKor.getText().trim());

		return new Score(kor);
	}

	public Score getEng() {
		int eng = Integer.parseInt(tfEng.getText().trim());

		return new Score(eng);
	}

	public Score getMath() {
		int math = Integer.parseInt(tfMath.getText().trim());

		return new Score(math);
	}

	public Score getSoc() {
		int soc = Integer.parseInt(tfSoc.getText().trim());

		return new Score(soc);
	}

	public Score getSci() {
		int sci = Integer.parseInt(tfSci.getText().trim());

		return new Score(sci);
	}
	
	public StudentScoreAll getItem() {
		int kor = Integer.parseInt(tfKor.getText().trim());
		int eng = Integer.parseInt(tfEng.getText().trim());
		int math = Integer.parseInt(tfMath.getText().trim());
		int soc = Integer.parseInt(tfSoc.getText().trim());
		int sci = Integer.parseInt(tfSci.getText().trim());
		return new StudentScoreAll(kor, eng, math, soc, sci);
	}
	

}
