package nofuemagia.prode.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nofuemagia.prode.R;
import nofuemagia.prode.model.UsuarioTorneo;

/**
 * Created by Tano on 02/07/2016.
 */
public class PosicionesAdapter extends RecyclerView.Adapter<PosicionesAdapter.ViewHolder> {


    private final List<UsuarioTorneo> mDataSet;

    public PosicionesAdapter(List<UsuarioTorneo> dataset) {
        mDataSet = dataset;
    }

    @Override
    public PosicionesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posiciones, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PosicionesAdapter.ViewHolder holder, int position) {
        UsuarioTorneo actual = mDataSet.get(position);

        String pospri = "";
        if (position == 0)
            pospri = "{fa-star @color/oro}";
        else if (position == 1)
            pospri = "{fa-star @color/plata}";
        else if (position == 2)
            pospri = "{fa-star @color/bronce}";

        holder.tvNumero.setText(pospri + String.valueOf(position + 1));
        holder.tvNombre.setText(actual.getUsuario().getNombre());
        holder.tvPuntos.setText(String.valueOf(actual.getPuntos()));
        holder.tvAciertos.setText(String.valueOf(actual.getPronosticosAcertados()));
        holder.tvTotales.setText(String.valueOf(actual.getPronosticosTotales()));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvNumero;
        private final TextView tvNombre;
        private final TextView tvPuntos;
        private final TextView tvAciertos;
        private final TextView tvTotales;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNumero = (TextView) itemView.findViewById(R.id.item_posicion_n);
            tvNombre = (TextView) itemView.findViewById(R.id.item_posicion_nombre);
            tvPuntos = (TextView) itemView.findViewById(R.id.item_posicion_puntos);
            tvAciertos = (TextView) itemView.findViewById(R.id.item_posicion_acertados);
            tvTotales = (TextView) itemView.findViewById(R.id.item_posicion_totales);
        }
    }
}
