import java.util.*;

public class QueueProblem {
    public ArrayList<Integer> asylum(int[][] ope) {
        Queue<Integer>dog=new LinkedList<>();
        Queue<Integer>cat=new LinkedList<>();
        Queue<Integer>input=new LinkedList<>();
        ArrayList<Integer>output=new ArrayList<>();
        for(int i=0;i<ope.length;i++){
            if(ope[i][0]==1){
                if(ope[i][1]>0){
                    dog.offer(ope[i][1]);
                    input.offer(ope[i][1]);
                }else if(ope[i][1]<0){
                    cat.offer(ope[i][1]);
                    input.offer(ope[i][1]);
                }
            }else if(ope[i][0]==2){
                if(ope[i][1]==0){
                    if(!input.isEmpty()){
                        int tmp=input.poll();
                        output.add(tmp);
                        if(tmp>0){
                            dog.poll();
                        }else{
                            cat.poll();
                        }
                    }
                }
                if(ope[i][1]>0){
                    if (!dog.isEmpty()){
                        int tmp=dog.poll();
                        output.add(tmp);
                        input.remove(tmp);
                    }
                }
                if(ope[i][1]<0){
                    if (!cat.isEmpty()){
                        int tmp=cat.poll();
                        output.add(tmp);
                        input.remove(tmp);
                    }
                }

            }
        }
        return output;
    }


    class Employee {

        public int id;

        public int importance;

        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id){
        if(employees.isEmpty()||employees==null){
            return 0;
        }
        Map<Integer,Employee>map=new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Queue<Employee>que=new LinkedList<>();
        que.offer(map.get(id));
        int ret=0;
        while(!que.isEmpty()){
            Employee out=que.poll();
            ret+=out.importance;
            for(int sub:out.subordinates){
                que.offer(map.get(sub));
            }
        }
        return ret;
    }

}
