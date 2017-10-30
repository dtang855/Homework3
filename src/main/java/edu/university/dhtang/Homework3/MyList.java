package edu.university.dhtang.Homework3;
import java.util.Scanner;

class Element implements Comparable<Element> {
	Integer num;
	String str;
	int flag;
	public Element(Integer number){
		num = number;
		flag = 1;
	}
	public Element(String string) {
		str = string;
		flag = 0;
	}
	public int compareTo(Element o) {
		if(flag == 1) {
			return (this.num.compareTo(o.num));
		}
		else
			return (this.str.compareTo(o.str));
	}
	
}

public class MyList{
	public static boolean binSearch(Element[] aList, Element key){
		int left = 0;
		int right = aList.length - 1;
		
		while(left <= right){
			int mid = left + ((right-left) / 2);
			int x = key.compareTo(aList[mid]);
			if(x == 0){
				return true;
			}
			else if(x < 0){
				right = mid - 1;
			}
			else{
				left = mid + 1;
			}
		}		
		return false;	
	}
	
    public static void main(String[] args){

    	Element[] elementArray = new Element[4];
    	
    	Element a = new Element(3);
    	Element b = new Element(4);
    	Element c = new Element(5);
    	Element d = new Element(6);
    	
    	elementArray[0] = a;
    	elementArray[1] = b;
    	elementArray[2] = c;
    	elementArray[3] = d;
    	
    	Element key = new Element(6);
        boolean result = binSearch(elementArray, key);

        if(result == true) {
        	System.out.println(1);
        }
        else
        	System.out.println(0);
    }
}