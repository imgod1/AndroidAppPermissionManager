package com.kk.imgod.sharebike.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/**
 * Class Name : PermissionDetailUtils.
 * Description : 跳转到应用权限管理页
 * Created by imgod.
 * Create Date 2017/5/23 17:13.
 */

public class PermissionDetailUtils {
    //设备制造商
    public static final String MANUFACTURER_HUAWEI = "Huawei";
    public static final String MANUFACTURER_MEIZU = "Meizu";
    public static final String MANUFACTURER_XIAOMI = "Xiaomi";
    public static final String MANUFACTURER_SONY = "Sony";
    public static final String MANUFACTURER_OPPO = "OPPO";
    public static final String MANUFACTURER_LG = "LG";
    public static final String MANUFACTURER_VIVO = "vivo";
    public static final String MANUFACTURER_SAMSUNG = "samsung";
    public static final String MANUFACTURER_LETV = "Letv";
    public static final String MANUFACTURER_ZTE = "ZTE";
    public static final String MANUFACTURER_YULONG = "YuLong";
    public static final String MANUFACTURER_LENOVO = "LENOVO";
    public static final String MANUFACTURER_360 = "360";

    /**
     * 跳转到应用详情页
     *
     * @param context 上下文
     */
    public static void openAppInfo(Context context) {
        //redirect user to app Settings
        context.startActivity(getOpenAppInfoIntent(context));
    }

    public static Intent getOpenAppInfoIntent(Context context) {
        Intent i = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + context.getApplicationContext().getPackageName()));
        return i;
    }

    /**
     * 跳转到相应设备的该app的权限管理界面
     *
     * @param context 上下文
     */
    public static void goToAppPermissionManagerActivity(Context context) {
        Intent intent;
        if (Build.MANUFACTURER.equals(MANUFACTURER_HUAWEI)) {
            intent = gotoHuaWeiPermission(context);
        } else if (Build.MANUFACTURER.equals(MANUFACTURER_LETV)) {
            intent = gotoLePermission(context);
        } else if (Build.MANUFACTURER.equals(MANUFACTURER_LG)) {
            intent = gotoLgPermission(context);
        } else if (Build.MANUFACTURER.equals(MANUFACTURER_MEIZU)) {
            intent = gotoMeiZuPermission(context);
        } else if (Build.MANUFACTURER.equals(MANUFACTURER_OPPO)) {
            intent = gotoOppoPermission(context);
        } else if (Build.MANUFACTURER.equals(MANUFACTURER_SONY)) {
            intent = gotoSonyPermission(context);
        } else if (Build.MANUFACTURER.equals(MANUFACTURER_XIAOMI)) {
            intent = gotoMiuiPermission(context);
        } else if (Build.MANUFACTURER.equals(MANUFACTURER_360)) {
            intent = goto360Permission(context);
        } else {
            intent = getOpenAppInfoIntent(context);
        }
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            openAppInfo(context);
        }
    }


    /**
     * 跳转到miui的权限管理页面
     */
    public static Intent gotoMiuiPermission(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getApplicationContext().getPackageName());
        return intent;
    }


    /**
     * 跳转到华为的权限管理页面
     */
    public static Intent gotoHuaWeiPermission(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("packageName", context.getApplicationContext().getPackageName());
        ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        intent.setComponent(comp);
        return intent;
    }

    /**
     * 跳转到魅族的权限管理页面
     */
    public static Intent gotoMeiZuPermission(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("packageName", context.getApplicationContext().getPackageName());
        return intent;
    }

    /**
     * 跳转到索尼的权限管理页面
     */
    public static Intent gotoSonyPermission(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("packageName", context.getApplicationContext().getPackageName());
        ComponentName comp = new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity");
        intent.setComponent(comp);
        return intent;
    }

    /**
     * 跳转到Oppo的权限管理页面
     */
    public static Intent gotoOppoPermission(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("packageName", context.getApplicationContext().getPackageName());
        ComponentName comp = new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        intent.setComponent(comp);
        return intent;
    }

    /**
     * 跳转到Lg的权限管理页面
     */
    public static Intent gotoLgPermission(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("packageName", context.getApplicationContext().getPackageName());
        ComponentName comp = new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity");
        intent.setComponent(comp);
        return intent;
    }

    /**
     * 跳转到乐视的权限管理页面
     */
    public static Intent gotoLePermission(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("packageName", context.getApplicationContext().getPackageName());
        ComponentName comp = new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps");
        intent.setComponent(comp);
        return intent;
    }

    /**
     * 跳转到360手机的权限管理页面
     */
    public static Intent goto360Permission(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("packageName", context.getApplicationContext().getPackageName());
        ComponentName comp = new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        intent.setComponent(comp);
        return intent;
    }

}
