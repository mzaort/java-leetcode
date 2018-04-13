package googleCode;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
    	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode p = head, q, r, s;
    	while(p != null){
    		r = new RandomListNode(p.label);
    		map.put(p, r);
    		p = p.next;
    	}
    	
    	p = head;
    	while(p != null){
    		q = map.get(p);
    		r = map.get(p.next);
    		s = map.get(p.random);
    		q.next = r;
    		q.random = s;
    		p = p.next;
    	}
    	
    	return map.get(head);
    }
    
    //wrong
    public RandomListNode copyRandomList2(RandomListNode head){
    	if(head == null) return null;
    	RandomListNode f = new RandomListNode(head.label);
    	f.random = head.random;
    	head.random = f;
    	
    	RandomListNode p = head.next, q = f;
    	while(p != null){
    		q.next = new RandomListNode(p.label);
    		q = q.next;
    		q.random = p.random;
    		p.random = q;
    		p = p.next;
    	}
    	
    	p = f;
    	while(p != null){
    		p.random = p.random == null ? null : p.random.random;
    		p = p.next;
    	}
    	return f;
    }
    
    public RandomListNode copyRandomList3(RandomListNode head){
    	if(head == null) return head;
    	RandomListNode p, q, r;
    	
    	
    	for(p = head; p != null; p = p.next.next){
    		q = new RandomListNode(p.label);
    		q.next = p.next;
    		p.next = q;
    	}
    	
    	for(p = head; p != null; p = p.next.next){
    		p.next.random = p.random == null ? null : p.random.next;
    	}
    	
    	r = head.next;
    	for(p = head, q = head.next; q.next != null; p = p.next, q = q.next){
    		p.next = q.next;
    		q.next = p.next.next;
    	}
    	p.next = null;
    	return r;
    }
}
