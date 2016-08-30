package com.bignerdranch.android.sunset;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sam on 16/8/30.
 */
public class SunsetFragment extends Fragment {

    private View mSceneView;
    private View mSkyView;
    private View mSunView;

    public static SunsetFragment newInstance() {
        return new SunsetFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sunset, container, false);

        mSceneView = v;
        mSkyView = v.findViewById(R.id.sky);
        mSunView = v.findViewById(R.id.sun);

        mSceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        return v;
    }

    private void startAnimation() {
        float sunYStart = mSunView.getTop();
        float sunYEnd = mSkyView.getHeight();

        ObjectAnimator heightAnimator = ObjectAnimator
                .ofFloat(mSunView, "y", sunYStart, sunYEnd)
                .setDuration(3000);

        heightAnimator.start();
    }
}
