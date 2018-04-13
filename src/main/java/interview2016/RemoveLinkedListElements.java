package interview2016;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode f = new ListNode(0);
		f.next = head;
		for(ListNode p = f, q = f.next; q != null; q = p.next){
			if(q.val == val){
				p.next = q.next;
			}else{
				p = q;
			}
		}
		return f.next;
	}
}
