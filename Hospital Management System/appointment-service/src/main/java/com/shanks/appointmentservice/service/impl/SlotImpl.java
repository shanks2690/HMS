package com.shanks.appointmentservice.service.impl;


import com.shanks.appointmentservice.entity.AppointmentSlot;
import com.shanks.appointmentservice.exception.ErrorSavingRecordException;
import com.shanks.appointmentservice.exception.NoRecordsFound;
import com.shanks.appointmentservice.repository.SlotRepository;
import com.shanks.appointmentservice.service.SlotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotImpl implements SlotServices {
@Autowired
SlotRepository slotRepo;


    @Override
    public AppointmentSlot addSlot(AppointmentSlot slot) {
        try{
            return slotRepo.save(slot);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AppointmentSlot> viewSlots(int docId) {
        try {
            List<AppointmentSlot> slotList = slotRepo.findByDocId(docId);
            if (!slotList.isEmpty()) {
                return slotList.stream().filter(x-> x.getIsAvaiable()==true).toList();
            }
                else throw new RuntimeException();
        } catch (Exception e) {
            throw new NoRecordsFound("No Slots available for Doc Id :"+ docId);
        }

    }
    @Override
    public String deleteSlot(Long slotId) {
        try{
            slotRepo.deleteById(slotId);
        return "Slot Deleted";
        }
        catch (Exception e) {
            throw new NoRecordsFound("No such record exists!");
        }
    }

    @Override
    public AppointmentSlot updateSlot(Long slotId, Boolean available) {
        try{
            AppointmentSlot slot= slotRepo.findById(slotId).orElseThrow();
            slot.setIsAvaiable(available);
            return  slotRepo.save(slot);
        }
        catch (Exception e) {
            throw new ErrorSavingRecordException("Error updating the record!");
        }
    }

}
