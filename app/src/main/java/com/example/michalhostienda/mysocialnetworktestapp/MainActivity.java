package com.example.michalhostienda.mysocialnetworktestapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.michalhostienda.mysocialnetworktestapp.fragments.FBLoginButtonFragment;

public class MainActivity extends MyBaseActivity implements View.OnClickListener {

    private static final String FRAGMENT_TAG = "fb_login_button_fragment";
    private Button buttonFbLogin;
    private boolean fbButtonActivated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fbButtonActivated = false;
        this.buttonFbLogin = (Button) findViewById(R.id.bFBLogin);
        this.buttonFbLogin.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showOrHideFbLoginButton() {
        FragmentManager fm = this.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FBLoginButtonFragment fbLoginButtonFragment = (FBLoginButtonFragment) fm.findFragmentByTag(FRAGMENT_TAG);

        if (this.fbButtonActivated) {
            if (fbLoginButtonFragment != null) {
                ft.remove(fbLoginButtonFragment);
                ft.addToBackStack(null);
                ft.commit();
                this.fbButtonActivated = false;
            }
        } else {
            if (fbLoginButtonFragment == null) {
                fbLoginButtonFragment = new FBLoginButtonFragment();
            }
            ft.replace(R.id.flFragmentFbLoginButton, fbLoginButtonFragment, FRAGMENT_TAG);
            ft.addToBackStack(null);
            ft.commit();
            this.fbButtonActivated = true;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bFBLogin:
                showOrHideFbLoginButton();
                break;
            default:
                Log.e("ERROR", "Incorrect value in switch!");
        }
    }
}
