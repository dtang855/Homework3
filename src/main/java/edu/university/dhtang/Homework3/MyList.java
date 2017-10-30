package edu.university.dhtang.Homework3;
import java.util.Scanner;

class Element {
	int index;
	double key;
	
	public Element(int index, double key){
		this.index = index;
		this.key = key;
	}
}
public class MyList {
	public static void bubbleSortArray(Element[] inputArray) {
		int n = inputArray.length;
		Element temp = new Element(0,0);
		
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < (n-i-1); j++) {
				if(inputArray[j].key > inputArray[j+1].key || (inputArray[i].key - inputArray[j+1].key == 0 & inputArray[i].index > inputArray[i].index)) {
					temp = inputArray[j];
					inputArray[j] = inputArray[j+1];
					inputArray[j+1] = temp;
				}
			}
		}
	}
    public static int binSearch(Element[] aList, double key){
		int left = 0;
		int right = aList.length - 1;
		while(left <= right){
			int mid = left + ((right-left) / 2);
			if(aList[mid].key - key == 0){
				if(mid != 0) {
					if(aList[mid].key - aList[mid - 1].key == 0) {
						right = mid - 1;
					}
					else 
						return aList[mid].index;
				}
				else
					return aList[mid].index;
			}
			else if(key < aList[mid].key){
				right = mid - 1;
			}
			else{
				left = mid + 1;
			}
		}		
		return -1;	
	}
//    public static int returnIndex(double key, Double[] arr) {
//    	int index = 0;
//    	for(int i = 0; i < arr.length; i++) {
//    		if(arr[i].equals(key)) {
//    			index = i;
//    		}
//    	}
//    	return index;
//    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double []inputList = new double[args.length];
        
        for(int i = 0; i < args.length; i++){
            inputList[i] = (Double.parseDouble(args[i]));
        }
        
        Element[] elementArray = new Element[inputList.length];
        
        for (int i = 0; i < elementArray.length; i++) {
        	elementArray[i] = new Element(i, inputList[i]);
        }
        
        bubbleSortArray(elementArray);
        
//        for (int i = 0; i < elementArray.length; i++) {
//        	System.out.println(elementArray[i].key + " " + elementArray[i].index + " ");
//        }
        double key = input.nextDouble();
        
        int result = binSearch(elementArray, key);

        if(result != -1) {
        	System.out.println(result);
        }
        else
        	System.out.println("The key was not found!");
		input.close();
    }
    
}