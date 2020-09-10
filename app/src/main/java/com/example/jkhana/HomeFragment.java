package com.example.jkhana;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.ActionBar;


public class HomeFragment extends Fragment {
    int[] sliderImageId ;
    private ImageView dimage;
    private TextView dinner;
    private TextView fastfood;
    private ImageView fimag;
    private ImageView frimag;
    private TextView fruits;
    private ImageView gimag;
    private TextView grocerie;
    private ImageView liimag;
    private ImageView limag;
    private TextView liqueur;
    private TextView lunch;
    private ImageView nimag;
    private TextView nonveg;
    public ActionBar toolbar;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ImageSlider imgslider =(ImageSlider) v.findViewById(R.id.slider);
        List<SlideModel> slide = new ArrayList<>();
        slide.add(new SlideModel(R.drawable.grocerie,"Gloceries"));
        slide.add(new SlideModel(R.drawable.vejroll,"VejRoll"));
        slide.add(new SlideModel(R.drawable.img,"Gloceries"));
        slide.add(new SlideModel(R.drawable.streetfood,"StreetFood"));
        imgslider.setImageList(slide,true)  ;


        grocerie = (TextView) v.findViewById(R.id.groceriestext);
        fastfood = (TextView) v.findViewById(R.id.fastfoodtext);
        lunch = (TextView) v.findViewById(R.id.lunchtext);
        nonveg = (TextView) v.findViewById(R.id.nonvegtext);
        dinner = (TextView) v.findViewById(R.id.dinnertext);
        liqueur = (TextView) v.findViewById(R.id.liqueurtext);
        fruits = (TextView) v.findViewById(R.id.fruitstext);
        gimag = (ImageView) v.findViewById(R.id.groceries);
        fimag = (ImageView) v.findViewById(R.id.fastfood);
        limag = (ImageView) v.findViewById(R.id.lunch);
        nimag = (ImageView) v.findViewById(R.id.nonveg);
        dimage = (ImageView) v.findViewById(R.id.dinner);
        liimag = (ImageView) v.findViewById(R.id.liqueur);
        frimag = (ImageView) v.findViewById(R.id.fruits);
        LinearLayout li = (LinearLayout) v.findViewById(R.id.linergloc);
        LinearLayout food = (LinearLayout) v.findViewById(R.id.linearfood);
        LinearLayout lun = (LinearLayout) v.findViewById(R.id.linearlunch);
        LinearLayout non = (LinearLayout) v.findViewById(R.id.linearnonveg);
        LinearLayout dinn = (LinearLayout) v.findViewById(R.id.lineardinner);
        LinearLayout lique = (LinearLayout) v.findViewById(R.id.linearliqueur);
        LinearLayout frui = (LinearLayout) v.findViewById(R.id.linearfruits);




        li.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Groceries.class));
                Toast.makeText(getActivity(), "Moving to groceries", Toast.LENGTH_SHORT).show();
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Food.class));
                Toast.makeText(getActivity(), "Moving to FastFood", Toast.LENGTH_SHORT).show();
            }
        });
        lun.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Lunch.class));
                Toast.makeText(getActivity(), "Moving to Lunch", Toast.LENGTH_SHORT).show();
            }
        });
        non.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Nonveg.class));
                Toast.makeText(getActivity(), "Moving to NonVeg", Toast.LENGTH_SHORT).show();
            }
        });
        dinn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Dinner.class));
                Toast.makeText(getActivity(), "Moving to Dinner",Toast.LENGTH_SHORT ).show();

            }
        });
        lique.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Liqueurs.class));
                Toast.makeText(getActivity(), "Moving to Liqueurs", Toast.LENGTH_SHORT).show();
            }
        });
        frui.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Fruits.class));
                Toast.makeText(getActivity(), "Moving to Fruits", Toast.LENGTH_SHORT).show();
            }
        });
         return v;
    }


}
