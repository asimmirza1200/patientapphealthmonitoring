
package com.f.healthmonitoring.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllDoctor {

    @SerializedName("response")
    @Expose
    private List<Doctor> response = null;

    public List<Doctor> getResponse() {
        return response;
    }

    public void setResponse(List<Doctor> response) {
        this.response = response;
    }

}
