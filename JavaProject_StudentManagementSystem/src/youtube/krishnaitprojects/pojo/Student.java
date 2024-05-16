package youtube.krishnaitprojects.pojo;

/***
 * @author KRISHNA IT PROJECTS
 * @version 1
 * @since 2024
 */

public class Student {

	private Integer studentId;

	private String studentName;

	private String studentRollNo;

	private String studentDepartment;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public Student() {
		
	}

	public Student(Integer studentId, String studentName, String studentRollNo, String studentDepartment) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
		this.studentDepartment = studentDepartment;
	}

	@Override
	public String toString() {
		return "Student Details:"
				+ "1. StudentId= " + studentId + ", "
				+ "2. StudentName= " + studentName + ", "
				+ "3. StudentRollNo= " + studentRollNo + ", "
				+ "4. StudentDepartment= " + studentDepartment + "." ;
	}

}
