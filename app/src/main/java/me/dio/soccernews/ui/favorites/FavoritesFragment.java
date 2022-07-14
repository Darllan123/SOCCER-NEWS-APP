package me.dio.soccernews.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import me.dio.soccernews.MainActivity;
import me.dio.soccernews.databinding.FragmentFavoritesBinding;
import me.dio.soccernews.domain.News;
import me.dio.soccernews.ui.adapter.NewsAdapter;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel FavoritesViewModel =
                new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = binding.inflate(inflater, container, false);

        MainActivity activity = (MainActivity) getActivity();
        List<News> favoriteNews = activity.getDb().newsDao().loadFavoriteNews();
        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvNews.setAdapter(new NewsAdapter(favoriteNews , upDatedNews -> {

                activity.getDb().newsDao().save(upDatedNews);



            }));



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}