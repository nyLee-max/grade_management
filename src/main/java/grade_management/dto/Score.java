package grade_management.dto;

public class Score {
	private int No;
	private Student stdNo;
	private Subject subNo;
	private int stdScore;

	public Score() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Score(Subject subNo, int stdScore) {
		this.subNo = subNo;
		this.stdScore = stdScore;
	}


	public Score(Subject subNo) {
		this.subNo = subNo;
	}


	public Score(Student stdNo) {
		this.stdNo = stdNo;
	}

	public Score(int stdScore) {
		this.stdScore = stdScore;
	}


	public Score(Student stdNo, Subject subNo, int stdScore) {
		this.stdNo = stdNo;
		this.subNo = subNo;
		this.stdScore = stdScore;
	}


	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		this.No = no;
	}
	
	
	
	public Student getStdNo() {
		return stdNo;
	}


	public void setStdNo(Student stdNo) {
		this.stdNo = stdNo;
	}


	public Student getStudent() {
		return stdNo;
	}
	public void setStudent(Student stdNo) {
		this.stdNo = stdNo;
	}
	public Subject getSubject() {
		return subNo;
	}
	public void setSubject(Subject subNo) {
		this.subNo = subNo;
	}
	public int getStdScore() {
		return stdScore;
	}
	public void setStdScore(int stdScore) {
		this.stdScore = stdScore;
	}
	@Override
	public String toString() {
		return String.format("Score [No=%s, stdNo=%s, subNo=%s, stdScore=%s]", No, stdNo, subNo, stdScore);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stdNo == null) ? 0 : stdNo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (stdNo == null) {
			if (other.stdNo != null)
				return false;
		} else if (!stdNo.equals(other.stdNo))
			return false;
		return true;
	}

	
	
	
}
