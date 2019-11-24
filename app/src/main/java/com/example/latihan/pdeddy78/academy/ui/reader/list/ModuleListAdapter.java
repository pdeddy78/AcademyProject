package com.example.latihan.pdeddy78.academy.ui.reader.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan.pdeddy78.academy.R;
import com.example.latihan.pdeddy78.academy.data.ModuleEntity;

import java.util.ArrayList;
import java.util.List;

public class ModuleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final MyAdapterClickListener listener;
    private List<ModuleEntity> modules = new ArrayList<>();

    public ModuleListAdapter(MyAdapterClickListener listener) {
        this.listener = listener;
    }

    public void setModules(List<ModuleEntity> modules) {
        if (modules == null) return;
        this.modules.clear();
        this.modules.addAll(modules);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ModuleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items_module_list_custom, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ModuleEntity module = modules.get(position);
        ModuleViewHolder moduleViewHolder = (ModuleViewHolder) holder;
        moduleViewHolder.bind(module.getmTitle());
        moduleViewHolder.itemView.setOnClickListener(v -> {
            listener.onItemClicked(holder.getAdapterPosition(), modules.get(moduleViewHolder.getAdapterPosition()).getmModuleId());
        });
    }

    @Override
    public int getItemCount() {
        return modules.size();
    }

    class ModuleViewHolder extends RecyclerView.ViewHolder {

        final TextView textTitle;
        final TextView textLastSeen;

        ModuleViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_module_title);
            textLastSeen = itemView.findViewById(R.id.text_last_seen);
        }

        void bind(String title) {
            textTitle.setText(title);
        }
    }
}

interface MyAdapterClickListener {
    void onItemClicked(int position, String moduleId);
}