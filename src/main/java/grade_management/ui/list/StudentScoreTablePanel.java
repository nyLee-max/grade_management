package grade_management.ui.list;

import java.util.List;

import javax.swing.SwingConstants;

import grade_management.dto.StudentScoreAll;
import grade_management.service.SearchService;
import grade_management.ui.exception.NotSelectedException;

public class StudentScoreTablePanel extends AbstractCustomTablePanel<StudentScoreAll> {
	private SearchService service;

	public StudentScoreTablePanel() {
		service = new SearchService();
	}

	@Override
	public void initList() {
		list = service.showStudentScoreByAll();
		System.out.println(list);
	}

	@Override
	public StudentScoreAll getItem() {
		int row = table.getSelectedRow();
		int stdNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new StudentScoreAll(stdNo)));
	}

	public void setInitList(List<StudentScoreAll> std) {
		list = std;
	}

	@Override
	protected void setAlighAndwidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8);
		setTableCellWidth(100, 100, 100, 100, 100, 100, 100, 100, 100);

	}

	@Override
	public Object[] toArray(StudentScoreAll t) {
		return new Object[] { t.getStdNo(), t.getStdName(), t.getClassCode(), t.getKor(), t.getEng(), t.getMath(),
				t.getSoc(), t.getSci(), t.getAvg() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "학번", "이름", "분반", "국어", "영어", "수학", "사회", "과학", "평균" };
	}

}
