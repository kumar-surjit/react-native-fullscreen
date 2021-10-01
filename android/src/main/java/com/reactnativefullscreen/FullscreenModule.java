package com.reactnativefullscreen;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.UiThreadUtil;

@ReactModule(name = FullscreenModule.NAME)
public class FullscreenModule extends ReactContextBaseJavaModule {
    public static final String NAME = "Fullscreen";

    public FullscreenModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "FullScreenModule";
    }

    @ReactMethod
    public void enableFullScreen() {
      Log.d("FullScreenModule", "FullScreen mode enabled ");
      UiThreadUtil.runOnUiThread(
        new Runnable() {
          @Override
          public void run() {
            View decorView = getReactApplicationContext().getCurrentActivity().
              getWindow().getDecorView();
            decorView.setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN);
          }
        }
      );
    }

    @ReactMethod
    public void disableFullScreen(){
        UiThreadUtil.runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        View decorView = getReactApplicationContext().getCurrentActivity().getWindow().getDecorView();
                        decorView.setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                    }
                }
        );
    }
}
