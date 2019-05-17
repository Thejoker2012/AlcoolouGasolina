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
    //private TextView textResultado;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);

        editPrecoAlcool = (EditText) findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = (EditText) findViewById(R.id.editPrecoGasolina);
        //textResultado = (TextView) findViewById(R.id.textResultado);

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
            //textResultado.setText("Preencha os preços primeiro!");
            Toast.makeText(this, "Preencha os preços primeiro!", Toast.LENGTH_LONG).show();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("VALORALCOOL",precoAlcool);
        editor.putString("VALORGASOLINA",precoGasolina);

        editor.commit();
    }
    public void calcularMelhorPreco(String pAlcool, String pGasolina){

        //Converter valores string para numeros
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        Double resultado = precoAlcool / precoGasolina;
        if(resultado>=0.7){
            //textResultado.setText("Melhor utilizar Gasolina!");
            Toast.makeText(this, "Melhor utilizar Gasolina!", Toast.LENGTH_LONG).show();
        }else{
            //textResultado.setText("Melhor utilizar Álcool!");
            Toast.makeText(this, "Melhor utilizar Álcool!", Toast.LENGTH_LONG).show();
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
