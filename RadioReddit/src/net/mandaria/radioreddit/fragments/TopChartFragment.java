package net.mandaria.radioreddit.fragments;

import net.mandaria.radioreddit.R;
import net.mandaria.radioreddit.RadioRedditApplication;
import net.mandaria.radioreddit.tasks.GetTopChartTask;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.SherlockFragment;


public class TopChartFragment extends SherlockFragment {
	
	private String _type = "";

	public TopChartFragment()
	{
	
	}
	
	public TopChartFragment(String type)
	{
		_type = type;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.topchart, container, false);
	}

	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setUserVisibleHint(true);
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		if(_type.equals("all") || _type.equals("month") || _type.equals("week") || _type.equals("day"))
		{
			// TODO: cache results to memory?
			//	if(application.TopCharts[_type] == null)
			new GetTopChartTask((RadioRedditApplication)getActivity().getApplication(), getActivity(), getView(), _type).execute();
			//  else
			//		GetTopChartTask.drawResultsToActivity(
		}
		
		Button btn_TryAgain_TopChart = (Button)getView().findViewById(R.id.btn_TryAgain_TopChart);
		btn_TryAgain_TopChart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(_type.equals("all") || _type.equals("month") || _type.equals("week") || _type.equals("day"))
				{
					new GetTopChartTask((RadioRedditApplication)getActivity().getApplication(), getActivity(), getView(), _type).execute();
				}
			}
		});
	}
}