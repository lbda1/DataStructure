/**
 * Created by liyang54 on 2018/9/25.
 */
//A��input��B��output��C��length��k
//�����ҳ�������k����������C��k��Խ�磬�������������������ʱ����K+1���պþ�C��0����C��k����
//C�м�¼���Ǳ�ĳ��Ԫ��С�����ֵĸ�����C�е��������A��Ԫ�ص�ֵ
//�������Դ���������ֱ����kС
//C[A[j]]��ʾС�ڵ���A[j]��Ԫ�صĸ�����Ҳ����������֮��ĸ�Ԫ�ص�λ��
public class CountSort {

    int toFindk(int A[]){//�ҳ�A���������Ԫ��k
        int max=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
            }
        }
        return max;
    }


    void countingSort(int A[],int B[],int k){//�����k����ǰ��K+1��ΪcountSort.countingsort(A, B, k+1);
        int C[]=new int[k];
        for(int i=0;i<k;i++){
            C[i]=0;
        }

        for(int j=0;j<A.length;j++){
            C[A[j]]=C[A[j]]+1;//��A�е���ֵת��ΪC�ж�Ӧλ�õĸ�����C����ͳ��A����ȵ�Ԫ�ش洢��c��
        }

        for(int j=1;j<k;j++){
            C[j]=C[j]+C[j-1];//С�ڵ���j��Ԫ�صĸ���
        }

        for(int j=A.length-1;j>=0;j--){
            B[C[A[j]]-1]=A[j];//ע������Ҫ��1��C[A[j]]��ʾС�ڵ���A[j]��Ԫ�صĸ�����Ҳ����������֮��ĵ�ǰԪ��A[j]��λ��
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