package com.example1.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputAlcool, inputGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputAlcool = findViewById(R.id.inputAlcool);
        inputGasolina = findViewById(R.id.inputGasolina);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void calcularPreco(View view) {

        // Recuperar valores digitados
        String precoAlcool = inputAlcool.getText().toString();
        String precoGasolina = inputGasolina.getText().toString();

        // Validar os campos digitados
        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados) {
            // Convertendo string para double
            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);

            // Cálculo do melhor combustível
            double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7) {
                txtResultado.setText("Melhor utilizar Gasolina");
            } else {
                txtResultado.setText("Melhor utilizar Álcool");
            }
        }
    }

    // Método validar campos = campos vazios.
    public boolean validarCampos(String pAlcool, String pGasolina) {
        boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}