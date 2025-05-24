package com.alex.skypatrol;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button reportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reportButton = findViewById(R.id.button);

        reportButton.setOnClickListener(v -> showRescueDialog());
    }

    private void showRescueDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.provide_details_dialog, null);

        EditText inputField = dialogView.findViewById(R.id.input_field);
        Button sendButton = dialogView.findViewById(R.id.send_button);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(true)
                .create();

        sendButton.setOnClickListener(view -> {
            String inputText = inputField.getText().toString().trim();
//            sendRescueReport(inputText, dialog);
            Toast.makeText(this, "Zgłoszenie wysłane", Toast.LENGTH_LONG).show();

        });

        dialog.show();
    }


//    private void sendRescueReport(String message, AlertDialog dialog) {
//        new Thread(() -> {
//            try {
//                OkHttpClient client = new okhttp3.OkHttpClient();
//
//                RequestBody requestBody = new okhttp3.FormBody.Builder()
//                        .add("message", message)
//                        .build();
//
//                Request request = new okhttp3.Request.Builder()
//                        .url("http://localhost:8080/report")
//                        .post(requestBody)
//                        .build();
//
//                Response response = client.newCall(request).execute();
//
//                runOnUiThread(() -> {
//                    if (response.isSuccessful()) {
//                        Toast.makeText(this, "Zgłoszenie wysłane", Toast.LENGTH_LONG).show();
//                        dialog.dismiss();
//                    } else {
//                        Toast.makeText(this, "Błąd wysyłania: " + response.code(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                runOnUiThread(() ->
//                        Toast.makeText(this, "Wystąpił błąd: " + e.getMessage(), Toast.LENGTH_SHORT).show()
//                );
//            }
//        }).start();
//    }

}