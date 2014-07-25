package com.example.hellomaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapClickListener {
	
	private final LatLng UPV = new LatLng(39.481106, -0.340987);
	private GoogleMap mapa;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);
	      mapa = ((SupportMapFragment) getSupportFragmentManager()
	            .findFragmentById(R.id.map)).getMap();
	      mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	      mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(UPV, 15));
	      mapa.setMyLocationEnabled(true);
	      mapa.getUiSettings().setZoomControlsEnabled(false);
	      mapa.getUiSettings().setCompassEnabled(true);
	      mapa.addMarker(new MarkerOptions()
	            .position(UPV)
	            .title("UPV")
	            .snippet("Universidad Polit�cnica de Valencia")
	            .icon(BitmapDescriptorFactory
	                   .fromResource(R.drawable.ic_launcher))
	            .anchor(0.5f, 0.5f));
	      mapa.setOnMapClickListener(this);
		 
		 
		   
	}
	
	
	public void addMarker(View view) {
	      mapa.addMarker(new MarkerOptions().title("Mi marcador").position(
	           new LatLng(mapa.getCameraPosition().target.latitude,
	      mapa.getCameraPosition().target.longitude)));

	   }
	 
	   @Override
	   public void onMapClick(LatLng puntoPulsado) {
	      mapa.addMarker(new MarkerOptions().position(puntoPulsado).
	         icon(BitmapDescriptorFactory
	            .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
	   }
	   
	   public void animateCamera(View view) {
		      if (mapa.getMyLocation() != null)
		         mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
		            new LatLng( mapa.getMyLocation().getLatitude(),mapa.getMyLocation().getLongitude()), 15));
		   }
	   
	   public void moveCamera(View view) {
	         mapa.moveCamera(CameraUpdateFactory.newLatLng(UPV));
	   }
	   
	   
	

	
}
