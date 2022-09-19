package mb.livedatabase1.api;
import androidx.lifecycle.LiveData;
import java.util.List;

import mb.livedatabase1.model.DogModel;

public interface DogApi {
    LiveData<DogModel>       findById (int id);
    LiveData<List<DogModel>> findAll ();
}

