/**
 * Created by liyang54 on 2018/9/20.
 */
//ÿ��ֱ�Ӹı�������elements
//�Ѿ������������ʽ�洢��
//���㿪ʼ��������i* 2 + 1���Һ�����i* 2 + 2
//�������ǹ����󶥶ѣ���С��������
//������֮��ÿ���ٰ������Ǹ�Ԫ�أ�Ҳ�������ĸ��ڵ㣩�ŵ����
//ÿ�ζ�ȥ������Ѿ�ok���Ǹ�Ԫ�ؽ��н���
//�󶥶��Ǳ�ʾ�Ѵ��Ҷ�ӽڵ���������ڵ���
public class HeapSort {
    public  static  void  heapSortfunction( int [] elements){
        for ( int  i = elements.length- 1 ; i >  0 ; i--){//ÿ���Ƕ�element[0:i]�������Ƕ�ȥ������Ѿ�ok���Ǹ�Ԫ�ؽ��н���
            buildHeap(elements,i); //����,����֮�������ѣ�Ҳ���Ǹ��ڵ�������
            swap(elements, 0 ,i); //�������ڵ�����һ���ڵ㣬����ÿ�ΰѵ�ǰ���ķ��������
        }
    }

    private  static  void  buildHeap( int [] elements, int  lastIndex){//���ǰ�elements��0:lastindex���������
        int  lastParentIndex = (lastIndex- 1 )/ 2 ; //������һ�����ڵ㣬�Ա���潨��
        // �����ѭ���ǵ����һ�����ڵ㣬��Ϊ�Ǹ��ڵ�����������һ������
        for ( int  i = lastParentIndex; i >= 0 ; i--){
            int  parent = elements[i];
            int  leftChild = elements[i* 2 + 1 ]; //��ڵ�϶�����
            int  rightChild = leftChild;
            if (i* 2 + 2  <=lastIndex){//������һ�����ҽڵ㣬�ͰѶ�Ӧ���ҽڵ㸳����
                //���㿪ʼ��������i* 2 + 1���Һ�����i* 2 + 2
                rightChild = elements[i* 2 + 2 ]; //�ҽڵ㲻һ������
            }
            int  maxIndex = leftChild<rightChild?i* 2 + 2 :i* 2 + 1 ;//��leftchild��rightchild�д��index��maxindex
            //���㿪ʼ��������i* 2 + 1���Һ�����i* 2 + 2
            if (parent < elements[maxIndex]){//���parentС�����Һ����еĴ��һ�����ͽ���
                swap(elements,i,maxIndex);
            }
        }
    }

    private  static  void  swap( int [] elements, int  firstIndex, int  secondIndex){
        int  temp = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = temp;
    }

    public static void main(String[] args ){
        int a[]={2,3,1,5,8,9,3};
        heapSortfunction(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }

    }

}
