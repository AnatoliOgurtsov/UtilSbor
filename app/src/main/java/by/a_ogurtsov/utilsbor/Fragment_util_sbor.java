package by.a_ogurtsov.utilsbor;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_util_sbor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_util_sbor extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    final String LOG_TAG = "myLogs";
    final String ATTRIBUTE_CAT = "cat";
    final String ATTRIBUTE_CAT_INFO = "cat_info";
    final String ATTRIBUTE_CAT_IMAGE = "cat_image";
    private Spinner spinner_cat;
    MySimpleAdapter sAdapter;
    View child;
    FrameLayout FL;
    RadioGroup rg_m1, rg_n1, rg_m2, rg_spec_new;
    TextView itog, do3, ot3, poloska_do3, poloska_ot3,  tv_samosval_massa;
    public int vozrast, category;
    OnClickListener radiolistener;
    RadioGroup.OnCheckedChangeListener rg_m1_listener;
    Intent intent;
    RadioButton rb2, rb3, rb4, rb5, rb6, rb1_spec_new, rb2_spec_new;
    String[] cat_info, cat;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_util_sbor.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_util_sbor newInstance(String param1, String param2) {
        Fragment_util_sbor fragment = new Fragment_util_sbor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_util_sbor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String LOG_TAG = "myLogs";


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        cat = getResources().getStringArray(R.array.cat);
        cat_info = getResources().getStringArray(R.array.cat_info);
        int[] cat_image = {R.drawable.ic_legk_car, R.drawable.ic_micro_bus, R.drawable.ic_bus, R.drawable.ic_gruz_3_5, R.drawable.ic_gruz_5_12, R.drawable.ic_gruz_12_, R.drawable.ic_samosval, R.drawable.ic_spec};
        //=======готовим данные для спиннера выбора категорий
        ArrayList<Map<String, Object>> cat_data = new ArrayList<Map<String, Object>>(cat.length);
        Map<String, Object> m;
        for (int i = 0; i < cat.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_CAT, cat[i]);
            m.put(ATTRIBUTE_CAT_INFO, cat_info[i]);
            m.put(ATTRIBUTE_CAT_IMAGE, cat_image[i]);
            cat_data.add(m);
        }
        //====================================================
        String[] from = {ATTRIBUTE_CAT, ATTRIBUTE_CAT_INFO, ATTRIBUTE_CAT_IMAGE};
        int[] to = {R.id.tv_cat, R.id.tv_cat_info, R.id.tv_cat_image};
        sAdapter = new MySimpleAdapter(this.getActivity(), cat_data, R.layout.spinner_item_us_category_ts, from, to);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_util_sbor, container, false);

        do3 = (TextView) v.findViewById(R.id.tv_do3);
        ot3 = (TextView) v.findViewById(R.id.tv_ot3);
        poloska_do3 = (TextView) v.findViewById(R.id.poloska_do3);
        poloska_ot3 = (TextView) v.findViewById(R.id.poloska_ot3);

        FL = (FrameLayout) v.findViewById(R.id.FL1);
        itog = (TextView) v.findViewById(R.id.tv);

        //====================фиксим поворот экрана==============================================
        //========================================================================================
        if (savedInstanceState == null) {
            vozrast = 1;
            poloska_do3.setBackgroundColor(getResources().getColor(R.color.banner));
            poloska_ot3.setBackgroundColor(getResources().getColor(R.color.whiteblue));
        }
        else {
            vozrast = savedInstanceState.getInt("VOZRAST");
            switch (vozrast){
                case 1:
                    poloska_do3.setBackgroundColor(getResources().getColor(R.color.banner));
                    poloska_ot3.setBackgroundColor(getResources().getColor(R.color.whiteblue));
                    break;
                case 2:
                    poloska_do3.setBackgroundColor(getResources().getColor(R.color.whiteblue));
                    poloska_ot3.setBackgroundColor(getResources().getColor(R.color.banner));
                    break;
                            }
        }

        if (savedInstanceState == null) category = 1;
        else category = savedInstanceState.getInt("CATEGORY");

        //========================================================================================
        //========================================================================================




       // String custom_font = "Roboto-Regular.ttf";
       // Typeface CF = Typeface.createFromAsset(getActivity().getAssets(), custom_font);
       // baz_stavka.setTypeface(CF);

