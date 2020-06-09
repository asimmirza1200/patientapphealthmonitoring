
package com.f.healthmonitoring.Model;

public class Medicine {


    private String Medicinename, PrescriptedBy,Symptoms,Disease;


    public String getSymptoms() {
        return Symptoms;
    }

    public void setSymptoms(String symptoms) {
        Symptoms = symptoms;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public Medicine(String medicinename, String prescriptedBy, String symptoms, String disease) {
        this.Medicinename = medicinename;
        this.PrescriptedBy = prescriptedBy;
        this.Symptoms = symptoms;
        this.Disease = disease;


    }

    public String getMedicinename() {
        return Medicinename;
    }

    public void setMedicinename(String medicinename) {
        Medicinename = medicinename;
    }

    public String getPrescriptedBy() {
        return PrescriptedBy;
    }

    public void setPrescriptedBy(String prescriptedBy) {
        PrescriptedBy = prescriptedBy;
    }
}