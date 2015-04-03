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
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.OverlayItem.HotspotPlace;



public class osmMainActivity extends Activity {
	private GeoPoint homeGeoPoint;
	private ItemizedIconOverlay<OverlayItem> pointsOverlay;
	private List<OverlayItem> points;
	private ResourceProxy mResourceProxy;
	private OverlayItem homeMark;
	private MapView map;

	
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
		
		map.getOverlays().add(pointsOverlay);

    }
	
	
	
}

