/**
 * Created by liyang54 on 2018/9/23.
 * ѡ��������ÿ��ѡ�����С������ǰ���λ�á�ð��������ÿ�αȽ���������Ԫ�أ������С���������
 * O(n2)
 */
public class BubbleSort {
    void bubble_sort(int arr[], int len) {
        int i, j;
        int temp=0;
        for (i = 0; i < len - 1; i++)          //���ѭ������������������Ϊlen-1
            for (j = 0; j < len - 1 - i; j++)  //�ڲ�ѭ��Ϊ��ǰi���� ����Ҫ�ȽϵĴ���
                if (arr[j] > arr[j + 1])
                    {   temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j+1] = temp;
                    }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {5, 11, 6, 7, 2, 3};
        bubbleSort.bubble_sort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
