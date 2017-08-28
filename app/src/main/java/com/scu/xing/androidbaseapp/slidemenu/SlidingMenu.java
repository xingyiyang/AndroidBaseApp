package com.scu.xing.androidbaseapp.slidemenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ViewDragHelper;
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
 * horizontalscrollview添加了横向的滚动条
 * 相当于把屏幕放大了两倍
 * Created by xing on 2017/8/26.
 */

public class SlidingMenu extends HorizontalScrollView{

    private LinearLayout mWapper;  //horizontalscrollview里面的一个linealayout布局
    private ViewGroup mMenu;       //linearlayout左边的viewgroup，作为菜单
    private ViewGroup mContent;    //linearlayout右边的viregroup，作为正文

    private int mScreenWidth;            //屏幕的宽度，在构造方法中可以获取
    private int mMenuRightPadding = 50;  //菜单和屏幕右边的距离，默认为50dp
    private int mMenuWidth; //菜单的宽度，随着左右滑动正文动态变化

    private boolean once;   //不给值就默认为false
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

          //获取屏幕的宽度
//        WindowManager vm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics outmetrics = new DisplayMetrics();
//        vm.getDefaultDisplay().getMetrics(outmetrics); //outmetrics获取了屏幕的宽度、高度
//        mScreenWidth = outmetrics.widthPixels;
//
//        //把50dp转为50px
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
                    mMenuRightPadding = a.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,
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

        //once首先为false，这样if里面的语句只调用一次，避免多次调用浪费资源
        if(!once){
            //HorizontalScrollView里面的第一个child，在cehuamenu布局中，为linearlayout
            mWapper = (LinearLayout)getChildAt(0);
            //linearlayout的第一个child，在左边，左边是菜单
            mMenu = (ViewGroup)mWapper.getChildAt(0);
            //linearlayout的第二个child，在右边，右边是正文
            mContent = (ViewGroup)mWapper.getChildAt(1);

            //菜单的宽度为屏幕的宽度减去菜单距离最右边的填充
            mMenuWidth = mMenu.getLayoutParams().width = mScreenWidth-mMenuRightPadding;
            //正文的宽度就是屏幕的宽度
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }

    }

    /**
     * 通过设置偏移量，将menu隐藏在屏幕左边
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //滚动屏幕，改变菜单在屏幕中的位置，scrollto设置的是偏移量
        //mMenuEidth是正数，往左边移动
        //我要移动view到坐标点（100，100），那么我的偏移量就是(0,0)-（100，100）= (-100 ，-100），我就要执行view.scrollTo(-100,-100),达到这个效果。
        if(changed){
            this.scrollTo(mMenuWidth,0);
        }
    }

    /**
     * 获取用户对屏幕的动作，是按下、抬起还是移动
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_UP:
                //隐藏在左边的宽度
                int scrollX = getScrollX();

                //如果菜单显示没有一半就隐藏，显示超过一半了就完全显示
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

    /**
     * 滚动发生时会触发
     * @param l
     * @param t
     * @param oldl
     * @param oldt
     */
//    @Override
//    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
//
//        super.onScrollChanged(l, t, oldl, oldt);
//        float scale = 1*1.0f/mMenuWidth;  //1~0
//        //调用属性动画，设置translatx,设置抽屉式侧滑菜单
//        mMenu.setTranslationX(l);
//    }
}
