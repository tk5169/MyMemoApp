package com.example.android.sample.mymemoapp;

import android.content.Context;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import java.nio.file.Path;

/**
 * Created by Admin on 2017/09/14.
 */

public class MemoEditText extends EditText {

    //ビットマスク
    //直線
    private  static  final int SOLID = 1;
    //破線
    private  static final int DASH = 2;
    //通常の太さ
    private  static final  int NORMAL = 4;
    //太線
    private  static  final int BOLD = 8;

    //このViewの横幅
    private  int mMeasuredWidth;
    //一行の高さ
    private  int mLineHeight;
    //画面上に表示可能な行数
    private  int mDisplayLineCount;


    private Path mPath;
    //どのように描画するか、を保持する
    private Paint mPaint;

    public  MemoEditText(Context context) {
        this(context, null);
    }

    public  MemoEditText(Context context, AttributesSet attrs) {
        super(context,attrs);
        init(context, attrs);
    }
}

    public  MemoEditText(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初期設定
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //Pathは、複数の直線や曲線などの情報をカプセル化する
        mPath = new Path();

        //Paintはどのように描画するかという情報を保持する
        mPaint　= new Paint();

        //Paint.Style.STROKEは塗りつぶしなしで、輪郭線を描画するスタイル
        mPaint.setStyle(Paint.Style.STROKE);

        //インスタンス生成時に、属性情報が渡されている場合
        //かつ、Android　Studioのプレビュー表示ではない場合
        if (attrs != null && !isInEditMode()) {
            //属性情報を取得
            int lineEffectBit;
            int lineColer;

            Resource resources = context.getResources();
            TypeArray typeArray = context.obtainStyledAttributes(
                    attrs, R.styleable.MemoEditText);
                    try {
                        //属性に設定された値を取得
                        lineEffectBit = typeArray.getInteger(
                                R.styleable.MemoEditText_lineEffect,SOLID););
                        lineColer = typeArray.getColor(
                                R.styleable.MemoEditText_lineColor, Color.GRAY););
                    } finally {
                        //必ずrecycle()を呼ぶ
                        typeArray.recycle();
                    }

                    //かけ線のエフェクトを設定
            if((lineEffectBit & DASH) == DASH) {
                //破線が設定されている場合
                DashPathEffect effect = new DashPathEffect(new float[]{
                        resources.getDimension(R.dimen.text_rule_interval_on),
                        resources.getDimension(R.dimen.text_rule_interval_off)},
                    Of);
                mPaint.setPathEffect(effect;)
            }

            float strokeWedth;
            if ((lineEffectBit & BOLD) == BOLD) {
                //太線が設定されている場合
                strokeWidth = resources.getDimension(
                        R.dimen.text_rule_width_normal);
            }
            mPaint.setStrokeWidth(strokeWidth);

            //色を指定//
            mPaint.setColor(lineColer);
        }
    }
