package edu.swt.throughred;
//package gameSprite;//��ĳ����Ӧ��package����
//
//import java.io.InputStream;
//import edu.swt.throughred.R;
//import edu.swt.throughred.R.drawable;
//import android.content.Context;
//import android.graphics.*;
//import android.graphics.PorterDuff.Mode;
//import android.util.AttributeSet;
//import android.view.*;
//import android.widget.Toast;
//import game.engine.*;
//
//
//public class enemy extends SurfaceView implements SurfaceHolder.Callback{
//
//	static SurfaceHolder holder;
//	
//	static Canvas canvas;
//	static Paint p = new Paint();
//	static Sprite sEnemy;
//	
//	static int sx=0;
//	static int sy=0;
//	
//	static int sw=32;
//	static int sh=48;
//	
//	Bitmap bmpEnemy;
//	static int speed = 10;
//	
//	static int direct_up = 1;
//	static int direct_down = 2;
//	static int direct_left = 3;
//	static int direct_right = 4;
//	
//	static int direction = 2;//��ǰ����
//	static int lastdirection = 2;
//	
//    boolean isRunning = true;
//
//
//	public enemy(Context context, AttributeSet attrs) {
//		super(context, attrs);
//		// TODO Auto-generated constructor stub
//		this.setZOrderOnTop(true);
//
//		holder = this.getHolder();
//		holder.setFormat(PixelFormat.TRANSLUCENT);
//		holder.addCallback(this); 
//		
//		/*��ȡʵ��ͼƬ����*/
//		InputStream isEnemy = getResources().openRawResource(R.drawable.enemy);//��ȡͼƬ��Դ
//		bmpEnemy = BitmapFactory.decodeStream(isEnemy);
//		
//		/*������Ϸ��������*/
//		sEnemy = new Sprite(bmpEnemy);//����ͼƬ
//		sEnemy.setPosition(100, 100);//��������
//		sEnemy.setVisible(true);//����Ϊ�ɼ�	
//	}
//	
//	
//	public void checkStatus(){
//		sx = sEnemy.getX();
//		sy = sEnemy.getY();
//					
//		if(sy+sh>=this.getWidth()){
//			sEnemy.setPosition(sx, 0);
//		}
//			else{
//				sEnemy.move(0, speed);
//			}
//			
//			
//		}
//		
//	public static void draw(){
//		/*������Ϸ����*/
//		canvas = holder.lockCanvas();//��ס������ʼ�滭
//		canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);//�����������
//		
//		//checkStatus();
//
////		sx = sHero.getX();
////		sy = sHero.getY();
////
////		canvas.drawText("Hero", sx, sy+sh, p);
//		
//		sEnemy.paint(canvas);//������Ϸ����
//		
//		holder.unlockCanvasAndPost(canvas);//��������
//	}
//	
//	
//	public class myThread implements Runnable{
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			while(isRunning){
//				synchronized(holder){
//					try {
//						
//						
//						checkStatus();
//
//						draw();
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}	
//		}
//		
//	}
//
//
//	@Override
//	public void surfaceCreated(SurfaceHolder holder) {
//		// TODO Auto-generated method stub	
//		new Thread(new myThread()).start();
//	}
//	
//
//	@Override
//	public void surfaceChanged(SurfaceHolder holder, int format, int width,
//			int height) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void surfaceDestroyed(SurfaceHolder holder) {
//		// TODO Auto-generated method stub	
//		isRunning = false;		
//	}
//
//}
