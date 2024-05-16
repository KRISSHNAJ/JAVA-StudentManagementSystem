package youtube.krishnaitprojects.service;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import youtube.krishnaitprojects.customutility.CustomValidation;
import youtube.krishnaitprojects.pojo.Student;

/***
 * @author KRISHNA IT PROJECTS
 * @version 1
 * @since 2024
 */

public class StudentService {

	private Map<Integer, Student> studentMapObj;
	private Set<Integer> studentIds;

	public StudentService() {
		studentMapObj = new LinkedHashMap<>();
		studentIds = new HashSet<>();
	}

	public String addStudent(Student studentObj) {
		try {
			if (studentObj != null) {
				if (!CustomValidation.isPositive(studentObj.getStudentId())) {
					if (!studentIds.contains(studentObj.getStudentId())) {
						studentMapObj.put(studentObj.getStudentId(), studentObj);
						studentIds.add(studentObj.getStudentId());
						return "The given Student details Successfully ADDED";
					} else {
						return "The Given Student ID are already Available for Other Student !!!";
					}
				} else {
					return "The Given Student ID not Valid!!!";
				}
			} else {
				return "The given Student Details are NULL ";
			}
		} catch (Exception e) {
			System.out.println("Student Details ADDED Operation Failed in StudentService.addStudent() " + e.getMessage());
			return "Please Contact your System Administartor";
		}
	}
	
	public String retrieveStudent(int studentId) {
		try {
			if (!CustomValidation.isPositive(studentId)) {
				if (studentMapObj.containsKey(studentId)) {
					Student studentObj = studentMapObj.get(studentId);
					if (studentObj != null) {
							return "Student details found: " + studentObj.toString();
					} else {
						return "Student details is NULL for this given StudentID " + studentId;
					}
				} else {
					return "Student ID Not found for this given Student Details : " + studentId;
				}
			} else {
				return "Invalid Student ID : " + studentId;
			}
		} catch (Exception e) {
			System.out.println("Student Details Retrieve Operation Failed in StudentService.retrieveStudent(): " + e.getMessage());
			return "Please Contact your System Administartor";
		}
	}

	public String findStudent(int studentId) {
		try {
			if (!CustomValidation.isPositive(studentId)) {
				if (studentMapObj.containsKey(studentId)) {
					return "The given Student ID is available !!!";
				} else {
					return "Student ID Not found in this Student Details : " + studentId;
				}
			} else {
				return "Invalid Student ID : " + studentId;
			}
		} catch (Exception e) {
			System.out.println("Student Details Find Operation Failed in StudentService.retrieveStudent(): " + e.getMessage());
			return "Please Contact your System Administartor";
		}
	}
	
	public String searchStudent(String studentName) {
		try {
			if (!CustomValidation.isNullOrEmpty(studentName)) {
				if (studentMapObj != null) {
					for (Student studentElement : studentMapObj.values()) {
						if (studentName.equalsIgnoreCase(studentElement.getStudentName())) {
							return studentElement.toString();
						} else {
							return "The given Student Name is Not Available !!! ";
						}
					}
				} else {
					return "Student Data is EMPTY !!! ";
				}
			} else {
				return "The given Student Name Input is NULL/ EMPTY !!! ";
			}
		} catch (Exception e) {
			System.out.println("Student Details Search Operation Failed in StudentService.searchStudent(): " + e.getMessage());
			return "Please Contact your System Administartor";
		}
		return "";
	}

	public Set<Student> showAllStudents() {
		Set<Student> studentDetails = new LinkedHashSet<>();
		try {
			if (!studentMapObj.isEmpty() || studentMapObj !=null ) {
				for (Student studentElement : studentMapObj.values()) {
					studentDetails.add(studentElement);
				}
			} else {
				return studentDetails;
			}
		} catch (Exception e) {
			System.out.println("Show All StudentsDetails Operation Failed in StudentService.showAllStudents(): " + e.getMessage());
		}
		return studentDetails;
	}
	
	public String updateStudent(int studentId, Student studentDetails) {
		try {
			if(!CustomValidation.isPositive(studentId)) {
				if(studentMapObj.containsKey(studentId)) {
					if(studentDetails != null) {
						studentMapObj.put(studentId, studentDetails);
					}else {
						return "The Given Student Details are Null";
					}
				}else {
					return "The Given Student ID is Not Available";
				}
			}else {
				return "The Given Student ID is Not Valid!!!";
			}
		}catch (Exception e) {
			System.out.println("Failed to Update Student Details Operation: in StudentService.updateStudent(): " + e.getMessage());
			return "Please Contact your System Administartor";
		}
		return "Student Details Updated Successfully";
	}
	
	public String deleteStudentById(int studentId) {
		try {
			if(!CustomValidation.isPositive(studentId)) {
				if(studentMapObj.containsKey(studentId)) {
					studentMapObj.remove(studentId);
				}else {
					return "The Given Student ID is Not Available";
				}
			}else {
				return "The Given Student ID is Not Valid!!!";
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete Student Details Operation: in StudentService.deleteStudentById(): " + e.getMessage());
			return "Please Contact your System Administartor";
		}
		return "The Given Student Details Successfully Deleted !!!";
	}
	
	public String deleteAllStudents() {
		try {
			studentMapObj.clear();
		} catch (Exception e) {
			System.out.println("Failed to Delete All Student Details Operation: in StudentService.deleteAllStudents(): " + e.getMessage());
			return "Please Contact your System Administartor";
		}
		return "All Student Details Successfully Deleted !!!";
	}

}