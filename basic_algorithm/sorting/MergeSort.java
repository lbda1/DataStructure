/**
 * Created by liyang54 on 2018/9/20.
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        int[] a={11,9,10,3,16,18,12,14,7,21,2};
        MergeSort ms=new MergeSort();
        int temp[] =new int [a.length];
        ms.mergesort(a, 0, a.length-1, temp);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        //最后temp和a中是一样的
        System.out.println();
        for(int i=0;i<temp.length;i++){
            System.out.print(temp[i]+"  ");
        }
    }


/*
分阶段可以理解为就是递归拆分子序列的过程，递归深度为log2n
治：只要比较两个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。然后再进行比较，
如果有数列为空，那直接将另一个数列的数据依次取出即可。
归并的同时就排序，相当于两个操作
*/

    //每次合并的是a[first,first+k]不是整个a
    public void mergearray(int a[], int first, int mid, int last, int temp[])
    {
        int i = first, j = mid + 1;
        int k = 0;
//      i是a[fisrt,middle], j是a[middle+1,end], k是temp的

        while (i <= mid && j <= last) //两个数列都有，把大的给他
        {
            if (a[i] <= a[j])//[first,mid]和[mid+1,end]比较first和end+1
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        //上面i和j已近变化了
        //如果有一个数列为空，那直接将另一个数列的数据依次取出即可
        while (i <= mid)
            temp[k++] = a[i++];

        while (j <= last)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++) //这里的i是序列了，不是first了
            a[first + i] = temp[i];//temp里面放的是顺序好的数据
        //通过修改temp，来修改a
    }


    public void mergesort(int a[], int first, int last, int temp[])
    {
        if (first < last)
        {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp);    //左边有序
            mergesort(a, mid + 1, last, temp); //右边有序
            mergearray(a, first, mid, last, temp); //再将二个有序数列合并
        }
    }

}