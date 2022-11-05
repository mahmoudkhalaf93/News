package com.example.news.ui.home;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.news.database.NewsDatabase;
import com.example.news.database.NewsDatabaseDao;
import com.example.news.database.NewsEgypt;
import com.example.news.databinding.FragmentHomeBinding;
import com.example.news.network.NewsApiConnect;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        Application application = requireActivity().getApplication();

        NewsDatabaseDao newsDatabaseDao = NewsDatabase.getInstance(requireContext()).getDao();

        HomeViewModelFactory factory = new HomeViewModelFactory(application, NewsApiConnect.getInstance(), newsDatabaseDao);
        HomeViewModel homeViewModel =
                new ViewModelProvider(this, factory).get(HomeViewModel.class);

        TopBannerAdapter.GoToDetailsScreenListener goToDetailsScreenListener = new TopBannerAdapter.GoToDetailsScreenListener() {
            @Override
            public void onClickListener(int newsId) {
                //TODO go to details screen
            }
        };
        TopBannerAdapter.SaveToBookMarkListener saveToBookMarkListener = new TopBannerAdapter.SaveToBookMarkListener() {
            @Override
            public void onClickListener(NewsEgypt news) {
                homeViewModel.addNewsEgyptToFavorite(news);
            }
        };

        TopBannerAdapter topBannerAdapter = new TopBannerAdapter(goToDetailsScreenListener, saveToBookMarkListener);

        homeViewModel.listofNewsEgypt.observe(getViewLifecycleOwner(), newsEgypts -> {
            if (newsEgypts != null && newsEgypts.size() > 0) {
                topBannerAdapter.submitList(newsEgypts);
            }
        });
        binding.topBanner.setAdapter(topBannerAdapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}