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
	
	//�б�Ի���
	private void showListDia()
	{
		final String[] mList={"ѡ��1","ѡ��2","ѡ��3","ѡ��4","ѡ��5","ѡ��6","ѡ��7"};
		AlertDialog.Builder listDia=new AlertDialog.Builder(MActivity.this);
		listDia.setTitle("�б�Ի���");
		listDia.setItems(mList, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				/*�±��Ǵ�0��ʼ��*/
				
			}
		});
		listDia.create().show();
	}
	
	
	private void showReadProcess()
	{
		mReadProcessDia=new ProgressDialog(MActivity.this);
		mReadProcessDia.setProgress(0);
		mReadProcessDia.setTitle("����������");
		mReadProcessDia.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mReadProcessDia.setMax(MAX_READPROCESS);
		mReadProcessDia.show();
		new Thread(this).start();
	}
	
	//�¿���һ���̣߳�ѭ�����ۼӣ�һֱ��100Ȼ����ֹͣ
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
		//��ȡ�����Ժ󴰿�����ʧ
		mReadProcessDia.cancel();
	}
	
	
}
