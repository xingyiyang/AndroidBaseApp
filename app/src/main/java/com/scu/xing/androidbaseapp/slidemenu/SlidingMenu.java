package com.scu.xing.androidbaseapp.slidemenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.scu.xing.androidbaseapp.R;

/**
 * Created by xing on 2017/8/26.
 */

public class SlidingMenu extends HorizontalScrollView{

    private LinearLayout mWapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;

    private int mScreenWidth;
    private int mMenuRightPadding = 50;  //单位是dp
    private boolean once;
    private int mMenuWidth;

    private boolean isOpen; //是否打开菜单，默认为菜单隐藏在左边


    public SlidingMenu(Context context) {
        this(context,null); //调用两个参数的构造方法
    }

    /**
     * 未使用自定义属性时，调用
     * @param context
     * @param attrs
     */
    public SlidingMenu(Context context, AttributeSet attrs) {

          this(context,attrs,0); //调用3个参数的构造方法
//        super(context, attrs);

//        WindowManager vm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics outmetrics = new DisplayMetrics();
//        vm.getDefaultDisplay().getMetrics(outmetrics);
//        mScreenWidth = outmetrics.widthPixels;
//
//        //把dp转为px
//        mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,
//                context.getResources().getDisplayMetrics());

    }

    /**
     * 当使用了自定义属性时，会调用此构造方法
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //获取我们定义的属性
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SlidingMenu,defStyleAttr,0);

        int n = a.getIndexCount();
        for(int i=0;i<n;i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.SlidingMenu_rightpadding:
                    mMenuRightPadding = a.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,
                            context.getResources().getDisplayMetrics()));
            }
        }

        a.recycle();
        WindowManager vm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outmetrics = new DisplayMetrics();
        vm.getDefaultDisplay().getMetrics(outmetrics);
        mScreenWidth = outmetrics.widthPixels;

        //把dp转为px
//        mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,
//                context.getResources().getDisplayMetrics());
    }

    /**
     * 设置子view的宽和高，设置自己的宽和高
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //once首先为false，这样if里面的语句只调用一次
        if(!once){
            mWapper = (LinearLayout)getChildAt(0);
            mMenu = (ViewGroup)mWapper.getChildAt(0);
            mContent = (ViewGroup)mWapper.getChildAt(1);

            mMenuWidth = mMenu.getLayoutParams().width = mScreenWidth-mMenuRightPadding;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }

    }


    /**
     * 通过设置偏移量，将menu隐藏
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed){
            this.scrollTo(mMenuWidth,0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_UP:
                //隐藏在左边的宽度
                int scrollX = getScrollX();

                if(scrollX >= mMenuWidth/2){
                    this.smoothScrollTo(mMenuWidth,0);
                    isOpen = false; //隐藏菜单
                }else{
                    this.smoothScrollTo(0,0);
                    isOpen = true; //显示菜单
                }
                return true;

        }
        return super.onTouchEvent(ev);
    }

    /**
     * 打开菜单
     */
    public void openMenu(){
        if(isOpen)return;
        this.smoothScrollTo(0,0);
        isOpen = true;
    }

    /**
     * 关闭菜单
     */
    public void closeMenu(){
        if(!isOpen)return;
        this.smoothScrollTo(mMenuWidth,0);
        isOpen = false;
    }

    /**
     * 切换菜单
     */
    public void toggle(){
        if(isOpen){
            closeMenu();
        }else{
            openMenu();
        }
    }
}
