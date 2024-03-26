package com.example.julietonlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private EditText edUserName, edEmail, edPassword, edComfirmPassword;
    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUserName = findViewById(R.id.editTextRegisterUserName);
        edEmail = findViewById(R.id.editTextRegisterEmail);
        edPassword = findViewById(R.id.editTextRegisterPassword);
        edComfirmPassword = findViewById(R.id.editTextRegisterPassword2);
        btn = findViewById(R.id.ButtonRegister);
        tv = findViewById(R.id.textviewRegisteringUser);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edUserName.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String ConfirmPassword = edComfirmPassword.getText().toString();


                Database db = new Database(getApplicationContext(), "healthCare", null, 1);
                if (username.length() == 0 || email.length() == 0 || edPassword.length() == 0 || edComfirmPassword.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "Fill the blank space", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(ConfirmPassword)) {

                        db.register(username, email, password);

                        Toast.makeText(RegisterActivity.this, "Account Created succesfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Your password and confirmation password differ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}


