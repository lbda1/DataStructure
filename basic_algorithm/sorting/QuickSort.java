/**
 * Created by liyang54 on 2018/9/20.
 * 快速排序法原理也是用了分治法，主要原理是将数组A分为A[p..q-1] 和A[q+1..r]，
 * 然后调整元素使得A[p..q-1]小于等于A[q]，A[q]小于等于A[q+1..r]。然后不断的递归，到最后就排序完成。
 * p--i是小于等于x的,i+1--j-1是大于等于x的,j--r是还未处理的
 * https://blog.csdn.net/fkyyly/article/details/20308069
 */
//partition(int A[],int p,int r)方法是关键，作用就是将数组分为A[p..q-1] 和A[q+1..r]
public class QuickSort {

    void quicksortfunction(int A[],int p,int r){//
        int q;
        if(p<r){
            q=partition(A,p,r);//返回主元的位置，从主元的地方分成前后两个部分再计算
            quicksortfunction(A, p, q-1);
            quicksortfunction(A,q+1, r);
        }
    }


    int partition(int A[],int p,int r){
        int x=A[r];//把每次数组A的最后一个元素作为主元
        int i=p-1;//开始的时候将i 移动到数组的外面
        for(int j=p;j<=r-1;j++){
            if(A[j]<=x){
                i++;
                swap(A, i,j);//p--i是小于等于x的,i+1--j-1是大于等于x的所以要交换下
            }
        }
        swap(A, i+1, r);//把主元放在中间好区分两边的
        return i+1;//返回主元的位置
    }


    void  swap( int [] A, int  firstIndex, int  secondIndex){
        int  temp = A[firstIndex];
        A[firstIndex] = A[secondIndex];
        A[secondIndex] = temp;
    }



    public static void main(String[] args) {
        QuickSort quicksort=new QuickSort();
        int A[]={2,8,7,1,3,5,6,4};
        quicksort.quicksortfunction(A, 0, A.length-1);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"  ");
        }
    }

}
