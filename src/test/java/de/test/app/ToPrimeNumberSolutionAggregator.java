package de.test.app;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToPrimeNumberSolutionAggregator implements ArgumentsAggregator {
    @Override
    public List<Integer> aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
        return Arrays.stream(argumentsAccessor.getString(2).split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
