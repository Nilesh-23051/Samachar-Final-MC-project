package com.hello.samachar.di

import android.app.Application
import androidx.room.Room
import com.hello.samachar.data.local.NewsDao
import com.hello.samachar.data.local.NewsDatabase
import com.hello.samachar.data.local.NewsTypeConvertor
import com.hello.samachar.data.manager.LocalUserManagerImpl
import com.hello.samachar.data.remote.NewsApi
import com.hello.samachar.data.repository.NewsRepositoryImpl
import com.hello.samachar.domain.manager.LocalUserManager
import com.hello.samachar.domain.repository.NewsRepository
import com.hello.samachar.domain.usecases.app_entry.AppEntryUseCases
import com.hello.samachar.domain.usecases.app_entry.ReadAppEntry
import com.hello.samachar.domain.usecases.app_entry.SaveAppEntry
import com.hello.samachar.domain.usecases.news.DeleteArticle
import com.hello.samachar.domain.usecases.news.GetNews
import com.hello.samachar.domain.usecases.news.LocationNews
import com.hello.samachar.domain.usecases.news.NewsUseCases
import com.hello.samachar.domain.usecases.news.SearchNews
import com.hello.samachar.domain.usecases.news.SelectArticle
import com.hello.samachar.domain.usecases.news.SelectArticles
import com.hello.samachar.domain.usecases.news.UpsertArticle
import com.hello.samachar.util.Constants.BASE_URL
import com.hello.samachar.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUSerManager(
        application: Application
    ): LocalUserManager =LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    )= AppEntryUseCases(
        readAppEntry= ReadAppEntry(localUserManager),
        saveAppEntry= SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)

    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ):NewsRepository=NewsRepositoryImpl(newsApi,newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ):NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            locationNews = LocationNews(newsRepository),
            upsertArticle=UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}