/*
 * Copyright 2015 Weijie Sun
 * Copyright 2015 Youdong Ma
 * Copyright 2015 Yufei Zhang
 * Copyright 2015 Chenrui Lei
 * Copyright 2015 Yang Zhang
 * Copyright 2015 Ji Yang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.List;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import ca.ualberta.cs.cmput301w15t04team04project.R.drawable;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.mapReceiver;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.OverlayItem.HotspotPlace;


/**
* This is the activity for the mean functionality of Open Street Map resouce from https://github.com/osmdroid/osmdroid/wiki/HowToMaven in April 2
* get though by the button home location of MainAcitivity.java is clicked. 
*
* @author Weijie Sun
* @version 1.0
* @date 2015.04.02
*/

//resource from https://github.com/osmdroid/osmdroid/wiki/HowToMaven in April 2


public class osmMainActivity extends Activity implements mapReceiver{
	private GeoPoint homeGeoPoint;
	private ItemizedIconOverlay<OverlayItem> pointsOverlay;
	private List<OverlayItem> points;
	private ResourceProxy mResourceProxy;
	private OverlayItem homeMark;
	private MapView map;
	private OverlayItem pick = null;
	private static boolean canEdit;
	private static String focusOn; 

	
	private static final int GOTO_HOME = Menu.FIRST;
	private static final int GOTO_CURRENT = GOTO_HOME + 1;
	private static final int GOTO_PICK = GOTO_HOME +2;

	/**
	 * onCreate method Once the activity is created, this method will give each
	 * view an object to help other methods set data or listeners.
	 * 
	 * @param savedInstanceState
	 *            the saved instance state bundle
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.osm_main);
        map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        IMapController mapController = map.getController();
        mapController.setZoom(9);
        GeoPoint startPoint = new GeoPoint(48.8583, 2,2944);
        mapController.setCenter(startPoint);
        
		mResourceProxy = new DefaultResourceProxyImpl(getApplicationContext());
		points = new ArrayList<OverlayItem>();
        
		homeMark = new OverlayItem("Home Location", "home", startPoint);
		homeMark.setMarker(getResources().getDrawable(drawable.person));
		
		pointsOverlay = new ItemizedIconOverlay<OverlayItem>(points, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {

			@Override
			public boolean onItemLongPress(int arg0, OverlayItem arg1) {
				return false;
			}
			@Override
			public boolean onItemSingleTapUp(int arg0, OverlayItem arg1) {
				return false;
			}
		},mResourceProxy);
		
		pointsOverlay.addItem(homeMark);
		pointsOverlay.setFocus(pick);
		mapController.setCenter(startPoint);
		
		map.getOverlays().add(pointsOverlay);

		
    }


	/**
	 * This method if from the mapReceiver interface to map the tap the position of map to be coming true
	 * 
	 * @param GeoPoint
	 *            is the point which should be chosen on the map
	 * @return false
	 */
	@Override
	public boolean singleTapConfirmedHelper(GeoPoint p) {
		if(canEdit == true){
			if(pick == null){
				pick = new OverlayItem("Picked Location","Pick", p);
	            pick.setMarker(getResources().getDrawable((drawable.person)));
	            pointsOverlay.addItem(pick);
	             
			}else{
				pointsOverlay.removeItem(pick);
	         	pick = new OverlayItem("Picked Location","Pick", p);
	         	pick.setMarker(getResources().getDrawable((drawable.person)));
	         	pointsOverlay.addItem(pick);
	        }
			map.invalidate();

		}
		   
	     return false;
	}
	/**
	 * This method if from the mapReceiver interface to map the tap the position of map to be coming true
	 * 
	 * @param GeoPoint
	 *            is the point which should be chosen on the map
	 * 
	 */

	@Override
	public boolean longPressHelper(GeoPoint p) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
}

