package org.radkon.portal.hello;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class HelloServer {

    @Inject
    private Logger log;

    public HelloServer() {
        // ok
    }

    HelloServer(Logger log) {
        this.log = log;
    }

    @PostConstruct
    public void sayHello() {
        log.info("##### Hello, Server!");
    }

}
