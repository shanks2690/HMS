package org.hms.billing.feigncalls;

import org.hms.billing.dto.MedicineQtyDto;
import org.hms.billing.dto.PharmaMedicineDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "PHARMACIST")
public interface PharmaFeign {

    // Get MedicineId, Medicine Qty & Price based on name
    // Get all Medicine by comma separated string
    @PostMapping("/pharma/searchmedicinebynamecollection")
    public List<PharmaMedicineDto> getMedicineByNameCollection(String nameCollection);

    // update medicine quantity in Pharmacy Medicine Table
    @PutMapping("/pharma/updatemedqty")
    public Boolean updateMedQty(@RequestBody List<MedicineQtyDto> medicineQty);

}
