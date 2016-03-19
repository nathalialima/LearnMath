package com.earg.learnmath.learnmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayInfo(getString(R.string.info_jogo));

        // Atribuindo OnClickListener ao botão de somar.
        Button buttonOperacaoSoma = (Button) findViewById(R.id.button_operacao_soma);
        buttonOperacaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculoActivity.class);
                intent.putExtra("operacao", "+");
                startActivity(intent);
            }
        });

        // Atribuindo OnClickListener ao botão de subtrair.
        Button buttonOperacaoSubtracao = (Button) findViewById(R.id.button_operacao_subtracao);
        buttonOperacaoSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculoActivity.class);
                intent.putExtra("operacao", "-");
                startActivity(intent);
            }
        });

        // Atribuindo OnClickListener ao botão de multiplicar.
        Button buttonOperacaoMultiplicacao = (Button) findViewById(R.id.button_operacao_multiplicacao);
        buttonOperacaoMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculoActivity.class);
                intent.putExtra("operacao", "*");
                startActivity(intent);
            }
        });

        // Atribuindo OnClickListener ao botão de dividir.
        Button buttonOperacaoDivisao = (Button) findViewById(R.id.button_operacao_divisao);
        buttonOperacaoDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculoActivity.class);
                intent.putExtra("operacao", "/");
                startActivity(intent);
            }
        });
    }

    /**
     * Método que mostra a informação de como jogar na tela.
     * @param info
     */
    private void displayInfo(String info) {
        TextView textViewInfo = (TextView) findViewById(R.id.text_view_info);
        textViewInfo.setText(info);
    }
}
