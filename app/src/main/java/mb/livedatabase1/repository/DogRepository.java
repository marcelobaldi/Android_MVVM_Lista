package mb.livedatabase1.repository;
import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;
import mb.livedatabase1.R;
import mb.livedatabase1.api.DogApi;
import mb.livedatabase1.model.DogModel;

public class DogRepository implements DogApi {
    //Atributos
    public static DogRepository instance;

    //Instancia
    public static DogRepository getInstance(){
        if(instance == null){ instance = new DogRepository(); }
        return instance;
    }

    //LiveData
    @Override public MutableLiveData<DogModel> findById(int id) {
        DogModel dogModel                     = new DogModel(id, "Merge", 35,  R.drawable.marge);
        MutableLiveData<DogModel> dogModel_LD = new MutableLiveData<>();

        new Handler().postDelayed(new Runnable() { @Override public void run() {
            dogModel_LD.postValue(dogModel);
        }}, 4000);

        return dogModel_LD;
    }

    @Override public MutableLiveData<List<DogModel>> findAll() {
        List<DogModel> listaDogs                     = new ArrayList<>();
        MutableLiveData<List<DogModel>> listaDogs_LD = new MutableLiveData<>();

        new Handler().postDelayed(new Runnable() { @Override public void run() {
            listaDogs.add(new DogModel(1, "Pitbull", 2, R.drawable.pitbull));
            listaDogs.add(new DogModel(2, "Golden", 5,  R.drawable.golden));
            listaDogs.add(new DogModel(2, "Pinscher", 1,  R.drawable.pinscher));
            listaDogs.add(new DogModel(2, "Shitzu", 4,  R.drawable.shitzu));

            listaDogs_LD.postValue(listaDogs);
        }}, 4000);

        return listaDogs_LD;
    }
}

