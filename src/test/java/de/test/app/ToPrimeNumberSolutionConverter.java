package de.test.app;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.TypedArgumentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToPrimeNumberSolutionConverter extends TypedArgumentConverter<String, List> {

    public ToPrimeNumberSolutionConverter() {
        super(String.class, List.class);
    }

    @Override
    protected List convert(String solution) throws ArgumentConversionException {
        return Arrays.stream(solution.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
