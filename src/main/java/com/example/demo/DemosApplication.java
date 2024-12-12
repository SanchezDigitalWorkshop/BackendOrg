package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemosApplication.class, args);
		//test

		/*JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("sanchezdigitalworkshop@gmail.com");
		mailSender.setPassword("citoecfdiyhxcwoe");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("sanchezdigitalworkshop@gmail.com");
			helper.setTo("valdemarjuancolichonramirez@gmail.com");
			helper.setSubject("Prueba de Envío");
			helper.setText("Este es un correo de prueba.");
			mailSender.send(message);
			System.out.println("Correo enviado con éxito.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}*/
	}

}
