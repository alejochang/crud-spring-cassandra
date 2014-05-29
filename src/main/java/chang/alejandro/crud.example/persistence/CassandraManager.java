/*
 * CassandraManager.java
 *
 * 1.0 (09/09/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */
package chang.alejandro.crud.example.persistence;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import chang.alejandro.crud.example.model.Gender;
import chang.alejandro.crud.example.utils.CassandraUtils;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.HColumn;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;
import me.prettyprint.hector.api.query.ColumnQuery;
import me.prettyprint.hector.api.query.QueryResult;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chang.alejandro.crud.example.persistence.annotations.Column;
import chang.alejandro.crud.example.persistence.annotations.ColumnFamily;
import chang.alejandro.crud.example.persistence.annotations.ManyToMany;
import chang.alejandro.crud.example.persistence.annotations.RowKey;

/**
 * @version 1.0 (09/09/2011)
 * 
 *          <p>
 *          CassandraManager is used to create and remove entity instances, and
 *          find entities by their key.
 *          </p>
 *          <p>
 *          The classes that define those entities, must use the annotations
 *          defined in the package com.alejandro.crud.persistence.annotations
 *          to map the entity classes with a Cassandra data base.
 *          </p>
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 * 
 */
public class CassandraManager {

	/**
	 * References the cluster
	 */
	private static Cluster cluster;

	/**
	 * References the keyspaceOperator.
	 */
	private static Keyspace keyspaceOperator;

	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext.xml");

		cluster = (Cluster) ctx.getBean("cluster");

