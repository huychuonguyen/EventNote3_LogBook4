package com.example.eventnote3_logbook_4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eventnote3_logbook_4.fragment.AddUpdateEventDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }



    private void initView() {

        AddUpdateEventDialogFragment addUpdateFragment = AddUpdateEventDialogFragment.newInstance(AddUpdateEventDialogFragment.EventType.Add);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameContainer, addUpdateFragment, AddUpdateEventDialogFragment.TAG)
                .commit();
    }

}