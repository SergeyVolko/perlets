package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import java.util.List;

/**
 * Фильтрация перелетов с учетом заданного списка фильтров
 */
public class AllTestFilters implements Filter {
    private final List<Filter> filters;

    public AllTestFilters(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public boolean test(Flight flight) {
        return filters.stream().allMatch(f -> f.test(flight));
    }
}
