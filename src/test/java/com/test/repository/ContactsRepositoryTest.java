package com.test.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.boot.entity.Contacts;
import com.boot.entity.Users;
import com.boot.repository.ContactRepository;
import com.boot.repository.impl.ContactRepositoryImpl;

public class ContactsRepositoryTest {

	private static ContactRepository contactRepository;
	private static Contacts contact1;
	private static Contacts contact2;
	private static Users user1;
	@BeforeClass
	public static void setUp(){
		 user1 = new Users();
		
		contactRepository = mock(ContactRepositoryImpl.class);
		contact1 = new Contacts();
		contact1.setName("Name");
		contact1.setMobilephone("2345");
		contact1.setUserId(user1);
		
		contact2 = new Contacts();
		contact2.setName("Name2");
		contact2.setMobilephone("123");
		contact2.setContactId(1);
		when(contactRepository.getUserContacts(user1)).thenReturn(Arrays.asList(contact1));
		when(contactRepository.findContactById(1)).thenReturn(contact2);
		
	}
	
	@Test
	public void testGetUsersContacts(){
		List<Contacts> contacts = contactRepository.getUserContacts(user1);
		assertEquals(1, contacts.size());
		assertEquals("Name", contacts.get(0).getName());
	}
	
	@Test
	public void testFindContactById(){
		Contacts contact = contactRepository.findContactById(contact2.getContactId());
		assertNotNull(contact);
		assertEquals("123", contact.getMobilephone());
	}
}
