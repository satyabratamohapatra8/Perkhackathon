package com.publisher.security.core.daoImpl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.earner.info.core.dao.UsersDao;
import com.earner.info.core.model.User;

import publisher.JUnitSpringTestBase;

public class DocumentMetadataDaoImplTest extends JUnitSpringTestBase{
	@Autowired
	UsersDao usersDao;
	@Test
	public void testGetMetadataOfDocument(){
		System.out.println("testGetMetadataOfDocument started");
		List<User> documentMetaDatas = usersDao.getAllUsers();
		System.out.println("extracted val"+documentMetaDatas);
	}
}
