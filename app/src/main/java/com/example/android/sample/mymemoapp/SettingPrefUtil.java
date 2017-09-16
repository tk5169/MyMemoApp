package com.example.android.sample.mymemoapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Admin on 2017/09/17.
 */

public class SettingPrefUtil {

    //保存ファイル名
    public  static  final  String PREF_FILE_NAME = "settings";

    //ファイル名プレフィックスのKEY
    private  static  final String KEY_FILE_NAME_PREFIX = "file.name.prefix";
    //未設定時のデフォルト値
    private static  final String KEY_FILE_NAME_PREFIX_DEFAULT = "memo";

    //ファイル名プレフィックスの値を取得する
    public  static  String getPrefFileNamePrefix(Context context) {
        //SharedPreferencesを取得
        SharedPreferences sp = context.getSharedPreferences(
                PREF_FILE_NAME, Context.MODE_PRIVATE);

        //SharedPreferencesから設定値を取得する
        return sp.getString(KEY_FILE_NAME_PREFIX,KEY_FILE_NAME_PREFIX_DEFAULT);

    }

    private  static  final String KEY_TEXT_SIZE = "text.siza";
    public  static  final  String TEXT_SIZE_LARGE = "text.size.large";
    //以下省略　P１７１の下から１７２、１７３

}
