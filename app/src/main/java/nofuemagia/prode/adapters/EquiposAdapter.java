package nofuemagia.prode.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import nofuemagia.prode.Util;
import nofuemagia.prode.model.Equipo;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
public class EquiposAdapter extends ArrayAdapter<Equipo> {


    private final Context mContext;
    private final List<Equipo> mDataSet;

    public EquiposAdapter(Context context, List<Equipo> dataset) {
        super(context, android.R.layout.select_dialog_item, android.R.id.text1, dataset);
        mContext = context;
        mDataSet = dataset;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        TextView tv = (TextView) v.findViewById(android.R.id.text1);

        Equipo usado = mDataSet.get(position);

        int res = Util.getResId(mContext, usado.getNombre().toLowerCase().replace(" ", ""), "mipmap");
        if (res > 0) {
            Drawable dr = ContextCompat.getDrawable(mContext, res);
            Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
            Drawable d = new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(bitmap, 75, 75, true));

            tv.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
        } else
            tv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        //Add margin between image and text (support various screen densities)
        int dp5 = (int) (5 * mContext.getResources().getDisplayMetrics().density + 0.5f);
        tv.setCompoundDrawablePadding(dp5);
        tv.setText(usado.getNombre());

        return v;
    }
}
