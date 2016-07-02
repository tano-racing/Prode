package nofuemagia.prode.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nofuemagia.prode.R;
import nofuemagia.prode.adapters.TorneoFragmentAdapter;

/**
 * Created by Tano on 02/07/2016.
 */
public class TorneoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_torneos, container, false);

        TabLayout tabPlanos = (TabLayout) v.findViewById(R.id.tabs_torneo);

        ViewPager pager = (ViewPager) v.findViewById(R.id.viewpager_torneo);
        TorneoFragmentAdapter adapter = new TorneoFragmentAdapter(getFragmentManager(), getContext());

        pager.setAdapter(adapter);
        tabPlanos.setupWithViewPager(pager);

        return v;
    }
}
