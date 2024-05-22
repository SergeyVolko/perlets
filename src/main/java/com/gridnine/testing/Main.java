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

        System.out.println("Все перелеты");
        flights.forEach(System.out::println);

        System.out.println("Исключение перелетов где общее время, проведённое на земле, превышает два часа");
        FilterFlightManager flightManager = new FilterFlightManager(filterTwoHours);
        flightManager.getFilterFlight(flights).forEach(System.out::println);

        System.out.println("Исключение перелетов где сегменты с датой прилёта позже даты вылета.");
        flightManager = new FilterFlightManager(filterArrival);
        flightManager.getFilterFlight(flights).forEach(System.out::println);

        System.out.println("Исключение перелетов до текущего момента времени.");
        flightManager = new FilterFlightManager(filterFlightBefore);
        flightManager.getFilterFlight(flights).forEach(System.out::println);

        System.out.println("Фильтрация по всем правилам");
        flightManager = new FilterFlightManager(allFilters);
        flightManager.getFilterFlight(flights).forEach(System.out::println);
    }
}