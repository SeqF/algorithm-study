package array.base;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 * 注意：有序
 */
public class Array2 {
    public int[] array;
    public int count;
    public int length;
    public Array2(int capacity){
        array = new int[capacity];
        count=0;
        length=capacity;
    }

    public Boolean insert(int value){
        if(array ==null && array.length ==0){
            return false;
        }else {
            //如果当前数组中还没有元素，则插入到第一个位置
            if(count==0){
                array[count] = value;
                count++;
                return true;
            }
            //插入值大于最后一个值，直接插入到尾部
            if(value>=array[count-1]){
                array[count]=value;
                count++;
                return true;
            }
            //与其他数组比较并挪动位置   (查找最后一个小于value的元素，如果没有则插入到尾部）
            for (int i = 0; i < array.length; i++) {
                if(value>=array[i]){
                    for (int j =count-1;j>=i+1;j--){
                        array[j+1]=array[j];
                    }
                    array[i+1]=value;
                    count++;
                    return true;
                }else {
                    //插入第一个位置
                    for (int j = 0; j < count-1; j++) {
                        array[j+1]=array[j];
                    }
                    array[0]=value;
                    count++;
                    return true;
                }
            }
        }
        return false;
    }

    public int delete(int index){
        if(index<0||index>=array.length){
            return -1;
        }else {
            for (int i = index; i < count-1; i++) {
                array[i]=array[i+1];
            }
        }
        count--;
        return 0;
    }

    //改为二分查找
    public int find(int value){
        for (int i =0;i<count-1;i++){
            if(array[i]==value){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于value的元素
     */
    public int bSearch(int value){
        int low=0;
        int high=array.length-1;
        while (low<=high){
            int mid=low+((high-low)>>1);
            if(array[mid]>value){
                high=mid-1;
            }else{
                if ((mid==array.length-1)||(array[mid+1]>=value)) {
                    return mid;
                }else {
                    low=mid+1;
                }
            }
        }
        return -1;
    }

    public void print(){
        for (int i=0;i<count;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
