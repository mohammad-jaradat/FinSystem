package com.qu.finsys.payloads.reports;

public class UsersReportUnit {

    String FIRSTNAME;
    String LASTNAME;
    String EMAIL;
    String MOBILENUMBER;


    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getMOBILENUMBER() {
        return MOBILENUMBER;
    }

    public void setMOBILENUMBER(String MOBILENUMBER) {
        this.MOBILENUMBER = MOBILENUMBER;
    }
}
