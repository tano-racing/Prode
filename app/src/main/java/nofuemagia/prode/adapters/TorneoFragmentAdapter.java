package nofuemagia.prode.adapters;

import android.content.Context;
import android.os.Bundle;
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
    private final Bundle mArguments;

    private String[] mNombres = new String[]{"Posiciones", "Pronostico"};

    public TorneoFragmentAdapter(FragmentManager fm, Context c, Bundle arguments) {
        super(fm);
        mContext = c;
        mArguments = arguments;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Fragment.instantiate(mContext, PosicionesFragment.class.getName(), mArguments);
            case 1:
                return Fragment.instantiate(mContext, PronosticoFragment.class.getName(), mArguments);
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
