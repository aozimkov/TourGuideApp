package com.example.android.tourguideapp;


import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.WorkSource;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends ListFragment{

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_list, container, false);

        final ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(
                R.drawable.news1,
                "В Кратово состоялась открытая тренировка Португальской сборной по футболу",
                "В преддверии Чемпионата мира по футболу – 2018, 9 июня, в Раменский район прибыла Сборная команда Португалии, которая расположилась на спортивной базе «Сатурн» в городском поселении Кратово. Уже 10 июня португальцы провели открытую тренировку, участниками которой стали не только международные и российские СМИ, но и ребята из детских футбольных секций Раменского района. Они горячо приветствовали кумира молодежи – знаменитого нападающего испанского клуба «Реал Мадрид» Криштиану Рональдо.",
                "http://ramns.ru/2018/06/10/v-kratovo-sostojalas-otkrytaja-trenirovka-portugalskoj-sbornoj-po-futbolu/"));

        cards.add(new Card(R.drawable.news2,
                "Фестиваль исторической реконструкции проходит в Раменском",
                "Сегодня и завтра раменчане смогут увидеть реконструкцией славянского поселения IX-XI в.в. Посмотреть зрелищные бои и насладиться экспозицией «Малая боевая ладья». Данное мероприятие проходит на Борисоглебском озере и на берегу со стороны ДС «Борисоглебский». Сегодня с 11.00 до 19.00, завтра с 11.00 до 16.00.",
                "http://ramns.ru/2018/06/10/festival-istoricheskoj-rekonstrukcii-prohodit-v-ramenskom/"));
        cards.add(new Card(R.drawable.news3,
                "Праздничную программу провели в поселке Красный Октябрь в честь Дня города Раменское",
                "День города Раменское – праздник традиционный для июня. Но летняя погода 10-го числа с утра не задалась: моросил дождь, солнышко спрятали тучи… Тем, кто был ответственным за праздник, кто готовился к Дню города с энтузиазмом профессионалов, было нелегко ситуацию взять в свои руки. Дети и взрослые, которые оделись по погоде, к празднику стремились, и дружная команда мастеров-затейников, артистов-солистов, звукорежиссеров, замечательно наладивших звук, открыли свою двухчасовую программу. С посёлка Красный Октябрь (ПКО) в залинейной части города на красивую детскую площадку, открытую здесь год назад, пришли дети с родителями, бабушками и дедушками. Первая часть праздничного дня была для детей радостным утренником: игры нравились, разрисованные умелой кистью организаторов детские лица улыбались, команды соревновались, болельщики болели… Подвижные игры для детей не надоедали их участникам, а родители, хоть и прятались под зонтиками, но были терпеливы и с удовольствием наблюдали за праздничной занятостью детей, веселой суетой и развитием нужных навыков в игре: пробежать, попасть в цель, потренировать сноровку, чтобы победить, а потом порадоваться и завершить всё «обнимашками».",
                "http://ramns.ru/2018/06/11/prazdnichnuju-programmu-proveli-v-poselke-krasnyj-oktjabr-v-chest-dnja-goroda-ramenskoe/"));
        cards.add(new Card(R.drawable.news4,
                "Журналисты российских и иностранных СМИ пребывают на открытую тренировку сборной Португалии в Кратове",
                "В их распоряжении — медиа-центр, обеспеченный всем необходимым для оперативной работы.",
                "http://ramns.ru/2018/06/10/zhurnalisty-rossijskih-i-inostrannyh-smi-prebyvajut-na-otkrytuju-trenirovku-sbornoj-portugalii-v-kratove/"));
        cards.add(new Card(R.drawable.news5,
                "Андрей Кулаков и Владимир Демин поздравили жителей Раменского с Днем города",
                "Уважаемые горожане и жители Раменского района! Дорогие ветераны и молодёжь! Примите искренние поздравления с Днём России и Днём города Раменское и Раменского района. В этом году наш традиционный праздник совпадает с государственным праздником россиян, нашего многонационального талантливого народа! И в эти же июньские дни Россия принимает участников и гостей чемпионата мира по футболу… Мы все отдаем должное подготовке страны к столь грандиозному международному событию и принимаем в этом участие! К Дню России, как и к Дню города, в Раменском пройдут праздничные программы – массовые, содержательные, яркие! Наша Родина – это страницы истории и современности, собранные воедино и отраженные в укладе нашей жизни, в нашем национальном самосознании и уважении к культуре народов планеты. Мы желаем успехов и удачи в делах! Здоровья, оптимизма, благополучия и активности в общественной жизни! Глава Раменского муниципального района А.Н.Кулаков Председатель Совета депутатов Раменского муниципального района В.Ф.Демин",
                "http://ramns.ru/2018/06/10/andrej-kulakov-i-vladimir-demin-pozdravili-zhitelej-ramenskogo-s-dnem-goroda/"));

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
