package ca.ualberta.cs.cmput301w15t04team04project.models;

//https://code.google.com/p/osmbonuspack/source/browse/trunk/OSMBonusPack/src/org/osmdroid/bonuspack/overlays/MapEventsOverlay.java March 26th 2015
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.Projection;
import org.osmdroid.views.overlay.Overlay;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

/**
* Empty overlay than can be used to detect events on the map,
* and to throw them to a MapEventsReceiver.
* @see MapEventsReceiver
* @author M.Kergall
*/
public class mapOverlay extends Overlay {

      private mapReceiver mReceiver;
     
      /**
       * @param ctx the context
       * @param receiver the object that will receive/handle the events.
       * It must implement MapEventsReceiver interface.
       */
      public mapOverlay(Context ctx, mapReceiver receiver) {
      super(ctx);
              mReceiver = receiver;
  }

      @Override protected void draw(Canvas c, MapView osmv, boolean shadow) {
              //Nothing to draw
      }
     
      @Override public boolean onSingleTapConfirmed(MotionEvent e, MapView mapView){
              Projection proj = mapView.getProjection();
              GeoPoint p = (GeoPoint)proj.fromPixels((int)e.getX(), (int)e.getY());
              return mReceiver.singleTapConfirmedHelper(p);
      }
     
      @Override public boolean onLongPress(MotionEvent e, MapView mapView) {
              Projection proj = mapView.getProjection();
              GeoPoint p = (GeoPoint)proj.fromPixels((int)e.getX(), (int)e.getY());
              //throw event to the receiver:
              return mReceiver.longPressHelper(p);
  }

}
