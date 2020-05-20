package tu.android_movielist.Operators;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import tu.android_movielist.MainActivity;
import tu.android_movielist.Movie.Movie;
import tu.android_movielist.Movie.MovieSource;
import tu.android_movielist.R;
import tu.android_movielist.ValidateEntry;

public class AddMovie extends Activity {
    EditText nameadd, directoradd, genreadd, yearadd;
    RatingBar ratingadd;
    Button addadd;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnew);

        nameadd=findViewById(R.id.nameadd);
        directoradd=findViewById(R.id.directoradd);
        genreadd=findViewById(R.id.genreadd);
        yearadd=findViewById(R.id.yearadd);
        ratingadd=findViewById(R.id.ratingadd);
        addadd=findViewById(R.id.addadd);
        this.setTitle("Add movie");

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int wp=metrics.widthPixels;
        int hp=metrics.heightPixels;

        getWindow().setLayout((wp), (int)(hp*0.6));

        addadd.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                ValidateEntry.valadd(nameadd.getText().toString(), directoradd.getText().toString(), genreadd.getText().toString(), yearadd.getText().toString());

                switch (ValidateEntry.error)
                {
                    case "Please enter in all of the spaces!":
                    case "Enter values with less than 30 characters!":
                    case "Such movie already exists in the list!":
                        Toast.makeText(getApplicationContext(), ValidateEntry.error, Toast.LENGTH_SHORT).show();
                        break;

                    case "false":
                        Movie movie=new Movie
                                (nameadd.getText().toString(), directoradd.getText().toString(), genreadd.getText().toString(), yearadd.getText().toString(), ratingadd.getRating());
                        MovieSource.add(movie);
                        runOnUiThread(new Runnable() { public void run() { MainActivity.adapter.notifyDataSetChanged(); } });
                        Toast.makeText(getApplicationContext(),"Movie successfully added!",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
