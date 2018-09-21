/**
 * Created by liyang54 on 2018/9/21.
 * ���ź�������A[1��j-1]�󣬽�Ԫ��A[j]���룬�γ��ź����������
 * ��Ҫ����ĵ�j��Ԫ��һ�κ�ǰ���ÿ��Ԫ�ؽ��бȽϣ���j-1������ǰ�������ΰѴ���key��ֵ������
 * ����֮�������Ҫ��key�滻�����ʵ�λ�ã���i+1��
 * O(n2)
 */
public class InsertSort {
    public void insertSort(int a[]) {
        int key;
        int i;
        for(int j=1;j<a.length;j++){
            key=a[j];
            i=j-1;
            //i��j-1��i�ǴӺ���ǰ����������i=i-1������a[i+1]=key�ǽ�A[j]��������������A[1��j-1]
            while(i>=0 && a[i]>key)
            {
                a[i+1]=a[i];//������Ǹ������滻�ˣ��൱��ǰ�������A[1��j-1]���������ݲ��֣�����key�ģ�a[j]��������Ų
                i=i-1;//Ҫ�ѵ�ǰҪ�ŵ�Ԫ��(��j��)�ŵ����ڵ�λ��
            }
            //�������ҵ���j�����ֺ��ʵĲ���λ��i+1
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
