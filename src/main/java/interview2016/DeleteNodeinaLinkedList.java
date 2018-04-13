package interview2016;

public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
    	assert(node != null && node.next != null);
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}
