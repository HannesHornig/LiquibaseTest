package de.test.app;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrimeNumberCalculatorTest
{


    /*
     - learning -> minimal Set of Test if possible
        -> Type of test -> exploratorive Test
     - Strategies -> fake it

     */

    /*
    TestCases
     -Take Start Number and End Number and return number up to end number
     -return prime Number
     -returns prime Number ordered
     */

    private PrimeNumberCalculator testee = new PrimeNumberCalculator();

    @Test
    public void calculatePrime_returnNonEmptyList()
    {
        List<Integer> listOfPrimes = testee.calculatePrime(1,10);
        assertFalse(listOfPrimes.isEmpty());
    }

    @Test
    public void calculatePrime_returnListOfNumbersBetweenParams(){
        List<Integer> integers = testee.calculatePrime(1, 10);
        assertTrue(integers.size()> 2);
    }

    @Test
    public void calculatePrime_first_primeNumber(){
        List<Integer> listOfPrimes = testee.calculatePrime(0,5);
        assertEquals(Integer.valueOf(2),listOfPrimes.get(0));
    }

    @Test
    public void calculatePrime_OrderOfFirstThreePrimes(){
        List<Integer> integers = testee.calculatePrime(0, 10);
        assertEquals(Integer.valueOf(2), integers.get(0));
        assertEquals(Integer.valueOf(3), integers.get(1));
        assertEquals(Integer.valueOf(5), integers.get(2));
        assertEquals(Integer.valueOf(7), integers.get(3));


    }

}
