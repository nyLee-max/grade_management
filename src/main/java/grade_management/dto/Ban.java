package grade_management.dto;

public class Ban {
	private String classCode;

	public Ban() {
		// TODO Auto-generated constructor stub
	}

	public Ban(String classCode) {
		this.classCode = classCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classCode == null) ? 0 : classCode.hashCode());
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
		Ban other = (Ban) obj;
		if (classCode == null) {
			if (other.classCode != null)
				return false;
		} else if (!classCode.equals(other.classCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s", classCode);
	}

}
