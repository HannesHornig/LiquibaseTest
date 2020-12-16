package de.test.app;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrimeNumberCalculatorTest
{
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
        assertTrue(integers.size()> 1);
        assertTrue(integers.size()< 10);
    }

    @Test
    public void calculatePrime_noNegativeStart(){
        List<Integer> calculatePrime = testee.calculatePrime(-1, 10);
        assertTrue(calculatePrime.isEmpty());
    }

    @Test
    public void calculatePrime_StartBiggerThenEnd(){
        List<Integer> calculatePrime = testee.calculatePrime(100, 10);
        assertTrue(calculatePrime.isEmpty());
    }

    @Test
    public void calculatePrime_OrderOfFirstPrimes(){
        List<Integer> integers = testee.calculatePrime(1, 10);
        assertEquals(Integer.valueOf(2), integers.get(0));
        assertEquals(Integer.valueOf(3), integers.get(1));
        assertEquals(Integer.valueOf(5), integers.get(2));
        assertEquals(Integer.valueOf(7), integers.get(3));


    }

}
