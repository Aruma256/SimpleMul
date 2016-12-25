package com.github.obsproth.simplemul;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private RecyclerView recyclerView;
    private List<Formula> dataList;
    private LayoutInflater inflater;

    public MyRecyclerAdapter(Context context) {
        this.dataList = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.recycler_element, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Formula formula = dataList.get(position);
        holder.textValA.setText(String.valueOf(formula.valA));
        holder.textValB.setText(String.valueOf(formula.valB));
        holder.textOperator.setText(formula.isMul ? String.valueOf("*") : String.valueOf("/"));
        holder.textAns.setText(String.valueOf(formula.ans));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    void addItem(Formula formula) {
        dataList.add(formula);
        notifyItemInserted(dataList.size() - 1);
        recyclerView.scrollToPosition(dataList.size() - 1);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textValA, textValB, textOperator, textAns;

        ViewHolder(View itemView) {
            super(itemView);
            textValA = (TextView) itemView.findViewById(R.id.elem_text_val_a);
            textValB = (TextView) itemView.findViewById(R.id.elem_text_val_b);
            textOperator = (TextView) itemView.findViewById(R.id.elem_text_operator);
            textAns = (TextView) itemView.findViewById(R.id.elem_text_ans);
        }
    }
}