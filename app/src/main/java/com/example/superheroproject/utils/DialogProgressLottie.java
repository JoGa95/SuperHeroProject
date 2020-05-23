package com.example.superheroproject.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.superheroproject.R;

public class DialogProgressLottie {
    public Dialog dialog;
    private Activity activityDialog;

    public DialogProgressLottie(Activity activityDialog) {
        this.activityDialog = activityDialog;
    }
    public void showDialogProgress(){
        dialog = new Dialog(activityDialog, R.style.AppBaseTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_cargando);
        LottieAnimationView lavLoader = dialog.findViewById(R.id.lavLoader);;

        lavLoader.setAnimation(R.raw.loader);
        lavLoader.setRepeatCount(LottieDrawable.INFINITE);
        lavLoader.setRepeatMode(LottieDrawable.REVERSE);
        lavLoader.playAnimation();

        dialog.show();
    }

    public  void CloseDialog(){
        if (this.dialog != null) {
            this.dialog.dismiss();
            this.dialog = null;
        }
    }

}
