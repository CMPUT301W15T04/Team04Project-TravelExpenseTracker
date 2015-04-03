package ca.ualberta.cs.cmput301w15t04team04project.models;

//https://code.google.com/p/osmbonuspack/source/browse/trunk/OSMBonusPack/src/org/osmdroid/bonuspack/overlays/MapEventsReceiver.java March 26 2015
import org.osmdroid.util.GeoPoint;

/**
* Interface for objects that need to handle map events thrown by a MapEventsOverlay.
* @see MapEventsOverlay
* @author M.Kergall
*/
public interface mapReceiver {

      /**
       * @param p the position where the event occurred.
       * @return true if the event has been "consumed" and should not be handled by other objects.
       */
      boolean singleTapConfirmedHelper(GeoPoint p);
     
      /**
       * @param p the position where the event occurred.
       * @return true if the event has been "consumed" and should not be handled by other objects.
       */
      boolean longPressHelper(GeoPoint p);    
}
