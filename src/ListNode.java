public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     
     public static ListNode makeList(int[] nums){
    	 ListNode head = new ListNode(0);
    	 ListNode cur = head;
    	 for(int i = 0; i < nums.length; ++i){
    		 cur.next = new ListNode(nums[i]);
    		 cur = cur.next;
    	 }
    	 return head.next;
     }
     
     public static void print(ListNode head){
    	 while(head != null){
    		 System.out.print(head.val +  " ");
    		 head = head.next;
    	 }
    	 System.out.println();
     }
  }