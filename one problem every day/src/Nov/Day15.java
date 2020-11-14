package Nov;

import java.util.*;

public class Day15 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer>map =new HashMap<>();
        List<Integer> list =new ArrayList<>();

        for(int n:arr1){
            list.add(n);
        }

        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }

        Collections.sort(list,(a,b)->{
            if (map.containsKey(a)||map.containsKey(b)){
                return map.getOrDefault(a,1000)-map.getOrDefault(b,1000);
            }
            return  a-b;
        });

        int []ret =new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            ret[i]=list.get(i);
        }

        return  ret;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int max=0;
        for(int n:arr1){
            max=Math.max(max,n);
        }

        int []arrays=new int[max+1];
        for(int n:arr1){
            arrays[n]++;
        }

        int []ret=new int[arr1.length];
        int idx=0;
        for(int n:arr2){
            while (arrays[n]>0){
                ret[idx++]=n;
                arrays[n]--;
            }
        }

        for(int i=0;i<=max;i++){
            while (arrays[i]>0){
                ret[idx++]=i;
                arrays[i]--;
            }
        }

        return  ret;
    }



}

