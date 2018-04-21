
import java.util.LinkedList;

/*
 * Author: <Insert your name> 
 * Date: <Date you submitted the assignment> 
 * Overview: <Program overview. What is this software? Do you have 
 * any special instructions to run this software?> 
*/
public class dynamicRegister {

    public static LinkedList cashReg(int[] change, int cents) {
        int max = Integer.MIN_VALUE;
        LinkedList LL = new LinkedList();
        
        if(change.length == 0){ //catch array input of size 1
            throw new IllegalArgumentException("input array cant be empty");
        }

        while (cents != 0) { //go until full change is given
            max = Integer.MIN_VALUE;
            for (int i = 0; i < change.length; i++) {
                if (change[i] <= cents) { //if the coin is usable
                    if (change[i] > max) { //check if its greater than last coin
                        max = change[i];
                    }
                }
            }
            LL.add(max); //found next coin
            cents = cents - max; //update total
        }
        return LL;
    }

}
