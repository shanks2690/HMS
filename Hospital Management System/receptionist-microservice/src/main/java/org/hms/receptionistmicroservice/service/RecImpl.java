package org.hms.receptionistmicroservice.service;

import org.hms.receptionistmicroservice.dto.RecCredDto;
import org.hms.receptionistmicroservice.entity.ReceptionistInfo;
import org.hms.receptionistmicroservice.exception.ErrorSavingUserException;
import org.hms.receptionistmicroservice.exception.NoRecordsFound;
import org.hms.receptionistmicroservice.repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecImpl implements  ReceptionServices{
   @Autowired
    ReceptionistRepository recRepo;

    @Override
    public ReceptionistInfo myInfo(String email) {
        try{
            return recRepo.findByEmail(email).orElseThrow();
        } catch (Exception e) {
            throw new NoRecordsFound("No such record ");
        }

    }

    @Override
    public ReceptionistInfo updateInfo(ReceptionistInfo recInfo, String userName) {
        try{
            ReceptionistInfo uRec = recRepo.findByEmail(userName).orElseThrow();
            uRec.setBranchCode(recInfo.getBranchCode()==null?uRec.getBranchCode():recInfo.getBranchCode());
            return    recRepo.save(uRec);
        } catch (Exception e) {
            throw new ErrorSavingUserException("Error Updating");
        }
    }

    @Override
    public String delRec(String email) {
        try {
            recRepo.deleteById(recRepo.findByEmail(email).get().getReceptionistId());
            return "Receptionist data deleted";
        } catch (Exception e) {
            throw new NoRecordsFound("Error deleting record!");
        }
    }

    @Override
    public Boolean addNewRec(RecCredDto recCredDto) {
        try{
            ReceptionistInfo recInfo = new ReceptionistInfo();
            recInfo.setEmail(recCredDto.getEmail());
            recInfo.setFirstName(recCredDto.getFirstname());
            recInfo.setLastName(recCredDto.getLastname());
            recRepo.save(recInfo);
            return true;

        } catch (Exception e) {
            throw new ErrorSavingUserException("Error adding record!");
        }
    }
}
