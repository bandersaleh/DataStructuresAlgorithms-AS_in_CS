import java.util.Arrays;
//Bander Saleh
//RTC CSI 260 Intro to Data Struct
//Professor Lhoucine Zerrouki
//Spring 2024

public class Main {
    public static void main(String[] args) {
        System.out.println("Question 1:");
        int[] array1 = {1, 2, 2, 5, 3, 6, 7, 8, 9, 10}; //define array1 Data
        System.out.printf("array1 = "); //Output initial array1 data
        printArray(array1); //Run Method that Outputs array data
        int thirdMax = getThirdMaxValue(array1); //Run thirdMax Method
        System.out.println("The third maximum value in the array is: " + thirdMax); //Output results


        System.out.println("\nQuestion 2:");
        int[] array2 = {1, 0, 0, 1, 1, 0, 1, 1, 0}; //define array2 Data
        System.out.printf("array2 = (initial) ");
        printArray(array2);
        separateOnesAndZeros(array2); //Run the Method I created
        System.out.printf("array2 = (sorted) ");
        printArray(array2);


        System.out.println("\nQuestion 3:");
        int[] array3 = {15, 19, 24, 31, 42, 47, 54, 60, 67, 92}; //defined initial array3 data
        System.out.printf("array3 = ");
        printArray(array3);
        int search3 = 24; //defined the value we are searching for
        int index3 = binarySearch(array3, search3); //defined int index3 to store the results from running binarySearch Method
        //ifElse statement that returns data found
        if (index3 != -1) {
            System.out.printf("%d is found at index: %d \n\n", search3, index3);
        }


        System.out.println("\nQuestion 4:");
        int[] array4 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 20, 22, 21, 23, 25, 30, 31, 32, 33}; //initial data (contains 10 odd numbers & 10 even numbers)
        printArray(array4);
        double oddsAverage = getAverageOfFirstTenOddValues(array4);
        System.out.println("average of odd values: " + oddsAverage);


        System.out.println("\nQuestion 5:");
        int[] array5 = {5, 7, -2, 9, 8, 10}; //initial data
        int sum = 27;
        String results = getConsecutiveTriplet(array5, sum); //use Method created to set value for new int needed
        System.out.println("Consecutive triplet with sum " + sum + ": " + results); //output to console


        System.out.println("\nQuestion 6:");
        int[] arraySorted = {1, 2, 3, 4, 5}; //initial data
        int[] arrayUnsorted = {1, 3, 2, 6, 5};
        System.out.printf("arraySorted = "); //output initial data
        printArray(arraySorted);
        System.out.printf("arrayUnsorted = ");
        printArray(arrayUnsorted);
        System.out.println("arraySorted is sorted? " + isSorted(arraySorted)); //output results after running method
        System.out.println("arraySorted is sorted? " + isSorted(arrayUnsorted));


        System.out.println("\nQuestion 7:");
        int[] array7A = {1, 2, 3, 8, 9}; //initial data
        int[] array7B = {1, 3, 6, 7, 8};
        System.out.printf("array7A = "); //output initial data
        printArray(array7A);
        System.out.printf("array7B = ");
        printArray(array7B);
        int[] array7C = mergeSortedArrays(array7A, array7B); //define new array and set value to Method results
        System.out.printf("Merged Array = "); //output new array value
        printArray(array7C);


