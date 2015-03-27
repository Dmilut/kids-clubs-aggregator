package ru.dmilut.prodlenka.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.dmilut.prodlenka.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:test-applicationContext.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAll() {
		List<User> users = userService.findAll();
		assertNotNull(users);		

	}

	/*
	 * @Test public void testFindOne() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testFindOneWithUnitsLong() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testSave() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testFindOneWithUnitsString() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testFindAllByUnit() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testDelete() { fail("Not yet implemented"); }
	 */

}
