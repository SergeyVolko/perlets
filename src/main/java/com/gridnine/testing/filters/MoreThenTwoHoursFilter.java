package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class MoreThenTwoHoursFilter implements Filter {
    private static final int TWO_HOURS = 2;

    @Override
    public boolean test(Flight flight) {
        Segment[] segments = flight.getSegments().toArray(new Segment[0]);
        long hours = IntStream.range(0, segments.length - 1)
                .mapToObj(i -> new LocalDateTime[] {segments[i].getArrivalDate(), segments[i + 1].getDepartureDate()})
                .mapToLong(arr -> ChronoUnit.HOURS.between(arr[0], arr[1]))
                .sum();
        return TWO_HOURS > hours;
    }
}
