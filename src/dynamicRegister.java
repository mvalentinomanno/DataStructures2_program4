
import java.util.LinkedList;

/*
 * Author: <Insert your name> 
 * Date: <Date you submitted the assignment> 
 * Overview: <Program overview. What is this software? Do you have 
 * any special instructions to run this software?> 
 */
public class dynamicRegister {

    public static LinkedList cashReg(int[] change, int cents) {

        int[] numCoins = new int[cents + 1];
        int[] lastCoin = new int[numCoins.length];
        LinkedList ll = new LinkedList();

        if (change.length == 0) { //catch array input of size 1
            throw new IllegalArgumentException("input array cant be empty");
        }

        numCoins[0] = 0;
        lastCoin[0] = 0;
// <= cents
        for (int i = 1; i < cents + 1; i++) {
            numCoins[i] = 1000000;
        }
  //<= cents
        for (int k = 1; k < cents + 1; k++) {
            for (int h = 0; h < change.length; h++) {
                if (k >= change[h]) {
                    int temp = numCoins[k - change[h]];
                    if (numCoins[k] > temp + 1 && temp != 1000000) {
                        numCoins[k] = temp + 1;
                    }
                }
            }
        }

        int big = 0;
        for (int i = 1; i < lastCoin.length; i++) {
            for (int j = 0; j < change.length; j++) {
                if (i % change[j] == 0) {
                    if (change[j] > big) {
                        big = change[j];
                    }
                }
            }
            lastCoin[i] = big;
            big = 0;
        }

        while (cents != 0) {
            ll.add(new String(Integer.toString(lastCoin[cents])));
            cents = cents - lastCoin[cents];
        }

        return ll;
    }

}
