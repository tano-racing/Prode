package nofuemagia.prode.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import nofuemagia.prode.R;
import nofuemagia.prode.model.Liga;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
public class LigasAdapter extends BaseAdapter {


    private final Context mContext;
    private final List<Liga> mDataSet;

    public LigasAdapter(Context context, List<Liga> dataset) {
        mContext = context;
        mDataSet = dataset;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Liga getItem(int i) {
        return mDataSet.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mDataSet.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Liga liga = mDataSet.get(i);

        View v = convertView;
        ViewHolder holder;
        if (null == v) {
            holder = new ViewHolder();

            v = LayoutInflater.from(mContext).inflate(R.layout.item_equipo, viewGroup, false);
            holder.tvEquipo = (TextView) v.findViewById(R.id.tv_equipo_item);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.tvEquipo.setText(String.format("%s (%s)", liga.getNombre(), liga.getPais().getNombre()));

        return v;
    }

    private class ViewHolder {
        public TextView tvEquipo;
    }
}
