package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();
//TODO remover mock de noticias
        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviaria teve desfalque importante", "Os astronautas John Young e Charles Duke alunissaram o módulo lunar Orion no dia 21 de abril nas Terras Altas de Descartes e passaram um total de 71 horas na ..."));
        news.add(new News("Ferroviaria jogará no sabado", "Wikipédia · A Wikipédia é um projeto de enciclopédia multilíngue de licença livre, baseado na · O nome Wikipedia foi criado por Larry Sanger e é uma combinação de ..."));
        news.add(new News("Palmeiras perde mais uma vez", "Wikipedia is a free online encyclopedia, created and edited by volunteers around the world and hosted by the Wikimedia Foundation."));
        this.news.setValue(news);
    }
    public LiveData<List<News>>  getNews() {
        return news;
    }
}