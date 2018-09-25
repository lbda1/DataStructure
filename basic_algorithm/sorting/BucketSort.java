import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyang54 on 2018/9/25.
 * Ͱ����bucket sort�������������ݷ��Ӿ��ȷֲ���ƽ�����������ʱ�������O(n)��
 * ������������������ݷֲ���һ��С�������������Ͱ���������������һ��������̲����ģ��ù��̽�Ԫ�ؾ��ȶ����طֲ���[0,1)�����ϡ�
 * 1.Ͱ����Ļ���˼��
 * Ͱ����[0,1)���仮��Ϊn����ͬ�Ĵ�С�������䣬��Щ�����䱻��ΪͰ��Ȼ��n������Ԫ�طֱ������Ե�Ͱ�С�
 * ��Ϊ����ʱ���ȶ����ģ�����һ�㲻���кܶ���ͬʱ����һ��Ͱ�е������������������Ը���Ͱ�е����ݽ�������
 * Ȼ�����ÿ��Ͱ�����մ���Ѹ���Ͱ�е�Ԫ���г������ɡ�
 * ����˵���ǰ�����arr����Ϊn����С��ͬ�����䣨Ͱ����ÿ������������������ϲ���
 * ����˵�ǲ��Ǻͷ��η��е����˰�����Ϊ���η����Ƿֽ�(��Ͱ) ���� ��������� �����ϲ���������·
 */
public class BucketSort {
//    public static void bucketSort(int[] A) {
//        //1. ����Ͱ
//        //1.1 ȷ��Ͱ�ĸ���n
//        int n = A.length;
//        //1.2 ��������ʼ��һ��List���������
//        List<ArrayList<Integer>> Blist = new ArrayList<>(n);
//        for(int i = 0; i < n; i++)
//            Blist.add(new ArrayList<Integer>());
//        //2.�������е�Ԫ�طŵ�Ͱ��
//        //2.1 ȷ��Ԫ�ص���ֵ
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for(int a : A){
//            max = Math.max(max, a);
//            min = Math.min(min, a);
//        }
//        //2.2 ȷ��ÿ��Ԫ�ط���Ͱ�ı�Ų��Ž�ȥ
//        for(int i : A){
//            //2.2.1 ȷ��Ͱ�ı��
//            int len = A.length;
//            //��1��Ϊ�˱�֤inde< A.length����ֹ�����׳�IndexOutofBoundsEx;
//            int index = (int)((i-min) / (max-min+1.0) * A.length);
//            //2.2.2 �����Ӧ��Ͱ��
//            Blist.get(index).add(i);
//        }
//        //3.Ͱ������
//        for(int i = 0; i < Blist.size(); i++){
//            java.util.Collections.sort(Blist.get(i));
//        }
//        //4.�ϲ�����
//        int j = 0;
//        for(ArrayList<Integer> arr : Blist){
//            for(int i : arr){
//                A[j++] = i;
//            }
//        }
//    }


    //�ڶ��ַ�Ͱ�ķ���
    public static void bucketSort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //Ͱ��
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //��ÿ��Ԫ�ط���Ͱ
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //��ÿ��Ͱ��������
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        //�ϲ�����
        int j = 0;
        for(ArrayList<Integer> arrTemp : bucketArr){
            for(int i : arrTemp){
                arr[j++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int A[]={2,5,3,30,2,3,0,6,7,2,1,4,3,20};
        BucketSort.bucketSort(A);
        System.out.println(Arrays.toString(A));
    }
}
