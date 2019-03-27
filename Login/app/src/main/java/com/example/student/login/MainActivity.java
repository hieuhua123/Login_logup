package com.example.student.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    Button btn_signin , btn_signup;
    EditText edt_account , edt_pass;

    FirebaseAuth mAuthencation ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuthencation = FirebaseAuth.getInstance();
        Anhxa();

     btn_signup.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             DangKy();
         }
     });

     btn_signin.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             DangNhap();
         }
     });
    }
    private void DangNhap()
    {
        String email = edt_account.getText().toString();
        String password = edt_pass.getText().toString();

        mAuthencation.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Sign In Succsess",Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(MainActivity.this, "Sign In failed",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }

    private void DangKy()
    {

        String email = edt_account.getText().toString();
        String password = edt_pass.getText().toString();

        mAuthencation.createUserWithEmailAndPassword(email,password )
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Sign up sucsess",Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(MainActivity.this, "Sign up falied", Toast.LENGTH_SHORT).show();

                        }


                    }
                });

    }
    private void Anhxa ()
    {
        btn_signin = (Button)findViewById(R.id.btn_signin);
        btn_signup = (Button)findViewById(R.id.btn_signup);
        edt_account = (EditText)findViewById(R.id.edt_account);
        edt_pass = (EditText)findViewById(R.id.edt_pass);
    }
}
