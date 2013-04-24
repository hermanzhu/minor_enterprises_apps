package com.fss.qdnewsproject1.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;

public class BitmapUtils extends Activity{
	public static Bitmap BitmapFullWidthChange(int screenwidth,int screenheight,
			int resourcewidth,int rescourceheight,int percent,Bitmap bm){
		 float scaleWidth = ((float) screenwidth) / resourcewidth;   
	     float scaleHeight = ((float) screenheight*percent/100) / rescourceheight;  
	     Log.d("scaleWidth", String.valueOf(scaleWidth));
	     Log.d("scaleHeight", String.valueOf(scaleHeight));
	     Matrix matrix=new Matrix();
	     matrix.postScale(scaleWidth,scaleHeight);
	     Bitmap resizedBitmap=Bitmap.createBitmap(bm,0,0,resourcewidth,rescourceheight,matrix,true);
		
	     return resizedBitmap;
	}
	public static BitmapDrawable BitmapFullWidthChangeDrawable(int screenwidth,int screenheight,
			int resourcewidth,int rescourceheight,int percent,Bitmap bm){
		 float scaleWidth = ((float) screenwidth) / resourcewidth;   
	     float scaleHeight = ((float) screenheight*percent/100) / rescourceheight;  
	     Log.d("scaleWidth", String.valueOf(scaleWidth));
	     Log.d("scaleHeight", String.valueOf(scaleHeight));
	     Matrix matrix=new Matrix();
	     matrix.postScale(scaleWidth,scaleHeight);
	     Bitmap resizedBitmap=Bitmap.createBitmap(bm,0,0,resourcewidth,rescourceheight,matrix,true);
	     BitmapDrawable bd=new BitmapDrawable(resizedBitmap);
	     return bd;
	}


}
