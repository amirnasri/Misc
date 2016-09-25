
public class Remove_every_kth_node {

	class Node
	{
		Node next;
		int data;
		
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	class GfG
	{
	    /*You are required to complete this method*/
	    Node delete(Node head, int k)
	    {
		// Your code here
		    if (k == 1 || head == null)
		        return null;
		        
		    Node n = head;
		    int i = 0;
		    while (true) {
		        if (n == null)
		            break;
		        if (i % k == k-2 && n.next != null) {
		            n.next = n.next.next;
		            i += 1;    
		        }
		        n = n.next;
		        i += 1;
		    }
		    return head;
	    }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = null;
		if (i)
			System.out.println();

	}

}


