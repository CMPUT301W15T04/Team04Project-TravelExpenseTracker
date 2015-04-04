package ca.ualberta.cs.cmput301w15t04team04project.models;

//https://code.google.com/p/osmbonuspack/source/browse/trunk/OSMBonusPack/src/org/osmdroid/bonuspack/overlays/MapEventsReceiver.java March 26 2015
import org.osmdroid.util.GeoPoint;

/**
* Interface for objects that need to handle map events thrown by a MapEventsOverlay.
* @see mapOverlay
* @author Weijie Sun
*/
public interface mapReceiver {

   
      boolean singleTapConfirmedHelper(GeoPoint p);
     

      boolean longPressHelper(GeoPoint p);    
}
