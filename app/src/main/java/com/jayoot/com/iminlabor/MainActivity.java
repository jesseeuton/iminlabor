package com.jayoot.com.iminlabor;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthUtil;


public class MainActivity extends Activity implements View.OnClickListener {
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        //login to Google +
        AccountManager manager = AccountManager.get(this);
        Account[] accounts = manager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);

        String[] names = new String[accounts.length];
        for (int i=0; i < names.length; i++) {
            names[i] = accounts[i].name;
        }

        Toast.makeText(getApplicationContext(), names.length + " accounts!", Toast.LENGTH_LONG).show();
    }
}
