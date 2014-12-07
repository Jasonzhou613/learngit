package com.andsos.jutility.common;

import android.content.Context;

/**
 * 获取应用的版本号和版本代码<br/>
 * {@link #getVersionName()}方法得到应用的Version name<br/>
 * {@link #getVersionCode()}方法得到应用的Version code
 * 
 * @version 1.0.1
 * @author Jason
 * @date 2013.11.25
 * @last_modify_date 2014.03.10
 */
public class AppInfomation {
	private Context mContext;
	private final String TAG = "JUtility.AppInfomation";
	
	public AppInfomation(Context context) {
		this.mContext = context;
	}

	/**
	 * 得到应用程序的包名
	 * 
	 * @return
	 */
	public String getPackageName() {
		return mContext.getPackageName();
	}

	/**
	 * 得到应用的version name,如：1.0.0
	 * 
	 * @return version name,发生异常时返回null;
	 */
	public String getVersionName() {
		String versionname = null;
		String pkName = "";

		try {
			pkName = mContext.getPackageName();
			versionname = mContext.getPackageManager()
					.getPackageInfo(pkName, 0).versionName;
		} catch (Exception e) {
			ULog.e(TAG,
					"AppInfomation->getVersionName exception:" + e.getMessage());
		}
		ULog.d(TAG, "App package name:" + pkName);
		ULog.d(TAG, "App version name:" + versionname);

		return versionname;
	}

	/**
	 * 得到应用的version code,如：131125
	 * 
	 * @return version code,发生异常时返回-1
	 */
	public int getVersionCode() {
		int versioncode = -1;

		try {
			versioncode = mContext.getPackageManager().getPackageInfo(
					mContext.getPackageName(), 0).versionCode;

		} catch (Exception e) {
			ULog.e(TAG,
					"AppInfomation->getVersionCode exception:" + e.getMessage());
		}
		ULog.d(TAG, "App version code:" + String.valueOf(versioncode));

		return versioncode;
	}
}
