package tu.android_movielist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import tu.android_movielist.Movie.MovieSource;
import tu.android_movielist.Operators.AddMovie;
import tu.android_movielist.Operators.RemoveMovie;

public class MainActivity extends AppCompatActivity {

    Button addMovie, removeMovie;
    public static Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMovie = findViewById(R.id.main_add);
        removeMovie = findViewById(R.id.main_delete);

        RecyclerView recyclerView = findViewById(R.id.main_recyclerView);
        adapter = new tu.android_movielist.Adapter(MovieSource.list());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        removeMovie.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, RemoveMovie.class)); } });

        addMovie.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, AddMovie.class)); } });
    }
}
