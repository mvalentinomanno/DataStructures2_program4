/*
 * Author: Michael Valentino-Manno
 * Date: 4/13/18
 * Overview: Greedy cash register problem with jtests
 */

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class dynamicRegisterTest {

    @Test
    public void test1() { //tests 1,2,3 test the greedy register method with different inputs
        int coins[] = {1, 5, 10, 25};//coins in use
        String result[] = {"25", "25", "10", "5", "1", "1", "1"}; //expected result
        int total = 68;
        int count = 0;

        LinkedList ll = dynamicRegister.cashReg(coins, total); //output list of coins
        String coinsReturned[] = new String[ll.size()];

        while (!ll.isEmpty()) {
            Object u = ll.remove();
            coinsReturned[count] = u.toString(); //convert list to array to compare
            count++;
        }

            Assert.assertArrayEquals(result, coinsReturned); //fail if expected array is not equal to output

    }

    @Test
    public void test2() {
        int coins[] = {1, 5, 10, 25};
        String result[] = {"25", "10", "10", "1", "1", "1", "1"};
        int total = 49;
        int count = 0;

        LinkedList ll = dynamicRegister.cashReg(coins, total);
        String coinsReturned[] = new String[ll.size()];

        while (!ll.isEmpty()) {
            Object u = ll.remove();
            coinsReturned[count] = u.toString();
            count++;
        }

            Assert.assertArrayEquals(result, coinsReturned);
    }

    @Test
    public void test3() {
        int coins[] = {1, 5, 10, 25 , 8};
        String result[] = {"10", "5", "1"};
        int total = 16;
        int count = 0;

        LinkedList ll = dynamicRegister.cashReg(coins, total);
        String coinsReturned[] = new String[ll.size()];

        while (!ll.isEmpty()) {
            Object u = ll.remove();
            coinsReturned[count] = u.toString();
            count++;
        }

            Assert.assertArrayEquals(result, coinsReturned);
    }

    @Test
    public void testEmptyArray() { //greedy register throws illegal argument if array is size 0
        int coins[] = new int[0];
        int total = 68;

        dynamicRegister.cashReg(coins, total);
    }

}
