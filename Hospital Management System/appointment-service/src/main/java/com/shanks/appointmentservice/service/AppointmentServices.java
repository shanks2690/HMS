package com.shanks.appointmentservice.service;




import com.shanks.appointmentservice.entity.AppointmentInfo;

import java.util.List;

public interface AppointmentServices {
    List<AppointmentInfo>  getAllAppointments(int docId);
    AppointmentInfo updateAppointmentStatus(AppointmentInfo appointmentInfo);

    AppointmentInfo addAppointment(AppointmentInfo appointmentInfo);

    String delAppointment(int apntId);

    void setCompleted( int apntId);



}
