package com.gridnine.testing;

import com.gridnine.testing.filters.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        Filter filterTwoHours = new MoreThenTwoHoursFilter();
        Filter filterArrival = new ArrivalEarlierDeparture();
        Filter filterFlightBefore = new FlightBeforeCurrentDateFilter();
        List<Filter> filters = List.of(filterTwoHours, filterArrival, filterFlightBefore);
        Filter allFilters = new AllTestFilters(filters);

        System.out.println("=".repeat(50));
        FilterFlightManager flightManager = new FilterFlightManager(filterTwoHours);
        flightManager.getFilterFlight(flights).forEach(System.out::println);

        System.out.println("=".repeat(50));
        flightManager = new FilterFlightManager(filterArrival);
        flightManager.getFilterFlight(flights).forEach(System.out::println);

        System.out.println("=".repeat(50));
        flightManager = new FilterFlightManager(filterFlightBefore);
        flightManager.getFilterFlight(flights).forEach(System.out::println);

        System.out.println("=".repeat(50));
        flightManager = new FilterFlightManager(allFilters);
        flightManager.getFilterFlight(flights).forEach(System.out::println);


    }
}