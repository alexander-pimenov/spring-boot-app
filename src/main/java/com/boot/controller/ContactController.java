package com.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.entity.Contacts;
import com.boot.entity.Users;
import com.boot.service.ContactService;
/**
 * Serves CRUD contact operations
 * @author admin
 *
 */
@Controller
public class ContactController {

	@Autowired
	private ContactService contactDao;

	@GetMapping("/add-contact")
	public String getCreateContactPage(Model model) {
		Contacts contact = new Contacts();
		model.addAttribute("newContact", contact);
		model.addAttribute("adding", true);
		return "addContact";
	}

	@PostMapping("/add-contact")
	public String addNewContact(@ModelAttribute("newContact") Contacts contact, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("currentUser");
		if (contact != null){
			contact.setUserId(user);
			contactDao.createContact(contact);
		}
		return "redirect:/home";
	}
	
	@GetMapping("/delete")
	public String editContact(@RequestParam("contactId") Integer contactId){
		if (contactId!=null){
			contactDao.deleteContact(contactDao.findContactById(contactId));
		}
		return "redirect:/home";
	}
	
	@GetMapping("/edit")
	public String getEditContactPage(@RequestParam("contactId") Integer contactId, Model model){
		model.addAttribute("newContact", contactDao.findContactById(contactId));
		model.addAttribute("editing", true);
		return "addContact";
	}
	
	@PostMapping("/edit")
	public String editContact(@ModelAttribute("newContact") Contacts contact, HttpServletRequest request){
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("currentUser");
		if (contact != null){
			contact.setUserId(user);
			contactDao.editContact(contact);
		}
		return "redirect:/home";
	}

}
