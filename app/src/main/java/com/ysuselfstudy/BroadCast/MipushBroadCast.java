package com.ysuselfstudy.BroadCast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.ysuselfstudy.AllString;
import com.example.ysuselfstudy.InfoActivity;
import com.example.ysuselfstudy.MainActivity;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.ysuselfstudy.database.MipushInfor;
import com.ysuselfstudy.time.DateTime;

public class MipushBroadCast extends PushMessageReceiver {

    private static final String TAG = "MipushBroadCast";

    /**
     * 透传消息
     * @param context
     * @param miPushMessage
     */
    @Override
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        Log.d(TAG, "onReceivePassThroughMessage: 透传消息到了"+miPushMessage.toString());
    }

    /**
     * 点击事件
     * @param context
     * @param miPushMessage
     */
    @Override
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        Log.d(TAG, "onNotificationMessageClicked: 点击事件");
        switch (miPushMessage.getContent())
        {
            case AllString.SHIWU :
                //打开我的信息主页。
                Intent i = new Intent(context, InfoActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
                break;
        }
    }

    /***
     * 当消息到了的时候
     * @param context
     * @param miPushMessage
     */
    @Override
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        Log.d(TAG, "onNotificationMessageArrived: 消息到了"+miPushMessage.toString());
        DateTime dateTime=new DateTime();
        String time=dateTime.getMonth()+"月"+dateTime.getDate()+"日";
        String information=miPushMessage.getDescription();
        MipushInfor mipushInfor = new MipushInfor(time, information);
        mipushInfor.save();
    }

    /**
     * 注册消息返回
     * @param context
     * @param miPushCommandMessage
     */
    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String message=miPushCommandMessage.getCommand();
        Log.d(TAG, "onReceiveRegisterResult: "+message);
        //如果这是注册的消息
        if(MiPushClient.COMMAND_REGISTER.equals(message))
        {
            if(miPushCommandMessage.getResultCode()== ErrorCode.SUCCESS)
            {
                Log.d(TAG, "onReceiveRegisterResult: 注册成功");
            }else {
                Log.d(TAG, "onReceiveRegisterResult: 注册失败");
            }
        }else{
            Log.d(TAG, "onReceiveRegisterResult: 其他情况");
        }
    }

    /**
     * 客户端向服务器发送命令后的返回结果
     * @param context
     * @param miPushCommandMessage
     */
    @Override
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String message=miPushCommandMessage.getCommand();
        Log.d(TAG, "onCommandResult: "+message);
        //如果这是注册的消息
        if(MiPushClient.COMMAND_REGISTER.equals(message))
        {
            if(miPushCommandMessage.getResultCode()== ErrorCode.SUCCESS)
            {
                Log.d(TAG, "onCommandResult: 注册成功");
            }else {
                Log.d(TAG, "onCommandResult: 注册失败");
            }
        }else{
            Log.d(TAG, "onCommandResult: 其他情况");
        }
    }
}