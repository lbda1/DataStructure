/**
 * Created by liyang54 on 2018/9/25.
 */
//A是input，B是output，C的length是k
//这里找出最大的是k，但是数组C【k】越界，所以这里我们在排序的时候让K+1，刚好就C【0】到C【k】了
//C中记录的是比某个元素小的数字的个数，C中的坐标就是A中元素的值
//这里所以待排序的数字必须比k小
//C[A[j]]表示小于等于A[j]的元素的个数，也就是排完序之后的该元素的位置
public class CountSort {

    int toFindk(int A[]){//找出A【】中最大元素k
        int max=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
            }
        }
        return max;
    }


    void countingSort(int A[],int B[],int k){//这里的k是以前的K+1因为countSort.countingsort(A, B, k+1);
        int C[]=new int[k];
        for(int i=0;i<k;i++){
            C[i]=0;
        }

        for(int j=0;j<A.length;j++){
            C[A[j]]=C[A[j]]+1;//把A中的数值转化为C中对应位置的个数，C就是统计A中相等的元素存储在c中
        }

        for(int j=1;j<k;j++){
            C[j]=C[j]+C[j-1];//小于等于j的元素的个数
        }

        for(int j=A.length-1;j>=0;j--){
            B[C[A[j]]-1]=A[j];//注意这里要减1，C[A[j]]表示小于等于A[j]的元素的个数，也就是排完序之后的当前元素A[j]的位置
            C[A[j]]=C[A[j]]-1;
        }
    }

    public static void main(String[] args){
        int A[]={2,5, 3,0,2,3,0,3};
        int B[]=new int[A.length] ;
        int k;
        CountSort countSort=new CountSort();
        k=countSort.toFindk(A);
        countSort.countingSort(A, B, k+1);
        for(int i=0;i<B.length;i++){
            System.out.print(B[i]+"   ");
        }
    }
}