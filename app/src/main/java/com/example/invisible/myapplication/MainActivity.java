package com.example.invisible.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MenuCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView1;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    Button button1;
    Button button6;
    Button button7;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView1 = (TextView) findViewById(R.id.textView1);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        button1 = (Button) findViewById(R.id.button1);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        imageView1 = (ImageView) findViewById(R.id.imageView1);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        if (checkBox1.isChecked())
                            textView1.setText("что-то пошло не так");
                        else
                            textView1.setText("все спокойно, все отлично");
                        break;
                    case R.id.button6:
                        if (checkBox2.isChecked())
                            textView1.setText("YOU PASSED O_O ");
                        else
                            textView1.setText("You shall NOT pass!111");
                        break;
                    case R.id.button7:
                        if (checkBox3.isChecked())
                            textView1.setText("Оп. ");
                        else
                            button7.setText("какого хуя эта кнопка центрует текст?");
                        break;
                }
            }
        };

        button1.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    imageView1.setImageDrawable(getResources().getDrawable(R.drawable.happy));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
}
