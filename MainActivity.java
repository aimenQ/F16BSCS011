package com.example.myapplication3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button SignIn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean saveSignIn;
    CheckBox savecheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        SignIn=(Button) findViewById(R.id.button1);
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);
        savecheckbox=(CheckBox)findViewById(R.id.checkBox);
        editor=sharedPreferences.edit();


        SignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SignIn();

            }
        });
        saveSignIn=sharedPreferences.getBoolean("save login ",true);
        if(saveSignIn==true)
            email.setText(sharedPreferences.getString("username",null));
        password.setText(sharedPreferences.getString("password",null));
    }
    public void clickexit( View v )
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public  void SignIn()
    {
        String emailAddress = email.getText().toString();
        String passwordUser = password.getText().toString();
        if (emailAddress.equals("Aimen Qayyum") && passwordUser.equals("curious")) {
        }
        Toast.makeText(this, "username and password matched!", Toast.LENGTH_LONG).show();
        if (SignIn.callOnClick()) {
            Toast.makeText(this, "you are logged in ", Toast.LENGTH_LONG).show();
        }
        if (savecheckbox.isChecked()) {
            editor.putBoolean("saveSignin", true);
            editor.putString("username", emailAddress);
            editor.putString("password", passwordUser);

            editor.commit();
        } else
            {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }

    }
}

