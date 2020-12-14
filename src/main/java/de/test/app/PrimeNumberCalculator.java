package de.test.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberCalculator {
    public List<Integer> calculatePrime(int start, int end) {

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {

            boolean isPrime = true;
            for (int b = i - 1; b > 1; b--) {
                isPrime = isPrime && i % b != 0;
            }

            if (isPrime && i != 0 && i != 1) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
