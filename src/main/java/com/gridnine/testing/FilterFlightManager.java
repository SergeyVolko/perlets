package com.gridnine.testing;

import com.gridnine.testing.filters.Filter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Менеджер фильтрации позволяет отфильтровать отфильтровать передаваемый список перелетовв
 * и вернуть отфильтрованный результат
 */
public class FilterFlightManager {
    private final Filter filter;

    public FilterFlightManager(final Filter filter) {
        this.filter = filter;
    }

    public List<Flight> getFilterFlight(List<Flight> flights) {
        return flights.stream()
                .filter(filter::test)
                .collect(Collectors.toList());
    }
}