//====================
//==============================================
        radiolistener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tv_do3:
                        Log.d(LOG_TAG, "Good3");
                        vozrast = 1;
                        poloska_do3.setBackgroundColor(getResources().getColor(R.color.banner));
                        poloska_ot3.setBackgroundColor(getResources().getColor(R.color.whiteblue));
                        itog(vozrast, category);
                        break;
                    case R.id.tv_ot3:
                        Log.d(LOG_TAG, "Good4");
                        vozrast = 2;
                        poloska_do3.setBackgroundColor(getResources().getColor(R.color.whiteblue));
                        poloska_ot3.setBackgroundColor(getResources().getColor(R.color.banner));
                        itog(vozrast, category);
                        break;
                    case R.id.radioButton2:  // в М1
                        //реализовать startActivity for rezult
                        intent = new Intent(getActivity().getBaseContext(), Vybor_obema_us.class);
                        startActivityForResult(intent, 1);

                        break;
                    case R.id.radioButton1_N:  // в N1N2N3
                        //реализовать startActivity for rezult
                        rb4.setText(getResources().getString(R.string.a10));
                        intent = new Intent(getActivity().getBaseContext(), Vybor_massa_us_n1n2n3_1.class);
                        startActivityForResult(intent, 1);
                        break;
                    case R.id.radioButton2_N:  // в N1N2N3
                        rb3.setText(getResources().getString(R.string.a9));
                        //реализовать startActivity for rezult
                        intent = new Intent(getActivity().getBaseContext(), Vybor_massa_us_n1n2n3_2.class);
                        startActivityForResult(intent, 1);
                        break;
                    case R.id.radioButton1_M2M3:
                        category = 8;
                        rb6.setText(getResources().getString(R.string.a2));
                        itog(vozrast, category);
                        break;
                    case R.id.radioButton2_M2M3:
                        //реализовать startActivity for rezult
                        intent = new Intent(getActivity().getBaseContext(), Vybor_obema_us_m2m3.class);
                        startActivityForResult(intent, 1);
                        break;
                    case R.id.textview1_sam:
                        //реализовать startActivity for rezult
                        intent = new Intent(getActivity().getBaseContext(), Vybor_massa_us_samosval.class);
                        startActivityForResult(intent, 1);
                        break;
                    case R.id.radioButton1_spec:
                        category = 25;
                        itog(vozrast, category);
                        break;
                    case R.id.radioButton2_spec:
                        category = 26;
                        itog(vozrast, category);
                        break;
                }
            }
        };

        do3.setOnClickListener(radiolistener);
        ot3.setOnClickListener(radiolistener);
