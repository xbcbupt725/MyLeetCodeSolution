import java.util.HashSet;
import java.util.Set;


public class Solution142 {
	public static void main(String[] args){
		int nums[] = {3,2,0,-4};
		ListNode head = ListNode.makeList(nums);
		Solution142 s = new Solution142();
		head.next.next.next.next = head.next;
		System.out.print(s.detectCycle2(head));
		
	}
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) return null;
        Set<ListNode> set = new HashSet<>();
        while(head != null){
        	if(set.contains(head))
        		return head;
        	set.add(head);
        	head = head.next;
        }
        return null;
    }
	
	public ListNode detectCycle2(ListNode head) {
		if(head == null || head.next == null) return null;
        boolean isCycle = false;
        ListNode slow = head,fast = head;
        while( slow != null && fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast && slow !=null){
        		isCycle = true;
        		break;
        	}
        }
        if(!isCycle) return null;
        slow = head;
        	while(slow != fast){
        		slow = slow.next;
        		fast = fast.next;
        	}
        return slow;
    }
}
