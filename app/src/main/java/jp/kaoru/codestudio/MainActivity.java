package jp.kaoru.codestudio;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static String TAG = "MainActivity";

    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);

        final String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        final String[] keywords = {"class","super","public","praivate","protected","void","extends","implements","var","function"};
        final String[] annotations = {"@Deprecated","@Override","@SuppressWarnings","@SafeVarargs","@FunctionalInterface","@Retention","@Documented","@Target","@Inherited","@Repeatable"};

        edittext = findViewById(R.id.editText);
        edittext.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                for(int i=0; i<numbers.length; i++) {
                    for (int j = 0; j < MainActivity.this.containcounter(s.toString(), numbers[i]); j++) {
                        if (j == MainActivity.this.containcounter(s.toString(), numbers[i])-1) {
                            s.setSpan(new ForegroundColorSpan(Color.parseColor("#000080")), s.toString().indexOf(numbers[i], j), s.toString().lastIndexOf(numbers[i]) + numbers[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } else {
                            s.setSpan(new ForegroundColorSpan(Color.parseColor("#000080")), s.toString().indexOf(numbers[i], j), s.toString().indexOf(numbers[i], j) + numbers[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                    }
                }
                for(int i=0; i<keywords.length; i++) {
                    for (int j = 0; j < MainActivity.this.containcounter(s.toString(), keywords[i]); j++) {
                        if (j == MainActivity.this.containcounter(s.toString(), keywords[i])-1) {
                            s.setSpan(new ForegroundColorSpan(Color.parseColor("#000080")), s.toString().indexOf(keywords[i], j), s.toString().lastIndexOf(keywords[i]) + keywords[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } else {
                            s.setSpan(new ForegroundColorSpan(Color.parseColor("#000080")), s.toString().indexOf(keywords[i], j), s.toString().indexOf(keywords[i], j) + keywords[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                    }
                }

                for(int i=0; i<annotations.length; i++) {
                    for (int j = 0; j < MainActivity.this.containcounter(s.toString(), annotations[i]); j++) {
                        if (j == MainActivity.this.containcounter(s.toString(), annotations[i])-1) {
                            s.setSpan(new ForegroundColorSpan(Color.parseColor("#808000")), s.toString().indexOf(annotations[i], j), s.toString().lastIndexOf(annotations[i]) + annotations[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } else {
                            s.setSpan(new ForegroundColorSpan(Color.parseColor("#808000")), s.toString().indexOf(annotations[i], j), s.toString().indexOf(annotations[i], j) + annotations[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                    }
                }

                for (int j = 0; j < MainActivity.this.containcounter(s.toString(), "\""); j++) {
                    if (j == MainActivity.this.containcounter(s.toString(), "\"")-1) {
                        s.setSpan(new ForegroundColorSpan(Color.parseColor("#008000")), s.toString().indexOf("\"", j), s.toString().lastIndexOf("\"") + "\"".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } else {
                        s.setSpan(new ForegroundColorSpan(Color.parseColor("#008000")), s.toString().indexOf("\"", j), s.toString().indexOf("\"", j) + "\"".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public int containcounter(String str, String target) {
        return str.split(target + "").length - 1;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG + "/onClick", edittext.getSelectionStart() + ":" + edittext.getSelectionEnd());
        switch (view.getId()) {
            case R.id.button:
                edittext.append("{", 0, 1);
                break;
            case R.id.button1:
                edittext.append("}", 0, 1);
                break;
            case R.id.button2:
                edittext.append("(", 0, 1);
                break;
            case R.id.button3:
                edittext.append(")", 0, 1);
                break;
            case R.id.button4:
                edittext.append(";", 0, 1);
                break;
            case R.id.button5:
                edittext.append("\"", 0, 1);
                break;
            case R.id.button6:
                edittext.append("\'", 0, 1);
                break;
            case R.id.button7:
                edittext.append("=", 0, 1);
                break;
        }
    }
}
