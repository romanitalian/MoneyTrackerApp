package net.romanitalian.moneytrackerapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;

import net.romanitalian.moneytrackerapp.R;
import net.romanitalian.moneytrackerapp.adapters.TransactionAdapter;
import net.romanitalian.moneytrackerapp.models.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TransactionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private TransactionAdapter transactionAdapter;
    List<Transaction> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.fragment_transactions, container, false);

        List<Transaction> adapterData = getTransactions();
        transactionAdapter = new TransactionAdapter(adapterData);

        recyclerView = (RecyclerView) inflate.findViewById(R.id.transaction_list);
        FloatingActionButton fab = (FloatingActionButton) inflate.findViewById(R.id.fab);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(transactionAdapter);
        fab.attachToRecyclerView(recyclerView);

        return inflate;
    }

    private List<Transaction> getTransactions() {
        Bundle bundle = getArguments();
        String dateFormat = bundle.getString("dateFormat");

        DateFormat df = new SimpleDateFormat(dateFormat, new Locale("ru"));
        Date nowCalendar = Calendar.getInstance().getTime();
        String now = df.format(nowCalendar);
        data.add(new Transaction("Huawei", "9800", now));
        data.add(new Transaction("SamsungS3", "13000", now));
        data.add(new Transaction("T-shirt", "300", now));
        data.add(new Transaction("Jeans", "1500", now));
        data.add(new Transaction("Printer", "4500", now));
        return data;
    }
}

