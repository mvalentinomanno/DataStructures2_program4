/*
 * Author: Michael Valentino-Manno, Benjamin Seal
 * Date: 4/24/18 
 * Overview: Using a dynamic algorithm, this program counts correct change
 * No main method, this program is run/tested by jtests.
 */

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class dynamicRegisterTest {

    @Test
    public void test1() { //test1 gives a situation where the greedy algorithm would be suboptimal, but dynamic succeeds
        int coins[] = {1, 5, 12, 25};//coins in use
        int expectedAns[] = {1, 5, 5, 5}; //expected change
        int total = 16; //total change due back
        int count = 0;
        LinkedList ll = dynamicRegister.cashReg(coins, total); //get list of coins

        int coinsReturned[] = new int[ll.size()];
        while (!ll.isEmpty()) { //loop until ll is empty
            Object u = ll.remove();
            coinsReturned[count] = Integer.parseInt(u.toString()); //convert objects in ll to integers
            count++;
        }

        for (int i = 0; i < expectedAns.length; i++) {
            Assert.assertEquals(expectedAns[i], coinsReturned[i]); //checks if the expected answer is the same as whats returned by dynamic algorithm
        }
    }

    @Test
    public void test2() { //another situation where the dynamic algo succeeds, but greedy would be suboptimal
        int coins[] = {1, 5, 21, 25};//coins in use
        int expectedAns[] = {21, 21, 21}; //expected ans
        int total = 63; //total due back
        int count = 0;
        LinkedList ll = dynamicRegister.cashReg(coins, total); //list of coins

        int coinsReturned[] = new int[ll.size()];
        while (!ll.isEmpty()) {
            Object u = ll.remove();
            coinsReturned[count] = Integer.parseInt(u.toString()); //converts objects in ll to ints
            count++;
        }

        for (int i = 0; i < expectedAns.length; i++) {
            Assert.assertEquals(expectedAns[i], coinsReturned[i]); //checks if the expected answer is what was returned
        }

    }

    @Test
    public void test3() { //last situation where the dynamic algo passes, but greedy would fail
        int coins[] = {1, 10, 25, 48};//coins in use
        int expectedAns[] = {1, 1, 1, 25, 25}; //expected answer
        int total = 53; //total due back
        int count = 0;
        LinkedList ll = dynamicRegister.cashReg(coins, total); //list of coins

        int coinsReturned[] = new int[ll.size()];
        while (!ll.isEmpty()) {
            Object u = ll.remove();
            coinsReturned[count] = Integer.parseInt(u.toString()); //convert ll to int array
            count++;
        }

        for (int i = 0; i < expectedAns.length; i++) {
            Assert.assertEquals(expectedAns[i], coinsReturned[i]); //compare output to expected array
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArray() { //dynamicRegister throws illegal argument if array is size 0
        int coins[] = new int[0]; //catches expected exception when empty array is passed
        int total = 68;

        dynamicRegister.cashReg(coins, total);
    }

}
