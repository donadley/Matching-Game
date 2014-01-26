package edu.centenary.matching_game;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;


public class GameActivity extends Activity {
	
	private Handler mHandler = new Handler();
    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            boolean match = mm.reset();
            if (match) {
            	// correct noise
            	MediaPlayer m2 = new MediaPlayer(); 
        		m2 = MediaPlayer.create(GameActivity.this, R.raw.correct); 
        		m2.start(); 
            } // incorrect noise
            // Then
            updateViews();
            boardView.setEnabled(true);
       }
    };
	/** This is the graphical representation of the gameboard. */
	private GridView boardView;
	
	/** Tells the grid what images are in which squares */
	private ImageAdapter ia;
	
	/** The model object for TopSpin games */
	private MatchingModel mm;

	/** Chosen size of the grid */
	private int size;
	
	/** Width of the screen */
	private int width;
	
	/** Height of the screen */
	private int height;
	
	private TextView tv;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.easy);
		setContentView(R.layout.hard);
		
		// Load the chosen screen size from the passed Bundle
		Bundle bundle = this.getIntent().getExtras();
		size = bundle.getInt("size");
		
		// Find the views and set the grid size	
		boardView = (GridView) this.findViewById(R.id.board);
		boardView.setNumColumns(size);
		boardView.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// react to somebody tapping a view
				int row = position / size;
				int column = position % size;
				int status = MatchingModel.ALREADYT;
				try {
					status = mm.game(mm.get(row, column));
				}
				
				catch (BombException be){
					Intent i = new Intent(GameActivity.this, ExplosionActivity.class);
					startActivity(i);
					finish();
				}
				catch (WinException we){
					Intent i = new Intent(GameActivity.this, WinActivity.class);
					startActivity(i);
					finish();
				}
					
				Log.d("Tapping..", "tapping at position" + position);
				Log.d("Tapping..", "flipped = " + mm.get(row, column).isFlipped());
				
				// 
				
				updateViews();
				
				if (status == MatchingModel.FIRST || status == MatchingModel.SECOND){
					MediaPlayer m2 = new MediaPlayer(); 
	        		m2 = MediaPlayer.create(GameActivity.this, R.raw.flip); 
	        		m2.start(); 
				}
				if (status == MatchingModel.SECOND) {
					mHandler.postDelayed(mUpdateTimeTask, 1000);
					boardView.setEnabled(false);
				}
				
			}
			
			
		});

		// Get the height and width of the screen
        width = getWindowManager().getDefaultDisplay().getWidth();
        height = getWindowManager().getDefaultDisplay().getHeight();
        
        // Take the smaller of the two and use it as the dimensions of the gameboard
        if (height < width) {
        	width = height;
        }
       
        // Create the Matching Object (spin) and mix it up
        mm = new MatchingModel(size);
        //mm.mixup(100);
        
        // An adapter so the grid is displayed programmatically
		ia = new ImageAdapter(getApplicationContext(), width, mm, size);
		boardView.setAdapter(ia);
		
		updateViews();
		// The buttons to shift clockwise, counterclockwise, and spin
	}
	
	/**
	 * General notification that models have been changed. Used to 
	 * reset grid images and ask if the game is solved
	 */
	public void updateViews() {
		ia.notifyDataSetChanged();				
		
		tv = (TextView) this.findViewById(R.id.matchCount);
		tv.setText("Match Count is: " + MatchingModel.count);
		
	}
}
