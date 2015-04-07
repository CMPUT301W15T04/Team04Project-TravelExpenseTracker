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


package ca.ualberta.cs.cmput301w15t04team04project.models;


import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.OverlayItem;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class SampleOverlayItem extends OverlayItem {
	public SampleOverlayItem(String aUid, String aTitle, String aDescription,
			GeoPoint aGeoPoint, Drawable aMarker, HotspotPlace aHotspotPlace) {
		super(aUid, aTitle, aDescription, aGeoPoint);
		this.setMarker(aMarker);
		this.setMarkerHotspot(aHotspotPlace);
	}

	public void draw(Canvas canvas) {
		//
	}
}
