package tu.android_movielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tu.android_movielist.Movie.Movie;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private final ArrayList<Movie> movies;

    public Adapter(ArrayList<Movie>movies) {
        this.movies = movies;
    }

    @NonNull
    @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View contactView=inflater.inflate(R.layout.showmovie, parent, false);
        return new ViewHolder((contactView));
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final Movie movies1 = movies.get(position);
        holder.setName("Name: " + movies1.getName());
        holder.setDirector("Director: " + movies1.getDirector());
        holder.setGenre("Genre: " + movies1.getGenre());
        holder.setYear("Year: " + movies1.getYear());
        holder.setRating(movies1.getRating());
        holder.setIndex("Index: " + holder.getAdapterPosition());
    }

    @Override public int getItemCount() {
        return movies.size();
    }
}
