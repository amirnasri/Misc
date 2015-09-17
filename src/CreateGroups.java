import java.util.Arrays;

class CreateGroups {
	
	static int minChanges(int[] groups, int minSize, int maxSize) {
		int sum = 0;
		for (int i = 0; i < groups.length; i++)
			sum += groups[i];
		if (sum < minSize * groups.length || sum > maxSize * groups.length)
			return -1;
		Arrays.sort(groups);
		int min_students = 0;
		for (int i = 0; i < groups.length; i++) {
			if (groups[i] < minSize) {
				min_students += minSize - groups[i];  
			}
			else
				break;
		}

		int max_students = 0;
		for (int i = 0; i < groups.length; i++) {
			if (groups[groups.length - i - 1] > maxSize) {
				max_students += groups[groups.length - i - 1] - maxSize;  
			}
			else
				break;
		}

		return Math.max(min_students, max_students);
	}
	
	public static void main(String[] args) {
		int[] groups = {49,60,36,34,36,52,60,43,52,59};
		int minSize = 45;
		int maxSize = 51;
		System.out.println(minChanges(groups, minSize, maxSize));
				
	}
	
}