		keyspaceOperator = (Keyspace) ctx.getBean("keyspace");
	}

	/**
	 * Persists the entity object in a Cassandra data base.
	 */
	public static void persist(Object entity) {

		/*
		 * Check if the given object is null and if the annotation @ColumnFamily
		 * is present
		 */
		if (entity == null
				|| entity.getClass().isAnnotationPresent(ColumnFamily.class) == false) {
			throw new IllegalArgumentException(
					"Entity must not be null and must be annotated with ColumnFamily.");
		}

		String columnFamily = null, rowKey = null;
		Map<String, String> columnValues = new HashMap<String, String>();
		// Set<String> manyToManyValues = new HashSet<String>();
		try {

			columnFamily = getColumnFamilyName(entity);

			Method[] methods = entity.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {

				if (methods[i].isAnnotationPresent(RowKey.class)) {
					// Invoke the method to read the row key value
					Object key = methods[i].invoke(entity, new Object[] {});
					rowKey = (String) key;

				} else if (methods[i].isAnnotationPresent(Column.class)) {
					/* Get the column name if the annotation Column is present */
					String columnName = null, columnValue = null;

					columnName = getColumnName(methods[i]);

					// Read the column value
					Object result = methods[i].invoke(entity, new Object[] {});

					// Check the result type
					if (result != null) {
						if (result instanceof Date) {
							columnValue = CassandraUtils
									.getFormattedDateString((Date) result);
						} else {
							columnValue = result.toString();
						}
					}

					columnValues.put(columnName, columnValue);

				} else if (methods[i].isAnnotationPresent(ManyToMany.class)) {
					// Handle the ManyToMany relation.
				}
			}

			// Check if there are column values to be stored.
			if (rowKey != null && columnValues.isEmpty() != true) {
				Mutator<String> mutator = HFactory.createMutator(
						keyspaceOperator, StringSerializer.get());

				// Insert each entry in by the rowKey annotated
				for (Entry<String, String> entry : columnValues.entrySet()) {
					mutator.insert(
							rowKey,
							columnFamily,
							HFactory.createStringColumn(entry.getKey(),
									entry.getValue()));
				}

				// Perform the insertion into the table that represents the
				// relation ManyToMany

			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the column family mapped with the entity class
	 * @param entity
	 * @return the column family name
	 */
	private static String getColumnFamilyName(Object entity) {
		String columnFamily;
		// Access the ColumnFamily class to extract the columnFamily name
		ColumnFamily columnFamilyAnn = (ColumnFamily) entity.getClass()
				.getAnnotation(ColumnFamily.class);

		columnFamily = columnFamilyAnn.name();
		return columnFamily;
	}

	/**
	 * Gets the value of the specified row key field(getter method) in the entity class
	 * @param entity
	 * @return
	 */
	private static String getRowKey(Object entity) {
		String rowKey = null;
		Method[] methods = entity.getClass().getMethods();
		try {
			for (int i = 0; i < methods.length; i++) {
				if (methods[i].isAnnotationPresent(RowKey.class)) {
					// Invoke the method to read the row key value
					Object key;

					key = methods[i].invoke(entity, new Object[] {});

					if (key != null) {
						rowKey = (String) key;
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return rowKey;
	}
	
	
	/**
	 * Gets the specified column name from the given Method (getter method)
	 * @param method
	 * @return the column name
	 */
	private static String getColumnName(Method method) {
		
		/* Get the column name from the Column annotation */
		
		Column columnAnn = (Column) method.getAnnotation(Column.class);

		return columnAnn.name();
	}
	
	
	/**
	 * Deletes all columns for the given object (takes the row key value from the annotated method) 
	 */
	public static void remove(Object entity) {
		/*
		 * 
		 */
		Mutator<String> mutator = HFactory.createMutator(keyspaceOperator,
				StringSerializer.get());
		String columnFamily = getColumnFamilyName(entity);
		String rowKey = getRowKey(entity);
		//A null passed as the column name (third argument) triggers the delete for all the columns.
		mutator.delete(rowKey, columnFamily, null, StringSerializer.get());
	}

	private static String getColumnValue(String columnFamily, String key,
			String columnName) {
		String columnValue = null;
		ColumnQuery<String, String, String> columnQuery = HFactory
				.createStringColumnQuery(keyspaceOperator);

		columnQuery.setColumnFamily(columnFamily).setKey(key)
				.setName(columnName);

		QueryResult<HColumn<String, String>> result;
		try {
			result = columnQuery.execute();
			if (result.get() != null) {
				columnValue = result.get().getValue();
			}
		} catch (Exception e) {
			columnValue = "";
		}

		return columnValue;
	}

	/**
	 * Finds a entity by a row key.
	 * The row key value is gotten from the annotated method with 
	 * <code>@RowKey</code>of the given entity.
	 * If the entity was not found, the entity is returned empty.
	 *  
	 * @param T the class template
	 * @param entity  the entity instance that contains the row key value.
	 * 
	 * @return the entity instance with the values found by the given row key value. 
	 */
	public static <T> T find(Class<T> T, Object entity) {
		String rootField, columnFamily, rowKey, columnName, columnValue;
		columnFamily = getColumnFamilyName(entity);
		rowKey = getRowKey(entity);
		Method[] methods = entity.getClass().getMethods();
		Method setterMethod;
		try {
			
			for (int i = 0; i < methods.length; i++) {

				if (methods[i].isAnnotationPresent(Column.class)) {
					columnName = getColumnName(methods[i]);
					
					// The method expected must be a getter.
					rootField = methods[i].getName();
					
					// index 3 to remove the prefix get
					rootField = rootField.substring(3);
					
					columnValue = getColumnValue(columnFamily, rowKey,
							columnName);

					// Handle the null column values
					if (columnValue == null) {
						columnValue = "";
					}

					//build the setter method name
					setterMethod = entity.getClass().getMethod(
							"set" + rootField, methods[i].getReturnType());

					Class parameterType = setterMethod.getParameterTypes()[0];

					Object parameter;

					//Evaluate the parameter type expected by the setter method 
					if (parameterType == String.class
							|| columnValue.length() == 0) {
						//
						parameter = columnValue;
					} else if (parameterType == Gender.class) {
						parameter = Gender.valueOf(columnValue);
					} else if (parameterType == Date.class) {
						parameter = CassandraUtils.parseDate(columnValue);
					} else if (parameterType == Boolean.class) {
						parameter = Boolean.valueOf(columnValue);
					} else {
						parameter = columnValue.toString();
					}

					setterMethod.invoke(entity, new Object[] { parameter });
				}
			}

			return (T) entity;

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Getter of <code>cluster</code> property.
	 * 
	 * @return <code>cluster</code> property value.
	 * @see #cluster
	 */

	public static Cluster getCluster() {
		return cluster;
	}
}
