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
        int coins[] = {1, 5, 12, 25};//coins in use
        int expectedAns[] = {1,5,5,5};
        int total = 16;
        int count = 0;
        LinkedList ll = dynamicRegister.cashReg(coins, total);

        int coinsReturned[] = new int[ll.size()];
        while (!ll.isEmpty()) {
            Object u = ll.remove();
            coinsReturned[count] = Integer.parseInt(u.toString());
            count++;
        }
        
        for(int i = 0; i < expectedAns.length; i++){
            Assert.assertEquals(expectedAns[i], coinsReturned[i]);
        }
    }

    
    @Test
    public void test2() {
        
    }

    @Test
    public void test3() {
       
    }
     
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArray() { //greedy register throws illegal argument if array is size 0
        int coins[] = new int[0];
        int total = 68;

        dynamicRegister.cashReg(coins, total);
    }

}
