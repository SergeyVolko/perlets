package com.gridnine.testing;

import com.gridnine.testing.filters.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class FilterFlightManagerTest {

    @Test
    public void whenAddFlightBeforeCurrentDateFilterThenListFlight() {
        Filter filter = new FlightBeforeCurrentDateFilter();
        FilterFlightManager manager = new FilterFlightManager(filter);
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> expected = List.of(
                flights.get(0),
                flights.get(1),
                flights.get(3),
                flights.get(4),
                flights.get(5)
        );
        List<Flight> result = manager.getFilterFlight(flights);
        assertThat(result)
                .hasSize(expected.size())
                .contains(expected.toArray(new Flight[0]));
    }

    @Test
    public void whenAddFlightArrivalEarlierDepartureThenListFlight() {
        Filter filter = new ArrivalEarlierDeparture();
        FilterFlightManager manager = new FilterFlightManager(filter);
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> expected = List.of(
                flights.get(0),
                flights.get(1),
                flights.get(2),
                flights.get(4),
                flights.get(5)
        );
        List<Flight> result = manager.getFilterFlight(flights);
        assertThat(result)
                .hasSize(expected.size())
                .contains(expected.toArray(new Flight[0]));
    }

    @Test
    public void whenAddFlightMoreThenTwoHoursThenListFlight() {
        Filter filter = new MoreThenTwoHoursFilter();
        FilterFlightManager manager = new FilterFlightManager(filter);
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> expected = List.of(
                flights.get(0),
                flights.get(1),
                flights.get(2),
                flights.get(3)
        );
        List<Flight> result = manager.getFilterFlight(flights);
        assertThat(result)
                .hasSize(expected.size())
                .contains(expected.toArray(new Flight[0]));
    }

    @Test
    public void whenAddFlightAllTestFiltersThenListFlight() {
        List<Filter> filters = List.of(
                new FlightBeforeCurrentDateFilter(),
                new ArrivalEarlierDeparture(),
                new MoreThenTwoHoursFilter()
        );
        Filter filter = new AllTestFilters(filters);
        FilterFlightManager manager = new FilterFlightManager(filter);
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> expected = List.of(
                flights.get(0),
                flights.get(1)
        );
        List<Flight> result = manager.getFilterFlight(flights);
        assertThat(result)
                .hasSize(expected.size())
                .contains(expected.toArray(new Flight[0]));
    }
}