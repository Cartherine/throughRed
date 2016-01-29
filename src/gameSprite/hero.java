package gameSprite;

import java.io.InputStream;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import edu.swt.throughred.R;
import game.engine.Sprite;
import gameSprite.start.myThread;



public class hero extends SurfaceView implements SurfaceHolder.Callback{

	static SurfaceHolder holder;
	
	static Canvas canvas;
	static Paint p = new Paint();
	static Sprite sHero;
	
	static int sx=0;
	static int sy=0;
	
	static int sw=40;
	static int sh=40;
	
	Bitmap bmpHero;
	static int speed = 10;
	
	static int direct_up = 1;
	static int direct_down = 2;
	static int direct_left = 3;
	static int direct_right = 4;
	
	static int direction = 1;//��ǰ����

	private boolean isUp, isDown, isLeft, isRight;
    boolean isRunning = true;


	public  hero(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.setZOrderOnTop(true);

		holder = this.getHolder();
		holder.setFormat(PixelFormat.TRANSLUCENT);
		holder.addCallback(this); 
		
		/*��ȡʵ��ͼƬ����*/
		InputStream isHero = getResources().openRawResource(R.drawable.hero);//��ȡͼƬ��Դ
		bmpHero = BitmapFactory.decodeStream(isHero);
		
		/*������Ϸ��������*/
		sHero = new Sprite(bmpHero, sw, sh);//����ͼƬ
		sHero.setPosition(sx, sy);//��������
		sHero.setVisible(true);//����Ϊ�ɼ�
	}
	
	
	public void checkStatus(){
		sx = sHero.getX();
		sy = sHero.getY();		
		if(direction == direct_up){	
			if(sy<=0){
				sHero.setPosition(sx, 0);
			}
			else{
				sHero.move(0, -speed);
			}
			
		}
		else if(direction == direct_down){			
			if(sy+sh>=this.getHeight()){
				sHero.setPosition(sx, this.getHeight()-sh);
			}
			else{
				sHero.move(0, speed);
			}
			
			
		}
		else if(direction == direct_left){			
			if(sx<=0){
				sHero.setPosition(0, sy);
			}
			else{
				sHero.move(-speed, 0);
			}			
		}
		else if(direction == direct_right){			
			if(sx+sw>=this.getWidth()){
				sHero.setPosition(this.getWidth()-sw, sy);
			}
			sHero.move(speed, 0);			
		}
	}
	

	
	public static void draw(){
		/*������Ϸ����*/
		canvas = holder.lockCanvas();//��ס������ʼ�滭
		canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);//�����������
		
		//checkStatus();
		
		sHero.paint(canvas);//������Ϸ����
//		sx = sHero.getX();
//		sy = sHero.getY();
//
//		canvas.drawText("Hero", sx, sy+sh, p);		
		holder.unlockCanvasAndPost(canvas);//��������
	}
	
	public boolean onTouchEvent(MotionEvent e){
		switch(e.getAction()){
		case MotionEvent.ACTION_DOWN:{
			return false;
		}
		case MotionEvent.ACTION_MOVE:{
			return false;
		}
		case MotionEvent.ACTION_UP:{
			int x = (int)e.getX();
			int y = (int)e.getY();
			
			sHero.setPosition(x, y);
			draw();

		}break;
		}// end of switch
		
		

		return true;
		
	}// end of method onTouchEvent()
	
	/**
	 * �����¼�����
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
			isUp = true;
		}
		if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
			isDown = true;
		}
		if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
			isLeft = true;
		}
		if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
			isRight = true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
			isUp = false;
		}
		if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
			isDown = false;
		}
		if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
			isLeft = false;
		}
		if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
			isRight = false;
		}
		return super.onKeyUp(keyCode, event);
	}


	/**
	 * ��Ϸ�߼�
	 */
	private void logic() {
		if (isUp) {
			sy -= 1;
		}
		if (isDown) {
			sy += 1;
		}
		if (isLeft) {
			sx -= 1;
		}
		if (isRight) {
			sx += 1;
		}
	}

	
	public class myThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning){
				synchronized(holder){
					try {
						
						
						checkStatus();

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

}
