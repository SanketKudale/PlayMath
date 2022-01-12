package com.sanket.funplay.ui.puzzle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PuzzleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PuzzleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}