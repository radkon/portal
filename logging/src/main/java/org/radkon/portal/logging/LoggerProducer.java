package org.radkon.portal.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerProducer {

    @Produces
    public Logger produceSlf4jLogger(InjectionPoint ip) {
        final Class<?> clazz = ip.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(clazz);
    }

}
