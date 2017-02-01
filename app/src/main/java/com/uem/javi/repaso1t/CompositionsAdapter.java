package com.uem.javi.repaso1t;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CompositionsAdapter extends BaseAdapter {

    // context aqui hace referencia a MainActivity
    Context contexto;
    Compositions comps;

    public CompositionsAdapter(Context cont, Compositions comps){
        this.contexto = cont;
        this.comps = comps;
    }

    @Override
    public int getCount() {
        return comps.getComps().length;
    }

    @Override
    public Object getItem(int i) {
        return comps.getComps()[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder vHolder;

        // la primera vez que se ejecuta view
        if(view == null){
            // infla el item que queremos usar
            view = LayoutInflater.from(contexto).inflate(R.layout.composition_item, null);
            vHolder = new ViewHolder();
            // relaciona los views con los ids
            vHolder.tvCompType = (TextView)view.findViewById(R.id.tvCompType);
            vHolder.tvCompRange = (TextView)view.findViewById(R.id.tvCompRange);
            vHolder.tvCompYears = (TextView)view.findViewById(R.id.tvCompYears);

            view.setTag(vHolder);
        }
        else{
            vHolder = (ViewHolder)view.getTag();
        }
        vHolder.tvCompType.setText(comps.getComps()[i].getName());
        vHolder.tvCompRange.setText(comps.getComps()[i].getBMVRange());
        vHolder.tvCompYears.setText(comps.getComps()[i].getYear());

        return view;
    }

    // clase interna
    // aqui incluiremos los elementos del item que tengan funcionalidad
    private static class ViewHolder{
        TextView tvCompType, tvCompYears, tvCompRange;
    }
}
