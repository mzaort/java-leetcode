package googleCode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
    	ListNode f1 = new ListNode(0);
    	ListNode f2 = new ListNode(0);
    	
    	ListNode p = head, p1 = f1, p2 = f2;
    	for(; p != null; p = p.next){
    		if(p.val < x){
    			p1.next = p;
    			p1 = p1.next;
    		}else{
    			p2.next = p;
    			p2 = p2.next;
    		}
    	}
    	p1.next = f2.next;
    	p2.next = null;
    	return f1.next;
    }
}
