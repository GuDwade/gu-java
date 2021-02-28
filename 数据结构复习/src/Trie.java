public class Trie {
    public static class TrieNode {

        private boolean isEnd;
        private TrieNode[] childern;
        private char val;

        public TrieNode() {
            isEnd = false;
            childern = new TrieNode[26];
        }
    }

    private  TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if (cur.childern[idx] == null){
                cur.childern[idx] = new TrieNode();
                cur.childern[idx].val = ch;
            }
            cur = cur.childern[idx];
        }
        cur.isEnd = true;
    }


    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if (cur.childern[idx] == null){
               return  false;
            }
            cur = cur.childern[idx];
        }
        return  cur.isEnd == true;
    }


    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';
            if (cur.childern[idx] == null){
               return  false;
            }
            cur = cur.childern[idx];
        }
        return true;
    }


    public void preTraverse(TrieNode node) {
        if(node != null) {
            System.out.print(node.val + "-");
            for(TrieNode child:node.childern) {
                preTraverse(child);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] strs = {"banana","band","bee","absolute","acm",};
       trie.insert(strs[0]);


    }
}