package Search;

/**
 * Created by liyang54 on 2018/9/25.
 * 递归实现二分查找
 */
public class BinarySearchRecursion {
    public static void main(String[] args) {
        //数组
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        //要查找的元素
        int key = 1;
        //第一个元素的下标
        int low = 0;
        //最后一个元素的下标
        int high = arr.length - 1;
        //获取指定元素的下标
        int index = getKey(arr, key, low, high);
        if(index==-1){
            System.out.println("不含有该元素 "+key);
        }else{
            System.out.println("含有该元素  "+key+"，下标是："+index);
        }
    }
    public static int getKey(int[] arr, int key, int low, int high) {
        //求中间元素的下标
        int mid = (low + high) / 2;
        //数组内不含有指定元素，依据下标的规则，退出
        if (low > high)
            return -1;
        //查找到指定元素
        if (key == arr[mid]) {
            return mid;
            //当查找的元素大于中间下标的元素，则改变开始下标的位置
        } else if (key > arr[mid]) {
            return getKey(arr, key, mid + 1, high);
        } else {
            //当查找的元素小于中间下标的元素，则改变结束下标的位置
            return getKey(arr, key, low, mid - 1);
        }
    }
}
