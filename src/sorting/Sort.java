package sorting;

/**
 * 排序算法类
 * 由小到大排序
 */
public class Sort {
    public static int[] a=new int[100];


    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            Sort.a[i]=(int)(Math.random()*100);
        }
        Sort.selectSort(a);
        for (int i=0;i<Sort.a.length;i++){
            System.out.println(Sort.a[i]);
        }
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertionSort(int[] a){
        int p;
        for (int i=1;i<a.length;i++){
            int temp=a[i];

            for (p=i;p>0 && a[p-1]>temp;p--){
                a[p]=a[p-1];
            }
            a[p]=temp;
        }
    }

    /**
     * 二分插入排序
     */
    public static void binaryInsertionSort(int[] a){
        for (int i=1;i<a.length;i++){
            binaryInsert(a,i);
        }
    }
    //二分查找应该插入的位置
    public static void binaryInsert(int[] a,int i){
        int left=0,right=i-1,middle;
        int temp=a[i];

        while(left<=right){
            middle=(left+right)/2;
            if (a[middle]>temp){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }

        for (int j=i;j>left;j--){
            a[j]=a[j-1];
        }
        a[left]=temp;
    }

    /**
     * 希尔排序
     * 以下代码非独立编写
     */
    public static void shellSort(int[] a){
        int j;

        for (int gap=a.length/2;gap>0;gap=gap/2){   //每次缩小增量gap
            for (int i = gap; i<a.length; i++){
                int temp = a[i];
                for (j=i; j>=gap && temp<a[j-gap]; j=j-gap){    //把相隔gap的数归为一组，进行排序
                    a[j]=a[j-gap];
                }
                a[j]=temp;
            }
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] a){
        int temp;
        for (int i=a.length;i>0;i--){
            for (int j=0;j<i-1;j++){
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    /**
     * 冒泡排序的一个改进
     * @param a
     */
    public static void bubbleSortPlus(int[] a){
        int temp;
        boolean noSwap;
        for (int i=a.length;i>0;i--){
            noSwap=true;
            for (int j=0;j<i-1;j++){
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    noSwap=false;
                }
            }
            if (noSwap){
                //如果一整轮比较中都没有出现交换，则排序已完成
                break;
            }
        }
    }

    /**
     * 快速排序
     * 分治思想
     * 进行多次范围逐渐减小的分类
     */
    public static void quickSort(int[] a){
        quickSort(a,0,a.length-1);
    }
    private static void quickSort(int[] a,int left, int right){
        if (right<=left){
            return;
        }
        int pivot=(left+right)/2;            //选择轴值
        swap(a,pivot,right);          //轴值放入数组末端
        pivot=partition(a,left,right);           //将轴值放入正确位置
        quickSort(a,left,pivot-1);           //对左右子式进行快排
        quickSort(a,pivot+1,right);
    }
    private static void swap(int[] a,int a1,int a2){
        int temp=a[a1];
        a[a1]=a[a2];
        a[a2]=temp;
    }
    //将数组以pvoit为轴分类的方法
    private static int partition(int[] a,int left,int right){
        int l=left;
        int r=right;           //创建左右指针
        int temp=a[r];           //保存轴值
        while(l!=r){
            //从左边开始查找大与轴值的项，找到后将此项移入右边空出的位置（实际上是轴值的位置），左边此项的位置空出
            while(a[l]<=temp && r>l){
                l++;
            }
            if (l<r){
                a[r]=a[l];
                r--;
            }
            //空出左边的位置后，从右边开始查找小于轴值的数，并放入左边空位中，右边出现一个空位
            while(a[r]>=temp && r>l){
                r--;
            }
            if (l<r){
                a[l]=a[r];
                l++;
            }
            //不断循环进行直至空位的左边全部小于轴值或空位的右边全部大于轴值（实际上是等价的，只是从左逼近或从右逼近），此时l==r，将轴值放入这个位置
        }
        a[l]=temp;
        return l;
    }

    /**
     * 直接选择排序
     */
    public static void selectSort(int[] a){
        for (int i=0; i<a.length; i++){
            int smallest=i;
            for (int j=i+1; j<a.length; j++){
                if (a[j]<a[smallest])
                    smallest=j;
            }
            swap(a,i,smallest);
        }
    }
}
