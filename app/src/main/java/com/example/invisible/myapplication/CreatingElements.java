package com.example.invisible.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Invisible on 16.07.2016.
 */
public class CreatingElements extends AppCompatActivity implements View.OnClickListener  {

    private static int elemsId = 0;
    LinearLayout llmyscreen;
    TextView textView3;
    RadioGroup rbGroup;
    EditText editText1;
    Button button_add;
    Button button_clear;
    SeekBar sbWeight;

    LinearLayout.LayoutParams lParams_btnAdd;
    LinearLayout.LayoutParams lParams_btnClr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);

        rbGroup = (RadioGroup) findViewById(R.id.rbGravity);
        textView3 = (TextView) findViewById(R.id.textView3);
        editText1 = (EditText) findViewById(R.id.editText1);
        button_add = (Button) findViewById(R.id.button_add);
        button_clear = (Button) findViewById(R.id.button_clear);
        llmyscreen = (LinearLayout) findViewById(R.id.llmyscreen);
        sbWeight = (SeekBar) findViewById(R.id.seekBar);

        lParams_btnAdd = (LinearLayout.LayoutParams) button_add.getLayoutParams();
        lParams_btnClr = (LinearLayout.LayoutParams) button_add.getLayoutParams();

        button_add.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        sbWeight.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int wLeft = seekBar.getMax() - progress;

                lParams_btnAdd.weight = wLeft;
                lParams_btnClr.weight = progress;

                button_add.setText(String.valueOf(progress));
                button_clear.setText(String.valueOf(wLeft));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                button_add.setText("Добавить");
                button_clear.setText("Очистить");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                int buttonGravity = Gravity.LEFT;

                switch (rbGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton1:
                        buttonGravity = Gravity.LEFT;
                        break;
                    case R.id.radioButton2:
                        buttonGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.radioButton3:
                        buttonGravity = Gravity.RIGHT;
                        break;
                }
                lParams.gravity = buttonGravity;
                Button newButton = new Button(this);
                newButton.setText(editText1.getText().toString());
                newButton.setId(elemsId);
                llmyscreen.addView(newButton,lParams);
                newButton = (Button) findViewById(elemsId);
                assert newButton != null;
                newButton.setOnClickListener(this);
                elemsId++;

                break;

            case R.id.button_clear:
                llmyscreen.removeAllViews();
                Toast.makeText(CreatingElements.this, "Deleted", Toast.LENGTH_SHORT).show();
                elemsId = 0;
                break;
            default:
                Toast.makeText(CreatingElements.this, String.valueOf(v.getId()), Toast.LENGTH_SHORT).show();
                llmyscreen.removeView(v);
                break;
        }

    }

}