        System.out.println("\nQuestion 8:");
        int[] array8 = {1, 2, 3, 4, 5}; //initial data
        MyArrayList list1 = new MyArrayList(); // Create an instance of MyArrayList Class
        // Add array8 data to MyArrayList
        for (int i = 0; i < array8.length; i++) {
            list1.add(i);
        }
        System.out.println("Original ArrayList:"); // Display the original list
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        Comparable removedElement = list1.remove(3); // Remove an element at index 3
        System.out.println("Element removed: " + removedElement);
        System.out.println("Updated ArrayList:"); // Display the updated list
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }


        System.out.println("\nQuestion 9:");
        MyLinkedList list2 = new MyLinkedList(); // Create an instance of MyLinkedList
        // Add some elements to the linked list
        list2.addFirst(10);
        list2.addFirst(20);
        list2.addFirst(30);
        list2.addFirst(40);
        list2.addFirst(50);
        // Display the initial LinkedList
        list2.display();
        // Remove an element at index 2
        list2.remove(2);
        System.out.println("Element removed: [2]");
        // Display the updated list
        System.out.println("Updated LinkedList:");
        list2.display();


        System.out.println("\nQuestion 10:");
        System.out.println("From main method test all the methods. ✔️");

    }//End of MAIN


    // METHODS CREATED (see below)
    // Method that outputs an array
    public static void printArray(int[] array) {
        //forLoop that prints each array index value out
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " "); //output value of each array index
        }
        System.out.println(); // Move to the next line after printing the array
    }


    // METHOD FOR QUESTION 1
    public static int getThirdMaxValue(int[] array) {
        int n = array.length; // array size
        int firstMax = 0; // Initialize top 3 max value temps
        int secondMax = 0;
        int thirdMax = 0;
        //forLoop to search through array once {1, 2, 2, 5, 3, 6, 7, 8, 9, 10}
        for (int i = 0; i < n; i++) {
            //ifElse statement to assign values to firstMax, secondMax, thirdMax
            if (array[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = array[i];
            } else if (array[i] > secondMax && array[i] != firstMax) {
                thirdMax = secondMax;
                secondMax = array[i];
            } else if (array[i] > thirdMax && array[i] != firstMax && array[i] != secondMax) {
                thirdMax = array[i];
            }
        }
        return thirdMax; //return value found
    }


    // METHOD FOR QUESTION 2
    public static void separateOnesAndZeros(int[] array) {
        int left = 0; //defined int array head
        int right = array.length - 1; //defined int array tail
        int[] arraySorted = new int[array.length]; //defined new sorted array
        int zero = 0; //defined int to count zero
        int one = 0; //defined in to count one
        //forLoop to iterate through our array once
        for (int i = 0; i < array.length; i++) {
            //ifElse statement to check index location value
            if (array[i] == 0) {
                zero++; //add 1 to int zero
            } else {
                one++; //add 1 to int one
            }
        }
        //forLoop to place zeroes at the beginning of the sorted array
        for (int i = 0; i < zero; i++) {
            arraySorted[left + i] = 0;
        }
        //forLoop to place ones at the end of the sorted array
        for (int i = 0; i < one; i++) {
            arraySorted[right - i] = 1;
        }
        //forLoop to update the original array with our sorted array
        for (int i = 0; i < array.length; i++) {
            array[i] = arraySorted[i];
        }
    }


    // METHOD FOR QUESTION 3
    public static int binarySearch(int[] array, int target) {
        //3.	Assume you have a sorted array containing the following: (array already sorted)
//        array = {15, 19, 24, 31, 42, 47, 54, 60, 67, 92};
//        target = 24; //[index=2]
//        Write down the steps that a binarysearch method take to search for the value of 24 Using the binarysearch algorithm
//        Initially first is set to 0 and last is set to array.length-1
        int n = array.length; //array size
        int first = 0; //define Method temps
        int mid = 0;
        int last = n - 1; //value=9
//        Take each step in the loop to show the values of first, mid and last until the value is found.
//        Show all the work (values of first mid and last) after each loop
        System.out.println("searching for value: 24[index:2]" + "\nfirst = " + first + "\nmid = " + mid + "\nlast = " + last);
        //while loop that runs until it at least finds the index with value 24
        while (first <= last) {
            mid = (first + last) / 2; //(pass1) mid=(0+9)/2=4 ... (pass2) mid=(0+3)/2=2
            System.out.println("//while loop starts...\nfirst = " + first + "\nmid = " + mid + "\nlast = " + last); //output current values of temp
            //check if target is at the mid
            if (target == array[mid]) { //(pass1)mid=42[index=4]FALSE ... (pass2)mid=24[index=3]TRUE
                return mid;
            } else if (target > array[mid]) { //(pass1)target<mid FALSE
                //search the right side of the array
                first = mid + 1;
            } else {
                last = mid - 1; //(pass1)last=4-1=3
            }
        }//end of while
        return -1;
    }


    // METHOD FOR QUESTION 4
    public static double getAverageOfFirstTenOddValues(int[] array) {
        // This method is passed and array of integers.
        // Its task is to compute the average value of the first 10 odd values.
        // You must account for the fact that this array may not have 10+ odd values.
        // In such case return the average value of all odds.
        int n = array.length;
        double sum = 0;
        double count = 0;

        //forLoop to iterate through input data once
        for (int i = 0; i < n; i++) {
            //ifelse statement to store odd values
            if (array[i] % 2 != 0) {
                sum = sum + array[i]; //add value of current index to the total sum
                count++; //add +1 to number of odd values counted
            }
        }
        double average = sum / count;
        return average;
    }


    // METHOD FOR QUESTION 5
    public static String getConsecutiveTriplet(int[] array, int sum) {
//        This method is passed an array. {5, 7, -2, 9, 8, 10}
//        Its job is to find which 3 consecutive values add up to the given sum = 27
//        The 3 values are put in a single string such as String result = String.format(“ [%d, %d, %d]”,v1,v2,v3).
//        Then returning result.
//        If an array has the following values: 5, 7, -2, 9, 8, 10
//        Then the followings are consecutive triplets: (5,7,-2) (7,-2,9), (-2,9,8) and (9,8,10).
//        The input array could have any number of values.
//        Positive and negative.
        int n = array.length;
        //forLoop to iterate through array once
        for (int i = 0; i < n; i++) {
            int tripletSum = array[i] + array[i + 1] + array[i + 2]; //test first array triplet
            //ifElse statement to check if the tripletSum add up to sum
            if (tripletSum == sum) {
//                return String.format(“[%d, %d, %d]”, array[i],array[i+1], array[i+2]);
                String result = String.format("[%d, %d, %d]", array[i], array[i + 1], array[i + 2]);
                return result; //Method outputs requested data
            }
        }
        return "No consecutive triplet found with sum " + sum; //return statement if the forLoop & ifElse statements return null.
    }


    // METHOD FOR QUESTION 6
    public static boolean isSorted(int[] array) {
//        this method takes an array and check whether it is already sorted or not.
//        Return true if sorted, false otherwise

        //forLoop to iterate through the array one time
        for (int i = 0; i < array.length - 1; i++) {
            //ifElse statement to return false if the array is not sorted
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true; //return true if forLoop returned nothing
    }


    // METHOD FOR QUESTION 7
    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
//        this method is to create and return an array (array3) that contains all the elements from both array1 and array2 in such a way that it ends up sorted without duplicates.
//        int[] array1 = {1,2,3,8,9};
        int index1 = 0; //temp int index value for array1
//        int[] array2 = {1,3,6,7,8};
        int index2 = 0; //temp int index value for array2
//        int[] array3 = {1,2,3,8,9,1,3,6,7,8};
//        int[] array3 = {1,2,3,6,7,8,9}
        int index3 = 0; //temp int index value for array3
        int[] array3 = new int[array1.length + array2.length]; //define array3
//        Once the merging is done it should be already sorted.
//        Cannot apply any sort algorithm once it is merged.
//        The merging algorithm should merge them one element at a time in such a way that array3 is always sorted at any point in the algorithm.

//        WhileLoop that runs while iterating through Array1 & Array2
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                if (index3 == 0 || array1[index1] != array3[index3 - 1]) {
                    array3[index3++] = array1[index1++];
                } else {
                    index1++;
                }
            } else if (array1[index1] > array2[index2]) {
                if (index3 == 0 || array2[index2] != array3[index3 - 1]) {
                    array3[index3++] = array2[index2++];
                } else {
                    index2++;
                }
            } else {
                if (index3 == 0 || array1[index1] != array3[index3 - 1]) {
                    array3[index3++] = array1[index1++];
                    index2++;
                } else {
                    index1++;
                    index2++;
                }
            }
        }
//        WhileLoop that runs while iterating through Array1 & Array3
        while (index1 < array1.length) {
            if (index3 == 0 || array1[index1] != array3[index3 - 1]) {
                array3[index3++] = array1[index1++];
            } else {
                index1++;
            }
        }
//        WhileLoop that runs while iterating through Array2 & Array3
        while (index2 < array2.length) {
            if (index3 == 0 || array2[index2] != array3[index3 - 1]) {
                array3[index3++] = array2[index2++];
            } else {
                index2++;
            }
        }
        // return array3 data
        return Arrays.copyOf(array3, index3);
    }


} // END OF MAIN CLASS


// METHOD FOR QUESTION 8 via MyArrayList Class
// METHOD FOR QUESTION 9 via MyLinkedList Class




