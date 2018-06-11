package com.example.android.tourguideapp;


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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_list, container, false);

        final ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(
                R.drawable.hotel1,
                "Апартаменты на Высоковольтной",
                "Апартаменты «На Высокой» с садом и бесплатным Wi-Fi расположены в Раменском.\n" +
                        "\n" +
                        "В некоторых апартаментах есть кухня с духовкой.\n" +
                        "\n" +
                        "Любители активного отдыха могут отправиться на велосипедную прогулку по окрестностям или взять напрокат велосипед.\n" +
                        "\n" +
                        "Стадион «Сатурн» находится в 1,5 км от апартаментов «На Высоковольтной». Расстояние до международного аэропорта Жуковский составляет 6 км.\n" +
                        "\n" +
                        "Расположение этого варианта — одно из лучших в Раменском! Гости довольны им больше, чем расположением других вариантов в этом районе.\n" +
                        "\n" +
                        "Здесь лучшее соотношение цены и качества в Раменском! По сравнению с другими вариантами в этом городе, гости получают больше за те же деньги.\n" +
                        "\n" +
                        "Мы говорим на вашем языке!\n",
                "https://www.booking.com/hotel/ru/apartments-on-vysokovoltnaya.ru.html",
                55.174549,
                38.202366));

        cards.add(new Card(
                R.drawable.hotel2,
                "Гостиница Мыс Отдыха Надежда",
                "Отель «Мыс отдыха Надежда» расположен в городе Раменское. К услугам гостей ресторан и бар. Подключен бесплатный Wi-Fi. На территории обустроена бесплатная частная парковка.\n" +
                        "\n" +
                        "В некоторых номерах есть гостиная зона. Предоставляются бесплатные туалетно-косметические принадлежности и фен. В числе удобств — телевизор с плоским экраном и кабельными каналами.\n" +
                        "\n" +
                        "В распоряжении гостей русская баня, финская сауна, турецкий хаммам, фитнес-центр и салон красоты. Желающие могут поиграть в бильярд и взять напрокат лыжное снаряжение. В окрестностях созданы условия для лыжного спорта и верховой езды. Расстояние от отеля «Мыс отдыха Надежда» до московского аэропорта Домодедово составляет 27 км.\n" +
                        "\n" +
                        "Парам особенно нравится расположение — они оценили проживание в этом районе для поездки вдвоем на 8,6. ",
                "https://www.booking.com/hotel/ru/mys-otdykha-nadezhda.ru.html",
                55.572602,
                38.215864));

        cards.add(new Card(
                R.drawable.hotel3,
                "Лесная поляна",
                "Отель «Лесная поляна» расположен в поселке Раменское, в 2,2 км от стадиона «Сатурн» и в 3,3 км от автобусного вокзала. К услугам гостей бесплатный Wi-Fi, бар, ресторан, круглосуточная стойка регистрации и экскурсионное бюро.\n" +
                        "\n" +
                        "В числе удобств каждого номера — письменный стол, телевизор с плоским экраном и собственная ванная комната с ванной. В номерах отеля «Лесная поляна» обустроен гостиный уголок.\n" +
                        "\n" +
                        "Расстояние до международного аэропорта Жуковский составляет 6 км.\n" +
                        "\n" +
                        "Парам особенно нравится расположение — они оценили проживание в этом районе для поездки вдвоем на 8,6.\n" +
                        "\n" +
                        "Здесь лучшее соотношение цены и качества в Раменском! По сравнению с другими вариантами в этом городе, гости получают больше за те же деньги.\n" +
                        "\n" +
                        "Мы говорим на вашем языке!",
                "https://www.booking.com/hotel/ru/liesnaia-poliana-ramenskoye.ru.html",
                55.591488,
                38.202452));


        CardAdapter adapter = new CardAdapter(getActivity(), cards);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

}
