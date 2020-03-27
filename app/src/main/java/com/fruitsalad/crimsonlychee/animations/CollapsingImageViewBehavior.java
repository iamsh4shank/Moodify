package com.fruitsalad.crimsonlychee.animations;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.AppBarLayout;

public class CollapsingImageViewBehavior extends com.fruitsalad.crimsonlychee.animations.ViewOffsetBehavior<ImageView> {

    private WindowInsetsCompat lastInsets;


    public CollapsingImageViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull ImageView child, @NonNull View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull ImageView child, @NonNull View dependency) {
        //keep child centered inside dependency respecting android:fitsSystemWindows="true"
        int systemWindowInsetTop = 0;
        if (lastInsets != null) {
            systemWindowInsetTop = lastInsets.getSystemWindowInsetTop();
        }

        int bottom = dependency.getBottom();
        float center = (bottom - systemWindowInsetTop) / 2F;
        float halfChild = child.getHeight() / 2F;
        setTopAndBottomOffset((int) (center + systemWindowInsetTop - halfChild));

        if (dependency instanceof AppBarLayout) {

            float totalScrollRange = ((AppBarLayout) dependency).getTotalScrollRange();

            float newTop = -dependency.getTop() /1.2F;
            float scale = (totalScrollRange - newTop) / totalScrollRange;
            child.setScaleX(scale);
            child.setScaleY(scale);

            float percentExpanded = (totalScrollRange - (-dependency.getTop())) / totalScrollRange;
            float alpha = 1 - percentExpanded;
            child.setAlpha(alpha);
        }
        return true;
    }


    @NonNull
    @Override
    public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView child, @NonNull WindowInsetsCompat insets) {
        lastInsets = insets;
        return super.onApplyWindowInsets(coordinatorLayout, child, insets);
    }
}
