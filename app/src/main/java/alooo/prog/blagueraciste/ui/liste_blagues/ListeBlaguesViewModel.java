package alooo.prog.blagueraciste.ui.liste_blagues;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListeBlaguesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ListeBlaguesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}