package com.merchpandas.abhishek.bakingapp.ui.stepdetail;

import android.os.Bundle;

import com.merchpandas.abhishek.bakingapp.R;
import com.merchpandas.abhishek.bakingapp.data.local.model.Step;
import com.merchpandas.abhishek.bakingapp.utils.ActivityUtils;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import timber.log.Timber;

public class StepDetailActivity extends AppCompatActivity {

    public static final String EXTRA_STEP_LIST = "EXTRA_STEP_LIST";
    public static final String EXTRA_POSITION = "EXTRA_POSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_detail);
        Timber.d("onCreate");

        ArrayList<Step> steps = getIntent().getParcelableArrayListExtra(EXTRA_STEP_LIST);
        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);

        StepDetailViewModel mViewModel = obtainViewModel(this);
        if (savedInstanceState == null) {
            mViewModel.init(steps, position);
        }

        setupToolbar();
        mViewModel.getNavigateToStepDetail().observe(this, new Observer<Step>() {
            @Override
            public void onChanged(Step step) {
                Timber.d("navigateToStepDetail");
                StepDetailFragment fragment = StepDetailFragment.newInstance(step);
                ActivityUtils.replaceFragmentInActivity(
                        getSupportFragmentManager(), fragment, R.id.fragment_step_detail);
            }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle("Step Detail");
        }
    }

    public static StepDetailViewModel obtainViewModel(FragmentActivity activity) {
        return ViewModelProviders.of(activity).get(StepDetailViewModel.class);
    }
}
