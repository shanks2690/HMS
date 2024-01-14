package org.hms.room.entity.enums;

public enum BranchCode {
    H1  ("Delhi"),
    H2("Mumbai"),
    H3("Bangalore"),
    H4("Lucknow"),
    H5("Dehradun");
    String branchName;
    BranchCode(String branchName) {
        this.branchName=branchName;
    }

    /*@Override
    public String toString() {
        return branchName;
    }*/
}
