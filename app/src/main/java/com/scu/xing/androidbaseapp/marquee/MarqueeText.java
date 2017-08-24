package com.scu.xing.androidbaseapp.marquee;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by xing on 2017/8/24.
 * 多行跑马灯效果
 */

public class MarqueeText extends android.support.v7.widget.AppCompatTextView{

    public MarqueeText(Context context) {
        super(context);
    }

    public MarqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
