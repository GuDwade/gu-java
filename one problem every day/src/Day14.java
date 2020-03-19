import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode {
      int val;
    ListNode next;
     ListNode(int x) { val = x; }
}
public class Day14 {
    //最长回文串
    public int longestPalindrome(String s) {
        int[]chars=new int[58];
        for(char ch:s.toCharArray()){
            chars[ch-'a']++;
        }
        int len=0;
        for(int x:chars ){
            //若x=偶数  (x&1)=0  若x=奇数  (x&1)=1
            len+=x-(x&1);
        }
        return  len<s.length()?len+1:len;
    }
    //回文链表
    public boolean isPalindrome(ListNode head) {
        List<Integer>list=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        int start=0;
        int end=list.size()-1;
        while(start<end){
            //不能用 ！=
            if(!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return  true;
    }
}
