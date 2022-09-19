package mb.livedatabase1.business;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.List;
import mb.livedatabase1.R;
import mb.livedatabase1.model.DogModel;
import mb.livedatabase1.repository.DogRepository;

public class DogBusiness {
    //Atributos
    //...

    //LiveData
    public MutableLiveData<DogModel> dog (int id, LifecycleOwner lo){
        MutableLiveData<DogModel> dogModel_LD   = new MutableLiveData<>();

        DogRepository.getInstance().findById(id).observe(lo, new Observer<DogModel>() {
        @Override public void onChanged(DogModel dogModelV) {
            dogModel_LD.postValue(dogModelV);
        }});

        return dogModel_LD;
    }

   public MutableLiveData<List<DogModel>> listaDogs(LifecycleOwner lo){
        List<DogModel>                  listaDogs     = new ArrayList<>();
        MutableLiveData<List<DogModel>> listaDogs_LD  = new MutableLiveData<>();

        DogRepository.getInstance().findAll().observe(lo, new Observer<List<DogModel>>() {
        @Override public void onChanged(List<DogModel> dogModelsV) {
            listaDogs.addAll(dogModelsV);
            listaDogs.add(new DogModel(2, "S Bernardo", 2, R.drawable.saobernardo));
            listaDogs_LD.postValue(listaDogs);
        }});

        return listaDogs_LD;
   }
}




