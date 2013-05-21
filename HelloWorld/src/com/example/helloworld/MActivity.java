package com.example.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class MActivity extends Activity implements Runnable{
	
	ProgressDialog mReadProcessDia=null;
	public final static int MAX_READPROCESS = 100;
	
	public void onCreate(Bundle instance){
		super.onCreate(instance);
		setContentView(R.layout.activity_meng);
		
		//showListDia();
		showReadProcess();
	}
	
	//列表对话框
	private void showListDia()
	{
		final String[] mList={"选项1","选项2","选项3","选项4","选项5","选项6","选项7"};
		AlertDialog.Builder listDia=new AlertDialog.Builder(MActivity.this);
		listDia.setTitle("列表对话框");
		listDia.setItems(mList, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				/*下标是从0开始的*/
				
			}
		});
		listDia.create().show();
	}
	
	
	private void showReadProcess()
	{
		mReadProcessDia=new ProgressDialog(MActivity.this);
		mReadProcessDia.setProgress(0);
		mReadProcessDia.setTitle("进度条窗口");
		mReadProcessDia.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mReadProcessDia.setMax(MAX_READPROCESS);
		mReadProcessDia.show();
		new Thread(this).start();
	}
	
	//新开启一个线程，循环的累加，一直到100然后在停止
	@Override
	public void run()
	{
		int Progress= 0;
		while(Progress < MAX_READPROCESS)
		{
			try {
				Thread.sleep(100);
				Progress++;
				mReadProcessDia.incrementProgressBy(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//读取完了以后窗口自消失
		mReadProcessDia.cancel();
	}
	
	
}
