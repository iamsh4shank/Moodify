
package com.fruitsalad.crimsonlychee.ui.camera;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class CameraViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CameraViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}

