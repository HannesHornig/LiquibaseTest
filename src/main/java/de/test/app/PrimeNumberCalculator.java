package de.test.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PrimeNumberCalculator {

    public List<Integer> calculatePrime(int start, int end) {

        if (start < 1 || start > end) {
            throw new IllegalArgumentException("start needs to be >=1 and end > start");
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int numberToTest = start; numberToTest <= end; numberToTest++) {
            if (checkIfPrimeNumber(numberToTest)) {
                primeNumbers.add(numberToTest);
            }
        }
        return primeNumbers;
    }

    private boolean checkIfPrimeNumber(int numberToTest) {

        if(numberToTest == 1){
            return false;
        }

        boolean isPrime = true;
        for(int numberBelowTestNumber = numberToTest-1 ; numberBelowTestNumber > 1; numberBelowTestNumber--){
            isPrime = isPrime && numberToTest % numberBelowTestNumber != 0;
        }

        return isPrime;
    }
}
