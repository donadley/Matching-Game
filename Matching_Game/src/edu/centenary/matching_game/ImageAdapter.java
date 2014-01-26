package edu.centenary.matching_game;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	/** The Context in which the GridView will be placed. */
	private Context context;
	
	/** A pointer to the game in DomineeringActivity. */
	private MatchingModel mm;
	
	/** The width of the gameboard. */
	private int width;
	
	/** The number of squares in the grid */
	private int squares;
	
	/** Maximum number of pieces, from 5x5 board */
	public static final int MAXPIECES = 16;

	/** References to the images for the pieces */
	private int[] pIDs = { R.drawable.bomb, R.drawable.sphere, R.drawable.cube, 
			R.drawable.dodecahedron, R.drawable.pyramid, R.drawable.cone, R.drawable.cylinder, R.drawable.cuboid, R.drawable.fourstar, 
			R.drawable.glossystar, R.drawable.greenstar, R.drawable.orangestar, R.drawable.purplestar, R.drawable.back }; 

	/**
	 * Constructor for an ImageAdapter. This class maps images to the GridView based 
	 * on the pieces in the Matching object.
	 * @param c The context in which the GridView is placed.
	 * @param w The width of the screen and the gameboard.
	 * @param top The TopSpin object with which we are concerned.
	 * @param n total number of squares
	 * @see BaseAdapter
	 */
	public ImageAdapter(Context c, int w, MatchingModel mm, int n) {
		context = c;
		this.mm = mm;
		this.width = w;
		this.squares = n;
	}

	/** Returns the number of squares. */
	public int getCount() {
		return squares * squares;
	}

	/** Returns the item at the specified position. Irrelevant in our case. */

	public Object getItem(int position) {
		return null;
	}

	/** Returns the ID of the item at the specified position. Irrelevant in our case. */

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * This method is called in the mapping of images to the GridView.
	 * @param position The position of the current image in the grid.
	 * @param convertView If this isn't null, its contents are used in lieu of creating a new ImageView.
	 * @param parent The ViewGroup which will hold the ImageView.
	 * @return View
	 * @see View
	 * @see ViewGroup
	 * @see ImageView
	 */

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView view;
		if (convertView == null) {
			view = new ImageView(context);
			view.setLayoutParams(new GridView.LayoutParams(width/(squares + 1), width/(squares + 1)));
			view.setScaleType(ImageView.ScaleType.CENTER_CROP);
			view.setPadding(3,3,3,3);
		} else {
			view = (ImageView) convertView;
		}
		int row = position / squares;
		int column = position % squares;
		
		PictureCard pc = mm.get(row, column);
		if (pc.isFlipped()) {
			view.setImageResource(pIDs[pc.getShape()]);
		} else {
			view.setImageResource(pIDs[PictureCard.BACK]);
		}
		return view;
	}
}
