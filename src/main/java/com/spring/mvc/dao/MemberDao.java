package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.model.Member;

public interface MemberDao extends EntityDao<Member> {

	/**
	 * Find {@link Member} by emailAddress.
	 * @param email as {@link String}.
	 * @return type {@link Member}.
	 */
	Member findByEmail(String email);

	/**
	 * find all {@link Member}s ordered by Name.
	 * @return {@link List} of {@link Member}s.
	 */
	List<Member> findAllOrderedByName();

}
