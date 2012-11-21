package com.spring.mvc.dao;

/**
 * Interface having basic CRUD operations.
 * 
 * @author Vijitha Epa.
 * @param <T> generic type.
 */
public interface EntityDao<T> {

	/**
	 * Create Entity.
	 * 
	 * @param generic entity.
	 * @return generic entity.
	 */
	T create(T entity);

	/**
	 * Update Entity.
	 * 
	 * @param generic entity.
	 * @return generic entity.
	 */
	T update(T entity);

	/**
	 * Delete Entity.
	 * 
	 * @param generic entity.
	 * @return generic entity.
	 */
	T delete(T entity);

	/**
	 * Get Entity.
	 * 
	 * @param entity id.
	 * @return generic entity.
	 */
	T get(Long entityId);

	/**
	 * Find entity by id.
	 * 
	 * @param entity id.
	 * @return generic entity.
	 */
	T findById(Long id);

}
