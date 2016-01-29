package gameSprite;//请改成你对应的package名称

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
//	static int direction = 2;//当前方向
//	static int lastdirection = 2;
	
	/*获取游戏界面的宽和高*/
	WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);	
	Display dis = wm.getDefaultDisplay();	

	int w = dis.getWidth();//宽
    int h = dis.getHeight();//高
    
    boolean isRunning = true;


	public start(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.setZOrderOnTop(true);

		holder = this.getHolder();
		holder.setFormat(PixelFormat.TRANSLUCENT);
		holder.addCallback(this); 
		
//		/*读取实际图片内容*/
//		InputStream isHero = getResources().openRawResource(R.drawable.sprite02);//读取图片资源
//		bmpHero = BitmapFactory.decodeStream(isHero);
//		
//		InputStream isEnemy = getResources().openRawResource(R.drawable.enemy);//读取图片资源
//		bmpEnemy = BitmapFactory.decodeStream(isEnemy);
		
//		/*配置游戏精灵属性*/
//		sHero = new Sprite(bmpHero, sw, sh);//设置图片
//		sHero.setPosition(sx, sy);//设置坐标
//		sHero.setVisible(true);//设置为可见
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
//			//canvas.drawText("撞上了！！", 200, 200, p);
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
		/*绘制游戏精灵*/
		canvas = holder.lockCanvas();//锁住画布开始绘画
		canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);//清除画布内容
		
		//checkStatus();
		
//		sHero.paint(canvas);//绘制游戏精灵
//		sx = sHero.getX();
//		sy = sHero.getY();
//
//		canvas.drawText("Hero", sx, sy+sh, p);
		
//		sEnemy.paint(canvas);
		
		holder.unlockCanvasAndPost(canvas);//解锁画布
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
