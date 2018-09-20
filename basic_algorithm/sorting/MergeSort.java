/**
 * Created by liyang54 on 2018/9/20.
 * �鲢����
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
        //���temp��a����һ����
        System.out.println();
        for(int i=0;i<temp.length;i++){
            System.out.print(temp[i]+"  ");
        }
    }


/*
�ֽ׶ο������Ϊ���ǵݹ��������еĹ��̣��ݹ����Ϊlog2n
�Σ�ֻҪ�Ƚ��������еĵ�һ������˭С����ȡ˭��ȡ�˺���ڶ�Ӧ������ɾ���������Ȼ���ٽ��бȽϣ�
���������Ϊ�գ���ֱ�ӽ���һ�����е���������ȡ�����ɡ�
�鲢��ͬʱ�������൱����������
*/

    //ÿ�κϲ�����a[first,first+k]��������a
    public void mergearray(int a[], int first, int mid, int last, int temp[])
    {
        int i = first, j = mid + 1;
        int k = 0;
//      i��a[fisrt,middle], j��a[middle+1,end], k��temp��

        while (i <= mid && j <= last) //�������ж��У��Ѵ�ĸ���
        {
            if (a[i] <= a[j])//[first,mid]��[mid+1,end]�Ƚ�first��end+1
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        //����i��j�ѽ��仯��
        //�����һ������Ϊ�գ���ֱ�ӽ���һ�����е���������ȡ������
        while (i <= mid)
            temp[k++] = a[i++];

        while (j <= last)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++) //�����i�������ˣ�����first��
            a[first + i] = temp[i];//temp����ŵ���˳��õ�����
        //ͨ���޸�temp�����޸�a
    }


    public void mergesort(int a[], int first, int last, int temp[])
    {
        if (first < last)
        {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp);    //�������
            mergesort(a, mid + 1, last, temp); //�ұ�����
            mergearray(a, first, mid, last, temp); //�ٽ������������кϲ�
        }
    }

}