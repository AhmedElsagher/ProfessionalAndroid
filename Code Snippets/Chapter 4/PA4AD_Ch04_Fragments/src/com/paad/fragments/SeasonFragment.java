package com.paad.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

/**
 * MOVED TO PA4AD_Ch04_Seasons
 */
public class SeasonFragment extends DialogFragment {

	public interface OnSeasonSelectedListener {
		public void onSeasonSelected(Season season);
	}

	private OnSeasonSelectedListener onSeasonSelectedListener;
	private Season currentSeason;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			Season s = new Season();
			s.s = "fragment";
			onSeasonSelectedListener = (OnSeasonSelectedListener) activity;
			setSeason(s);

		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnSeasonSelectedListener");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Fragment Dialog");
		builder.setIconAttribute(R.drawable.ic_launcher);
		builder.setPositiveButton(R.string.app_name, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});
		builder.setNegativeButton(R.string.app_name, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});
		return builder.create();
	}

	private void setSeason(Season season) {
		currentSeason = season;
		onSeasonSelectedListener.onSeasonSelected(season);
	}

}
