public class Trie {
    //实现前缀树
    private class TrieNode {
        private boolean isEnd;
        private TrieNode[] son;

        public TrieNode() {
            isEnd=false;
            son=new TrieNode[26];
        }

    }

    private  TrieNode root;

    public Trie() {
       root=new TrieNode();
    }


    public void insert(String word) {
        TrieNode cur=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if (cur.son[idx]==null){
                cur.son[idx]=new TrieNode();
            }
            cur=cur.son[idx];
        }
        cur.isEnd=true;
    }


    public boolean search(String word) {
        TrieNode cur=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if (cur.son[idx]==null){
               return false;
            }
            cur=cur.son[idx];
        }
        return cur.isEnd==true;
    }


    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(char ch:prefix.toCharArray()){
            int idx=ch-'a';
            if (cur.son[idx]==null){
                return false;
            }
            cur=cur.son[idx];
        }
        return true;
    }
}
