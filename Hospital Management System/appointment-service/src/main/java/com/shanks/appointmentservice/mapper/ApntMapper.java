package com.shanks.appointmentservice.mapper;

import com.shanks.appointmentservice.dto.AppointmentInfoDto;
import com.shanks.appointmentservice.dto.AppointmentSlotDto;
import com.shanks.appointmentservice.entity.AppointmentInfo;
import com.shanks.appointmentservice.entity.AppointmentSlot;
import com.shanks.appointmentservice.repository.SlotRepository;
import com.shanks.appointmentservice.service.SlotServices;
import org.aspectj.weaver.patterns.ConcreteCflowPointcut;
import org.springframework.beans.factory.annotation.Autowired;

public class ApntMapper {

    public static AppointmentInfo mapToApnt(AppointmentInfoDto dto) {
        AppointmentInfo apnt = new AppointmentInfo();
        apnt.setPEmail(dto.getPEmail());
        apnt.setApproval(dto.getApproval());
        apnt.setDate(dto.getDate());
        apnt.setDepartment(dto.getDepartment());
        apnt.setEmergency(dto.getEmergency());
        apnt.setPatFname(dto.getPatFname());
        apnt.setPatLname(dto.getPatLname());
        apnt.setSlotId(dto.getSlotId());
        apnt.setPatientId(dto.getPatientId());
        apnt.setStatus(true);
        return apnt;
    }


    public static AppointmentInfoDto mapToDto(AppointmentInfo info) {
        AppointmentInfoDto apnt = new AppointmentInfoDto();
        apnt.setPEmail(info.getPEmail());
        apnt.setDate(info.getDate());
        apnt.setPatFname(info.getPatFname());
        apnt.setPatLname(info.getPatLname());
        apnt.setPatientId(info.getPatientId());
        apnt.setEmergency(info.getEmergency());
        return apnt;
    }
    public static AppointmentSlot mapToSlot(AppointmentSlotDto dto) {
        AppointmentSlot apnt = new AppointmentSlot();
        apnt.setDepartment(dto.getDepartment());
        apnt.setBranchCode(dto.getBranchCode());
        apnt.setSlotFrom(dto.getSlotFrom());
        apnt.setSlotTo(dto.getSlotTo());
        apnt.setIsAvaiable(dto.getIsAvaiable());
        apnt.setDate(dto.getDate());
        apnt.setDocId(dto.getDocId());
        apnt.setDocFname(dto.getDocFname());
        apnt.setDocLname(dto.getDocLname());


        return apnt;
    }
}
