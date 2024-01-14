package com.shanks.appointmentservice.service;


import com.shanks.appointmentservice.entity.SimpleMail;
import com.shanks.appointmentservice.feign.EmailFeign;
import org.shanks.MailBoxObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailRequestService {
    @Autowired
    EmailFeign emailFeign;

    public void sendMail(MailBoxObject message) {
        SimpleMail simpleMail = SimpleMail.builder().body("Hi "+ message .pname+ ".Your appointment with Dr.."+ message.dname +" has been confirmed for tommorow 1000-1030 AM")
                                                        .sub("Appointment Confirmation")
                                                        .to("shashankk.mtoc@gmail.com")
                                                                .from("shashankk.smail@gmail.com").build();
emailFeign.sendMail(simpleMail);
    }
}
