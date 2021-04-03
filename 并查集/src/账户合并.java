import java.util.*;

public class 账户合并 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        //["John", "johnsmith@mail.com", "john00@mail.com"],
        // ["John", "johnnybravo@mail.com"],
        // ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
        // ["Mary", "mary@mail.com"]]


        // 邮箱 --- 邮箱编号  映射
        Map<String,Integer> emailToIndex = new HashMap<>();
        // 邮箱 --- 所属用户  映射
        Map<String,String>  emailToUser = new HashMap<>();

        int count = 0;
        for(int i = 0; i < accounts.size(); i++){
            List<String> acount = accounts.get(i);
            String user = acount.get(0);
            int sz = acount.size();

            for(int j = 1; j < sz; j++){
                String email = acount.get(j);
                if (!emailToIndex.containsKey(email)){
                    emailToIndex.put(email,count++);
                    emailToUser.put(email,user);
                }
            }
        }

        UnionFind uf = new UnionFind(count);
        for (List<String> account : accounts){
            int sz = account.size();
            String email = account.get(1);
            int idx = emailToIndex.get(email);

            for(int i = 2; i < sz; i++){
                String email1 = account.get(i);
                int idx1 = emailToIndex.get(email1);
                uf.union(idx1,idx);
            }
        }

        //将联通的邮箱归类
        Map<Integer,List<String>> emails = new HashMap<>();
        for (String email : emailToIndex.keySet()){
            int idx = emailToIndex.get(email);
            int root = uf.find(idx);
            List<String> list = emails.getOrDefault(root,new ArrayList<>());
            list.add(email);
            emails.put(root,list);
        }

        List<List<String>> rets = new ArrayList<>();
        for(List<String> email : emails.values()){
            Collections.sort(email);
            String firstEmail = email.get(0);
            String user = emailToUser.get(firstEmail);

            List<String> account = new ArrayList<>();
            account.add(user);
            account.addAll(email);

            rets.add(account);
        }

        return  rets;
    }
}
