package grade_management.dto;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

public class Student {
	private int stdNo;
	private Ban classCode;
	private String stdName;
	private Date enterDate;
	private String PhotoName;
	private Blob stdPhoto;
	private List<Score> score;
	private int avg;

	public Student(int stdNo, Ban classCode, String stdName, Date enterDate, String photoName, Blob stdPhoto,
			List<Score> score, int avg) {
		this.stdNo = stdNo;
		this.classCode = classCode;
		this.stdName = stdName;
		this.enterDate = enterDate;
		PhotoName = photoName;
		this.stdPhoto = stdPhoto;
		this.score = score;
		this.avg = avg;
	}

	public Student(int stdNo, Ban classCode, String stdName, List<Score> score, int avg) {
		this.stdNo = stdNo;
		this.classCode = classCode;
		this.stdName = stdName;
		this.score = score;
		this.avg = avg;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public Student(int stdNo, Ban classCode, String stdName, Date enterDate) {
		this.stdNo = stdNo;
		this.classCode = classCode;
		this.stdName = stdName;
		this.enterDate = enterDate;
	}



	public Student(int stdNo, Ban classCode, String stdName, List<Score> score) {
		this.stdNo = stdNo;
		this.classCode = classCode;
		this.stdName = stdName;
		this.score = score;
	}



	public Student(int stdNo, Ban classCode, String stdName) {
		this.stdNo = stdNo;
		this.classCode = classCode;
		this.stdName = stdName;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Ban classCode) {
		this.classCode = classCode;
	}

	public Student(int stdNo, Ban classCode, String stdName, Date enterDate, String photoName, Blob stdPhoto,
			List<Score> score) {
		this.stdNo = stdNo;
		this.classCode = classCode;
		this.stdName = stdName;
		this.enterDate = enterDate;
		this.PhotoName = photoName;
		this.stdPhoto = stdPhoto;
		this.score = score;
	}



	public Student(int stdNo) {
		this.stdNo = stdNo;
	}



	public Student(int stdNo, Ban classCode, String stdName, Date enterDate, String photoName, Blob stdPhoto) {
		this.stdNo = stdNo;
		this.classCode = classCode;
		this.stdName = stdName;
		this.enterDate = enterDate;
		this.PhotoName = photoName;
		this.stdPhoto = stdPhoto;
	}


	public Ban getBan() {
		return classCode;
	}
	
	
	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}


	public Ban getClassCode() {
		return classCode;
	}
	
	public void setClassCode(Ban classCode) {
		this.classCode = classCode;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getPhotoName() {
		return PhotoName;
	}

	public void setPhotoName(String photoName) {
		PhotoName = photoName;
	}

	public Blob getStdPhoto() {
		return stdPhoto;
	}

	public void setStdPhoto(Blob stdPhoto) {
		this.stdPhoto = stdPhoto;
	}

	public List<Score> getScore() {
		return score;
	}

	public void setScore(List<Score> score) {
		this.score = score;
	}
	

	@Override
	public String toString() {
		return String.format("Student [stdNo=%s, classCode=%s, stdName=%s, enterDate=%s, PhotoName=%s, stdPhoto=%s]",
				stdNo, classCode, stdName, enterDate, PhotoName, stdPhoto);
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
		Student other = (Student) obj;
		if (stdNo != other.stdNo)
			return false;
		return true;
	}


	


}
