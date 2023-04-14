package com.mktechit28.mktextview;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatTextView;
public class MKTextView extends AppCompatTextView {
    private static final int DEFAULT_TEXT_SIZE_SP = 15;

    public MKTextView(Context context) {
        super(context);
        init(null);
    }

    public MKTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MKTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    private void init(AttributeSet attrs) {
        float textSize;
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MKTextView);
            textSize = typedArray.getDimension(R.styleable.MKTextView_mkTextSize, DEFAULT_TEXT_SIZE_SP);
            textSize = textSize > 0 ? (int) (textSize / getResources().getDisplayMetrics().scaledDensity) : DEFAULT_TEXT_SIZE_SP;

            typedArray.recycle();
        } else {
            textSize = DEFAULT_TEXT_SIZE_SP;
        }

        setMkTextSize(textSize);
    }

    private void setMkTextSize(float textSize) {
        int desiredTextSize = (int) textSize;

        float scale = getResources().getDisplayMetrics().density;
        int fixedTextSizePixels = (int) (desiredTextSize * scale + 0.5f);
        setTextSize(TypedValue.COMPLEX_UNIT_PX, fixedTextSizePixels);

    }
}
