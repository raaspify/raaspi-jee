/**
 * 
 */
package com.rcomputer.genapp.addon;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
* This is Addon class to define custom CDI qualifier named Addon, needed by extended cdi classes
* @author 3r Computer Systems  
* @version 2.0
* Apply the following changes for any new addon cdi bean which extends existing bean
* copy existing bean but rename the file to xxxAddon.java
* Change contents to
* package com.rcomputer.genapp.addon
* add import com.rcomputer.genapp.model.*; 
* add import com.rcomputer.genapp.action.*; 
* change to @Named("xxxAddon")
* add @Addon
* change to public class xxxAddon extends xxx implements java.io.Serializable
* protected methods in action/model package cannot be called, instead use 
* reflection or a wrapper class (if already added in class extended ) addonXXX method.
*/

@Qualifier
@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, PARAMETER })
public @interface Addon {

}