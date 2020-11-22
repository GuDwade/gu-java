package Nov;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Day21 {

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }

        ListNode nHead = head;
        ListNode nTail = nHead;
        ListNode cur = head.next;

        while (cur != null){
            ListNode next = cur .next;
            if (cur.val < nHead.val){
                nTail.next = next;
                cur.next = nHead;
                nHead = cur;
            }else if (cur.val >= nTail.val){
                nTail = cur;
            }else{
                ListNode prev = null;
                ListNode in = nHead;

                while (in != null && cur.val >= in.val){
                    if (prev == null){
                        prev = in;
                    }else {
                        prev = prev.next;
                    }
                    in = in.next;
                }

                nTail.next = next;
                prev.next = cur;
                cur.next = in;

            }

            cur = next;

        }

        return  nHead;
    }

    public static  ListNode buildList(){
        ListNode n1=new ListNode(-1);
        ListNode n2=new ListNode(5);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(0);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return  n1;
    }

    public static int largestRectangleArea(int[] heights) {
        int [] arrays = new  int[heights.length+2];
        System.arraycopy(heights,0,arrays,1,heights.length);

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for(int i = 0; i < arrays.length; i++){

            while (!stack.isEmpty() && arrays[i] < arrays[stack.peek()]) {
                int h = arrays[stack.pop()];
                area = Math.max(area,h * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        return  area;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> stack = new Stack<>();
        Map <Integer , Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(),-1);
        }

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            ret[i] = map.get(nums1[i]);
        }
        return  ret;
    }

    public static void main(String[] args) {
        ListNode head = buildList();
        insertionSortList(head);
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
