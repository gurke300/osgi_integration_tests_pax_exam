/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osgi.paxexam.it;

import static com.mycompany.osgi.paxexam.it.PaxExamProvisioningSupport.aopAllianceBundle;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;


/**
 *
 * @author Stephan
 */
@RunWith(PaxExam.class)
public class RunOSGiWithHibernateProvisioningSupportIT {

    
    @Configuration
    public Option[] configureTest() throws IOException {

        return CoreOptions.options(
            CoreOptions.cleanCaches(),
            aopAllianceBundle(),
            PaxExamProvisioningSupport.javaeeBundles(),
            PaxExamProvisioningSupport.xmlBundles(),
            PaxExamProvisioningSupport.jbossBundles(),
            PaxExamProvisioningSupport.hibernateBundles(),
            PaxExamProvisioningSupport.slf4jBundles(),
//            CoreOptions.bundle("reference:file:target/classes"),
            CoreOptions.junitBundles());
    }

    @Test
    public void shouldContainTheHibernateFrameworkBundles() throws Exception {
        Bundle hibernateCoreBundle = FrameworkUtil.getBundle(org.hibernate.Session.class);
        Assert.assertNotNull(hibernateCoreBundle);
        Assert.assertEquals(Bundle.ACTIVE, hibernateCoreBundle.getState());
    }

}
