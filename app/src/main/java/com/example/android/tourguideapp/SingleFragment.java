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


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleFragment extends Fragment {

    public SingleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /**
         * Define Single Card Elements
         */
        View singleCard = inflater.inflate(R.layout.single_fragment, container, false);
        ImageView singleImage = singleCard.findViewById(R.id.single_image);
        TextView singleHeader = singleCard.findViewById(R.id.single_header);
        TextView singleDesc = singleCard.findViewById(R.id.single_description);
        Button singleButton = singleCard.findViewById(R.id.single_button);
        Button singleMapButton = singleCard.findViewById(R.id.single_map_button);
        TextView singleContactsHeader = singleCard.findViewById(R.id.contacts_header);
        TextView singlePhoneOne = singleCard.findViewById(R.id.phone_one);
        TextView singlePhoneTwo = singleCard.findViewById(R.id.phone_two);

        final String url = getArguments().getString("url", "");
        final int image = getArguments().getInt("image", R.drawable.ic_launcher_background); // IMPORTANT IMAGE!!!
        final double lat = getArguments().getDouble("lat", 181);
        final double lon = getArguments().getDouble("lon", 181);
        final String phone1 = getArguments().getString("phone1", "");
        final String phone2 = getArguments().getString("phone2", "");

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
            // Map logic
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
        } else {
            singlePhoneOne.setVisibility(View.GONE);
            singleContactsHeader.setVisibility(View.GONE);

        }

        if (!phone2.equals("")){
            singlePhoneTwo.setVisibility(View.VISIBLE);
            singlePhoneTwo.setText(phone2);
        } else {
            singlePhoneTwo.setVisibility(View.GONE);
        }


        singleImage.setImageResource(image);
        singleHeader.setText(getArguments().getString("header", "Header"));
        singleDesc.setText(getArguments().getString("description", "Description"));


        return singleCard;
    }

}
