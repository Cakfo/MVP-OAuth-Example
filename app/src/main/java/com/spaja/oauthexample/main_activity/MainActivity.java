package com.spaja.oauthexample.main_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spaja.oauthexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View {

    @BindView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//      Button button = (Button) findViewById(R.id.button);

        Presenter examplePresenter = new Presenter(new EggsRepositoryImpl(), this);
        examplePresenter.getEggs();

    }

    @Override
    public void displayEggsMessage(String response) {
        TextView textView = (TextView) findViewById(R.id.text);
        if (response != null) {
            textView.setText(response);
        }
    }
}
