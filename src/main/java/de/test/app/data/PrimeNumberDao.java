package de.test.app.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrimeNumberDao extends JpaRepository<PrimeNumber,Integer> {

    List<PrimeNumber> findPrimeNumberBetween(int start, int end);

    PrimeNumber findByPrimeNumberEqual(int primeNumber);

}
