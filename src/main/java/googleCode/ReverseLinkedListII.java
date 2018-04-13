package googleCode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode f = new ListNode(0);
        f.next = head;
        
        ListNode p, q, r, t;
        int i = 0;
        for(p = f; i < m - 1; i++, p = p.next);
        q = t = p.next;
        i++;
        while(i <= n){
        	r = q.next;
        	q.next = p.next;
        	p.next = q;
        	q = r;
        	i++;
        }
        t.next = q;
        return f.next;
    }
}
