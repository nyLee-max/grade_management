package grade_management.ui.content;

import java.awt.GridLayout;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import grade_management.dto.Ban;
import grade_management.dto.Student;
import grade_management.service.SearchService;
import com.toedter.calendar.JDateChooser;

public class StudentPanel extends JPanel {
	private JTextField tfstdNo;
	private JTextField tfName;
	private JComboBox<Ban> cmbclassCode;
	
	private SearchService service;
	private DefaultComboBoxModel<Ban> banModel;
	private JLabel lblEnterdate;
	private JDateChooser JdcEnterdate;

	
	public StudentPanel() {
		service = new SearchService();
		initialize();
		
		List<Ban> banList = service.showBanList();
		cmbclassCode.setModel(new DefaultComboBoxModel<Ban>(new Vector<>(banList)));
		
		lblEnterdate = new JLabel("입학날짜");
		add(lblEnterdate);
		
		JdcEnterdate = new JDateChooser();
		add(JdcEnterdate);
		
	}



	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblstdNo = new JLabel("학번");
		add(lblstdNo);
		
		tfstdNo = new JTextField();
		add(tfstdNo);
		tfstdNo.setColumns(10);
		
		JLabel lblName = new JLabel("이름");
		add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);
		
		JLabel lblClass = new JLabel("분반");
		add(lblClass);
		
		cmbclassCode = new JComboBox<>();
		add(cmbclassCode);
	}
	
	public void clearTf() {
		tfstdNo.setText("");
		tfName.setText("");
		cmbclassCode.setSelectedIndex(-1);
	}
	
	public void setItem(Student item) {
		tfstdNo.setText(item.getStdNo()+"");
		tfName.setText(item.getStdName()+"");
		cmbclassCode.setSelectedItem(item.getClassCode());
		JdcEnterdate.setDate(item.getEnterDate());
	}
	
	public Student getItem() {
		int stdNo = Integer.parseInt(tfstdNo.getText().trim());
		String stdName = tfName.getText().trim();
		Ban classCode = (Ban) cmbclassCode.getSelectedItem();
		Date enterDate = JdcEnterdate.getDate();
		System.out.println(enterDate);
		return new Student(stdNo, classCode, stdName, enterDate);
	}
	
	
}
