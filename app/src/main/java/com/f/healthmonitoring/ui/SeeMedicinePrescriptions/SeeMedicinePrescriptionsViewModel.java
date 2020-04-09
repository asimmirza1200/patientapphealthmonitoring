package com.f.healthmonitoring.ui.SeeMedicinePrescriptions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeeMedicinePrescriptionsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SeeMedicinePrescriptionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}