public class Solution {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
	    int val  = 0;
	    if( a == null && b== null)
	        return null;
	    if(a == null || a.val > b.val){
	        val = b.val;
	        b = b.next;
	    } else{
	        val = a.val;
	        a = a.next;
	    }
	    ListNode newHead = new ListNode(val);
	    ListNode node = newHead;
	    while(a != null && b !=null){
	        if(a.val <= b.val){
	            ListNode temp = new ListNode(a.val);
                node.next = temp;
	            a = a.next;
	            node = node.next;
	        } else{
	            ListNode temp = new ListNode(b.val);
	            node.next = temp;
	            b = b.next;
	            node = node.next;
	        }
	    }
	    while (a != null){
	        ListNode temp = new ListNode(a.val);
	        node.next = temp;
	        node = node.next;
	        a = a.next;
	    }
	    while(b != null){
	        ListNode temp = new ListNode(b.val);
	        node.next = temp;
	        node = node.next;
	        b = b.next;
	    }
	    return newHead;
	}
}
