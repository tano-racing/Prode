package nofuemagia.prode.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nofuemagia.prode.R;
import nofuemagia.prode.adapters.PosicionesAdapter;
import nofuemagia.prode.model.UsuarioTorneo;

/**
 * Created by Tano on 02/07/2016.
 */
public class PosicionesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private PosicionesAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_posiciones, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_posiciones);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        Bundle args = getArguments();

        List<UsuarioTorneo> participantes = UsuarioTorneo.getParticipantes(args.getLong("ID"));
        mAdapter = new PosicionesAdapter(participantes);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }
}
