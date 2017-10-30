package com.brand.homestation.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.brand.homestation.R;
import com.brand.homestation.activity.MainActivity;
import com.brand.homestation.models.InstagramApp;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.HashMap;

public class RegisterationActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputLayout inputLayout1,inputLayout2,inputLayout3,inputLayout4;
    EditText name,email,pass,phone;
    TextView accept,instaLogin;
    Button register;

    public static final String CLIENT_ID = "e78baff2f02f4ea1aeda06816512af38";
    public static final String CLIENT_SECRET = "321be35b77304d7181683574b0c9cc50";
    public static final String CALLBACK_URL = "instagram://connect";


    private InstagramApp mApp;
    private Button btnConnect, btnViewInfo, btnGetAllImages;
    private LinearLayout llAfterLoginView;
    private HashMap<String, String> userInfoHashmap = new HashMap<String, String>();
    private Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
//            if (msg.what == InstagramApp.WHAT_FINALIZE) {
                userInfoHashmap = mApp.getUserInfo();
//            } else if (msg.what == InstagramApp.WHAT_FINALIZE) {
//                Toast.makeText(RegisterationActivity.this, "Check your network.",
//                        Toast.LENGTH_SHORT).show();
//            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        inputLayout1=(TextInputLayout) findViewById(R.id.textInput1);
        inputLayout2=(TextInputLayout) findViewById(R.id.textInput2);
        inputLayout3=(TextInputLayout) findViewById(R.id.textInput3);
        inputLayout4=(TextInputLayout) findViewById(R.id.textInput4);
        name=(EditText) findViewById(R.id.et_name);
        email=(EditText) findViewById(R.id.et_email);
        pass=(EditText) findViewById(R.id.et_password);
        phone=(EditText) findViewById(R.id.et_phone);
        accept=(TextView) findViewById(R.id.accept);
        instaLogin=(TextView) findViewById(R.id.instaLogin);
        register=(Button) findViewById(R.id.register);
        setUpFonts();


        //----------------------------------------


        instaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RegisterationActivity.this, MainActivity.class));

//                mApp = new InstagramApp(RegisterationActivity.this, CLIENT_ID,
//                        CLIENT_SECRET, CALLBACK_URL);
//                mApp.setListener(new InstagramApp.OAuthAuthenticationListener() {
//
//                    @Override
//                    public void onSuccess() {
//// tvSummary.setText("Connected as " + mApp.getUserName());
//                        Log.e("dis","dis");
//                        //btnConnect.setText("Disconnect");
//                        //llAfterLoginView.setVisibility(View.VISIBLE);
//// userInfoHashmap = mApp.
//                        mApp.fetchUserName(handler);
//                    }
//
//                    @Override
//                    public void onFail(String error) {
//                        Toast.makeText(RegisterationActivity.this, ".....0"+error, Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                bindEventHandlers();
//
//                if (mApp.hasAccessToken()) {
//// tvSummary.setText("Connected as " + mApp.getUserName());
//                    btnConnect.setText("Disconnect");
//                    llAfterLoginView.setVisibility(View.VISIBLE);
//                    mApp.fetchUserName(handler);
//
//                }

//                Log.e("name",""+userInfoHashmap.get(InstagramApp.TAG_USERNAME));
            }
        });
    }

    private void bindEventHandlers() {
        instaLogin.setOnClickListener(this);
    }



// OAuthAuthenticationListener listener ;

    @Override
    public void onClick(View v) {

        if (v == btnViewInfo) {

        }
    }

    private void connectOrDisconnectUser() {
        if (mApp.hasAccessToken()) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(
                    RegisterationActivity.this);
            builder.setMessage("Disconnect from Instagram?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    mApp.resetAccessToken();
// btnConnect.setVisibility(View.VISIBLE);
                                    llAfterLoginView.setVisibility(View.GONE);
                                    btnConnect.setText("Connect");
// tvSummary.setText("Not connected");
                                }
                            })
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    dialog.cancel();
                                }
                            });
            final AlertDialog alert = builder.create();
            alert.show();
        } else {
            mApp.authorize();
        }
    }

    private void displayInfoDialogView() {

//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
//                RegisterationActivity.this);
//        alertDialog.setTitle("Profile Info");
//
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.profile_view, null);
//        alertDialog.setView(view);
//        ImageView ivProfile = (ImageView) view
//                .findViewById(R.id.ivProfileImage);
//        TextView tvName = (TextView) view.findViewById(R.id.tvUserName);
//        TextView tvNoOfFollwers = (TextView) view
//                .findViewById(R.id.tvNoOfFollowers);
//        TextView tvNoOfFollowing = (TextView) view
//                .findViewById(R.id.tvNoOfFollowing);

//
//        new ImageLoader(MainActivity.this).DisplayImage(
//                userInfoHashmap.get(InstagramApp.TAG_PROFILE_PICTURE),
//                ivProfile);

//        tvNoOfFollowing.setText(userInfoHashmap.get(InstagramApp.TAG_FOLLOWS));
//        tvNoOfFollwers.setText(userInfoHashmap
//                .get(InstagramApp.TAG_FOLLOWED_BY));
//        alertDialog.create().show();
    }

    private void setUpFonts(){
        UtilitiesClass.setFont(inputLayout1,this,0);
        UtilitiesClass.setFont(inputLayout2,this,0);
        UtilitiesClass.setFont(inputLayout3,this,0);
        UtilitiesClass.setFont(inputLayout4,this,0);
        UtilitiesClass.setFont(name,this,0);
        UtilitiesClass.setFont(email,this,0);
        UtilitiesClass.setFont(pass,this,0);
        UtilitiesClass.setFont(phone,this,0);
        UtilitiesClass.setFont(accept,this,0);
        UtilitiesClass.setFont(instaLogin,this,0);
        UtilitiesClass.setFont(register,this,0);
    }
}