//=================

        spinner_cat = (Spinner) v.findViewById(R.id.spinner_vid_TS_util);
        spinner_cat.setAdapter(sAdapter);
        spinner_cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // надо очистить контейнер
                if (FL != null) {
                    FL.removeView(child);
                }
                switch (position) {
                    case 0:  //M1=================================================================
                        //category = 1;


                        Log.d(LOG_TAG, "pressed M1" + "категоррия = " + category);
                        child = inflater.inflate(R.layout.m1, null);
                        FL.addView(child);
                        rg_m1 = (RadioGroup) FL.findViewById(R.id.RG_M1);
                        rb2 = (RadioButton) rg_m1.findViewById(R.id.radioButton2);
                        rb2.setOnClickListener(radiolistener);

                        switch (category){
                            case 1:
                                rg_m1.check(R.id.radioButton1);
                                break;
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                rg_m1.check(R.id.radioButton2);
                                break;
                            case 7:
                                rg_m1.check(R.id.radioButton3);
                                break;
                            case 77:
                                rg_m1.check(R.id.radioButton3_1);
                            break;
                            default:          // используем именно при выборе М1, остальное выше - при повороте экрана
                                category = 1;
                                rg_m1.check(R.id.radioButton1);
                        }

                        itog(vozrast, category);



                        rg_m1_listener = new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                switch (checkedId) {
                                    case (R.id.radioButton1):
                                        rb2.setText(getResources().getString(R.string.a2));
                                        Log.d(LOG_TAG, "Good5");
                                        category = 1;
                                        itog(vozrast, category);

                                        break;
                                    case (R.id.radioButton2):
                                        Log.d(LOG_TAG, "Good6");
                                        // нажатие на выбор объема реализовано в onClickListener
                                        break;
                                    case (R.id.radioButton3):
                                        rb2.setText(getResources().getString(R.string.a2));
                                        Log.d(LOG_TAG, "Good7");
                                        category = 7;
                                        itog(vozrast, category);
                                        break;
                                    case (R.id.radioButton3_1):
                                        rb2.setText(getResources().getString(R.string.a2));
                                        Log.d(LOG_TAG, "Good77");
                                        category = 77;
                                        itog(vozrast, category);
                                        break;
                                }
                            }
                        };
                        rg_m1.setOnCheckedChangeListener(rg_m1_listener);
                        break;
                    case 1:  //M2=================================================================
                    case 2:  //M3=================================================================
                        // категории 8-12

                        child = inflater.inflate(R.layout.m2m3, null);
                        FL.addView(child);
                        rg_m2 = (RadioGroup) FL.findViewById(R.id.RG_M2M3);
                        rb5 = (RadioButton) rg_m2.findViewById(R.id.radioButton1_M2M3);
                        rb6 = (RadioButton) rg_m2.findViewById(R.id.radioButton2_M2M3);
                        rb5.setOnClickListener(radiolistener);
                        rb6.setOnClickListener(radiolistener);

                        switch (category) {
                            case 8:
                                rg_m2.check(R.id.radioButton1_M2M3);
                                break;
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                                rg_m2.check(R.id.radioButton2_M2M3);
                                break;
                            default:
                                category = 8;
                                rg_m2.check(R.id.radioButton1_M2M3);

                        }

                        itog(vozrast, category);
                        break;
                    case 3:  //N1=================================================================
                    case 4:  //N2=================================================================
                    case 5:  //N3=================================================================

                        child = inflater.inflate(R.layout.n1n2n3, null);
                        FL.addView(child);
                        rg_n1 = (RadioGroup) FL.findViewById(R.id.RG_N1N2N3);
                        rb3 = (RadioButton) rg_n1.findViewById(R.id.radioButton1_N);
                        rb4 = (RadioButton) rg_n1.findViewById(R.id.radioButton2_N);
                        rb3.setOnClickListener(radiolistener);
                        rb4.setOnClickListener(radiolistener);

                        switch (category){
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                                rg_n1.check(R.id.radioButton1_N);
                                break;
                            case 20:
                            case 21:
                                rg_n1.check(R.id.radioButton2_N);
                                break;
                            default:
                                category = 13;
                                rg_n1.check(R.id.radioButton1_N);
                        }

                        itog(vozrast, category);
                        break;
                    case 6:  // Самосвал==========================================================

                        child = inflater.inflate(R.layout.samosval, null);
                        FL.addView(child);
                        tv_samosval_massa = (TextView) FL.findViewById(R.id.textview1_sam);
                        tv_samosval_massa.setOnClickListener(radiolistener);
                        switch (category){
                            case 22:
                                tv_samosval_massa.setText(getResources().getString(R.string.a22));
                                break;
                            case 23:
                                tv_samosval_massa.setText(getResources().getString(R.string.a23));
                                break;
                            case 24:
                                tv_samosval_massa.setText(getResources().getString(R.string.a24));
                                break;
                            default:
                                category = 22;
                                tv_samosval_massa.setText(getResources().getString(R.string.a22));
                        }

                        itog(vozrast, category);
                        break;
                    case 7: // Специальные

                        child = inflater.inflate(R.layout.spec, null);
                        FL.addView(child);
                        rg_spec_new = (RadioGroup)FL.findViewById(R.id.RG_spec);
                        rb1_spec_new = (RadioButton)FL.findViewById(R.id.radioButton1_spec);
                        rb2_spec_new = (RadioButton)FL.findViewById(R.id.radioButton2_spec);
                        rb1_spec_new.setOnClickListener(radiolistener);
                        rb2_spec_new.setOnClickListener(radiolistener);
                        switch (category){
                            case 25:
                                rg_spec_new.check(R.id.radioButton1_spec);
                                break;
                            case 26:
                                rg_spec_new.check(R.id.radioButton2_spec);
                                break;
                            default:
                                rg_spec_new.check(R.id.radioButton1_spec);
                                category = 25;

                        }
                        itog(vozrast, category);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itog(vozrast, category);
            }
        });

        return v;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }

        category = Integer.parseInt(data.getStringExtra("category"));
        itog(vozrast, category);

    }

    class MySimpleAdapter extends SimpleAdapter {

        /**
         * Constructor
         *
         * @param context  The context where the View associated with this SimpleAdapter is running
         * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
         *                 Maps contain the data for each row, and should include all the entries specified in
         *                 "from"
         * @param resource Resource identifier of a view layout that defines the views for this list
         *                 item. The layout file should include at least those named views defined in "to"
         * @param from     A list of column names that will be added to the Map associated with each
         *                 item.
         * @param to       The views that should display column in the "from" parameter. These should all be
         *                 TextViews. The first N views in this list are given the values of the first N columns
         */
        public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public void setViewText(TextView v, String text) {
            super.setViewText(v, text);

            if (v.getId() == R.id.tv_cat) {
                if (text.equals("Самосвал"))
                    v.setTextColor(getResources().getColor(R.color.banner));
                else v.setTextColor(getResources().getColor(R.color.banner));
            }
        }
        @Override
        public void setViewImage(ImageView v, int value) {
            super.setViewImage(v, value);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CATEGORY", category);
        outState.putInt("VOZRAST", vozrast);

        Log.d(LOG_TAG, "Сохраняем данные............. категория=" + category + "возраст= " + vozrast);
    }

    public void itog(int vozrast, int category) {
        switch (vozrast) {
            case 1: // до 3 лет
                switch (category) {
                    case 0:
                        itog.setText("Hello");
                        break;
                    case 1:
                        itog.setText("851 рубль 40 копеек");
                        //itog.setText("8 514 000 бел. рублей");

                        break;
                    case 2:
                        itog.setText("851 рубль 40 копеек");
                        //itog.setText("8 514 000 бел. рублей");
                        rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a4));
                        break;
                    case 3:
                        itog.setText("1 326 рублей 60 копеек");
                        //itog.setText("13 266 000 бел. рублей");
                        rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a5));
                        break;
                    case 4:
                        itog.setText("2 534 рубля 40 копеек");
                        //itog.setText("25 344 000 бел. рублей");
                        rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a6));
                        break;
                    case 5:
                        itog.setText("3 435 рублей 30 копеек");
                        //itog.setText("34 353 000 бел. рублей");
                        rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a7));
                        break;
                    case 6:
                        itog.setText("5 445 рублей");
                        //itog.setText("54 450 000 бел. рублей");
                        rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a8));
                        break;
                    case 7:
                        itog.setText("495 рублей");
                        //itog.setText("4 950 000 бел. рублей");
                        break;
                    case 77:
                        itog.setText("495 рублей");
                        //itog.setText("4 950 000 бел. рублей");
                        break;
                    // m2 и m3
                    case 8:
                        itog.setText("4 455 рублей");
                        //itog.setText("44 550 000 бел. рублей");
                        break;
                    case 9:
                        itog.setText("4 455 рублей");
                        //itog.setText("44 550 000 бел. рублей");
                        rb6.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a18));
                        break;
                    case 10:
                        itog.setText("8 910 рублей");
                        //itog.setText("89 100 000 бел. рублей");
                        rb6.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a19));
                        break;
                    case 11:
                        itog.setText("11 880 рублей");
                        //itog.setText("118 800 000 бел. рублей");
                        rb6.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a20));
                        break;
                    case 12:
                        itog.setText("14 850 рублей");
                        //itog.setText("148 500 000 бел. рублей");
                        rb6.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a21));
                        break;
                    // n1, n2,n3
                    case 13:
                        itog.setText("3 712 рублей 50 копеек");
                        //itog.setText("37 125 000 бел. рублей");
                        rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a11));

                        break;
                    case 14:
                        itog.setText("5 940 рублей");
                        //itog.setText("59 400 000 бел. рублей");
                        rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a12));
                        break;
                    case 15:
                        itog.setText("7 425 рублей");
                        //itog.setText("74 250 000 бел. рублей");
                        rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a13));
                        break;
                    case 16:
                        itog.setText("8 167 рублей 50 копеек");
                        //itog.setText("81 675 000 бел. рублей");
                        rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a14));
                    break;
                    case 17:
                        itog.setText("9 949 рублей 50 копеек");
                        //itog.setText("99 495 000 бел. рублей");
                        rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a15));
                        break;
                    case 18:
                        itog.setText("10 914 рублей 80 копеек");
                        //itog.setText("109 148 000 бел. рублей");
                        rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a16));
                        break;
                    case 19:
                        itog.setText("21 532 рубля 50 копеек");
                        //itog.setText("215 325 000 бел. рублей");
                        rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a17));
                        break;
                    case 20:
                        itog.setText("10 914 рублей 80 копеек");
                        //itog.setText("109 148 000 бел. рублей");
                        rb4.setText(getResources().getString(R.string.a10) + " " + getResources().getString(R.string.a16));
                        break;
                    case 21:
                        itog.setText("21 532 рубля 50 копеек");
                        //itog.setText("215 325 000 бел. рублей");
                        rb4.setText(getResources().getString(R.string.a10) + " " + getResources().getString(R.string.a17));
                        break;
                    // самосвал
                    case 22:
                        itog.setText("100 980  рублей");
                        //itog.setText("1 009 800 000 бел. рублей");
                        tv_samosval_massa.setText(getResources().getString(R.string.a22));
                        break;
                    case 23:
                        itog.setText("185 625 рублей");
                        //itog.setText("1 856 250 000 бел. рублей");
                        tv_samosval_massa.setText(getResources().getString(R.string.a23));
                        break;
                    case 24:
                        itog.setText("274 725 рублей");
                        //itog.setText("2 747 250 000 бел. рублей");
                        tv_samosval_massa.setText(getResources().getString(R.string.a24));
                        break;
                    // специальные
                    case 25:
                        itog.setText("7 425 рублей");
                        //itog.setText("74 250 000 бел. рублей");
                        break;
                    case 26:
                        itog.setText("22 275 рублей");
                        //itog.setText("222 750 000 бел. рублей");
                        break;
                }
                break;
            ////////////////////////////////////////////////////////////////
            case 2:  // от 3 лет
                    switch (category) {
                            case 0:
                                itog.setText("Hello");
                                break;
                            case 1:
                                itog.setText("5 247 рублей");
                                //itog.setText("52 470 000 бел. рублей");
                                break;
                            case 2:
                                itog.setText("5 247 рублей");
                                //itog.setText("52 470 000 бел. рублей");
                                rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a4));
                                break;
                            case 3:
                                itog.setText("8 177 рублей 40 копеек");
                                //itog.setText("81 774 000 бел. рублей");
                                rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a5));
                                break;
                            case 4:
                                itog.setText("15 958 рублей 80 копеек");
                                //itog.setText("159 588 000 бел. рублей");
                                rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a6));
                                break;
                            case 5:
                                itog.setText("28 215 рублей");
                                //itog.setText("282 150 000 бел. рублей");
                                rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a7));
                                break;
                            case 6:
                                itog.setText("34 659 рублей 90 копеек");
                                //itog.setText("346 599 000 бел. рублей");
                                rb2.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a8));
                                break;
                            case 7:
                                itog.setText("742 рубля 50 копеек");
                                //itog.setText("7 425 000 бел. рублей");
                                break;
                            case 77:
                                itog.setText("7 425 000 бел. рублей");
                                break;

                            // m2 и m3
                            case 8:
                                itog.setText("7 425 рублей");
                                //itog.setText("74 250 000 бел. рублей");
                                break;
                            case 9:
                                itog.setText("7 425 рублей");
                                //itog.setText("74 250 000 бел. рублей");
                                rb6.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a18));
                                break;
                            case 10:
                                itog.setText("22 275 рублей");
                                //itog.setText("222 750 000 бел. рублей");
                                rb6.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a19));
                                break;
                            case 11:
                                itog.setText("32 670 рублей");
                                //itog.setText("326 700 000 бел. рублей");
                                rb6.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a20));
                                break;
                            case 12:
                                itog.setText("38 610 рублей");
                                //itog.setText("386 100 000 бел. рублей");
                                rb6.setText(getResources().getString(R.string.a2) + " " + getResources().getString(R.string.a21));
                                break;

                            //n1, n2,n3
                            case 13:
                                itog.setText("6 534 рублей");
                                //itog.setText("65 340 000 бел. рублей");
                                rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a11));
                                break;
                            case 14:
                                itog.setText("9 281 рубль 30 копеек");
                                //itog.setText("92 813 000 бел. рублей");
                                rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a12));
                                break;
                            case 15:
                                itog.setText("11 880 рублей");
                                //itog.setText("118 800 000 бел. рублей");
                                rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a13));
                                break;
                            case 16:
                                itog.setText("33 858 рублей");
                                //itog.setText("338 580 000 бел. рублей");
                                rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a14));
                                break;
                            case 17:
                                itog.setText("51 306 рублей 80 копеек");
                                //itog.setText("513 068 000 бел. рублей");
                                rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a15));
                                break;
                            case 18:
                                itog.setText("74 695 рублей 50 копеек");
                                //itog.setText("746 955 000 бел. рублей");
                                rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a16));
                                break;
                            case 19:
                                itog.setText("87 615 рублей");
                                //itog.setText("876 150 000 бел. рублей");
                                rb3.setText(getResources().getString(R.string.a9) + " " + getResources().getString(R.string.a17));
                                break;
                            case 20:
                                itog.setText("74 250 рублей");
                                //itog.setText("742 500 000 бел. рублей");
                                rb4.setText(getResources().getString(R.string.a10) + " " + getResources().getString(R.string.a16));
                                break;
                            case 21:
                                itog.setText("96 525 рублей");
                                //itog.setText("965 250 000 бел. рублей");
                                rb4.setText(getResources().getString(R.string.a10) + " " + getResources().getString(R.string.a17));
                                break;
                        // самосвал
                            case 22:
                                itog.setText("230 026 рублей 50 копеек");
                                //itog.setText("2 300 265 000 бел. рублей");
                                tv_samosval_massa.setText(getResources().getString(R.string.a22));
                                break;
                            case 23:
                                itog.setText("237 600 рублей");
                                //itog.setText("2 376 000 000 бел. рублей");
                                tv_samosval_massa.setText(getResources().getString(R.string.a23));
                                break;
                            case 24:
                                itog.setText("297 000 рублей");
                                //itog.setText("2 970 000 000 бел. рублей");
                                tv_samosval_massa.setText(getResources().getString(R.string.a24));
                                break;

                            // специальные
                            case 25:
                                itog.setText("74 250 рублей");
                                //itog.setText("742 500 000 бел. рублей");
                                break;
                            case 26:
                                itog.setText("96 525 рублей");
                                //itog.setText("965 250 000 бел. рублей");
                                break;
                        }
                        break;
                }

        }
    }

