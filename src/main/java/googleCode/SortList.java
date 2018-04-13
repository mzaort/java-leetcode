package googleCode;

public class SortList {
    public ListNode sortList(ListNode head) {
    	return sortList2(head)[0];
    }

	private ListNode[] sortList2(ListNode head) {
		ListNode[] res = {null, null};
		if(head != null){
			ListNode[] list = partition(head);
			ListNode[] left = sortList2(list[0]);
			ListNode[] right = sortList2(list[1]);
			
			if(left[0] == null){
				res[0] = head;
				head.next = right[0];
			}else{
				res[0] = left[0];
				left[1].next = head;
				head.next = right[0];
			}
			
			if(right[0] == null){
				res[1] = head;
			}else{
				res[1] = right[1];
			}
			
			res[1].next = null;
		}
		return res;
	}

	private ListNode[] partition(ListNode head) {
		//head not null;
		ListNode[] res = {null, null};
		ListNode p = head.next, q;
		while(p != null){
			q = p.next;
			if (p.val <= head.val) {
				p.next = res[0];
				res[0] = p;
			} else {
				p.next = res[1];
				res[1] = p;
			}
			p = q;
		}
		return res;
	}
}
