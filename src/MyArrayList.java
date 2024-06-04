public class MyArrayList {

    //internal array: an array of Object class or an array of Comparable
    //
    Comparable[] array; //array of comparable, array of object that can be
    //compared to each other, therefore sorted
    //Object[] array; //array of object, not necessary we can compare them. therefore
    //we cannot sort
    int index;

    public MyArrayList(){
        //create the array with default capacity of 10
        array = new Comparable[10];
        index=-1;
    }
    public MyArrayList(int capacity){
        array = new Comparable[capacity];
        index = -1;
    }
    public int size(){
        return index+1;
    }

    //operations
    //insert (add methods)
    //delete (remove methods)
    //search (get, getIndexOf, contains)

    //inset operations
    public void add(Comparable data){
        index++;
        if(index < array.length){
            array[index]=data;
        }
        else{
            //create new array twice as big
            Comparable[] tempArray = new Comparable[array.length*2];

            //copy old array to the new one
            for(int i=0; i<array.length; i++){
                tempArray[i] = array[i];
            }

            //move the reference array to point to the new temp array
            array =  tempArray;

            array[index]=data;
        }

    }//end of add method

    // METHOD FOR QUESTION 8
    //remove the Comparable object from the array that is at the given index
    public Comparable remove(int index) {
        if (index < 0 || index > this.index) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Comparable removedElement = array[index];
        // Shift elements to the left to fill the gap
        for (int i = index; i < this.index; i++) {
            array[i] = array[i + 1];
        }
        array[this.index--] = null; // Clear the last element and decrement index
        return removedElement;
    }


    //delete operation
    public boolean remove(Comparable data) {
        //search where the data is located
        int i = indexOf(data);
        if(i != -1){
            //then remove it. move all values below it up one step
            while(i<index){
                array[i] = array[i+1];
                i++;//next location
            }
            //adjust the internal pointer
            index--;
            return true;
        }
        else
            return false;
    }

    //search operation
    public int indexOf(Comparable data){

        //
        for(int i=0;i<=index; i++){
            //check if content of array is equal to data
            if(array[i].equals(data))
                return i;
        }
        return -1; //not found
    }

    //get method
    public Comparable get(int index){
        if(index >= 0 && index < array.length)
            return array[index];
        else
            throw new IndexOutOfBoundsException();

    }

}
