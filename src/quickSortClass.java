import java.util.Random;

public class quickSortClass {
    // Time Complexity :- O(N*Log(N))
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    public void swapper(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public int partition(int[] arr, int lowPointer, int highPointer, int pivot, int highIndex) {
        while (lowPointer < highPointer) {
            while (arr[lowPointer] <= pivot && lowPointer < highPointer) lowPointer++;
            while (arr[highPointer] >= pivot && lowPointer < highPointer) highPointer--;
            swapper(arr, lowPointer, highPointer);
        }
        swapper(arr, lowPointer, highIndex);
        return lowPointer;
    }

    public void quicksort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int pivotIndex=new Random().nextInt(highIndex-lowIndex)+lowIndex;
        int pivot = arr[pivotIndex];
        swapper(arr, pivotIndex, highIndex);
        int lowPointer = partition(arr, lowIndex, highIndex, pivot, highIndex);
        quicksort(arr, lowIndex, lowPointer - 1);
        quicksort(arr, lowPointer + 1, highIndex);
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 3, 4, 120, 1, 3, 45, 6, 8};
        quickSortClass obj = new quickSortClass();
        obj.quicksort(arr, 0, arr.length - 1);
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
