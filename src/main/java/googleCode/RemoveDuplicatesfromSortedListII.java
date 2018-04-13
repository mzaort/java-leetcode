package googleCode;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode f = new ListNode(0);
    	f.next = head;
    	
    	ListNode p = f;
    	while(p.next != null){
    		ListNode q = p.next;
    		int val = q.val;
    		int cnt = 1;
    		for(q = q.next; q != null && q.val == val; q = q.next, cnt++);
    		if(cnt >= 2){
    			p.next = q;
    		}else{
    			p = p.next;
    		}
    	}
    	return f.next;
    }
}
