import java.util.Arrays;
import java.util.Comparator;

public class Compare_software_versions {

	static class Version_comparator implements Comparator<String> {
		
		public int compare(String v1, String v2) {
			
			String[] v1_ = v1.split("\\.");
			String[] v2_ = v2.split("\\.");
			
			int l_min = Math.min(v1_.length, v2_.length);
			int i = 0;
			while (i < l_min) {
				if (v1_[i].compareTo(v2_[i]) != 0) 
					break;
				i++;
			}
			if (i < l_min) {
				
				int v1_i = v1_[i].compareTo("") == 0 ? 0 : Integer.parseInt(v1_[i]);
				int v2_i = v2_[i].compareTo("") == 0 ? 0 : Integer.parseInt(v2_[i]);
				return Integer.compare(v1_i, v2_i);
			}
			return Integer.compare(v1_.length, v2_.length);
		}
	}
	
	
	public static void main(String[] args) {
		String[] v1 = {"32.2.41.1", "3.4", "312.3.2", "3.2.4212", "1.32", "5.23.4", "5.2.1.2.3.4", "1.23"};
		//System.out.println(compare_versions(v1, v2));
		Arrays.sort(v1, new Version_comparator());
		
		for (String v: v1) {
			System.out.format("%s   ", v);
		}
		
	}
	
}
















