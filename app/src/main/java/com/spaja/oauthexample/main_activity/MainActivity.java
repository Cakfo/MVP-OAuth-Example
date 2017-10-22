package com.spaja.oauthexample.main_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.spaja.oauthexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View {

    @BindView (R.id.text) TextView textView;
    @BindView (R.id.button) Button button;
    private Presenter examplePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        examplePresenter = new Presenter(new EggsRepositoryImpl(), this);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                examplePresenter.getEggs();
            }
        });
    }


    @Override
    public void displayEggsMessage(String response) {
        TextView textView = (TextView) findViewById(R.id.text);
        if (response != null) {
            textView.setText(response);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        examplePresenter.clearResources();
    }
}
