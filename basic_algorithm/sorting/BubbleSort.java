/**
 * Created by liyang54 on 2018/9/23.
 * 选择排序是每次选择最大（小）放在前面的位置。冒泡排序是每次比较相邻两个元素，把最大（小）放在最后。
 * O(n2)
 */
public class BubbleSort {
    void bubble_sort(int arr[], int len) {
        int i, j;
        int temp=0;
        for (i = 0; i < len - 1; i++)          //外层循环控制趟数，总趟数为len-1
            for (j = 0; j < len - 1 - i; j++)  //内层循环为当前i趟数 所需要比较的次数
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
