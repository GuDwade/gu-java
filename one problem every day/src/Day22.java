import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}

    public TrieNode(char val) {
        this.val=val;
    }
}
class Trie {
    TrieNode root;

    public Trie(){
        root=new TrieNode();
    }

    public  int insert(String word) {
        TrieNode cur=root;
        boolean isNew=false;
        for(int i=word.length()-1;i>=0;i--){
            char c=word.charAt(i);
            if(cur.children[c-'a']==null){
                isNew=true;
                cur.children[c-'a']=new TrieNode(c);
            }
            cur=cur.children[c-'a'];
        }
        return  isNew?word.length()+1:0;
    }

}

class StringLengthCompartor implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return  o2.length()-o1.length();
    }
}
public class Day22 {

    //单词的压缩编码
    public int minimumLengthEncoding(String[] words){
        Set<String>set=new HashSet<>();
        for(String word:words){
            set.add(word);
        }
        for(String word:words){
            for(int i=1;i<word.length();i++){
                set.remove(word.substring(i));
            }
        }
        int ans=0;
        for(String word:set){
            ans+=word.length()+1;
        }
        return  ans;
    }

    public int minimumLengthEncoding1(String[] words){
        Trie tree=new Trie();
        int ans=0;
        Arrays.sort(words,new StringLengthCompartor());
        for(String word:words){
            ans+=tree.insert(word);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[]words={"sghd","sd","fds","dfgds","fsds"};
        System.out.println(Arrays.toString(words));
        Arrays.sort(words,new StringLengthCompartor());
        System.out.println(Arrays.toString(words));
    }
}
