package Search;

/**
 * Created by liyang54 on 2018/9/25.
 */
public class BinarySearch {
    public int search(int a[],int key)
    {
        int low,high,mid;
        low=0;     /*定义最底下标为记录首位*/
        high=a.length-1;    /*定义最高下标为记录末位*/
        while(low<=high)
        {
            mid=(low+high)/2;    /*折半*/
            if(key<a[mid])
                high=mid-1;
            else if(key>a[mid])
                low=mid+1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] a = {1,2,3,4,5,6,7,8,9};
        int b = binarySearch.search(a, 1);
        System.out.println("the location is:" + String.valueOf(b));
    }
}
