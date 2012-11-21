package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.model.Member;

public interface MemberDao extends EntityDao<Member> {

	Member findByEmail(String email);

	List<Member> findAllOrderedByName();

}
