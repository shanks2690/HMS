package com.shanks.appointmentservice.service.impl;

import com.shanks.appointmentservice.entity.AppointmentInfo;
import com.shanks.appointmentservice.entity.AppointmentSlot;
import com.shanks.appointmentservice.entity.SimpleMail;
import com.shanks.appointmentservice.exception.ErrorSavingRecordException;
import com.shanks.appointmentservice.exception.NoRecordsFound;
import com.shanks.appointmentservice.feign.EmailFeign;
import com.shanks.appointmentservice.repository.Appointment;
import com.shanks.appointmentservice.repository.SlotRepository;
import com.shanks.appointmentservice.service.AppointmentServices;
import com.shanks.appointmentservice.service.SlotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointmentImpl implements AppointmentServices {
    @Autowired
    Appointment apnt;
    @Autowired
    SlotServices slotServices;

    @Autowired
    SlotRepository slotRepo;

    @Override
    public List<AppointmentInfo> getAllAppointments(int docId) {
        try {
            List<AppointmentInfo> appList = apnt.findByDocId(docId);
            if (!appList.isEmpty())
                return appList.stream().filter(x-> x.getStatus()==true).toList();
            else throw new RuntimeException();
        } catch (Exception e) {
            throw new NoRecordsFound("No records found!");
        }
    }

    @Override
    public AppointmentInfo updateAppointmentStatus(AppointmentInfo appointmentInfo) {
        try {
                AppointmentInfo info =  apnt.save(appointmentInfo);
                slotServices.deleteSlot(appointmentInfo.getSlotId());
                return info;
        } catch (Exception e) {
            throw new ErrorSavingRecordException("Error saving record!");
        }
    }

    @Override
    public AppointmentInfo addAppointment(AppointmentInfo appointmentInfo) {
        try{
            AppointmentSlot slot = new AppointmentSlot();
            slot = slotRepo.findById(appointmentInfo.getSlotId()).orElseThrow();
            appointmentInfo.setDocLname(slot.getDocLname());
            appointmentInfo.setDepartment(slot.getDepartment());
            appointmentInfo.setBranchCode(slot.getBranchCode());
            appointmentInfo.setDocFname(slot.getDocFname());
            appointmentInfo.setDocId(slot.getDocId());
            appointmentInfo.setDate(slot.getDate());
            return apnt.save(appointmentInfo);
        } catch (Exception e) {
            throw new ErrorSavingRecordException("Error saving record!");
        }

    }

    @Override
    public String delAppointment(int apntId) {
        try {
            apnt.deleteById(apntId);
        } catch (Exception e) {
            throw new NoRecordsFound("No such record exists!");
        }
    return  "Appointment Deleted ";
    }

    @Override
    public void setCompleted(int apntId) {
        try {
            AppointmentInfo appointmentInfo = apnt.findById(apntId).orElseThrow();
            appointmentInfo.setStatus(false);
            apnt.save(appointmentInfo);
        } catch (Exception e) {
            throw new NoRecordsFound("No such record exists!");
        }
    }


}
