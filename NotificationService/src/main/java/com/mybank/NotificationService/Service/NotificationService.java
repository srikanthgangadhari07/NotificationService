package com.mybank.NotificationService.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mybank.NotificationService.DTO.TransactionDto;
import com.mybank.NotificationService.Model.Notification;
import com.mybank.NotificationService.Repository.NotificationRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class NotificationService {
	@Autowired 
	NotificationRepository NotificationRepository; 
	@Autowired
	JavaMailSender javaMailSender;
	
	public static final Logger LOGGER =LoggerFactory.getLogger(NotificationService.class);
	
	public Boolean notify(String email,Double amount ,TransactionDto transactionDto) throws MessagingException {
		LOGGER.info(" In NotificationService.notify()");
		Boolean status=false;
		Notification notification = new Notification();
		sendEmailNotification(email,transactionDto,amount);
		notification.setNotifyTo(email);
		notification.setStatus("SENT");
	     notification =	NotificationRepository.save(notification);
		if(notification!=null) {
		  status =true;
		}
		LOGGER.info(" Out NotificationService.sendEmailNotification()");
		return status;
	}
	
	public void sendEmailNotification(String to , TransactionDto  transaction, Double amount) throws MessagingException {
		LOGGER.info(" In MailService.sendEmailNotification()");
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		helper.setTo(to);
		LOGGER.info(" toMail : \n"+to);
		helper.setSubject("MyBank Notification");
		String text = buildEmailContent(transaction,amount);
		LOGGER.info(" mailText : \n"+text);
		helper.setText(text,false);
		javaMailSender.send(message);
		
	   LOGGER.info(" Out MailService.sendEmailNotification()");
	}
	public String  buildEmailContent(TransactionDto transaction,Double amount) {
		
		String transactionType =  ("DEPOSIT,TRANSFER_TO").contains(transaction.getTransactionType()) ? "Credited to" : "Debited from";
		
		return String.format("Dear customer ,\n\n  Rs.%.2f/- %s a/c XXXXX%s on %s. \n Your transaction reference number is:%s \n\nWarm Regards,\nMyBank.",
				amount,
				transactionType,
				transaction.getAccountId(),
				transaction.getTimeStamp(),
				transaction.getTransactionId());
		
	}

}
