package solution;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p, q, r, extra;
        extra = new ListNode(0);
        extra.next = head;
        
        int i = 1;
        p = extra;
        q = head;
        
        while(i < m){
        	p = p.next;
        	q = q.next;
        	i++;
        }
        
        r = q.next;
        i++;
        while(i <= n){
        	ListNode tmp = r;
        	r = r.next;
        	
        	tmp.next = p.next;
        	p.next = tmp;
        	i++;
        }
        
        q.next = r;
        
    	head = extra.next;
    	return head;
    }
}
