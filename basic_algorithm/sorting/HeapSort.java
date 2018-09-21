/**
 * Created by liyang54 on 2018/9/20.
 */
//每次直接改变了数组elements
//堆就是用数组的形式存储的
//从零开始是左孩子是i* 2 + 1，右孩子是i* 2 + 2
//本方法是构建大顶堆（有小到大排序）
//构建后之后，每次再把最大的那个元素（也就是树的根节点）放到最后
//每次对去除最后已经ok的那个元素进行建堆
//大顶堆是表示把大的叶子节点调换到父节点上
public class HeapSort {
    public  static  void  heapSortfunction( int [] elements){
        for ( int  i = elements.length- 1 ; i >  0 ; i--){//每次是对element[0:i]，这样是对去除最后已经ok的那个元素进行建堆
            buildHeap(elements,i); //建堆,建完之后是最大堆，也就是根节点是最大的
            swap(elements, 0 ,i); //交换根节点和最后一个节点，就是每次把当前最大的放在最后了
        }
    }

    private  static  void  buildHeap( int [] elements, int  lastIndex){//就是把elements【0:lastindex】变成最大堆
        int  lastParentIndex = (lastIndex- 1 )/ 2 ; //获得最后一个父节点，以便后面建堆
        // 下面的循环是到最后一个父节点，因为是父节点所以至少有一个左孩子
        for ( int  i = lastParentIndex; i >= 0 ; i--){
            int  parent = elements[i];
            int  leftChild = elements[i* 2 + 1 ]; //左节点肯定存在
            int  rightChild = leftChild;
            if (i* 2 + 2  <=lastIndex){//如果最后一个有右节点，就把对应的右节点赋给它
                //从零开始是左海子是i* 2 + 1，右孩子是i* 2 + 2
                rightChild = elements[i* 2 + 2 ]; //右节点不一定存在
            }
            int  maxIndex = leftChild<rightChild?i* 2 + 2 :i* 2 + 1 ;//把leftchild和rightchild中大的index给maxindex
            //从零开始是左孩子是i* 2 + 1，右孩子是i* 2 + 2
            if (parent < elements[maxIndex]){//如果parent小于左右孩子中的大的一个，就交换
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
