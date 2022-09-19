package mb.livedatabase1.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mb.livedatabase1.R;
import mb.livedatabase1.adapter.DogAdapter;
import mb.livedatabase1.databinding.ActivityDogListBinding;
import mb.livedatabase1.model.DogModel;
import mb.livedatabase1.viewmodel.DogViewModel;

public class DogListActivity extends AppCompatActivity {
    //Atributos
    private ActivityDogListBinding binding;
    private DogAdapter dogAdapter  = new DogAdapter();
    private List<DogModel> listaDogs   = new ArrayList<>();
    private DogViewModel dogViewModel;

    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //Tela Xml (View Binding e Data Binding) e view model
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dog_list);
        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);

        //Lista - Layout (Vertical/Horizontal/Grid)
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //Lista - Montatem
        binding.dogListRecycleXml.setLayoutManager(lm);
        binding.dogListRecycleXml.setAdapter(dogAdapter);

        //Carregamento Inicial  (Setter's e Load's)
        dogViewModel.setTitulo();
        dogViewModel.loadListaDogs(this);

        //Listener's            (Getter's)
        observer();
    }

    //Listener's
    public void observer(){
//        dogViewModel.getTitulo().observe(this, new Observer<String>() {
//            @Override public void onChanged(String sX) {
//                binding.dogTxtTitulo.setText(sX);
//            }});
//
//        dogViewModel.getDog().observe(this, new Observer<DogModel>() {
//            @Override public void onChanged(DogModel dogModelX) {
//                binding.dogTxtNumerodigitado.setText(String.valueOf(dogModelX.getId()));
//                Log.d("myLog", dogModelX.toString());
//            }});

        dogViewModel.getListaDogs().observe(this, new Observer<List<DogModel>>() {
        @Override public void onChanged(List<DogModel> dogModelsV) {
            Log.d("myLog", dogModelsV.toString());
            dogAdapter.atualizarLista(dogModelsV);
        }});
    }

    //Eventos
//    public void dog_btn_pegardados(View view){
//        String idS = binding.dogEdtNumeroid.getText().toString();
//        int    id  = Integer.parseInt(idS);
//        dogViewModel.setDog(id, this);
//    }
//    public void dog_btn_lista(View view){ dogViewModel.loadListaDogs(this); }


    //Método - Conteúdo Lista
    private void listaCarregar(){
        //Lista - Conteúdo
        listaDogs.add(new DogModel(1, "Shitzu",    3,  R.drawable.shitzu));
        listaDogs.add(new DogModel(2, "Vira Lata", 2,  R.drawable.viralata));
        listaDogs.add(new DogModel(3, "PitBull",   11, R.drawable.pitbull));
        listaDogs.add(new DogModel(4, "Husky",     9,  R.drawable.husky));

        //Lista - Adapter
        dogAdapter.atualizarLista(listaDogs);

        //Lista - Debugar
        Log.d("myLog Lista", listaDogs.toString());
        Log.d("myLog onCreate", String.valueOf(listaDogs.size()));
    }

}


