package mb.livedatabase1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import mb.livedatabase1.view.DogListActivity;

public class MainActivity extends AppCompatActivity {
    //Atributos
    //...

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //Tela XMl (Identificar Via Nativo)
        setContentView(R.layout.activity_main);

        //Redirecionamento
        startActivity(new Intent(this, DogListActivity.class));
    }
}


//Observações / Dúvidas
//- Conferir o Contexto do Adapter (Estou Pegando do Adapter Mesmo e Não da Activity);
//- Como Indexar a Lista Por Idade. Como Indexar Com mais de 1 Parâmetro (Por Idade e Por Nome ...);
//- Model é int ou Integer sempre?
//- Esta Certo a Forma de Notificação da Lista? Onde eh o Correto "notifyDataSetChanged"


