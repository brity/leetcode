/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
loop through two list, while keeping a stack which holds the result. 
*/

import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null){
            return l2;
        }else if (l2.val == 0 && l2.next == null){
            return l1;
        }else{
            
            int overflow = 0;
            Stack<Integer> st = new Stack<Integer>();
            
            while (l1 != null && l2 != null){
                int temp = (l1.val + l2.val + overflow) % 10;
                overflow = (l1.val + l2.val + overflow) / 10;
                
                st.push(temp);
                l1 = l1.next;
                l2 = l2.next;
            }
            
            
            while (l1 != null){
                int temp = (l1.val + overflow) % 10;
                overflow = (l1.val + overflow) / 10;
                
                st.push(temp);       
                l1 = l1.next;
            }
            
            while (l2 != null){
                int temp = (l2.val + overflow) % 10;
                overflow = (l2.val + overflow) / 10;
                
                st.push(temp);  
                l2 = l2.next;
            }
            
            if (overflow != 0) st.push(overflow);
            
            ListNode result = new ListNode(st.pop());
            ListNode curr = result;
            
            while (!st.empty()){
                int temp = st.pop();
                curr = new ListNode(temp);
                curr.next = result;
                result = curr;
            }
            return result;
        }
            
        }
}