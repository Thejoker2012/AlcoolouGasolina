package br.com.unisys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.unisys.domain.Combustivel;
import br.com.unisys.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity {

    private Double valorAlcool;
    private Double valorGasolina;
    private EditText Alcool;
    private EditText Gasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Alcool = findViewById(R.id.EtanoEdt);
        Gasolina = findViewById(R.id.GasolinaEdt);

        Button calcular = (Button) findViewById(R.id.CalcularBtn);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valorAlcool = Double.parseDouble(Alcool.getText().toString());
                valorGasolina = Double.parseDouble(Gasolina.getText().toString());

                //valorAlcool = Double.parseDouble(findViewById(R.id.EtanoEdt).toString());
                //valorGasolina = Double.parseDouble(findViewById(R.id.GasolinaEdt).toString());

                if(valorAlcool <= valorGasolina * 0.7){
                    Toast.makeText(MainActivity.this, "Alcool é melhor", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Gasolina é melhor", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
