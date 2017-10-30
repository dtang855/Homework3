package edu.university.dhtang.Homework3;
import java.util.Scanner;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
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
        CommandLineParser parser =  new DefaultParser();
        
        Option type = new Option("t", "type", true, "type of entry");
        Option key = new Option("k", "key", true, "key for list");
        Option list = new Option("l", "list", true, "list of entries");
        options.addOption(type);
        options.addOption(key);
        list.setArgs(Option.UNLIMITED_VALUES);
        options.addOption(list);

        CommandLine cmd = parser.parse(options, args);
        String listType = cmd.getOptionValue("t");
        String[] newList = cmd.getOptionValues("l");
        Element[] elementArray = new Element[newList.length];
        String inputKey = cmd.getOptionValue("k");
        boolean result = false;
        
        if (listType == "i") {
        	for(int i = 0; i < newList.length; i++) {
        		Element input = new Element(Integer.parseInt(newList[i]));
        		elementArray[i] = input;
        	}
        	Element listKey = new Element(Integer.parseInt(inputKey));
            result = binSearch(elementArray, listKey);
        }
        else {
        	for(int i = 0; i < newList.length; i++) {
        		Element input = new Element(newList[i]);
        		elementArray[i] = input;
        	}
        	Element listKey = new Element(inputKey);
        	result = binSearch(elementArray, listKey);
        }


        if(result == true) {
        	System.out.println(1);
        }
        else
        	System.out.println(0);
    }
}