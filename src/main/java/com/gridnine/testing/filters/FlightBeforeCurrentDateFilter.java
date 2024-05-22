package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import java.time.LocalDateTime;

/**
 * Фильтрация вылетов до текущего момента времени.
 */
public class FlightBeforeCurrentDateFilter implements Filter {

    @Override
    public boolean test(Flight flight) {
        return flight.getSegments()
                .stream()
                .map(Segment::getDepartureDate)
                .allMatch(date -> date.isAfter(LocalDateTime.now()));
    }
}
