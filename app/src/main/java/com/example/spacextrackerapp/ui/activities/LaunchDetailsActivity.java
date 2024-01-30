package com.example.spacextrackerapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.spacextrackerapp.R;
import com.example.spacextrackerapp.databinding.ActivityDashboardBinding;
import com.example.spacextrackerapp.databinding.ActivityLaunchDetailsBinding;
import com.example.spacextrackerapp.model.FlightItemDetails;
import com.squareup.picasso.Picasso;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LaunchDetailsActivity extends AppCompatActivity {

    public FlightItemDetails flightItemDetails;
    ActivityLaunchDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLaunchDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        flightItemDetails = (FlightItemDetails) getIntent().getSerializableExtra("LaunchDetails");

        try {

            Picasso.get().load(flightItemDetails.getLinks().getMissionPatch()).into(binding.imgProfile);

            binding.titleTextView.setText(flightItemDetails.getMissionName());
            binding.textViewLaunchDate.setText(getDate(flightItemDetails.getLaunchDateUtc()));
            binding.textViewDiscription.setText(flightItemDetails.getDetails());
            binding.rocketName.setText(flightItemDetails.getRocket().getRocketName());
            binding.rocketType.setText(flightItemDetails.getRocket().getRocketType());
            binding.rocketNationality.setText(flightItemDetails.getRocket().getSecondStage().getPayloads().get(0).getNationality());
            binding.rocketPayloadType.setText(flightItemDetails.getRocket().getSecondStage().getPayloads().get(0).getPayloadType());
            String stringMassKg= Double.toString(flightItemDetails.getRocket().getSecondStage().getPayloads().get(0).getPayloadMassKg());
            binding.rocketPayloadMassKg.setText(stringMassKg);

            String stringMasslbs= Double.toString(flightItemDetails.getRocket().getSecondStage().getPayloads().get(0).getPayloadMassLbs());
            binding.rocketPayloadMasslbs.setText(stringMasslbs);
            binding.rocketOrbit.setText(flightItemDetails.getRocket().getSecondStage().getPayloads().get(0).getOrbit());
            binding.launchLocation.setText(flightItemDetails.getLaunchSite().getSiteNameLong());
            binding.launchStatus.setText(flightItemDetails.getLaunchSuccess() ? "Success" : "Failed");
            binding.launchReason.setText(flightItemDetails.getLaunchFailureDetails().getReason());

            if (flightItemDetails.getLaunchSuccess()){
                binding.textViewStatus.setText(R.string.successful);
                binding.textViewStatus.setTextColor(getResources().getColor(R.color.status_green_text_color));
                binding.imgVerified.setImageDrawable(getResources().getDrawable(R.drawable.ic_verified));
            }else {
                binding.textViewStatus.setText(R.string.failed);
                binding.textViewStatus.setTextColor(getResources().getColor(R.color.status_red_text_color));
                binding.imgVerified.setImageDrawable(getResources().getDrawable(R.drawable.ic_failed));
            }

            if (flightItemDetails.getLinks().getArticleLink() == null) {
                binding.btnArticleLink.setVisibility(View.GONE);
            }else{
                binding.btnArticleLink.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getArticleLink()));
            }

            if (flightItemDetails.getLinks().getMissionPatch() == null) {
                binding.btnMissionPatch.setVisibility(View.GONE);
            }else{
                binding.btnMissionPatch.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getMissionPatch()));
            }

            if (flightItemDetails.getLinks().getPresskit() == null) {
                binding.btnPresskit.setVisibility(View.GONE);
            }else{
                binding.btnPresskit.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getPresskit().toString()));
            }

            if (flightItemDetails.getLinks().getRedditCampaign() == null) {
                binding.btnRedditCampaign.setVisibility(View.GONE);
            }else{
                binding.btnRedditCampaign.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getRedditCampaign().toString()));
            }

            if (flightItemDetails.getLinks().getRedditMedia() == null) {
                binding.btnRedditMedia.setVisibility(View.GONE);
            }else{
                binding.btnRedditMedia.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getRedditMedia().toString()));
            }


            if (flightItemDetails.getLinks().getRedditRecovery() == null) {
                binding.btnRedditRecovery.setVisibility(View.GONE);
            }else{
            binding.btnRedditRecovery.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getRedditRecovery().toString()));
        }

            if (flightItemDetails.getLinks().getVideoLink() == null) {
                binding.btnVideoLink.setVisibility(View.GONE);
            }else{
                binding.btnVideoLink.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getVideoLink()));
            }

            if (flightItemDetails.getLinks().getWikipedia() == null) {
                binding.btnWikipedia.setVisibility(View.GONE);
            }else{
                binding.btnWikipedia.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getWikipedia()));
            }
            if (flightItemDetails.getLinks().getYoutubeId() == null) {
                binding.btnYoutubeId.setVisibility(View.GONE);
            }else{
                binding.btnYoutubeId.setOnClickListener(view1 -> openPage(flightItemDetails.getLinks().getYoutubeId()));
            }
        }catch (Exception e){
            Log.e("Exception",e.getMessage());
        }

        binding.closeImageView.setOnClickListener(view1 -> finish());

    }

    private void openPage(String stringUrl) {
        Log.e("urlo ",stringUrl);

        Uri webpage = Uri.parse(stringUrl);
/*
        if (!stringUrl.startsWith("http://") && !stringUrl.startsWith("https://")) {
            webpage = Uri.parse("http://" + stringUrl);
        }*/
        Log.e("url1 ",stringUrl);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(stringUrl));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else {

        }

    }

    private String getDate(String launchDateUtc) {
        String output = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            output =
                    Instant.parse ( launchDateUtc)
                            .atZone ( ZoneId.of ( "Asia/Kolkata" ) )
                            .format (
                                    DateTimeFormatter.ofLocalizedDateTime ( FormatStyle.LONG )
                                            .withLocale ( Locale.UK )
                            );
        }
        return output;
    }
}