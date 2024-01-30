package com.example.spacextrackerapp.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacextrackerapp.R;
import com.example.spacextrackerapp.databinding.DashboardViewItemHolderBinding;
import com.example.spacextrackerapp.model.FlightItemDetails;
import com.example.spacextrackerapp.viewmodels.LaunchesViewModel;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.ViewHolder> {

    private final List<FlightItemDetails> flightItemDetailsList;
    Activity activity;
    ActionListener listener;
    LaunchesViewModel viewModel;

    public LaunchesAdapter(Activity activity, List<FlightItemDetails> flightItemDetails,LaunchesViewModel viewModel, ActionListener listener) {
        this.flightItemDetailsList = flightItemDetails;
        this.activity = activity;
        this.listener = listener;
        this.viewModel = viewModel;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        DashboardViewItemHolderBinding binding = DashboardViewItemHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        FlightItemDetails modelObject = flightItemDetailsList.get(position);

        if (checkIsFavourite(modelObject.flightNumber))
            holder.binding.buttonFav.setImageResource(R.drawable.ic_baseline_star_rate_24);
        else
            holder.binding.buttonFav.setImageResource(R.drawable.ic_favorite);

        holder.binding.textViewMissionName.setText(modelObject.getMissionName());
        holder.binding.textViewRocketName.setText(modelObject.getRocket().getRocketName());


        holder.binding.textViewLaunchDate.setText(getDate(modelObject.getLaunchDateUtc()));
        if (modelObject.getLaunchSuccess() != null) {
            if (modelObject.getLaunchSuccess()) {
                holder.binding.textViewLaunchStatus.setText(R.string.successful);
                holder.binding.textViewLaunchStatus.setTextColor(activity.getResources().getColor(R.color.status_green_text_color));
                holder.binding.imgVerified.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_verified));
            } else {
                holder.binding.textViewLaunchStatus.setText(R.string.failed);
                holder.binding.textViewLaunchStatus.setTextColor(activity.getResources().getColor(R.color.status_red_text_color));
                holder.binding.imgVerified.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_failed));
            }
        }

        Picasso.get().load(modelObject.getLinks().getMissionPatchSmall()).into(holder.binding.imgProfile);
        holder.binding.getRoot().setOnClickListener(view -> listener.onCardClick(modelObject));
        holder.binding.buttonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isFav = checkIsFavourite(modelObject.flightNumber);
                if (isFav) {
                    //already added fav
                    listener.removeFavorite(modelObject);
                    holder.binding.buttonFav.setImageResource(R.drawable.ic_favorite);
                }
                else {
                    listener.addFavorite(modelObject);
                    holder.binding.buttonFav.setImageResource(R.drawable.ic_baseline_star_rate_24);
                }
            }
        });
    }

    private String getDate(String launchDateUtc) {
        String output = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             output =
                    Instant.parse ( launchDateUtc)
                            .atZone ( ZoneId.of ( "Asia/Kolkata" ) )
                            .format (
                                    DateTimeFormatter.ofLocalizedDateTime ( FormatStyle.MEDIUM )
                                            .withLocale ( Locale.UK )
                            );
        }
        return output;
    }

    private boolean checkIsFavourite(Integer flightNumber) {
        return false;
        //return viewModel.getIsFavorite(flightNumber);
    }

    @Override
    public int getItemCount() {
        return flightItemDetailsList == null ? 0 :
                flightItemDetailsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        DashboardViewItemHolderBinding binding ;

        public ViewHolder(DashboardViewItemHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface ActionListener {
        public void onCardClick(FlightItemDetails flightItemDetails);
        public void addFavorite(FlightItemDetails flightItemDetails);
        public void removeFavorite(FlightItemDetails flightItemDetails);
    }
}

