import java.util.ArrayList;

/*
 * Sept 16, 2015
 * Topcoder: http://community.topcoder.com/stat?c=problem_statement&pm=10251&rd=13520
 */

public class LinearPolyominoCovering {
	static StringBuilder sb = new StringBuilder();
	static boolean findCovering_(int len) {
		if (len % 2 != 0)
			return false;
		while (len > 2) {
			sb.append("AAAA");
			len -= 4;
		}
		if (len == 2)
			sb.append("BB");
		return true;
	}
	/*
	static String findCovering(String region) {
		int i = 0;
		int j = 0;
		while (j < region.length()) {
			if (region.charAt(j) == '.') {
				if (j > i && !findCovering_(j - i))
					return "impossible";

				sb.append('.');
				j++;
				while (j < region.length() && region.charAt(j) == '.') {
					sb.append('.');
					j++;
				}
				i = j;
			}
			else
				j++;
		}
		if (j == region.length()) {
			if (!findCovering_(j - i))
				return "impossible";
		}
		return sb.toString();
	}
	*/
	static String findCovering(String region) {
		
		// TODO: check region.length() == 1
		int i = 0;
		int j = 0;
		
		while (j < region.length() - 1) {
			if (region.charAt(j) == '.')
				sb.append('.');
			
			if (region.charAt(j) == 'X' && region.charAt(j+1) == '.') {
				if (!findCovering_(j - i + 1))
					return "impossible";
			} else if (region.charAt(j) == '.' && region.charAt(j+1) == 'X') {
				i = j + 1;
			}
			j++;
		}
		if (region.charAt(region.length() - 1) != '.') {
			if (!findCovering_(region.length() - i))
				return "impossible";
		}
		else
			sb.append('.');

		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(findCovering(".XX.."));

	}

}
