/*
 * Author: Michael Valentino-Manno, Benjamin Seal
 * Date: 4/24/18 
 * Overview: Using a dynamic algorithm, this program counts correct change
 * No main method, this program is run/tested by jtests
 */

import java.util.LinkedList;

public class dynamicRegister {

    public static LinkedList cashReg(int[] change, int cents) {

        // int[] numCoins = new int[cents + 1];
        int[] lastCoin = new int[cents + 1]; //array holds last coin used
        LinkedList ll = new LinkedList(); //list of change that'll be returned

        if (change.length == 0) { //catch array input of size 1
            throw new IllegalArgumentException("input array cant be empty");
        }

        // numCoins[0] = 0;
        lastCoin[0] = 0; //0 cents makes 0 cents

        /*
        for (int i = 1; i < cents + 1; i++) {   //I commented out code that was unnecessary
            numCoins[i] = 1000000;             //it built an array that held the least number of 
        }                                       //coins, but the method didnt need it
        for (int k = 1; k < cents + 1; k++) {
            for (int h = 0; h < change.length; h++) {
                if (k >= change[h]) {
                    int temp = numCoins[k - change[h]];
                    if (numCoins[k] > temp + 1 && temp != 1000000) {
                        numCoins[k] = temp + 1;
                    }
                }
            }
        }*/
        
        int big = 0;
        for (int i = 1; i < lastCoin.length; i++) { //loop through last coin array
            for (int j = 0; j < change.length; j++) { //for each denomination
                if (i % change[j] == 0) { //if a value is divisible by a denomination
                    if (change[j] > big) { //check if its the largest denomination that divided the change value 
                        big = change[j];
                    }
                }
            }
            lastCoin[i] = big; //the largest coin that produces a remainder of 0 is the last coin used
            big = 0; //reset 
        }

        while (cents != 0) { //loop until the change has been completely determined
            ll.add(new String(Integer.toString(lastCoin[cents]))); //add the value to linked list
            cents = cents - lastCoin[cents]; //update the change yet to be returned
        }

        return ll; //return the list
    }

}
