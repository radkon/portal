package org.radkon.portal.hello;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.radkon.portal.DeploymentBuilder;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.radkon.portal.DeploymentBuilder.*;

@RunWith(Arquillian.class)
public class HelloServerIntegrationTest {

    @Deployment
    public static Archive<?> deploy() {
        return createDeployment().with(persistenceModule(), loggingModule(), helloModule()).build();
    }

    @Inject
    HelloServer helloServer;

    @Test
    public void testInjectionIntoTestCase() {
        assertThat(helloServer).isNotNull();
    }

}
