public class 等式方程的可满足性 {

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for(String str : equations){
            char[] chars = str.toCharArray();
            if (chars[1] == '='){
                uf.union(chars[0] - 'a',chars[3] - 'a');
            }
        }


        for(String str : equations){
            char[] chars = str.toCharArray();
            if (chars[1] == '!'){
                if (uf.isConnected(chars[0] - 'a',chars[3] - 'a')){
                    return  false;
                }
            }
        }

        return  true;
    }
}
