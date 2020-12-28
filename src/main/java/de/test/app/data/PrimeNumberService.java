package de.test.app.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrimeNumberService {

    private PrimeNumberDao primeNumberDao;
    private PrimeNumberMapper mapper;

    public List<PrimeNumberDto> getPrimeNumberInInterval(int start, int end){

        if(end<start || start < 0 || end < 0){
            throw  new IllegalArgumentException("Invalid start and end parameter");
        }
        List<PrimeNumber> primeNumbers = primeNumberDao.findPrimeNumberBetween(start, end);

        return primeNumbers.stream().map(mapper::primeNumberToPrimeNumberDto).collect(Collectors.toList());
    }

    public boolean isPrimeNumber(PrimeNumberDto primeNumber){
        PrimeNumber prime = primeNumberDao.findByPrimeNumberEqual(primeNumber.getPrimeNumber());
        return prime != null;
    }

    public void save(PrimeNumberDto primeNumberDto){
        primeNumberDao.save(mapper.primeNumberDtoToPrimeNumber(primeNumberDto));
    }


}
