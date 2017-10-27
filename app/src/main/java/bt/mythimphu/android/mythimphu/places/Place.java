package bt.mythimphu.android.mythimphu.places;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by moic on 10/26/16.
 */

public class Place {

    private LatLng latLng;
    private String title;
    private String snippet;
    private Marker marker;

    Place(LatLng latLng, String t, String s, Marker m){

        this.setLatLng(latLng);
        this.setMarker(m);
        this.setTitle(t);
        this.setSnippet(s);
    }


    public LatLng getLatLng() {
        return latLng;
    }

    public  void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }




}
