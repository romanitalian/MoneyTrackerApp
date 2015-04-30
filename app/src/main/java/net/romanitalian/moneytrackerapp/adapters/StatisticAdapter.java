package net.romanitalian.moneytrackerapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.romanitalian.moneytrackerapp.R;
import net.romanitalian.moneytrackerapp.models.Statistic;

import java.util.List;

public class StatisticAdapter extends ArrayAdapter<Statistic> {
    List<Statistic> categories;

    public StatisticAdapter(Context context, List<Statistic> statistic) {
        super(context, 0, statistic);
        this.categories = statistic;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Statistic categories = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title_id);

        title.setText(categories.getTitle());
        return convertView;
    }
}