package com.ming.abner.circlegame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


/**
 * 游戏页面
 */

public class AbnerGameCircleActivity extends Activity {
    public static AbnerGameCircleActivity mAbnerGameCircleActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_circle);
        mAbnerGameCircleActivity = this;
    }
    /**用于维持状态的mAbnerGameCircleActivity，需要维持状态的Activity

     * 游戏结束后回调此
     */
    public void showAchievement(int achievement) {
        saveAchievement(achievement);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);/**栈顶单实例(当该activity处于task栈顶时，可以复用，直接onNewIntent)*/
        startActivity(intent);

    }/**打开MainActivity*/

    private void saveAchievement(int achievement) {
        SharedPreferences sp = getSharedPreferences("Preferences", 0);
        sp.edit().putInt("Achievement1", achievement).commit();
        int top = sp.getInt("Achievement2", 0);
        if (achievement > top) {
            sp.edit().putInt("Achievement2", achievement).commit();
        }
    }
}
