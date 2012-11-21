package com.spring.mvc.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.model.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/test-applicationContext.xml" })
// @Transactional
// @TransactionConfiguration(defaultRollback = false)
public class MemberDaoTest {

	@Autowired(required = true)
	private MemberDao memberDao;

	@Test
	public void testRegister() {
		Member member = new Member();
		member.setEmail("vijitha.doe@mailinator.com");
		member.setName("vijitha Doe");
		member.setPhoneNumber("2125552121");

		memberDao.create(member);
		Long id = member.getId();
		Assert.assertNotNull(id);

		Assert.assertEquals(1, memberDao.findAllOrderedByName().size());
		Member newMember = memberDao.findById(id);

		Assert.assertEquals("vijitha Doe", newMember.getName());
		Assert.assertEquals("vijitha.doe@mailinator.com", newMember.getEmail());
		Assert.assertEquals("2125552121", newMember.getPhoneNumber());
		// return;
	}

	@Test
	public void testFindById() {
		Member member = memberDao.findById(01L);

		Assert.assertEquals("vijitha Doe", member.getName());
		Assert.assertEquals("vijitha.doe@mailinator.com", member.getEmail());
		Assert.assertEquals("2125552121", member.getPhoneNumber());
		// return;
	}

	@Test
	public void testFindByEmail() {
		Member member = memberDao.findByEmail("vijitha.doe@mailinator.com");

		Assert.assertEquals("vijitha Doe", member.getName());
		Assert.assertEquals("vijitha.doe@mailinator.com", member.getEmail());
		Assert.assertEquals("2125552121", member.getPhoneNumber());
		// return;
	}

	@Test
	public void testFindAllOrderedByName() {
		Member member = new Member();
		member.setEmail("jane.doe@mailinator.com");
		member.setName("Jane Doe");
		member.setPhoneNumber("2125552122");
		memberDao.create(member);

		List<Member> members = memberDao.findAllOrderedByName();
		Assert.assertEquals(2, members.size());
		Member newMember = members.get(0);

		Assert.assertEquals("Jane Doe", newMember.getName());
		Assert.assertEquals("jane.doe@mailinator.com", newMember.getEmail());
		Assert.assertEquals("2125552122", newMember.getPhoneNumber());
		// return;
	}
}
