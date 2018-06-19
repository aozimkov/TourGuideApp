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

        View singleCard = inflater.inflate(R.layout.single_fragment, container, false);
        ImageView singleImage = singleCard.findViewById(R.id.single_image);
        TextView singleHeader = singleCard.findViewById(R.id.single_header);
        TextView singleDesc = singleCard.findViewById(R.id.single_description);
        Button singleButton = singleCard.findViewById(R.id.single_button);

        final String url = getArguments().getString("url", "");

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

        singleImage.setImageResource(getArguments().getInt("image", -1));
        singleHeader.setText(getArguments().getString("header", "Header"));
        singleDesc.setText(getArguments().getString("description", "Description"));


        return singleCard;
    }

}
