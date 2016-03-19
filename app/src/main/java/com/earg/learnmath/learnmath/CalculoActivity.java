package com.earg.learnmath.learnmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class CalculoActivity extends AppCompatActivity {

    private final static String OPERACAO_SOMA = "+";
    private final static String OPERACAO_SUBTRACAO = "-";
    private final static String OPERACAO_MULTIPLICACAO = "*";
    private final static String OPERACAO_DIVISAO = "/";

    private Integer valor1;
    private Integer valor2;
    private String operacao;
    private String nomeOperacao;
    private Integer respostaCorreta;
    private Integer contadorTentativas;

    private EditText editTextValorCalculo;
    private Button buttonCalcular;
    private Button buttonProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        editTextValorCalculo = (EditText) findViewById(R.id.edit_text_valor_calculo);

        // Atribuindo OnClickListener ao botão de calcular.
        buttonCalcular = (Button) findViewById(R.id.button_calcular);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificaResposta();
            }
        });

        // Atribuindo OnClickListener ao botão de próximo.
        buttonProximo = (Button) findViewById(R.id.button_proximo);
        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novaConta();
                buttonCalcular.setVisibility(View.VISIBLE);
                buttonProximo.setVisibility(View.GONE);
            }
        });

        // Recuperando dados passados da activity anterior.
        Intent intent = getIntent();
        operacao = intent.getStringExtra("operacao");

        novaConta();
    }

    /**
     * Método que verifica se a resposta está certa ou errada.
     */
    private void verificaResposta() {

        if(!editTextValorCalculo.getText().toString().trim().equals("") && editTextValorCalculo.getText() != null) {

            Integer valorInformado = Integer.valueOf(editTextValorCalculo.getText().toString());

            if(valorInformado.equals(respostaCorreta)) {
                displayMensagem("Parabéns, você acertou!");
                buttonCalcular.setVisibility(View.GONE);
                buttonProximo.setVisibility(View.VISIBLE);
                editTextValorCalculo.setEnabled(false);
            } else {
                if(contadorTentativas > 1) {
                    contadorTentativas--;
                    displayMensagem("Você errou! Tente novamente.");
                    displayTentativas(contadorTentativas.toString());
                    editTextValorCalculo.setText("");
                } else {
                    novaConta();
                }
            }
        } else {
            displayMensagem("Digite um número!");
        }
    }

    /**
     * Método que gera novos valores para uma nova conta.
     */
    private void novaConta() {
        contadorTentativas = 3;
        displayTentativas(contadorTentativas.toString());
        gerarValores();
        displayOperacao();
        calcularResposta();
        displayMensagem("");
        editTextValorCalculo.setText("");
        editTextValorCalculo.setEnabled(true);
    }

    /**
     * Método que gera valores aleatórios para o cálculo.
     */
    private void gerarValores() {
        Random random = new Random();
        valor1 = random.nextInt(100);
        valor2 = random.nextInt(100);
    }

    /**
     * Método que calcula a resposta correta para fazer a comparação com a resposta informada pelo
     * usuário e a armazena em uma variável.
     */
    private void calcularResposta() {
        if(operacao.equals(OPERACAO_SOMA)) {
            respostaCorreta = valor1 + valor2;
        } else if(operacao.equals(OPERACAO_SUBTRACAO)) {
            respostaCorreta = valor1 - valor2;
        } else if(operacao.equals(OPERACAO_MULTIPLICACAO)) {
            respostaCorreta = valor1 * valor2;
        } else if(operacao.equals(OPERACAO_DIVISAO)) {
            respostaCorreta = valor1 / valor2;
        }
    }

    /**
     * Método que exibe a operação gerada na tela e seu respectivo nome.
     */
    private void displayOperacao() {

        TextView textViewValor1 = (TextView) findViewById(R.id.text_view_valor1);
        TextView textViewValor2 = (TextView) findViewById(R.id.text_view_valor2);
        TextView textViewNomeOperacao = (TextView) findViewById(R.id.text_view_nome_operacao);
        TextView textViewOperador = (TextView) findViewById(R.id.text_view_operador);

        if(operacao.equals(OPERACAO_SOMA)) {
            nomeOperacao = "Adição";
        } else if(operacao.equals(OPERACAO_SUBTRACAO)) {
            nomeOperacao = "Subtração";
        } else if(operacao.equals(OPERACAO_MULTIPLICACAO)) {
            nomeOperacao = "Multiplicação";
        } else if(operacao.equals(OPERACAO_DIVISAO)) {
            nomeOperacao = "Divisão";
        }

        textViewValor1.setText(valor1.toString());
        textViewValor2.setText(valor2.toString());
        textViewNomeOperacao.setText(nomeOperacao);
        textViewOperador.setText(operacao);
    }

    /**
     * Método que exibe a quantidade de tentativas.
     */
    private void displayTentativas(String tentativasRestantes) {
        TextView textViewMsg = (TextView) findViewById(R.id.text_view_tentativas);
        textViewMsg.setText(tentativasRestantes);
    }

    /**
     * Método que exibe uma mensagem na tela.
     */
    private void displayMensagem(String mensagem) {
        TextView textViewMsg = (TextView) findViewById(R.id.text_view_msg);
        textViewMsg.setText(mensagem);
    }
}
