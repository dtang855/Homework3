package edu.university.dhtang.Homework3;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

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
	
    public static void main(String[] args) throws ParseException{
        Options options = new Options();
        options.addOption("--type", true, "type of entry");
//        options.addOption("--key", true, "key");
//        options.addOption("--list", true, "list of entries");
        
        CommandLineParser parser =  new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        
        System.out.println(cmd.getOptionValue("--type"));
//        String[] list = cmd.getOptionValues("--list");
//        Element[] elementArray = new Element[list.length];
//        
//        if (type == "i") {
//        	int[] intList = new int[list.length];
//        	for(int i = 0; i < intList.length; i++) {
//        		intList[i] = Integer.parseInt(list[i]);
//        	}
//            System.arraycopy(intList, 0, elementArray, 0, list.length);
//        }
//        else {
//        	System.arraycopy(list, 0, elementArray, 0, list.length);
//        }
//
//        Element key = new Element(cmd.getOptionValue("--key"));
//
//        for(int i  = 0; i < elementArray.length; i++) {
//        	System.out.print(elementArray[i] + " ");
//        }
//        boolean result = binSearch(elementArray, key);
//
//        if(result == true) {
//        	System.out.println(1);
//        }
//        else
//        	System.out.println(0);
//    }
    }
}