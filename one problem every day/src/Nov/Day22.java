package Nov;

import java.util.*;

public class Day22 {
    public int trap(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++ ) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int hCur = height[stack.pop()];
                while (!stack.isEmpty() && height[stack.peek()] == hCur) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    area += (Math.min(height[i],height[stack.peek()]) - hCur) * (i-stack.peek()-1);
                }
            }

            stack.push(i);
        }

        return  area;

    }


    public ListNode sortList(ListNode head) {
        return  mergerSort(head);
    }

    private ListNode mergerSort(ListNode head) {

        if (head == null || head.next == null) {
            return  head;
        }

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast !=null && fast.next != null){
            pre =slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        ListNode l1 = mergerSort(head);
        ListNode l2 = mergerSort(slow);
        return  mergerTwoList(l1,l2);

    }

    private ListNode mergerTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return  l2;
        }

        if (l2 == null){
            return  l1;
        }

        ListNode nHead = null;
        ListNode nTail = nHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (nHead == null){
                    nHead = l1;
                    nTail =nHead;
                }else {
                    nTail.next = l1;
                    nTail = l1;
                }
                l1 = l1.next;
            }else{
                if (nHead == null) {
                    nHead = l2;
                    nTail =nHead;
                }else {
                    nTail.next = l2;
                    nTail = l2;
                }
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            nTail .next = l1;
        }

        if (l2 != null) {
            nTail.next = l2;
        }

        return  nHead;
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null){
            return  new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[list.size()];
        for(int i =0 ; i < list.size(); i++) {
            int num = list.get(i);
            while (!stack.isEmpty() && list.get(stack.peek()) < num) {
                ret[stack.pop()] = num;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ret[stack.pop()] = 0;
        }
        return  ret;
    }

}
