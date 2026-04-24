//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

class ListNode{
    int val;
    ListNode next;
    
    ListNode(int val){
        this.val = val;
        next = null;
    }
}

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int maxVal = 0;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nextNode = null, prev=null;
        while(slow!=null){
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        } 

        while(prev!=null){
            maxVal = Math.max(maxVal, prev.val + head.val);
            prev = prev.next;
            head = head.next;
        }
        return maxVal;
    }
}

public class Main
{
    public static ListNode createList(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        for(int num : arr){
            node.next = new ListNode(num);
            node = node.next;
        }
        return dummy.next;
    }
    
	public static void main(String[] args) {
		
		int[] arr = {2,1,3,2,9,5};
		
		ListNode head = createList(arr);
		
		Solution sol = new Solution();
		System.out.println("Max Sum: "+ sol.pairSum(head));
		
	}
}
