package tu.android_movielist.Operators;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tu.android_movielist.MainActivity;
import tu.android_movielist.Movie.MovieSource;
import tu.android_movielist.R;
import tu.android_movielist.ValidateEntry;

public class RemoveMovie extends Activity {
    Button removeButton;
    EditText deleteText;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletemovie);

        deleteText=findViewById(R.id.delete);
        removeButton=findViewById(R.id.remove);
        this.setTitle("Remove movie");

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int vw=metrics.widthPixels;
        int vh=metrics.heightPixels;

        getWindow().setLayout((vw), (int)(vh*0.3));

        removeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                ValidateEntry.valremove(deleteText.getText().toString());

                switch(ValidateEntry.error)
                {
                    case "Please enter a name!":
                    case "Enter a name with less than 30 characters!":
                    case "No such movie!":
                        Toast.makeText(getApplicationContext(), ValidateEntry.error, Toast.LENGTH_SHORT).show();
                        break;

                    case "false":
                        MovieSource.delete(deleteText.getText().toString());
                        runOnUiThread(new Runnable() { public void run() { MainActivity.adapter.notifyDataSetChanged(); } });
                        Toast.makeText(getApplicationContext(), "Movie was removed!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
