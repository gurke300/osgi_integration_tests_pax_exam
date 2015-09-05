/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osgi.paxexam.it;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.osgi.framework.BundleContext;

import javax.inject.Inject;

/**
 *
 * @author Stephan
 */
@RunWith(PaxExam.class)
public class RunOSGiContainerIT {

    @Inject
    private BundleContext bundleContext;

    @Configuration
    public Option[] configure() throws IOException {

        return CoreOptions.options(
//            CoreOptions.systemProperty("org.osgi.framework.startlevel.beginning").value("4"),
//            CoreOptions.cleanCaches(true),
            CoreOptions.junitBundles()
            
        );
    }

    @Test
    public void shouldHaveInjectedTheBundleContextOfThisTestBundle() {
        assertNotNull(this.bundleContext);
        assertTrue("JUnit Test Bundle should start with PAX", this.bundleContext.getBundle().getSymbolicName().startsWith("PAX"));
    }

}
