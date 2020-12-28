package de.test.app.data;

import org.mapstruct.Mapper;

@Mapper
public interface PrimeNumberMapper {
    PrimeNumberDto primeNumberToPrimeNumberDto(PrimeNumber primeNumber);
    PrimeNumber primeNumberDtoToPrimeNumber (PrimeNumberDto primeNumberDto);
}
