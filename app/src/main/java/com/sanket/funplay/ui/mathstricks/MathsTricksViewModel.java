package com.sanket.funplay.ui.mathstricks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MathsTricksViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MathsTricksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}