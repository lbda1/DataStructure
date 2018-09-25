/**
 * Created by liyang54 on 2018/9/24.
 * 对每个分组进行插入排序
 * gap是增量，gap是组数，每个组内进行插入排序（此小组不是直接相连的那几个元素，而是相隔gap的元素），然后再比较交换a[i]和a[i+gap]
 * 如对{80,30,60,40,20,10,50,70}进行排序
 * 当gap=4时,意味着将数列分为4个组： {80,20},{30,10},{60,50},{40,70},每个组分别进行排序然后合并得到{20,10,50,40,80,30,60,70}
 * 当gap=2时,意味着将数列分为2个组：{20,50,80,60}, {10,40,30,70}每个组分别进行排序然后合并得到{20,10,50,30,60,40,80,70}
 */
import java.util.Arrays;
public class ShellSort {
    public static void main(String []args){
//        int []arr ={8,9,1,7,2,3,5,4,6,0};
//        int []arr ={9,1,5,8,3,7,6,0,2,4};
        int []arr ={80,30,60,40,20,10,50,70};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     * @param arr
     */
    public void sort(int []arr){
        //外层循环是控制gap的，里面的两层循环是insert sort
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    //插入排序采用交换法
                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
            System.out.println(String.valueOf(gap) + " :" + Arrays.toString(arr));
        }
    }

    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }



    //    另外一种方法，与上面不同之处就是插入排序中采用的是移动法
//    /**
//     * 希尔排序 针对有序序列在插入时采用移动法。
//     * @param arr
//     */
//    public static void sort1(int []arr){
//        //增量gap，并逐步缩小增量
//        for(int gap=arr.length/2;gap>0;gap/=2){
//            //从第gap个元素，逐个对其所在组进行直接插入排序操作
//            for(int i=gap;i<arr.length;i++){
//                int j = i;
//                int temp = arr[j];
//                if(arr[j]<arr[j-gap]){
//                    while(j-gap>=0 && temp<arr[j-gap]){
//                        //移动法
//                        arr[j] = arr[j-gap];
//                        j-=gap;
//                    }
//                    arr[j] = temp;
//                }
//            }
//        }
//    }
}