package grade_management.dto;

public class StudentScoreAll {
	private int stdNo;
	private String stdName;
	private Ban classCode;
	private int kor;
	private int eng;
	private int math;
	private int soc;
	private int sci;
	private int avg;

	public StudentScoreAll() {
	}


	
	public StudentScoreAll(int kor, int eng, int math, int soc, int sci) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.soc = soc;
		this.sci = sci;
	}



	public StudentScoreAll(int stdNo, String stdName, Ban classCode, int kor, int eng, int math, int soc, int sci,
			int avg) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.classCode = classCode;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.soc = soc;
		this.sci = sci;
		this.avg = avg;
	}



	public StudentScoreAll(int stdNo) {
		this.stdNo = stdNo;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public Ban getClassCode() {
		return classCode;
	}

	public void setClassCode(Ban classCode) {
		this.classCode = classCode;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getSoc() {
		return soc;
	}

	public void setSoc(int soc) {
		this.soc = soc;
	}

	public int getSci() {
		return sci;
	}

	public void setSci(int sci) {
		this.sci = sci;
	}
	
	

	public int getAvg() {
		return avg;
	}



	public void setAvg(int avg) {
		this.avg = avg;
	}


	@Override
	public String toString() {
		return String.format(
				"StudentScoreAll [stdNo=%s, stdName=%s, classCode=%s, kor=%s, math=%s, eng=%s, soc=%s, sci=%s, avg=%s]",
				stdNo, stdName, classCode, kor, math, eng, soc, sci, avg);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stdNo;
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
		StudentScoreAll other = (StudentScoreAll) obj;
		if (stdNo != other.stdNo)
			return false;
		return true;
	}

}