
package com.f.healthmonitoring.Model;

public class Patient {


    private String Patientname;
    private String Fathername;
    private String Address;
    private String Phonenumber;

    private String Disease;

    public Patient(String patientname, String fathername) {
        this.Patientname=patientname;
        this.Fathername=fathername;
//        this.Address=address;
//        this.Phonenumber=phonenumber;
//        this.Disease=disease;

    }


    public String getPatientname() {
        return Patientname;
    }

    public void setPatientname(String patientname) {
        Patientname = patientname;
    }

    public String getFathername() {
        return Fathername;
    }

    public void setFathername(String fathername) {
        Fathername = fathername;
    }

//    public String getAddress() {
//        return Address;
//    }
//
//    public void setAddress(String address) {
//        Address = address;
//    }
//
//    public String getPhonenumber() {
//        return Phonenumber;
//    }
//
//    public void setPhonenumber(String phonenumber) {
//        Phonenumber = phonenumber;
//    }
//
//
//
//    public String getDisease() {
//        return Disease;
//    }
//
//    public void setDisease(String disease) {
//        Disease = disease;
//    }


}
