package me.shenfan.neteasewelcome.sample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.flyco.systembar.SystemBarHelper;

import me.shenfan.neteasewelcome.sample.R;

/**
 * Created by Sun on 2016/6/20.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        SystemBarHelper.immersiveStatusBar(this);
    }
}
