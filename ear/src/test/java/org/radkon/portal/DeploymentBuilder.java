package org.radkon.portal;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public final class DeploymentBuilder {

    private final WebArchive underConstruction = ShrinkWrap.create(WebArchive.class, "portal-test.war");

    public static DeploymentBuilder createDeployment() {
        return new DeploymentBuilder().with(assertj());
    }

    private static JavaArchive assertj() {
        final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "assertj.jar");
        archive.addPackages(true, "org.assertj");
        return archive;
    }

    public static JavaArchive persistenceModule() {
        final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "portal-persistence.jar");
        archive.addPackages(true, "org.radkon.portal.persistence");
        archive.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return archive;
    }

    public static JavaArchive loggingModule() {
        final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "portal-logging.jar");
        archive.addPackages(true, "org.radkon.portal.logging");
        archive.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return archive;
    }

    public static JavaArchive helloModule() {
        final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "portal-hello.jar");
        archive.addPackages(true, "org.radkon.portal.hello");
        archive.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return archive;
    }

    private DeploymentBuilder() {
        // ok
    }

    public DeploymentBuilder with(JavaArchive... libraries) {
        for (JavaArchive library : libraries) {
            underConstruction.addAsLibraries(library);
        }
        return this;
    }

    public Archive<?> build() {
        return underConstruction;
    }

}
