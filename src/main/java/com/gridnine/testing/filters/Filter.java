package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

/**
 * Интерфейс филтрации полетов
 */
public interface Filter {
    boolean test(Flight flight);
}
