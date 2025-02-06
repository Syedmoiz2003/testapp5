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

public class AllFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_all);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<String> profiles = Arrays.asList(
                "John - Rank 1", "Alice - Rank 2", "Bob - Rank 3", "Eve - Rank 4",
                "Michael - Rank 5", "Sophia - Rank 6", "Daniel - Rank 7", "Olivia - Rank 8",
                "James - Rank 9", "Emma - Rank 10", "Lucas - Rank 11", "Mia - Rank 12",
                "Benjamin - Rank 13", "Ava - Rank 14", "Elijah - Rank 15", "Charlotte - Rank 16",
                "Henry - Rank 17", "Amelia - Rank 18", "Alexander - Rank 19", "Harper - Rank 20"
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
