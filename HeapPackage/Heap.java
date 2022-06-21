package HeapPackage;
public class Heap {
    int arr[]  ;
    int len ;
    Heap(){
        arr = new int[20] ;
        len = 0 ;
    }

    public void insert(int value){
        if(len == 0){
            arr[len++] = value;
            return;
        }
        if(value > arr[(len-1)/2] ){
            int ind = (len-1) / 2;
            while(value > arr[ind] ){
                bubbelUp(arr , ind , value , len);
                ind = (ind -1 )/2 ;
            }
        }else{
            arr[len] = value;
        }
        len++;
    }
    private void bubbelUp(int[] arr, int ind, int value , int dest) {
        int temp = arr[ind];
        arr[ind] = value;
        arr[dest] = temp ;
    }
    public void printHeap() {
        int i = 0;
        for (i = 0; i < len; i++) {
            System.out.print("\n" + arr[i] + " ");
            print(arr, i);
        }
    }
    private void print(int[] arr, int i) {
        System.out.print( (arr[i*2 + 1]  ) + " ");
        System.out.print( (arr[i*2 + 2] ) + " ");
    }
    public void remove(){
        if(isEmpty()) throw  new IllegalCallerException();
        arr[0] = arr[--len];
        int index =0;
        while(index <= len && !isValidParent(index) ){
            int largeChildIndex = Math.max(leftChild(index), rightChild(index));
            swap(arr ,index , largeChildIndex) ;
            index = largeChildIndex ;
        }
    }

    private boolean isEmpty() {
        return len == 0 ;
    }

    private boolean isValidParent(int index){
        return arr[index] >= leftChild(index) &&
                arr[index] >= rightChild(index) ;
    }
    private int rightChild(int index) {
        return arr[rightChildIndex(index)] ;
    }

    private int leftChild(int index){
        return arr[leftChildIndex(index)] ;
    }
    private int leftChildIndex(int index){
        return index * 2 +1;
    }
    private int rightChildIndex(int index){
        return index * 2+2;
    }
    private void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
    }
}
