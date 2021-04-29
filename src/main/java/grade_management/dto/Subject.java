package grade_management.dto;

public class Subject {
	private int subNo;
	private String subName;
	
	public Subject() {
	}
	
	public Subject(int subNo) {
		this.subNo = subNo;
	}
	
	public Subject(int subNo, String subName) {
		this.subNo = subNo;
		this.subName = subName;
	}
	
	public Subject(String subName) {
		this.subName = subName;
	}

	public int getSubNo() {
		return subNo;
	}
	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}

	
	@Override
	public String toString() {
		return String.format("%s" , subName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subNo;
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
		Subject other = (Subject) obj;
		if (subNo != other.subNo)
			return false;
		return true;
	}

	
}
