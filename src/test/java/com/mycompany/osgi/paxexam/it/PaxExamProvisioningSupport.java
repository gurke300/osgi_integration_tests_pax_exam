/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osgi.paxexam.it;

import static org.ops4j.pax.exam.CoreOptions.mavenBundle;

import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;

public class PaxExamProvisioningSupport {

    /**
     * Returns the bundle for the aop interface of the aopalliance needed e.g. by spring-aop.
     *
     * @return bundle for aop domain
     */
    public static Option aopAllianceBundle() {
        return mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.aopalliance", "1.0_6");
    }

    /**
     * Returns the spring bundles used in this project.
     *
     * @return spring 4 bundles
     */
    public static Option springBundles() {
        return CoreOptions.composite(
            // spring dependencies bundles
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.spring-aop", "4.0.7.RELEASE_1"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.spring-beans", "4.0.7.RELEASE_1"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.spring-context", "4.0.7.RELEASE_1"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.spring-context-support", "4.0.7.RELEASE_1"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.spring-core", "4.0.7.RELEASE_1"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.spring-jdbc", "4.0.7.RELEASE_1"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.spring-orm", "4.0.7.RELEASE_1"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.spring-tx", "4.0.7.RELEASE_1"));
    }

    /**
     * Exports the javaee specification bundles.
     *
     * @return a composite option holding several javaee spec bundles:
     * <ul><li>javax.transaction</li><li>cdi-api</li><li>javax.interceptor-api</li><li>javax.el-api</li></ul>
     *
     */
    public static Option javaeeBundles() {
        return CoreOptions.composite(
            mavenBundle("javax.transaction", "javax.transaction-api", "1.2"),
            mavenBundle("javax.enterprise", "cdi-api", "1.2"),
            mavenBundle("javax.interceptor", "javax.interceptor-api", "1.2"),
            mavenBundle("javax.el", "javax.el-api", "3.0.1-b04"));
    }

    public static Option apacheAriesBlueprintBundles() {
        return CoreOptions.composite(
            mavenBundle("org.apache.aries.blueprint", "org.apache.aries.blueprint.core"),
            mavenBundle("org.apache.aries.blueprint", "org.apache.aries.blueprint.cm"),
            mavenBundle("org.apache.aries.blueprint", "org.apache.aries.blueprint.annotation.api"),
            mavenBundle("org.apache.aries.proxy", "org.apache.aries.proxy.api", "1.0.0"),
            mavenBundle("org.apache.aries.proxy", "org.apache.aries.proxy.impl", "1.0.4"),
            mavenBundle("org.apache.aries.quiesce", "org.apache.aries.quiesce.api", "1.0.0"),
            mavenBundle("org.apache.aries", "org.apache.aries.util", "1.1.0")
        );
    }

    public static Option apacheAriesTransactionManager() {
        return CoreOptions.composite(mavenBundle("org.apache.aries.transaction", "org.apache.aries.transaction.blueprint"),
                                     mavenBundle("org.apache.aries.transaction", "org.apache.aries.transaction.manager")
        );
    }

    public static Option slf4jBundles() {
        return CoreOptions.composite(
            mavenBundle("org.slf4j", "slf4j-api", "1.7.7"),
            // a fragment cannot be started but installed
            mavenBundle("org.slf4j", "slf4j-simple", "1.7.7").noStart());
    }

    public static Option jbossBundles() {
        return CoreOptions.composite(
            mavenBundle("org.jboss.logging", "jboss-logging", "3.1.3.GA"),
            mavenBundle("org.jboss", "jandex", "1.2.1.Final"));
    }

    public static Option xmlBundles() {
        return CoreOptions.composite(
            mavenBundle("com.fasterxml", "classmate", "1.1.0"),
            mavenBundle("org.apache.servicemix.specs", "org.apache.servicemix.specs.stax-api-1.2"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.dom4j", "1.6.1_5")
        );
    }

    public static Option hibernateBundles() {
        return CoreOptions.composite(
            mavenBundle("org.javassist", "javassist", "3.18.2-GA"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.ehcache", "2.6.9_1"),
            mavenBundle("org.apache.servicemix.bundles", "org.apache.servicemix.bundles.antlr", "2.7.7_3"),
            mavenBundle("org.hibernate.javax.persistence", "hibernate-jpa-2.1-api", "1.0.0.Final"),
            mavenBundle("org.hibernate", "hibernate-core", "4.3.8.Final"),
            mavenBundle("org.hibernate", "hibernate-entitymanager", "4.3.8.Final"),
            mavenBundle("org.hibernate.common", "hibernate-commons-annotations", "4.0.5.Final"),
            mavenBundle("org.hibernate", "hibernate-ehcache", "4.3.8.Final")
        );
    }
}
