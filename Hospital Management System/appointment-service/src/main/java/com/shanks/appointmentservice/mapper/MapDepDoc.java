package com.shanks.appointmentservice.mapper;


import com.shanks.appointmentservice.dto.DocDepDto;
import com.shanks.appointmentservice.entity.enums.BranchCode;
import com.shanks.appointmentservice.entity.enums.Department;

import java.util.*;

public class MapDepDoc {

    public static Map<BranchCode,Map<Department, List<DocDepDto>>> depMapDoc(List<DocDepDto> docs) {
        Map<BranchCode,Map<Department, List<DocDepDto>>> bigMap = new HashMap<>();
        Set<BranchCode> bSet = new HashSet<>();
        docs.forEach(x->bSet.add(x.getBranchCode()));
        System.out.println(docs);
        List<DocDepDto> temp;
        for(BranchCode bCode:bSet)
        {
        Set<Department> depSet = new HashSet<>();
        docs.stream().filter(x->x.getBranchCode().name().equalsIgnoreCase(bCode.name())).forEach(x -> depSet.add(x.getDepartment()));

        Map<Department, List<DocDepDto>> depMap = new HashMap<>();
        for (Department dep : depSet) {
            temp = docs.stream().filter(x -> x.getDepartment().name().equalsIgnoreCase(dep.name())).toList();
            depMap.put(dep, temp);
        }
        bigMap.put(bCode,depMap);
        }
        return bigMap;
    }
}
