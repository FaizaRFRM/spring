package com.example.demo.Controller.DTO;

import com.example.demo.mailing.models.EmailDetails;
import com.example.demo.mailing.service.EmailServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "email")
public class EmailController {

        @Autowired
        private EmailServise emailService;

        // Sending a simple Email
        @PostMapping("/sendMail")
        public String
        sendMail(@RequestBody EmailDetails details) {
            String status = emailService.sendSimpleMail(details);

            return status;
        }

        // Sending email with attachment
        @PostMapping("/sendMailWithAttachment")
        public String sendMailWithAttachment(
                @RequestBody EmailDetails details) {
            String status = emailService.sendMailWithAttachment(details);

            return status;
        }
    }

