package com.shanks.appointmentservice.service;



import com.shanks.appointmentservice.entity.AppointmentSlot;

import java.util.List;

public interface SlotServices {

     AppointmentSlot addSlot(AppointmentSlot slot);
     List<AppointmentSlot> viewSlots(int docId);
    String deleteSlot(Long slotId);
    AppointmentSlot updateSlot(Long slotId, Boolean available);


}
