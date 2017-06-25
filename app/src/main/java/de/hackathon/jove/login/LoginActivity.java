package de.hackathon.jove.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import de.hackathon.jove.R;
import de.hackathon.jove.rest.Callback;
import de.hackathon.jove.rest.HttpContext;
import de.hackathon.jove.rest.tasks.LoginTask;
import de.hackathon.jove.rest.tasks.models.Login;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.password);
                new LoginTask(username.getText().toString(), password.getText().toString()).exectute(new HttpContext(), new Callback<Login>() {
                    @Override
                    public void onSuccess(Login result) {
                        String token = result.getToken();
                        Toast.makeText(LoginActivity.this, "Logged in " + token, Toast.LENGTH_LONG).show();
                        LoginActivity.this.finish();
                    }

                    @Override
                    public void onFailed(String error) {
                        Toast.makeText(LoginActivity.this, "Failed to login", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
