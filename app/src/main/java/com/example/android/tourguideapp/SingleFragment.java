package com.example.android.tourguideapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleFragment extends Fragment {

    @BindView(R.id.single_image) ImageView singleImage;
    @BindView(R.id.single_header) TextView singleHeader;
    @BindView(R.id.single_description) TextView singleDesc;
    @BindView(R.id.single_button) Button singleButton;
    @BindView(R.id.single_map_button) Button singleMapButton;
    @BindView(R.id.contacts_header) TextView singleContactsHeader;
    @BindView(R.id.phone_one) TextView singlePhoneOne;

    private Unbinder unbinder;

    public SingleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /**
         * Define Single Card Elements
         */
        View singleCard = inflater.inflate(R.layout.single_fragment, container, false);
        unbinder = ButterKnife.bind(this, singleCard);

        final String url = getArguments().getString("url", "");
        final int image = getArguments().getInt("image", R.drawable.ic_launcher_background); // IMPORTANT IMAGE!!!
        final double lat = getArguments().getDouble("lat", 181);
        final double lon = getArguments().getDouble("lon", 181);
        final String phone1 = getArguments().getString("phone1", "");

        /**
         * Url button logic
         */
        if(url.equals("")){
            singleButton.setVisibility(View.GONE);
        } else {
            singleButton.setVisibility(View.VISIBLE);
            singleButton.setText(getArguments().getString(
                    "button", getString(R.string.read_more)));

            singleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            });
        }


        /**
         * Map location button logic
         */
        if (lat < 181 && lon < 181){
            singleMapButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String mapUrl = "https://www.google.com/maps/@" + lat +
                            "," + lon +
                            ",18z";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(mapUrl));
                    startActivity(intent);
                }
            });
        } else {
            singleMapButton.setVisibility(View.GONE);
        }

        /**
         * Phone links logic
         */
        if (!phone1.equals("")){
            singlePhoneOne.setVisibility(View.VISIBLE);
            singleContactsHeader.setVisibility(View.VISIBLE);
            singlePhoneOne.setText(phone1);
            singlePhoneOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String uri = "tel:" + phone1;
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                }
            });
        } else {
            singlePhoneOne.setVisibility(View.GONE);
            singleContactsHeader.setVisibility(View.GONE);
        }

        Picasso.get().load(image).into(singleImage);
        singleHeader.setText(getArguments().getString("header", "Header"));
        singleDesc.setText(getArguments().getString("description", "Description"));


        return singleCard;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
