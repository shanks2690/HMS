package org.hms.receptionistmicroservice.service;

import org.hms.receptionistmicroservice.dto.RecCredDto;
import org.hms.receptionistmicroservice.entity.ReceptionistInfo;

public interface ReceptionServices {
    ReceptionistInfo myInfo(String email);
Boolean addNewRec(RecCredDto recCredDto);
    ReceptionistInfo updateInfo(ReceptionistInfo recInfo, String userName);

    String delRec(String email);
}
