package googleCode;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        assert (k > 0);
        if(k == 1) return head;
        
        ListNode first = new ListNode(0);
        ListNode p = head, u = first;
        ListNode q, r, s, t;
        int cnt = 0;
        while(p != null){
        	for(cnt = 1, q = p; cnt < k && q != null; q = q.next, cnt++);
        	if(cnt < k || q == null) {u.next = p; break;}
        	
        	r = q.next;
        	s = p;
        	while(s != r){
        		t = s.next;
        		s.next = u.next;
        		u.next = s;
        		s = t;
        	}
        	u = p;
        	p = r;
        }
        return first.next;
    }
}
