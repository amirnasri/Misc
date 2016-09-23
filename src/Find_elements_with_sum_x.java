import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

class Find_elements_with_sum_x {
	public static void main(String[] args) {
		
		Integer[] l = new Integer[10];
		Random r = new Random();
		for (int i = 0; i < l.length; i++) {
			l[i] = r.nextInt(10);
			System.out.print(l[i] + "  ");
		}
		System.out.println();

		int x = 10;
		/*
		HashSet<Integer> hs = new HashSet<>();
		int x_2_cnt = 0;
		boolean check_for_x_2 = x % 2 == 0;
		for (int i: l) {
			if (check_for_x_2 && i == x/2) {
				x_2_cnt++;
				if (x_2_cnt == 2) {
					System.out.println(x/2);
					return;
				}
			}
			hs.add(i);
		}
		
		for (int i: l) {
			if (hs.contains(new Integer(x-i))) {
				if (i != x/2 || x % 2 != 0) {
					System.out.println(i);
				}
			}
		}
		*/
		// Second solution
		
		int low = 0;
		int high = l.length - 1;
		
		Arrays.sort(l);
		
		for (int i: l) {
			System.out.print(i + "  ");
		}
		System.out.println();
		
		while (low != high) {
			if (l[low] + l[high] > x)
				high --;
			else if (l[low] + l[high] < x)
				low ++;
			else {
				System.out.println(low + "  " + high);
				low ++;
			}
		}
		
	}
}

/*
# python implementations
import sys

a = [4, 11, 1, 8, 12, 6, 3]
a = sorted(a)
print(a)

l = 0
r = len(a) -1

sum = int(sys.stdin.readline())

while True:
	if (l >= r):
		break
	s = a[l] + a[r]
	if (s < sum):
		l += 1
	elif (s > sum):
		r -= 1
	else:
		print(a[l], a[r])
		l += 1
		r -= 1
	
*/
