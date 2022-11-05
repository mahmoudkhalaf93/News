package com.example.news.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;
import com.example.news.database.NewsEgypt;
import com.example.news.databinding.ListItemTopBannerBinding;
import com.squareup.picasso.Picasso;

public class TopBannerAdapter extends ListAdapter<NewsEgypt, TopBannerAdapter.TopBannerViewHolder> {
    GoToDetailsScreenListener detailsScreenListener;
    SaveToBookMarkListener bookmarkClickListener;

    protected TopBannerAdapter(GoToDetailsScreenListener detailsScreenListener, SaveToBookMarkListener bookmarkClickListener) {
        super(new TopBannerDiffCallback());
        this.detailsScreenListener = detailsScreenListener;
        this.bookmarkClickListener = bookmarkClickListener;
    }

    @NonNull
    @Override
    public TopBannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemTopBannerBinding binding = ListItemTopBannerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TopBannerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopBannerViewHolder holder, int position) {
        NewsEgypt news = getItem(position);
        holder.bind(news);
    }



    public abstract static class GoToDetailsScreenListener {
        public abstract void onClickListener(int newsId);
    }

    public static class TopBannerDiffCallback extends DiffUtil.ItemCallback<NewsEgypt> {
        @Override
        public boolean areItemsTheSame(@NonNull NewsEgypt oldItem, @NonNull NewsEgypt newItem) {
            return (oldItem.getId() == newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull NewsEgypt oldItem, @NonNull NewsEgypt newItem) {
            return oldItem.equals(newItem);
        }


    }

    public abstract static class SaveToBookMarkListener {
        public abstract void onClickListener(NewsEgypt news);
    }

    class TopBannerViewHolder extends RecyclerView.ViewHolder {
        private final ListItemTopBannerBinding binding;

        public TopBannerViewHolder(@NonNull ListItemTopBannerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(NewsEgypt news) {
            binding.setDetailsScreenListener(detailsScreenListener);
            binding.setSaveToBookmarkListener(bookmarkClickListener);
            if (news.getInFavorite())
                binding.bookmarkButton.setImageResource(R.drawable.bookmark_white_24);
            else
                binding.bookmarkButton.setImageResource(R.drawable.bookmark_border_white_24);
            binding.setNews(news);
            Picasso.get().load(news.getUrlToImage()).into(binding.imageBackground);
            binding.time.setText(news.getPublishedAt());
            binding.title.setText(news.getTitle());
        }

    }
}
