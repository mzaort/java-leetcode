package solution;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ListNode first, p, q;
    	first = new ListNode(0);
    	first.next  = head;
    	p = first;
    	for(int cur = 0; cur < n && p != null; cur++){
    		p = p.next;
    	}
    	if(p != null){
    		q = first;
    		while(p.next != null){
    			p = p.next;
    			q = q.next;
    		}
    		q.next = q.next.next;
    	}
    	return first.next;
    }
}
