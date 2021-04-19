package grade_management.ui.list;

import javax.swing.SwingConstants;

import grade_management.dto.Student;
import grade_management.service.SearchService;
import grade_management.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class StudentTablePanel extends AbstractCustomTablePanel<Student> {
	private SearchService service;
	public StudentTablePanel() {
		service = new SearchService();
	}

	@Override
	public void initList() {
		list = service.showStudent();
		System.out.println(list);
	}
	@Override
	protected void setAlighAndwidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
		//컬럼별 너비 조정
		setTableCellWidth(100, 100, 100, 100, 100, 100, 100, 100);
		
	}
	
	@Override
	public Object[] toArray(Student t) {
		return new Object[] {t.getStdNo(), t.getStdName(), t.getBan().getClassCode(), 
				t.getScore().get(0).getStdScore(),
				t.getScore().get(1).getStdScore(), 
				t.getScore().get(2).getStdScore(), 
				t.getScore().get(3).getStdScore(), 
				t.getScore().get(4).getStdScore()};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"학번", "이름", "분반", "국어", "영어", "수학", "사회", "과학"};
	}



	public Student getItem() {
		int row = table.getSelectedRow();
		int StdNo = (int)table.getValueAt(row, 0);
		
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Student(StdNo)));
	}

	
}
