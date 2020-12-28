package de.test.app;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.LoggerFactory;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class PrimeNumberCalculatorTest {
    public static final String EXPECTED_EXCEPTION_MESSAGE = "start needs to be >=1 and end > start";
    public static final String EXPECTED_LOG_MESSAGE = "Starting calculation of Prime from 1 to 10";
    private PrimeNumberCalculator testee = new PrimeNumberCalculator();

    private ListAppender<ILoggingEvent> listAppender;

    // TODO difference Before-Each and Before-ALL
    @BeforeEach
    public void before(){
        Logger logger = (Logger) LoggerFactory.getLogger(PrimeNumberCalculator.class);
        listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);
    }

    @AfterEach
    public void after(){
        listAppender.stop();
    }

    @Test
    public void calculatePrime_returnNonEmptyList() {
        List<Integer> listOfPrimes = testee.calculatePrime(1, 10);
        assertFalse(listOfPrimes.isEmpty());
    }

    @Test
    public void calculatePrime_returnListOfNumbersBetweenParams() {
        List<Integer> integers = testee.calculatePrime(1, 10);
        assertTrue(integers.size() > 1);
        assertTrue(integers.size() < 10);
    }

    @Test
    public void calculatePrime_noNegativeStart() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> testee.calculatePrime(-1, 10));
        assertEquals(illegalArgumentException.getMessage(), EXPECTED_EXCEPTION_MESSAGE);
    }

    @Test
    public void calculatePrime_StartBiggerThenEnd() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> testee.calculatePrime(100, 10));
        assertEquals(illegalArgumentException.getMessage(), EXPECTED_EXCEPTION_MESSAGE);
    }

    @Test
    public void calculatePrime_OrderOfFirstPrimes() {
        List<Integer> integers = testee.calculatePrime(1, 10);
        assertEquals(Integer.valueOf(2), integers.get(0));
        assertEquals(Integer.valueOf(3), integers.get(1));
        assertEquals(Integer.valueOf(5), integers.get(2));
        assertEquals(Integer.valueOf(7), integers.get(3));
    }

    // Example of Method Source parameterized Test

    @Tag("parameterized")
    @ParameterizedTest
    @MethodSource
    public void calculatePrime_ParameterizedTests_staticMethodSource(int start, int end, List<Integer> solution) {
        List<Integer> integers = testee.calculatePrime(start, end);
        assertAll("Returns primes and only primes",
                () -> assertTrue(integers.containsAll(solution)),
                () -> assertEquals(integers.size(), solution.size()));
    }

    public static Stream<Arguments> calculatePrime_ParameterizedTests_staticMethodSource() {
        return Stream.of(Arguments.arguments(1, 10, Arrays.asList(2, 3, 5, 7)),
                Arguments.arguments(4, 10, Arrays.asList(5, 7)),
                Arguments.arguments(10, 20, Arrays.asList(11, 13, 17, 19)));
    }

    @Tag("parameterized")
    @ParameterizedTest
    @CsvFileSource(resources = "/primeNumberStarterArguments.csv")
    public void calculatePrime_ParameterizedTests_CsvFileWithConverter(int start, int end,
                                                                       @ConvertWith(ToPrimeNumberSolutionConverter.class) List<Integer> solution) {
        List<Integer> integers = testee.calculatePrime(start, end);

        assertAll("Returns primes and only primes",
                () -> assertTrue(integers.containsAll(solution)),
                () -> assertEquals(integers.size(), solution.size()));
    }

    @Tag("parameterized")
    @DisplayName("Automated Parameterized Prime Number Test")
    @ParameterizedTest(name = "{index} Test with start {0} and end {1} and the solution {2}")
    @CsvFileSource(resources = "/primeNumberStarterArguments.csv")
    public void calculatePrime_ParameterizedTests_CsvFileWithArgumentAccessor(ArgumentsAccessor arguments,
                                                                              @AggregateWith(ToPrimeNumberSolutionAggregator.class) List<Integer> solution) {
        List<Integer> integers = testee.calculatePrime(arguments.getInteger(0), arguments.get(1, Integer.class));

        assertAll("Returns primes and only primes",
                () -> assertTrue(integers.containsAll(solution)),
                () -> assertEquals(integers.size(), solution.size()));
    }

    // TODO Sl4j and log4j
    @Test
    public void calculatePrime_checkIfInitialLoggingWorks() {

        testee.calculatePrime(1, 10);

        List<ILoggingEvent> logsList = listAppender.list;
        boolean isExpectedLogMessagePresent = logsList.stream().anyMatch(event -> EXPECTED_LOG_MESSAGE.equals(event.getFormattedMessage())
                && Level.INFO.equals(event.getLevel()));

        assertTrue(isExpectedLogMessagePresent);
    }

}
