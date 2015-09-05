/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.shop;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Stephan
 */
public class ServiceRegistry {
    
    private final Map<Class<?>, Object> registry = new HashMap<>();
    
    
    public <C> C getRegisteredService(Class<C> serviceClass) {
        return serviceClass.cast(this.registry.get(serviceClass));
    }
    
    public void registerService(Object service) {
        this.registry.put(service.getClass(), service);
    }
}
