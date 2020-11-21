package Nov;

import java.util.*;

public class Day5 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> rets = new LinkedList<>();
        if (root == null){
            return  rets;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int sz = queue.size();
            while (sz > 0){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                sz--;
                list.add(cur.val);
            }
            rets.addFirst(list);
        }

        return  rets;
    }

    public List<Integer> getRow(int rowIndex) {
        Integer [][] roads = new Integer[rowIndex+1][rowIndex+1];

        for(int i = 0 ; i < rowIndex ; i++ ){
            for(int j = 0 ; j <= i ;j++){
                if(j == 0 || j == i ){
                    roads[i][j] = 1;
                }else{
                    roads[i][j] =roads[i-1][j]+roads[i-1][j+1];
                }
            }
        }

        List<Integer> ret = Arrays.asList(roads[rowIndex]);
        return  ret;
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }

        ListNode nHead = new ListNode(head.val);
        ListNode nTail = nHead;
        ListNode cur = head.next;

        while (cur != null){
            ListNode nCur =new ListNode(cur.val);
            if (nCur.val <= nHead.val){
                nCur.next = nHead;
                nHead = nCur;
            }else if (nCur.val >= nTail.val){
                nTail.next = nCur;
                nTail = nCur;
            }else{
                ListNode prev = null;
                ListNode in = nHead;

                while (in != null && nCur.val >= in.val){
                    if (prev == null){
                        prev = in;
                    }else {
                        prev = prev.next;
                    }
                    in = in.next;
                }

                prev.next = nCur;
                nCur.next = in;

            }

            cur = cur.next;

        }

        return  nHead;
    }
}
