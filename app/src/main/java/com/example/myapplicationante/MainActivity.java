package com.example.myapplicationante;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textemail;
    TextView teksthaslo;
    Button button;
    TextView wyswietl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textemail = findViewById(R.id.textemail);
        teksthaslo = findViewById(R.id.teksthaslo);
        button = findViewById(R.id.button);
        wyswietl = findViewById(R.id.wyswietl);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog();
            }
        });
        wyswietl.setText("Witaj! Aplikacja wykonana przez: Kacper Maciaszek");

    }
    private void showEditDialog(){
        final EditText editText1 = new EditText(this);
        editText1.setText(teksthaslo.getText());

        new AlertDialog.Builder(this)
                .setTitle("Zmień haslo")
                .setMessage("Podaj nowe haslo")
                .setView(editText1)
                .setPositiveButton("zapisz", (dialog, which) -> {
                    teksthaslo.setText(editText1.getText().toString());
                })
                .setNegativeButton("Anuluj", null)
                .show();

        final EditText editText = new EditText(this);
        editText.setText(textemail.getText());

        new AlertDialog.Builder(this)
                .setTitle("Zmień Email")
                .setMessage("Podaj nowy email:")
                .setView(editText)
                .setPositiveButton("zapisz",(dialog, which) -> {
                    textemail.setText(editText.getText().toString());
                })
                .setNegativeButton("Anuluj", null)
                .show();
    }
}