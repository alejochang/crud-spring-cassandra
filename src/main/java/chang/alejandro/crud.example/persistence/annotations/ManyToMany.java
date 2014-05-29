/*
 * ManyToMany.java
 *
 * 1.0 (10/09/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.crud.example.persistence.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0 (10/09/2011)
 * Defines a many-to-many relationship.
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface ManyToMany {
	
	String columnFamily();

}
