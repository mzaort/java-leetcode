package microsoft;

public class FisrtSharedNode {
	public ListNode share(ListNode n1, ListNode n2){
		int len1 = length(n1), len2 = length(n2), diff = len1 - len2;
		if(len1 < len2){
			ListNode tmp = n2;
			n2 = n1;
			n1 = tmp;
			diff = -diff;
		}
		ListNode p = n1;
		int k = 0;
		for(; k < diff; k++, p = p.next);
		for(; p != n2; p = p.next, n2 = n2.next);
		return p;
	}

	private int length(ListNode p) {
		int len = 0;
		for(; p != null; len++, p = p.next);
		return len;
	}
	
}
