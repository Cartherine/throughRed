package edu.swt.throughred;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.widget.*;

public class ThroughRed extends Activity {

	ImageButton b1;
	ImageButton b2;
	ImageButton b3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	/* È«ÆÁÏÔÊ¾´°¿Ú*/
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    				WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_through_red);
        b1 = (ImageButton)this.findViewById(R.id.b1);
        b2 = (ImageButton)this.findViewById(R.id.b2);
        b3 = (ImageButton)this.findViewById(R.id.b3);
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(ThroughRed.this,startRed.class);
				startActivity(intent);
			}
		});
        b2.setOnClickListener(new View.OnClickListener() {
			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(ThroughRed.this,rankRed.class);
				startActivity(intent);	
 			}
 		});
        b3.setOnClickListener(new View.OnClickListener() {
			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(ThroughRed.this,aboutRed.class);
				startActivity(intent);
 			}
 		});
        
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_through_red, menu);
        return true;
    }
    
}

