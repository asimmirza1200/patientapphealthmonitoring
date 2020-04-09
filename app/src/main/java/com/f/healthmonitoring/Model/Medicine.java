
package com.f.healthmonitoring.Model;

public class Medicine {


    private String Medicinename, PrescriptedBy;


    public Medicine(String medicinename,String prescriptedBy) {
        this.Medicinename = medicinename;
        this.PrescriptedBy = prescriptedBy;


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