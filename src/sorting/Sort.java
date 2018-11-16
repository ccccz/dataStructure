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
        Sort.bubbleSort(a);
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
}
