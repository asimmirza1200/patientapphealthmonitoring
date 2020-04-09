package com.f.healthmonitoring.ui.SeeAllDoctor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeeAllDoctorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SeeAllDoctorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Doctor fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}