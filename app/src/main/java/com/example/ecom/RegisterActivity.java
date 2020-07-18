package com.example.ecom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText fullName;
    private Button register;
    private TextView loginuser;
    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        fullName = findViewById(R.id.full_name);
        loginuser = findViewById(R.id.login_user);
        register = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();
        mRootRef = FirebaseDatabase.getInstance().getReference();
        pd = new ProgressDialog(this);

        loginuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtUserName = username.getText().toString();
                String txtFullName = fullName.getText().toString();
                String txtEmail = email.getText().toString();
                String txtPassword = password.getText().toString();

                if(TextUtils.isEmpty(txtUserName) || TextUtils.isEmpty(txtEmail)
                   || TextUtils.isEmpty(txtFullName) || TextUtils.isEmpty(txtPassword) ) {
                    Toast.makeText(RegisterActivity.this,"Empty Credentials",Toast.LENGTH_SHORT).show();
                } else if( txtPassword.length() < 6) {
                    Toast.makeText(RegisterActivity.this,"Password length should be greater than 6 charaters",Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txtUserName , txtFullName , txtEmail ,txtPassword );
                }
            }
        });
    }

    private void registerUser(final String UserName,final String FullName,final String Email, String Password) {
        pd.setMessage("Please Wait");
        pd.show();
        mAuth.createUserWithEmailAndPassword(Email , Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                HashMap<String , Object> map = new HashMap<>();
                map.put("FullName",FullName);
                map.put("Email",Email);
                map.put("UserName",UserName);
                map.put("id", mAuth.getCurrentUser().getUid());

                mRootRef.child("Users").child(mAuth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            pd.dismiss();
                            Toast.makeText(RegisterActivity.this,"Update the profile for better experience",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,com.example.ecom.startup.MainActivity.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                            finish();
                        }
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(RegisterActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
