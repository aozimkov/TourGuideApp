package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_list, container, false);

        final ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(
                R.drawable.food1,
                "Якитория",
                "Адрес: ул. Чугунова, 15a, Раменское, Московская обл., 140105\n" +
                        "Время работы: \n" +
                        "среда\t11:00–23:59\n" +
                        "четверг\t11:00–23:59\n" +
                        "пятница\t11:00–5:00\n" +
                        "суббота\t11:00–5:00\n" +
                        "воскресенье\t11:00–23:59\n" +
                        "понедельник\t11:00–23:59\n" +
                        "вторник\t11:00–23:59\n",
                "http://www.yakitoriya.ru/",
                55.576628, 38.207794,
                "+74964658107", ""));

        cards.add(new Card(
                R.drawable.food2,
                "Бургер Кинг",
                "Адрес: ТЦ Галерея, ул. Чугунова, 15А, Раменское, Московская обл., 140105\n" +
                        "Время работы: \n" +
                        "среда\t10:00–23:00\n" +
                        "четверг\t10:00–23:00\n" +
                        "пятница\t10:00–23:00\n" +
                        "суббота\t10:00–23:00\n" +
                        "воскресенье\t10:00–23:00\n" +
                        "понедельник\t10:00–23:00\n" +
                        "вторник\t10:00–23:00\n",
                "http://burgerking.ru/",
                55.576628, 38.207794,
                "+74955445000",
                ""));

        cards.add(new Card(
                R.drawable.food3,
                "Ми-Ля",
                "Адрес: ул. Михалевича, 2, Раменское, Московская обл., 140100\n" +
                        "Время работы: \n" +
                        "среда\t11:00–0:00\n" +
                        "четверг\t11:00–0:00\n" +
                        "пятница\t11:00–0:00\n" +
                        "суббота\t11:00–0:00\n" +
                        "воскресенье\t11:00–0:00\n" +
                        "понедельник\t11:00–0:00\n" +
                        "вторник\t11:00–0:00\n",
                "http://www.ми-ля.рф/",
                55.568324, 38.225784,
                "+74964617399",
                ""));

        cards.add(new Card(
                R.drawable.food4,
                "Кафе Хинкальная",
                "Адрес: ул. Куйбышева, 39-а, Раменское, Московская обл., 140100" +
                        "Время работы: \n" +
                        "среда\t11:00–23:00\n" +
                        "четверг\t11:00–23:00\n" +
                        "пятница\t11:00–23:00\n" +
                        "суббота\t11:00–0:00\n" +
                        "воскресенье\t11:00–0:00\n" +
                        "понедельник\t11:00–23:00\n" +
                        "вторник\t11:00–23:00\n",
                "http://cafe-hinkali.ru",
                55.564813, 38.201010,
                "+74964619024",
                ""));

        cards.add(new Card(
                R.drawable.food5,
                "Пицца О'Кей",
                "Адрес: д., ул. Карла Маркса, 5, Раменское, Московская обл., 140100\n" +
                        "Время работы: \n" +
                        "среда\t24 часа в сутки\n" +
                        "четверг\t24 часа в сутки\n" +
                        "пятница\t24 часа в сутки\n" +
                        "суббота\t24 часа в сутки\n" +
                        "воскресенье\t24 часа в сутки\n" +
                        "понедельник\t24 часа в сутки\n" +
                        "вторник\t24 часа в сутки\n",
                "http://pizza-okey.ru/",
                55.569372, 38.223252,
                "+74964616161",
                ""));

        cards.add(new Card(
                R.drawable.food6,
                "Conquistador",
                "Адрес: Северное ш., 10, Раменское, Московская обл., 140105\n" +
                        "Время работы: \n" +
                        "среда\t12:00–0:00\n" +
                        "четверг\t12:00–0:00\n" +
                        "пятница\t12:00–0:00\n" +
                        "суббота\t12:00–0:00\n" +
                        "воскресенье\t12:00–0:00\n" +
                        "понедельник\t12:00–0:00\n" +
                        "вторник\t12:00–0:00\n",
                "",
                5.582931, 38.222442,
                "+79165648989",
                ""));


        CardAdapter adapter = new CardAdapter(getActivity(), cards, "list");
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Card currentCard = cards.get(i);
                Intent intent = new Intent();

                if(currentCard.hasCardImage()) intent.putExtra(
                        "image", currentCard.getmImage());
                if(currentCard.hasUrl()) {
                    intent.putExtra("url", currentCard.getmUrl());
                    intent.putExtra("button", getString(R.string.open_in_browser));
                }

                if(currentCard.hasCardFirstContact()){
                    intent.putExtra("phone1", currentCard.getmContactOne());
                }

                if(currentCard.hasCardSecondContact()){
                    intent.putExtra("phone2", currentCard.getmContactOne());
                }

                if(currentCard.hasCoordinates()){
                    intent.putExtra("lat", currentCard.getmLat());
                    intent.putExtra("lon", currentCard.getmLon());
                }

                intent.putExtra("header", currentCard.getmHeader());
                intent.putExtra("description", currentCard.getmDescription());

                intent.setClass(getActivity(), SingleActivity.class);
                startActivity(intent);

            }
        });

        return rootView;
    }

}
