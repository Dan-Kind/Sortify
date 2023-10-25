package sortify;

public class SortingAlgorithms {

    private static int delay = 100;

    public static void bubbleSortAsync(SortableInteger[] array) {
        new Thread(() -> {
            bubbleSort(array);
        }).start();
    }
    
    public static void selectionSortAsync(SortableInteger[] array) {
        new Thread(() -> {
            selectionSort(array);
        }).start();
    }
    
    public static void mergeSortAsync(SortableInteger[] array) {
        new Thread(() -> {
            mergeSort(array, 0, array.length - 1);
        }).start();
    }
    
    public static void quickSortAsync(SortableInteger[] array) {
        new Thread(() -> {
            quickSort(array, 0, array.length - 1);
        }).start();
    }
    
    private static void bubbleSort(SortableInteger[] array) {
        int n = array.length;
        SortableInteger temp = new SortableInteger(0);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    //swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                    try {
                        Thread.sleep(delay); // Add delay in milliseconds
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    updateArray(array);
                }
            }
        }
        System.out.println("Bubble sorted");
        updateArray(array);
    }
    
    private static void selectionSort(SortableInteger[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            SortableInteger temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            try {
                Thread.sleep(delay); // Add delay in milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            updateArray(array);
        }

        System.out.println("Selection sorted");
        updateArray(array);
    }
    
    private static void mergeSort(SortableInteger[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(SortableInteger[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        SortableInteger[] leftArray = new SortableInteger[n1];
        SortableInteger[] rightArray = new SortableInteger[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;

            try {
                Thread.sleep(delay); // Add delay in milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            updateArray(array);
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;

            try {
                Thread.sleep(delay); // Add delay in milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            updateArray(array);
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;

            try {
                Thread.sleep(delay); // Add delay in milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            updateArray(array);
        }
    }
    
    private static void quickSort(SortableInteger[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(SortableInteger[] array, int low, int high) {
        SortableInteger pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                SortableInteger temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                try {
                    Thread.sleep(delay); // Add delay in milliseconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                updateArray(array);
            }
        }

        SortableInteger temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        try {
            Thread.sleep(delay); // Add delay in milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        updateArray(array);
        return i + 1;
    }

    private static void updateArray(SortableInteger[] array) {
        SortLogic.getInstance().setDataArray(array);
    }
}
