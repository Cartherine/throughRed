package gameSprite;//��ĳ����Ӧ��package����

import java.io.InputStream;
import android.content.Context;
import android.graphics.*;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.*;
import android.widget.Toast;
import game.engine.*;


public class start extends SurfaceView implements SurfaceHolder.Callback{

	static SurfaceHolder holder;
	
	static Canvas canvas;
	static Paint p = new Paint();
//	static Sprite sHero;
//	static Sprite sEnemy01;
//	
//	static int sx=0;
//	static int sy=0;
	
	static int sw=40;
	static int sh=40;
	
//	Bitmap bmpHero;
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
	
	/*��ȡ��Ϸ����Ŀ�͸�*/
	WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);	
	Display dis = wm.getDefaultDisplay();	

	int w = dis.getWidth();//��
    int h = dis.getHeight();//��
    
    boolean isRunning = true;


	public start(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.setZOrderOnTop(true);

		holder = this.getHolder();
		holder.setFormat(PixelFormat.TRANSLUCENT);
		holder.addCallback(this); 
		
//		/*��ȡʵ��ͼƬ����*/
//		InputStream isHero = getResources().openRawResource(R.drawable.sprite02);//��ȡͼƬ��Դ
//		bmpHero = BitmapFactory.decodeStream(isHero);
//		
//		InputStream isEnemy = getResources().openRawResource(R.drawable.enemy);//��ȡͼƬ��Դ
//		bmpEnemy = BitmapFactory.decodeStream(isEnemy);
		
//		/*������Ϸ��������*/
//		sHero = new Sprite(bmpHero, sw, sh);//����ͼƬ
//		sHero.setPosition(sx, sy);//��������
//		sHero.setVisible(true);//����Ϊ�ɼ�
//		;
//		sEnemy = new Sprite(bmpEnemy);
//		sEnemy.setPosition(100, 100);
//		sEnemy.setVisible(true);	
	}
	
	
//	public void checkStatus(){
//		sx = sHero.getX();
//		sy = sHero.getY();
//		
//		
//		if(sHero.collidesWith(sEnemy, true)){
//			//canvas.drawText("ײ���ˣ���", 200, 200, p);
//			sEnemy.setVisible(false);
//		}
//		
//		if(direction == direct_up){
//			if(direction != lastdirection){
//				lastdirection = direction;
//			}			
//			sHero.nextFrame();
//			
//			if(sy<=0){
//				sHero.setPosition(sx, 0);
//			}
//			else{
//				sHero.move(0, -speed);
//			}
//			
//		}
//		else if(direction == direct_down){
//			if(direction != lastdirection){
//				lastdirection = direction;
//			}
//			
//			sHero.nextFrame();
//			
//			if(sy+sh>=h){
//				sHero.setPosition(sx, h-sh);
//			}
//			else{
//				sHero.move(0, speed);
//			}
//			
//			
//		}
//		else if(direction == direct_left){
//			if(direction != lastdirection){
//				lastdirection = direction;
//			}
//			
//			sHero.nextFrame();
//			
//			if(sx<=0){
//				sHero.setPosition(0, sy);
//			}
//			else{
//				sHero.move(-speed, 0);
//			}
//			
//			
//		}
//		else if(direction == direct_right){
//			if(direction != lastdirection){
//				lastdirection = direction;
//			}
//			
//			sHero.nextFrame();
//			
//			if(sx+sw>=w){
//				sHero.setPosition(w-sw, sy);
//			}
//			sHero.move(speed, 0);
//			
//		}
//	}
//	

	
	public static void draw(){
		/*������Ϸ����*/
		canvas = holder.lockCanvas();//��ס������ʼ�滭
		canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);//�����������
		
		//checkStatus();
		
//		sHero.paint(canvas);//������Ϸ����
//		sx = sHero.getX();
//		sy = sHero.getY();
//
//		canvas.drawText("Hero", sx, sy+sh, p);
		
//		sEnemy.paint(canvas);
		
		holder.unlockCanvasAndPost(canvas);//��������
	}
	
//	public boolean onTouchEvent(MotionEvent e){
//		switch(e.getAction()){
//		case MotionEvent.ACTION_DOWN:{
//			int x = (int)e.getX();
//			int y = (int)e.getY();
//			
//			sHero.setPosition(x, y);
//			draw();
//
//		}break;
//		case MotionEvent.ACTION_MOVE:{
//			int x = (int)e.getX();
//			int y = (int)e.getY();
//			
//			sHero.setPosition(x, y);
//			draw();
//	
//		}break;
//		case MotionEvent.ACTION_UP:{
//			int x = (int)e.getX();
//			int y = (int)e.getY();
//			
//			sHero.setPosition(x, y);
//			draw();
//
//		ju}break
//		}// end of switch
//		
//		
//
//		return true;
//		
//	}// end of method onTouchEvent()
//	
	
	public class myThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning){
				synchronized(holder){
					try {
						
						
//						checkStatus();

						draw();
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}	
		}
		
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub	
		new Thread(new myThread()).start();
	}
	

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub	
		isRunning = false;		
	}


	public int getW() {
		return w;
	}


	public void setW(int w) {
		this.w = w;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}

}
