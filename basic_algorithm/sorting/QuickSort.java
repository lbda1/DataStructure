/**
 * Created by liyang54 on 2018/9/20.
 * ��������ԭ��Ҳ�����˷��η�����Ҫԭ���ǽ�����A��ΪA[p..q-1] ��A[q+1..r]��
 * Ȼ�����Ԫ��ʹ��A[p..q-1]С�ڵ���A[q]��A[q]С�ڵ���A[q+1..r]��Ȼ�󲻶ϵĵݹ飬������������ɡ�
 * p--i��С�ڵ���x��,i+1--j-1�Ǵ��ڵ���x��,j--r�ǻ�δ�����
 * https://blog.csdn.net/fkyyly/article/details/20308069
 */
//partition(int A[],int p,int r)�����ǹؼ������þ��ǽ������ΪA[p..q-1] ��A[q+1..r]
public class QuickSort {

    void quicksortfunction(int A[],int p,int r){//
        int q;
        if(p<r){
            q=partition(A,p,r);//������Ԫ��λ�ã�����Ԫ�ĵط��ֳ�ǰ�����������ټ���
            quicksortfunction(A, p, q-1);
            quicksortfunction(A,q+1, r);
        }
    }


    int partition(int A[],int p,int r){
        int x=A[r];//��ÿ������A�����һ��Ԫ����Ϊ��Ԫ
        int i=p-1;//��ʼ��ʱ��i �ƶ������������
        for(int j=p;j<=r-1;j++){
            if(A[j]<=x){
                i++;
                swap(A, i,j);//p--i��С�ڵ���x��,i+1--j-1�Ǵ��ڵ���x������Ҫ������
            }
        }
        swap(A, i+1, r);//����Ԫ�����м���������ߵ�
        return i+1;//������Ԫ��λ��
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
