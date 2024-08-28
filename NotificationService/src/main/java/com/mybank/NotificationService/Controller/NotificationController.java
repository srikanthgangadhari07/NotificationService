package com.mybank.NotificationService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.NotificationService.DTO.TransactionDto;
import com.mybank.NotificationService.Service.NotificationService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	NotificationService notificactionService;
	@PostMapping("/notify/{email}/{amount}")
    public Boolean notify(@PathVariable  String email, @PathVariable Double amount,@RequestBody TransactionDto transaction ) throws MessagingException {
		return notificactionService.notify(email, amount, transaction);
		
	}
}
