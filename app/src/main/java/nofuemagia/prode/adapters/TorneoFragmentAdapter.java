package nofuemagia.prode.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import nofuemagia.prode.fragments.PosicionesFragment;
import nofuemagia.prode.fragments.PronosticoFragment;

/**
 * Created by Tano on 02/07/2016.
 */
public class TorneoFragmentAdapter extends FragmentStatePagerAdapter {

    private final Context mContext;
    private String[] mNombres = new String[]{"Posiciones", "Pronostico"};

    public TorneoFragmentAdapter(FragmentManager fm, Context c) {
        super(fm);
        mContext = c;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Fragment.instantiate(mContext, PosicionesFragment.class.getName(), null);
            case 1:
                return Fragment.instantiate(mContext, PronosticoFragment.class.getName(), null);
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mNombres[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
