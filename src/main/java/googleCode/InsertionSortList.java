package googleCode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
    	ListNode first = new ListNode(0);
    	ListNode p = head, q, r;
    	while(p != null){
    		r = p.next;
    		q = first;
    		for(; q.next != null && q.next.val < p.val; q = q.next);
    		p.next = q.next;
    		q.next = p;
    		p = r;
    	}
    	return first.next;
    }
}
