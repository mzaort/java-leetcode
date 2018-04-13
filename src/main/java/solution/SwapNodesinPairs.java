package solution;

public class SwapNodesinPairs {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(3);
		ListNode res = new SwapNodesinPairs().swapPairs(head);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
	
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode first = new ListNode(0);
        first.next = head;
        
        ListNode p, q, r;
        p = first;
        
        while(p != null && (q = p.next) != null && (r = p.next.next) != null){
        	p.next = r;
        	q.next = r.next;
        	r.next = q;
        	p = q;
        }
        
        return first.next;
    }
}
