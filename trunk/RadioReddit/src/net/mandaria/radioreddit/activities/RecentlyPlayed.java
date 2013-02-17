package net.mandaria.radioreddit.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import com.actionbarsherlock.view.MenuInflater;
import net.mandaria.radioreddit.R;
import net.mandaria.radioreddit.R.layout;
import net.mandaria.radioreddit.activities.TopCharts.TabsAdapter;
import net.mandaria.radioreddit.fragments.SongListFragment;

import com.viewpagerindicator.TabPageIndicator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class RecentlyPlayed extends SherlockFragmentActivity
{
	int _currentFragmentPage = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recentlyplayed);   
        
        getSupportActionBar().setTitle(getString(R.string.recentlyplayed));
        
        FragmentPagerAdapter adapter = new TabsAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setOffscreenPageLimit(1);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        indicator.setOnPageChangeListener(new OnPageChangeListener() {
			
        	@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
        		_currentFragmentPage = position;
            	invalidateOptionsMenu();
			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				// TODO Auto-generated method stub
				
			}
			

		});
        
    }
    
    class TabsAdapter extends FragmentPagerAdapter {
        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }
        

        @Override
        public Fragment getItem(int position) {
        	Fragment fragment = new Fragment();
        	switch(position)
        	{
        		case 0:
        			fragment = new SongListFragment("recentlyplayed_songs");
        			break;
        		case 1:
        			fragment = new SongListFragment("recentlyplayed_episodes");
        			break;
        		default:
        			fragment = new SongListFragment("recentlyplayed_songs");
        			break;
        	}
        	
            return fragment;
        }

        public CharSequence getPageTitle(int position) {
        	
        	String pageTitle = "";
        	switch(position)
        	{
        		case 0:
        			pageTitle = "Songs";
        			break;
        		case 1:
        			pageTitle = "Episodes";
        			break;
        		default:
        			pageTitle = "Songs";
        			break;
        	}
        	return pageTitle;
        }

        @Override
        public int getCount() {
          return 2;
        }
    }
    
    @Override
    public void onResume()
    {
    	super.onResume();
    }
    
    
    @Override
	public boolean onPrepareOptionsMenu(com.actionbarsherlock.view.Menu menu)
	{		
		return true;
	}
    
    @Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) 
    {	
    	super.onCreateOptionsMenu(menu);		
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) 
	{
		return false;
	}
 
}