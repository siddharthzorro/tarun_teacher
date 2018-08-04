package com.example.siddharth.tarun_teacher;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;

public class OverflowMenuButton extends AppCompatImageView {
        public OverflowMenuButton(Context context) {
            this(context, null);
        }

        public OverflowMenuButton(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public OverflowMenuButton(Context context, AttributeSet attrs, int defStyleAttr) {
            super(new ContextThemeWrapper(context, R.style.OverflowButtonTheme), attrs, R.attr.actionOverflowButtonStyle);

            setClickable(true);
            setFocusable(true);
            setVisibility(VISIBLE);
            setEnabled(true);
        }
    }