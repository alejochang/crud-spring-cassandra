/*
 * ColumnFamily.java
 *
 * 1.0 (10/09/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.crud.example.persistence.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @version 1.0 (10/09/2011)
 * Is used to specify a mapped column family for an entity.
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnFamily {
	
	String name();

}
