/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        int[] a = new int [B];
        ListNode node = A;
        int i = B;
        while(node != null){
            if(i == B){
                reverse(node, a, B);
                i = 1;
                node = node.next;
            } else {
                node = node.next;
                i ++;
            }
        }
        return A;
    }
    
    private void reverse(ListNode A, int[] a,  int B){
        ListNode node = A;
        for(int i = 0, j = B-1; i < B; i++, j--){
            a[j] = node.val;
            node = node.next;
        }
        node = A;
        for(int i = 0; i < B; i++){
            node.val = a[i];
            node = node.next;
        }
    }
}
