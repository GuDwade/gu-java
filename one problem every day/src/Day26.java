public class Day26 {
    //排序数组
    public int[] sortArray(int[] nums) {
        //insertSort(nums);
        shellSort(nums);
        return nums;
    }

    public void insertSort(int[]array){
        for(int i=0;i<array.length-1;i++){
            int end=i;
            int value=array[i+1];
            while(end>=0&&value<array[end]){
                array[end+1]=array[end];
                end--;
            }
            array[end+1]=value;
        }
    }

    public void shellSort(int[]array){
        int gap=array.length;
        while(gap>1){
            gap=gap/2;
            for(int i=0;i<array.length-gap;i++){
                int end=i;
                int value=array[i+gap];
                while(end>=0&&value<array[end]){
                    array[end+gap]=array[end];
                    end-=gap;
                }
                array[end+gap]=value;
            }
        }
    }

    public void  bubbleSort(int[]array){
        for(int i=0;i<array.length-1;i++){
            boolean flag=true;
            for(int j=0;j<array.length-1-i;i++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    flag=false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public void swap(int []array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    public void selectSort(int[]array){
        int end=array.length-1;
        while(end>0){
            int max=end;
            for(int i=end-1;i>=0;i--){
                if(array[i]>array[max]){
                    max=i;
                }
            }
            swap(array,end,max);
            end--;
        }
    }

    public void selectSort1(int[]array){
        int start=0;
        int end=array.length-1;
        while(start<end){
            int min=start;
            int max=end;
            for(int i=start;i<=end;i++){
                if(array[i]<array[min]){
                    min=i;
                }
                if(array[i]>array[max]){
                    max=i;
                }
            }
            swap(array,start,min);

            if(max==start){
                max=min;
            }

            swap(array,end,max);
            start++;
            end--;
        }

    }

    public void heapSort(int[] array) {
        for(int i=array.length-2/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
        int end=array.length-1;
        while(end>0){
            swap(array,0,end);
            shiftDown(array,end,0);
            end--;
        }
    }

    public  void shiftDown(int[] array, int size, int index) {
        int left=index*2+1;
        while(left<size){
            int max=left;
            int right=index*2+2;
            if(right<size&&array[right]>array[left]){
                max=right;
            }
            if(array[index]>=array[max]){
                break;
            }
            swap(array,index,max);
            index=max;
            left=index*2+1;
        }
    }
    public void quickSort(int[]array,int left,int right){
        if(left<right){
            int mid=partion(array,left,right);
            quickSort(array,left,mid-1);
            quickSort(array,mid+1,right);
        }
    }
    public int  partion(int[]array,int left,int right){
        int value=array[left];
        int start=left;
        while (left<right){
            while(left<right&&array[right]>=value){
                right--;
            }
            while(left<right&&array[left]<=value){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,left,start);
        return left;
    }
    public void mergeSort(int []array){
        int[]helper=new int[array.length];
        mergeSortInter(array,0,array.length-1,helper);
    }
    public  void mergeSortInter(int []array,int left,int right,int[]helper){
        if(left<right){
            int mid=(left+right)/2;
            mergeSortInter(array,left,mid,helper);
            mergeSortInter(array,mid+1,right,helper);
            merge(array,left,mid,right,helper);
        }
    }

    private void merge(int[]array,int left,int mid,int right,int[]helper){
        int begin1=left, end1=mid;
        int begin2=mid+1, end2=right;
        int index=left;

        while(begin1<=end1&&begin2<=end2){
            if(array[begin1]<array[begin2]){
                helper[index++]=array[begin1++];
            }else{
                helper[index++]=array[begin2++];
            }
        }

        while(begin1<=end1)
            helper[index++]=array[begin1++];
        while(begin2<=end2)
            helper[index++]=array[begin2++];
        //拷贝
        for(int i=left;i<=right;i++){
            array[i]=helper[i];
        }
    }

}
