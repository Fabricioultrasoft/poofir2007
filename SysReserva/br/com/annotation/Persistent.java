/*
 * Persistent.java
 * 
 * Created on 20/10/2007, 08:42:41
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Persistent {}
