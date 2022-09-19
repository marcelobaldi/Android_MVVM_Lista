package mb.livedatabase1.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mb.livedatabase1.databinding.AdapterDogLinhaBinding;
import mb.livedatabase1.model.DogModel;
import mb.livedatabase1.view.DogActivity;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogHolder> {
    //Atributos
    private Context        context;                            //Contexto (Pego Aqui Do Adapter!)
    private List<DogModel> listaDogs = new ArrayList<>();      //Conteúdo da Lista


    //Lista - Conteúdo (Receber / Atualizar)
    public void atualizarLista(List<DogModel> listaDogsAtualizada){
        listaDogs.clear();                       //Limpar Lista
        listaDogs.addAll(listaDogsAtualizada);   //Setar Lista

        //Manipular Lista (Colocar *)
//        List<DogModel> novaLista = new ArrayList<>();
//        for (DogModel item : listaDogs) {
//            DogModel dog = new DogModel(item.getId(), item.getNome(), 0, item.getImagem());
//            novaLista.add(dog);
//        }
//        listaDogs.clear();
//        listaDogs.addAll(novaLista);

        notifyDataSetChanged();                  //Avisar Adapter ("Lista Pronta / Teve Alteração")
    }

    //Lista - Tamanho
    @Override public int getItemCount() { return listaDogs.size(); }

    //Linha - Configuração (Arquivo Xml)
    @NonNull @Override public DogAdapter.DogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflater
        LayoutInflater inflaterX = LayoutInflater.from(parent.getContext());

        //Arquivo XML
        AdapterDogLinhaBinding adptLinha = AdapterDogLinhaBinding.inflate(inflaterX, parent, false);

        //Contexto (Pego Aqui do Adapter, E Não Vindo do Activity)
        context = parent.getContext();

        //Classe Holder
        return new DogHolder(adptLinha);
    }

    //Linha - Configuração (Objetos)
    @Override public void onBindViewHolder(@NonNull DogAdapter.DogHolder holderX, int positionY) {
        //Objetos - Setar
        DogModel dog = listaDogs.get(positionY);
        holderX.bindingAdapterXml.dogAdptNomeXml.setText(dog.getNome());
        holderX.bindingAdapterXml.dogAdptIdadeXml.setText(String.valueOf(dog.getIdade()));
        holderX.bindingAdapterXml.dogAdptImagemXml.setImageResource(dog.getImagem());

        holderX.bindingAdapterXml.dogAdptImagemXml.getContext();

        //Objetos - Eventos
        holderX.bindingAdapterXml.dogAdptImagemXml.setOnClickListener(view -> {
            Toast.makeText(context, String.valueOf(listaDogs.get(positionY).getId()), Toast.LENGTH_SHORT).show();
            Intent intentX = new Intent(context, DogActivity.class);          //Ir Para Tela
            intentX.putExtra("chaveDog", listaDogs.get(positionY));      //do Item Escolhido
            context.startActivity(intentX);
        });
        holderX.bindingAdapterXml.dogAdptNomeXml.setOnClickListener(view -> {
            Toast.makeText(context, listaDogs.get(positionY).getNome(), Toast.LENGTH_SHORT).show();
        });

        //Linha - Eventos (ItemView)
        holderX.itemView.setOnClickListener(view -> {
            Intent intentX = new Intent(context, DogActivity.class);          //Ir Para Tela
            intentX.putExtra("chaveDog", listaDogs.get(positionY));     //do Item Escolhido
            context.startActivity(intentX);
        });

    }

    //Linha - Identificação (Arquivo Xml)
    public static class DogHolder extends RecyclerView.ViewHolder {
        //Atributos
        public AdapterDogLinhaBinding bindingAdapterXml;                //Arquivo Xml da Linha

        //Construtor
        public DogHolder(AdapterDogLinhaBinding bindingAdapter) {
            super(bindingAdapter.getRoot());
            this.bindingAdapterXml = bindingAdapter;
        }
    }
}



