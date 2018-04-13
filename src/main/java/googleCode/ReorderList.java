package googleCode;

public class ReorderList {
	
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);
		ListNode ln6 = new ListNode(6);
		ListNode ln7 = new ListNode(7);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln6;
		ln6.next = ln7;
		ln7.next = null;
		
		rl.reorderList(ln1);
		
		for(ListNode p = ln1; p != null; p = p.next){
			System.out.println(p.val + ".");
		}
		
	}
	
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null || head.next.next == null) return;
    	ListNode p = head, q = head;
    	for(; p.next != null && p.next.next != null; p = p.next.next, q = q.next);
    	
    	ListNode head2 = q.next;
    	q.next = null;
    	
    	ListNode reverse2 = null;
    	p = head2;
    	while(p != null){
    		q = p.next;
    		p.next = reverse2;
    		reverse2 = p;
    		p = q;
    	}
    	
    	p = head.next;
    	q = reverse2;
    	ListNode r = head, r1, r2;
    	while(p != null && q != null){
    		r1 = p.next;
    		r2 = q.next;
    		r.next = q;
    		q.next = p;
    		r = p;
    		p = r1;
    		q = r2;
    	}
    	if(q != null) r.next = q;
    }
}
