package com.example.flickfetch;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSearch;
    private Button buttonSearch;
    private LinearLayout linearLayoutResults;

    private OmdbApiService omdbApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização das views
        editTextSearch = findViewById(R.id.editText_search);
        buttonSearch = findViewById(R.id.button_search);
        linearLayoutResults = findViewById(R.id.linear_layout_results); // Inicialização da linearLayoutResults

        // Configuração do Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Inicialização do serviço da API OMDb
        omdbApiService = retrofit.create(OmdbApiService.class);

        // Configuração do botão de pesquisa
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editTextSearch.getText().toString().trim();
                if (!query.isEmpty()) {
                    searchMovies(query);
                }
            }
        });
    }

    private void searchMovies(String query) {
        Call<Movie> call = omdbApiService.getMovieInfo("1ff59903", query);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    // Exibir informações do filme
                    showMovieInfo(movie);
                } else {
                    Log.e("MainActivity", "Erro na solicitação: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.e("MainActivity", "Falha na solicitação: " + t.getMessage());
            }
        });
    }

    private void showMovieInfo(Movie movie) {
        // Limpar resultados anteriores
        linearLayoutResults.removeAllViews();
        // Exibir o pôster do filme
        ImageView imageViewPoster = new ImageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        imageViewPoster.setLayoutParams(layoutParams);
        linearLayoutResults.addView(imageViewPoster);

        String posterUrl = movie.getPoster();
        if (posterUrl != null && !posterUrl.isEmpty()) {
            // Usando a biblioteca Glide para carregar a imagem do pôster
            Glide.with(this)
                    .load(posterUrl)
                    .placeholder(R.drawable.placeholder_poster) // Imagem de espaço reservado enquanto carrega
                    .error(R.drawable.placeholder_poster) // Imagem de erro, caso a imagem não possa ser carregada
                    .into(imageViewPoster);
        } else {
            // Caso o pôster não esteja disponível, você pode exibir uma imagem padrão
            imageViewPoster.setImageResource(R.drawable.placeholder_poster);
        }
        // Adicionar texto de informações do filme
        addInfoTextViewWithDivider("Título", movie.getTitle());
        addInfoTextViewWithDivider("Ano", movie.getYear());
        addInfoTextViewWithDivider("Enredo", movie.getPlot());
        addInfoTextViewWithDivider("Classificação", movie.getClassificacao());
        addInfoTextViewWithDivider("Lançado", movie.getLancado());
        addInfoTextViewWithDivider("Tempo de execução", movie.getTempoDeExecucao());
        addInfoTextViewWithDivider("Gênero", movie.getGenero());
        addInfoTextViewWithDivider("Diretor", movie.getDiretor());
        addInfoTextViewWithDivider("Escritor", movie.getEscritor());
        addInfoTextViewWithDivider("Atores", movie.getAtores());
        addInfoTextViewWithDivider("Idioma", movie.getIdioma());
        addInfoTextViewWithDivider("País", movie.getPais());
        addInfoTextViewWithDivider("Prêmios", movie.getPremios());
        addInfoTextViewWithDivider("Metascore", movie.getMetascore());
        addInfoTextViewWithDivider("imdbRating", movie.getImdbRating());
        addInfoTextViewWithDivider("imdbVotes", movie.getImdbVotes());
        addInfoTextViewWithDivider("imdbID", movie.getImdbID());
        addInfoTextViewWithDivider("Type", movie.getType());
        addInfoTextViewWithDivider("DVD", movie.getDvd());
        addInfoTextViewWithDivider("BoxOffice", movie.getBoxOffice());
        addInfoTextViewWithDivider("Produção", movie.getProducao());
        addInfoTextViewWithDivider("Site", movie.getSite());

    }


    private void addInfoTextViewWithDivider(String label, String value) {
        // Criar um TextView para o rótulo
        TextView labelTextView = new TextView(this);
        labelTextView.setText(label);
        labelTextView.setTextColor(Color.BLACK); // Definir a cor do texto como preto
        linearLayoutResults.addView(labelTextView);

        // Criar um TextView para o valor
        TextView valueTextView = new TextView(this);
        valueTextView.setText(value);
        valueTextView.setTextColor(Color.BLACK); // Definir a cor do texto como preto
        linearLayoutResults.addView(valueTextView);

        // Adicionar um divisor entre os textos
        View dividerView = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2 // Altura do divisor
        );
        dividerView.setLayoutParams(layoutParams);
        dividerView.setBackgroundColor(Color.BLACK); // Definir a cor do divisor como preto
        linearLayoutResults.addView(dividerView);
    }
}
