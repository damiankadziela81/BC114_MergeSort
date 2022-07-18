public class Main {

    // merge sort = recursively divide array in 2, sort, re-combine
    // run-time complexity = O(n Log n)
    // space complexity    = O(n)

    public static void main(String[] args){

        int[] array = {9,8,7,6,5,4,3,2,1};

        mergeSort(array);

        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

    }

    private static void mergeSort(int[] array) {

        int length = array.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0;  // left array
        int j = 0;  // right array

        for(; i < length; i++){
            if(i < middle) {
                leftArray[i] = array[i];
            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }

        System.out.println("left array");
        for(int k : leftArray) System.out.print(k + " ");
        System.out.println();

        System.out.println("right array");
        for(int l : rightArray) System.out.print(l + " ");
        System.out.println();

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray,rightArray,array);
        System.out.println("array after sort");
        for(int m : array) System.out.print(m + " ");
        System.out.println();
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array){
        System.out.println("MERGING");
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i=0, l=0, r=0;

        //check conditions for merging
        while(l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
