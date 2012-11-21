package com.spring.mvc.dao;


public interface EntityDao<T> {

	T create(T entity);

	T update(T entity);

	T delete(T entity);

	T get(Long entityId);

	T findById(Long id);

}
