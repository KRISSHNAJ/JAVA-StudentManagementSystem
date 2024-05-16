package youtube.krishnaitprojects.apptest;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import youtube.krishnaitprojects.customutility.CustomValidation;
import youtube.krishnaitprojects.pojo.Student;
import youtube.krishnaitprojects.service.StudentService;

/***
 * @author KRISHNA IT PROJECTS
 * @version 1
 * @since 2024
 */

public class StudentApp {

	public static void main(String[] args) {
		try {

			StudentService studentServiceObj = new StudentService();

			Scanner scannerObj = new Scanner(System.in);

			int option = 0;

			do {
				displayMenu();
				option = scannerObj.nextInt();
				scannerObj.nextLine();
				switch (option) {
				case 1:
					addStudent(studentServiceObj, scannerObj);
					break;
				case 2:
					retrieveStudent(studentServiceObj, scannerObj);
					break;
				case 3:
					findStudent(studentServiceObj, scannerObj);
					break;
				case 4:
					searchStudent(studentServiceObj, scannerObj);
					break;
				case 5:
					showAllStudents(studentServiceObj, scannerObj);
					break;
				case 6:
					updateStudent(studentServiceObj, scannerObj);
					break;
				case 7:
					deleteStudentById(studentServiceObj, scannerObj);
					break;
				case 8:
					deleteAllStudent(studentServiceObj, scannerObj);
					break;
				case 9:
					System.out.println("Program Exit..");
					break;
				default:
					System.out.println("Invalid Option!!!");
				}
			} while (option != 9);
			scannerObj.close();

		} catch (Exception e) {
			System.out.println("Failed to make any operations: in StudentApp " + e.getMessage());
			System.out.println("Please Contact your System Administartor");
		}
	}
	

	public static void displayMenu() {
        System.out.println("MENU");
        System.out.println("1: Add Student");
        System.out.println("2: Retrieve Student");
        System.out.println("3: Find Student");
        System.out.println("4: Search Student");
        System.out.println("5: Show All Students");
        System.out.println("6: Update Student");
        System.out.println("7: Delete Student");
        System.out.println("8: Delete All Student");
        System.out.println("9: Exit");
        System.out.println("Enter your choice: ");
	}
	
	
	private static void addStudent(StudentService studentServiceObj, Scanner scannerObj) {
		try {
			System.out.println("Enter student details:");
			System.out.println("Student ID: ");
			Integer studentId = scannerObj.nextInt();
			scannerObj.nextLine(); 
			System.out.println("Student Name: ");
			String studentName = scannerObj.nextLine();
			System.out.println("Student Roll No: ");
			String studentRollNo = scannerObj.nextLine();
			System.out.println("Student Department: ");
			String studentDepartment = scannerObj.nextLine();
			String isStudentAdded = studentServiceObj.addStudent(new Student(studentId, studentName, studentRollNo, studentDepartment));
			System.out.println(isStudentAdded);
		} catch (Exception e) {
			System.out.println("Failed to ADD student details Operations: in StudentApp.addStudent() " + e.getMessage());
			System.out.println("Please Contact your System Administartor");
		}
	}
	

	private static void retrieveStudent(StudentService studentServiceObj, Scanner scannerObj) {
	    try {
	        System.out.println("Enter the Student ID: ");
	        int studentId = scannerObj.nextInt();
	        scannerObj.nextLine(); 
	        String result = studentServiceObj.retrieveStudent(studentId);
	        if (result != null) {
	            System.out.println(result);
	        } else {
	            System.out.println("Student Details Not Available !!!");
	        }
	    } catch (Exception e) {
	        System.out.println("Failed to retrieve student details Operations: in StudentApp.retrieveStudent()" + e.getMessage());
	        System.out.println("Please Contact your System Administartor");
	    }
	}
	
	private static void findStudent(StudentService studentServiceObj, Scanner scannerObj) {
		try {
			System.out.println("Enter the Student ID: ");
			int studentId = scannerObj.nextInt();
			String output = studentServiceObj.findStudent(studentId);
			System.out.println(output);
		}catch (Exception e) {
			System.out.println("Failed to find student details Operations: in StudentApp.findStudent()" + e.getMessage());
			System.out.println("Please Contact your System Administartor");
		}
		
	}
	
	private static void searchStudent(StudentService studentServiceObj, Scanner scannerObj) {
		try {
			System.out.println("Enter the Student NAME: ");
			String studentName = scannerObj.nextLine();
			if (!CustomValidation.isNullOrEmpty(studentName)) {
				String output = studentServiceObj.searchStudent(studentName);
				System.out.println(output);
			}else {
				System.out.println("The given Student Name Input was NULL/ EMPTY !!!");
			}
		} catch (Exception e) {
			System.out.println("Failed to Search student details Operations: in StudentApp.findStudent()" + e.getMessage());
			System.out.println("Please Contact your System Administartor");
		}
	}
	
	private static void showAllStudents(StudentService studentServiceObj, Scanner scannerObj) {
		Set<Student> studentDetails = new LinkedHashSet<>();
		try {
			studentDetails = studentServiceObj.showAllStudents();
			if (!studentDetails.isEmpty()) {
				for (Student studentElement : studentDetails) {
					System.out.println(studentElement.toString());
				}
			}else {
				System.out.println("No Student Details Found !!!");
			}
		} catch (Exception e) {
			System.out.println("Failed to Show All Students Details Operations: in StudentApp.showAllStudents()" + e.getMessage());
			System.out.println("Please Contact your System Administartor");
		}
	}
	
	private static void updateStudent(StudentService studentServiceObj, Scanner scannerObj) {
		try {
			System.out.println("Enter student details:");
			System.out.println("Student ID: ");
			Integer studentId = scannerObj.nextInt();
			scannerObj.nextLine();
			System.out.println("Student Name: ");
			String studentName = scannerObj.nextLine();
			System.out.println("Student Roll No: ");
			String studentRollNo = scannerObj.nextLine();
			System.out.println("Student Department: ");
			String studentDepartment = scannerObj.nextLine();
			String result = studentServiceObj.updateStudent(studentId, new Student(studentId, studentName, studentRollNo, studentDepartment));
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Failed to Update Student Details Operation: in StudentApp.updateStudent()" + e.getMessage());
			System.out.println("Please Contact your System Administartor");
		}

	}

	private static void deleteStudentById(StudentService studentServiceObj, Scanner scannerObj) {
		try {
			System.out.println("Enter The Student ID You want to Delete: ");
			int studentId = scannerObj.nextInt();
			String output = studentServiceObj.deleteStudentById(studentId);
			System.out.println(output);
		} catch (Exception e) {
			System.out.println("Failed to Delete Student Details By ID Operation: in StudentApp.deleteStudentById()" + e.getMessage());
			System.out.println("Please Contact your System Administartor");
		}	
	}
	
	private static void deleteAllStudent(StudentService studentServiceObj, Scanner scannerObj) {
		try {
			System.out.println("All Student Details Deleting operation going on....");
			String output = studentServiceObj.deleteAllStudents();
			System.out.println(output);
		}catch (Exception e) {
			System.out.println("Failed to Delete All Student Details Operation: in StudentApp.deleteAllStudent()" + e.getMessage());
			System.out.println("Please Contact your System Administartor");
		}	
	}
	
}
