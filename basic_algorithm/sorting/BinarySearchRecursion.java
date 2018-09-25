package Search;

/**
 * Created by liyang54 on 2018/9/25.
 * �ݹ�ʵ�ֶ��ֲ���
 */
public class BinarySearchRecursion {
    public static void main(String[] args) {
        //����
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        //Ҫ���ҵ�Ԫ��
        int key = 1;
        //��һ��Ԫ�ص��±�
        int low = 0;
        //���һ��Ԫ�ص��±�
        int high = arr.length - 1;
        //��ȡָ��Ԫ�ص��±�
        int index = getKey(arr, key, low, high);
        if(index==-1){
            System.out.println("�����и�Ԫ�� "+key);
        }else{
            System.out.println("���и�Ԫ��  "+key+"���±��ǣ�"+index);
        }
    }
    public static int getKey(int[] arr, int key, int low, int high) {
        //���м�Ԫ�ص��±�
        int mid = (low + high) / 2;
        //�����ڲ�����ָ��Ԫ�أ������±�Ĺ����˳�
        if (low > high)
            return -1;
        //���ҵ�ָ��Ԫ��
        if (key == arr[mid]) {
            return mid;
            //�����ҵ�Ԫ�ش����м��±��Ԫ�أ���ı俪ʼ�±��λ��
        } else if (key > arr[mid]) {
            return getKey(arr, key, mid + 1, high);
        } else {
            //�����ҵ�Ԫ��С���м��±��Ԫ�أ���ı�����±��λ��
            return getKey(arr, key, low, mid - 1);
        }
    }
}
