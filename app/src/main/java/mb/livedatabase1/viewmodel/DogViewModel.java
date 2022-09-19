package mb.livedatabase1.viewmodel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

import mb.livedatabase1.business.DogBusiness;
import mb.livedatabase1.model.DogModel;

public class DogViewModel extends ViewModel {
    //Atributos
    private final  MutableLiveData<String>         titulo_LD    = new MutableLiveData<>();
    private final  MutableLiveData<DogModel>       dogModel_LD  = new MutableLiveData<>();
    private final  MutableLiveData<List<DogModel>> listaDogs_LD = new MutableLiveData<>();

    //LiveData - GetterSetter
    public void setTitulo()                    { titulo_LD.postValue("Tela Dog"); }
    public MutableLiveData<String> getTitulo() { return titulo_LD;                }

    public void setDog(int idV, LifecycleOwner lo){
        DogBusiness dogBusiness = new DogBusiness();
        dogBusiness.dog(idV, lo).observe(lo, new Observer<DogModel>() {
        @Override public void onChanged(DogModel dogModelV) {
            dogModel_LD.postValue(dogModelV);
        }});
    }
    public MutableLiveData<DogModel> getDog() { return dogModel_LD; }

    public void loadListaDogs(LifecycleOwner lo){
        DogBusiness    dogBusiness = new DogBusiness();
        List<DogModel> listaDogs   = new ArrayList<>();

        dogBusiness.listaDogs(lo).observe(lo, new Observer<List<DogModel>>() {
        @Override public void onChanged(List<DogModel> dogModelsV) {
            listaDogs.addAll(dogModelsV);
            listaDogs_LD.postValue(listaDogs);
        }});
    }
    public MutableLiveData<List<DogModel>> getListaDogs() { return listaDogs_LD; }
}

