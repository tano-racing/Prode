package nofuemagia.prode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import nofuemagia.prode.model.Equipo;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
public class EquiposAdapter extends BaseAdapter {


    private final Context mContext;
    private final List<Equipo> mDataSet;

    public EquiposAdapter(Context context, List<Equipo> dataset) {
        mContext = context;
        mDataSet = dataset;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Equipo getItem(int i) {
        return mDataSet.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mDataSet.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Equipo equipo = mDataSet.get(i);

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

        holder.tvEquipo.setText(equipo.getNombre());

        return v;
    }

    private class ViewHolder {
        public TextView tvEquipo;
    }
}
