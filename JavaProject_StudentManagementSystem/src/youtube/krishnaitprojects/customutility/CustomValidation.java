package youtube.krishnaitprojects.customutility;

/***
 * @author KRISHNA IT PROJECTS
 * @version 1
 * @since 2024
 */

public class CustomValidation {

	public static boolean isPositive(Integer value) { // +ve integer
		try {
			if (value < 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Exception Occured in CustomerValidation.isPositive()," + e.getMessage());
		}
		return false;
	}

	public static boolean isNullOrEmpty(String value) { // given str is null/empty
		try {
			if (value == null || value.trim().isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Exception Occured in CustomerValidation.isPositive()," + e.getMessage());
		}
		return false;
	}

}