/**
 * Created by liyang54 on 2018/9/24.
 * ��ÿ��������в�������
 * gap��������gap��������ÿ�����ڽ��в������򣨴�С�鲻��ֱ���������Ǽ���Ԫ�أ��������gap��Ԫ�أ���Ȼ���ٱȽϽ���a[i]��a[i+gap]
 * ���{80,30,60,40,20,10,50,70}��������
 * ��gap=4ʱ,��ζ�Ž����з�Ϊ4���飺 {80,20},{30,10},{60,50},{40,70},ÿ����ֱ��������Ȼ��ϲ��õ�{20,10,50,40,80,30,60,70}
 * ��gap=2ʱ,��ζ�Ž����з�Ϊ2���飺{20,50,80,60}, {10,40,30,70}ÿ����ֱ��������Ȼ��ϲ��õ�{20,10,50,30,60,40,80,70}
 */
import java.util.Arrays;
public class ShellSort {
    public static void main(String []args){
//        int []arr ={8,9,1,7,2,3,5,4,6,0};
//        int []arr ={9,1,5,8,3,7,6,0,2,4};
        int []arr ={80,30,60,40,20,10,50,70};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ϣ������ ������������ڲ���ʱ���ý�����
     * @param arr
     */
    public void sort(int []arr){
        //���ѭ���ǿ���gap�ģ����������ѭ����insert sort
        //����gap��������С����
        for(int gap=arr.length/2;gap>0;gap/=2){
            //�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
            for(int i=gap;i<arr.length;i++){
                int j = i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    //����������ý�����
                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
            System.out.println(String.valueOf(gap) + " :" + Arrays.toString(arr));
        }
    }

    /**
     * ��������Ԫ��
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }



    //    ����һ�ַ����������治֮ͬ�����ǲ��������в��õ����ƶ���
//    /**
//     * ϣ������ ������������ڲ���ʱ�����ƶ�����
//     * @param arr
//     */
//    public static void sort1(int []arr){
//        //����gap��������С����
//        for(int gap=arr.length/2;gap>0;gap/=2){
//            //�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
//            for(int i=gap;i<arr.length;i++){
//                int j = i;
//                int temp = arr[j];
//                if(arr[j]<arr[j-gap]){
//                    while(j-gap>=0 && temp<arr[j-gap]){
//                        //�ƶ���
//                        arr[j] = arr[j-gap];
//                        j-=gap;
//                    }
//                    arr[j] = temp;
//                }
//            }
//        }
//    }
}