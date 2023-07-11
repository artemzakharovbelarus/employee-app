package com.targsoft.employeeapp.application.util;

import com.targsoft.employeeapp.domain.Employee;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Long, Employee> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheEventLogger.class);

    @Override
    public void onEvent(CacheEvent<? extends Long, ? extends Employee> cacheEvent) {
        LOGGER.debug("Employee cache event, key: {}, old value: {}, new value: {}",
                     cacheEvent.getKey(),
                     cacheEvent.getOldValue(),
                     cacheEvent.getNewValue());
    }
}
