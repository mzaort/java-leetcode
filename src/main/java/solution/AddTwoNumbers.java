package solution;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode res = new ListNode(0);
		ListNode tail = res;
		int surplus = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + surplus;
			int current = sum % 10;
			surplus = sum / 10;
			tail.next = new ListNode(current);
			tail = tail.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int sum = l1.val + surplus;
			int current = sum % 10;
			surplus = sum / 10;
			tail.next = new ListNode(current);
			tail = tail.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int sum = l2.val + surplus;
			int current = sum % 10;
			surplus = sum / 10;
			tail.next = new ListNode(current);
			tail = tail.next;
			l2 = l2.next;
		}
		if(surplus != 0){
			tail.next = new ListNode(surplus);
		}
		return res.next;
	}
}