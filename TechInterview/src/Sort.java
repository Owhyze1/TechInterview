public class Sort {



  public static void selectionSort(int[] array) {
    int temp;

    for (int i = 0; i < array.length-1; i++) {

      for (int j = i+1; i < array.length; j++) {

        if (array[j] < array[i]) {
          temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }

  public static void printArray(int[] array) {

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

}


// 3 12 1 7 4 2
// 1 12 3 7 4 2   i = 0, j = 2
//                i = 1, j = 2
// 1 3 12 7 4 2   i = 1, j = 5
// 1 2 12 7 4 3
//                i = 2, j = 3
// 1 2 7 12 4 3   i = 2, j = 4
// 1 2 4 12 7 3   i = 2, j = 5
// 1 2 3 12 7 4
//                i = 3, j = 4
// 1 2 3 7 12 4   i = 3, j = 5
// 1 2 3 4 12 7
//                i = 4, j = 5
// 1 2 3 4 7 12
