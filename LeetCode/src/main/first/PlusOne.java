package first;
import java.util.LinkedList;

public class PlusOne {
	    public int[] plusOne(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        LinkedList<Integer> list = new LinkedList<Integer>();
	        boolean addFlag = true;
	        if(num.length == 0){
	            list.addFirst(1);
	        }else{
	            for(int i=num.length-1;i>=0;i--){
	                int digit = num[i];
	                if(addFlag){
	                    digit++;
	                    addFlag = false;
	                }
	                if(digit>=10){
	                    digit = digit%10;
	                    addFlag = true;
	                }
	                list.addFirst(digit);
	            }
	            if(addFlag){
	                list.addFirst(1);
	            }
	        }
	        
	        int[] newNum = new int[list.size()];
	        for(int i=0;i<list.size();i++){
	            newNum[i] = list.get(i);
	        }
	        return newNum;
	    }
}
