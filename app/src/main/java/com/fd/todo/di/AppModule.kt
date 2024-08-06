package com.fd.todo.di

import android.app.Application
import androidx.room.Room
import com.fd.todo.data.AppDatabase
import com.fd.todo.data.TodoRepository
import com.fd.todo.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: AppDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }
}