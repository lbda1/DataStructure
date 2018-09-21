/**
 * Created by liyang54 on 2018/9/21.
 * 在排好子数组A[1…j-1]后，将元素A[j]插入，形成排好序的子数组
 * 需要排序的第j和元素一次和前面的每个元素进行比较（从j-1逆序往前），依次把大于key的值往后拉
 * 拉完之后，最后需要将key替换到合适的位置（第i+1）
 * O(n2)
 */
public class InsertSort {
    public void insertSort(int a[]) {
        int key;
        int i;
        for(int j=1;j<a.length;j++){
            key=a[j];
            i=j-1;
            //i是j-1，i是从后往前（所以下面i=i-1）下面a[i+1]=key是将A[j]插入已排序数组A[1…j-1]
            while(i>=0 && a[i]>key)
            {
                a[i+1]=a[i];//后面的那个数被替换了，相当于前面有序的A[1…j-1]中连续数据部分，大于key的（a[j]）的往后挪
                i=i-1;//要把当前要排的元素(第j个)排到该在的位置
            }
            //上面是找到第j个数字合适的插入位置i+1
            a[i+1]=key;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InsertSort sort=new InsertSort();
        int a[]={3,1,2,8,2,10,4,11};
        sort.insertSort(a);
        for(int k=0;k<a.length;k++){
            System.out.print(a[k]+"  ");
        }
    }

}
