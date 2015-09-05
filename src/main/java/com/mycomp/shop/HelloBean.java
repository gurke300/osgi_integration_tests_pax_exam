/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.shop;

/**
 *
 * @author Stephan
 */
public class HelloBean implements IHelloBean {
    
    @Override
    public String hello() {
        return "hello";
    }
    
}
