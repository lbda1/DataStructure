import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyang54 on 2018/9/25.
 * 桶排序（bucket sort）假设输入数据服从均匀分布。平均情况下他的时间代价是O(n)。
 * 计数排序假设输入数据分布于一个小区间的整数，而桶排序则假设输入是一个随机过程产生的，该过程将元素均匀独立地分布于[0,1)区间上。
 * 1.桶排序的基本思想
 * 桶排序将[0,1)区间划分为n个相同的大小的子区间，这些子区间被称为桶。然后将n个输入元素分别放入各自的桶中。
 * 因为输入时均匀独立的，所以一般不会有很多数同时落在一个桶中的情况。这样，我们想对各个桶中的数据进行排序，
 * 然后遍历每个桶，按照次序把各个桶中的元素列出来即可。
 * 简单来说就是把数组arr划分为n个大小相同子区间（桶），每个子区间各自排序，最后合并。
 * 这样说是不是和分治法有点像了啊！因为分治法就是分解(分桶) —— 解决（排序） ——合并这样的套路
 */
public class BucketSort {
//    public static void bucketSort(int[] A) {
//        //1. 构造桶
//        //1.1 确定桶的个数n
//        int n = A.length;
//        //1.2 声明并初始化一个List，存放链表；
//        List<ArrayList<Integer>> Blist = new ArrayList<>(n);
//        for(int i = 0; i < n; i++)
//            Blist.add(new ArrayList<Integer>());
//        //2.将数组中的元素放到桶中
//        //2.1 确定元素的最值
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for(int a : A){
//            max = Math.max(max, a);
//            min = Math.min(min, a);
//        }
//        //2.2 确定每个元素放入桶的编号并放进去
//        for(int i : A){
//            //2.2.1 确定桶的编号
//            int len = A.length;
//            //加1是为了保证inde< A.length，防止程序抛出IndexOutofBoundsEx;
//            int index = (int)((i-min) / (max-min+1.0) * A.length);
//            //2.2.2 放入对应的桶中
//            Blist.get(index).add(i);
//        }
//        //3.桶内排序
//        for(int i = 0; i < Blist.size(); i++){
//            java.util.Collections.sort(Blist.get(i));
//        }
//        //4.合并数据
//        int j = 0;
//        for(ArrayList<Integer> arr : Blist){
//            for(int i : arr){
//                A[j++] = i;
//            }
//        }
//    }


    //第二种分桶的方法
    public static void bucketSort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        //合并数据
        int j = 0;
        for(ArrayList<Integer> arrTemp : bucketArr){
            for(int i : arrTemp){
                arr[j++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int A[]={2,5,3,30,2,3,0,6,7,2,1,4,3,20};
        BucketSort.bucketSort(A);
        System.out.println(Arrays.toString(A));
    }
}
