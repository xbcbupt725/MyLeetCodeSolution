public class Solution206 {
	public static void main(String[] args){
		int[] nums = {};
		ListNode head = ListNode.makeList(nums);
		Solution206 s = new Solution206();
		ListNode newHead = s.reverseList(head);
		ListNode.print(newHead);
	}
    public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode newHead = null;
		ListNode next = null;
		while(head != null){
			next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;		
		}
		return  newHead;
        
    }
}