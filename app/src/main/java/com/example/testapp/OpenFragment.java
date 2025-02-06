package com.example.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class OpenFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_open, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_open);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<String> profiles = Arrays.asList(
                "Anna - Rank A", "Chris - Rank B", "Sophia - Rank C",
                "Michael - Rank A", "Emma - Rank B", "Daniel - Rank C",
                "Olivia - Rank A", "Liam - Rank B", "Isabella - Rank C",
                "Ethan - Rank A", "Ava - Rank B", "Mason - Rank C",
                "Charlotte - Rank A", "James - Rank B", "Amelia - Rank C",
                "Benjamin - Rank A", "Mia - Rank B", "Lucas - Rank C",
                "Harper - Rank A", "Henry - Rank B", "Jack - Rank C",
                "Ella - Rank A", "Logan - Rank B", "Sophie - Rank C"
        );

        ProfileAdapter adapter = new ProfileAdapter(profiles);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private static class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
        private final List<String> profiles;

        public ProfileAdapter(List<String> profiles) {
            this.profiles = profiles;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(profiles.get(position));
        }

        @Override
        public int getItemCount() {
            return profiles.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
