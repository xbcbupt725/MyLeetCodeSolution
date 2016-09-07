
public class Solution2 {
	ListNode last;
	public static void main(String[] args){
		int a[] = {2,4,9};
		int b[] = {8,6,4};
		ListNode la = ListNode.makeList(a);
		ListNode.print(la);
		ListNode lb = ListNode.makeList(b);
		ListNode.print(lb);
		Solution2 s = new Solution2();
		ListNode head = s.addTwoNumbers(la, lb);
		
		
		ListNode.print(head);
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int lengthL1 = 0;
    	ListNode c1 = l1;
    	while(c1 != null){
    		lengthL1++;
    		c1 = c1.next;
    	}
    	int lengthL2 = 0;
    	ListNode c2 = l2;
    	while(c2 != null){
    		lengthL2++;
    		c2 = c2.next;
    	}
    	ListNode longList = lengthL1 >= lengthL2 ? l1:l2;
    	ListNode shortList = lengthL1 >= lengthL2 ? l2:l1;
    	add(longList,shortList,0);
    	return longList;
    	
    }
    private void add(ListNode l1, ListNode l2,int c){
    	if(l1 != null && l1.next == null){
    		last = l1;
    	}
        if(l1 != null && l2 != null){   	
        	int sum = l1.val + l2.val + c;
        	l1.val = sum%10;
        	add(l1.next, l2.next ,sum/10);	
        }else if(l1 != null){
        	int sum = l1.val+ c;
        	l1.val = sum%10;
        	add(l1.next, null ,sum/10);	
        }else{
        	if(c != 0){
        		last.next = new ListNode(c);
        	}       
        }
    }
   
}