package googleCode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        
        ListNode p = first, q = first;
        int i = 0;
        while(i < n && p != null){
        	i++;
        	p = p.next;
        }
        assert(i == n && p != null);
        
        while(p.next != null){
        	p = p.next;
        	q = q.next;
        }
        
        q.next = q.next.next;
        
        return first.next;
    }
}
