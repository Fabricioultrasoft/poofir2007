/*
 * GetValue.java
 * 
 * Created on 24/10/2007, 07:33:59
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Clelia
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GetValue {

}
