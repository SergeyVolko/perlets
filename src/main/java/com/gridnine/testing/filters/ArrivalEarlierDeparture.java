package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

public class ArrivalEarlierDeparture implements Filter {

    @Override
    public boolean test(Flight flight) {
        return flight.getSegments()
                .stream()
                .noneMatch(s -> s.getDepartureDate().isAfter(s.getArrivalDate()));
    }
}
