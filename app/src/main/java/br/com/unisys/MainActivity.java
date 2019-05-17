package br.com.unisys;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.unisys.domain.Combustivel;
import br.com.unisys.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = (EditText) findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = (EditText) findViewById(R.id.editPrecoGasolina);
        textResultado = (TextView) findViewById(R.id.textResultado);

    }
    public void calcularPreco(View view){

        //recuperar valores digitados
       String precoAlcool = editPrecoAlcool.getText().toString();
       String precoGasolina = editPrecoGasolina.getText().toString();

       //Validar os campos digitados
        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
            this.calcularMelhorPreco(precoAlcool,precoGasolina);
        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }

    }
    public void calcularMelhorPreco(String pAlcool, String pGasolina){
        //Converter valores string para numeros
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        Double resultado = precoAlcool / precoGasolina;
        if(resultado>=0.7){
            textResultado.setText("Melhor utilizar Gasolina!");
        }else{
            textResultado.setText("Melhor utilizar Álcool!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;
        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }
        else if(pGasolina ==null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}
