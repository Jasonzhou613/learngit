package com.andsos.jutility.common;

import android.content.Context;

/**
 * ��ȡӦ�õİ汾�źͰ汾����<br/>
 * {@link #getVersionName()}�����õ�Ӧ�õ�Version name<br/>
 * {@link #getVersionCode()}�����õ�Ӧ�õ�Version code
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
	 * �õ�Ӧ�ó���İ���
	 * 
	 * @return
	 */
	public String getPackageName() {
		return mContext.getPackageName();
	}

	/**
	 * �õ�Ӧ�õ�version name,�磺1.0.0
	 * 
	 * @return version name,�����쳣ʱ����null;
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
	 * �õ�Ӧ�õ�version code,�磺131125
	 * 
	 * @return version code,�����쳣ʱ����-1
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
