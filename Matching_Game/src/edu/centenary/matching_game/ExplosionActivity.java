package edu.centenary.matching_game;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class ExplosionActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explosion);
        
        VideoView explosion = (VideoView) findViewById (R.id.explode);
        explosion.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.nexplosion));
        
        explosion.start();
}
	
}
