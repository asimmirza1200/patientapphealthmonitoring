
package com.f.healthmonitoring.Model;

public class Doctor {


    private String Doctorname;
    private String Specialization;
    private String Phonenumber;

    public Doctor(String doctorname, String specialization, String phonenumber) {
        this.Doctorname = doctorname;
        this.Specialization = specialization;
        this.Phonenumber = phonenumber;


    }

    public String getDoctorname() {
        return Doctorname;
    }

    public void setDoctorname(String doctorname) {
        Doctorname = doctorname;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }
}