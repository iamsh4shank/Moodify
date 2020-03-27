package com.fruitsalad.crimsonlychee.animations ;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.appbar.AppBarLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class SimpleCollapsingCircleImageViewBehavior extends CoordinatorLayout.Behavior<CircleImageView> {


    public SimpleCollapsingCircleImageViewBehavior() {
        super();
        Log.i("BEHAVIOUR", "CUSTOM BEHAVIOUR");
    }

    public SimpleCollapsingCircleImageViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull CircleImageView child, @NonNull View dependency) {
        return dependency instanceof CircleImageView;
    }

    /* TODO
     * Fix the user profile picture at top*/
    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull CircleImageView child, @NonNull View dependency) {

        Log.i("BEHAVIOUR", dependency.toString());

            float totalScrollRange = ((CircleImageView) dependency).getBorderWidth();

            float newTop = -dependency.getTop() /1.2F;
            float scale = (totalScrollRange - newTop) / totalScrollRange;
            child.setScaleX(scale);
            child.setScaleY(scale);

            float percentExpanded = (totalScrollRange - (-dependency.getTop())) / totalScrollRange;
            float alpha = 1 - percentExpanded;
            child.setAlpha(alpha);

        return true;
    }
}
