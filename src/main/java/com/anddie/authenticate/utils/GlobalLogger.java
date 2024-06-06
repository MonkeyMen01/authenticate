package com.anddie.authenticate.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GlobalLogger {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
}
