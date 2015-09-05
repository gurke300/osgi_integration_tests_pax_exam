/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osgi.paxexam.it;

import static com.mycompany.osgi.paxexam.it.PaxExamProvisioningSupport.aopAllianceBundle;
import static com.mycompany.osgi.paxexam.it.PaxExamProvisioningSupport.springBundles;

import java.io.IOException;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.blueprint.container.BlueprintContainer;
import org.osgi.service.blueprint.reflect.BeanMetadata;

import com.mycomp.shop.IHelloBean;
import javax.inject.Inject;

/**
 *
 * @author Stephan
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class RunOSGiWithProvisioningSupportIT {

    @Inject
    private IHelloBean helloBean;

    @Inject
    private BlueprintContainer blueprintContainer;

    @Inject
    private BundleContext blueprintBundleContext;

    @Configuration
    public Option[] configureTest() throws IOException {

        return CoreOptions.options(
            CoreOptions.cleanCaches(),
            aopAllianceBundle(),
            springBundles(),
            PaxExamProvisioningSupport.apacheAriesBlueprintBundles(),
            PaxExamProvisioningSupport.slf4jBundles(),
            CoreOptions.bundle("reference:file:target/classes"),
            CoreOptions.junitBundles());
    }

    @Test
    public void shouldContainTheSpringFrameworkBundles() throws Exception {
        Assert.assertNotNull(this.blueprintBundleContext);
        Assert.assertNotNull(FrameworkUtil.getBundle(org.springframework.context.ApplicationContext.class));
        Assert.assertNotNull(this.helloBean);
        System.out.println("HelloBean Service -> " + helloBean.hello());
        Assert.assertNotNull(this.blueprintContainer);
        System.out.println("blueprintcontainer Service -> " + blueprintContainer);

    }

    @Test
    public void shouldPrintTheBeanDefinition() throws Exception {

        Assert.assertNotNull(this.blueprintContainer);
        Assert.assertNotNull(this.helloBean);
        helloBean.hello();
        Optional<? extends BeanMetadata> beanMetadata = this.blueprintContainer.getMetadata(BeanMetadata.class).stream().filter(bm -> {
            System.out.println("bm.getId() "+bm.getId());
            return bm.getId().equals("helloBean");
        }).findAny();
        Assert.assertTrue(beanMetadata.isPresent());
        IHelloBean tmpHelloBean = (IHelloBean)this.blueprintContainer.getComponentInstance(beanMetadata.get().getId());
        System.out.println(tmpHelloBean.hello());
    }
}
