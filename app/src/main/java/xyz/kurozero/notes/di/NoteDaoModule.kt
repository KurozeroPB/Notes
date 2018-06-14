package xyz.kurozero.notes.di

import dagger.Module
import dagger.Provides
import xyz.kurozero.notes.mvp.model.NoteDao
import javax.inject.Singleton

@Module
class NoteDaoModule {

    @Provides
    @Singleton
    fun provideNoteDao(): NoteDao = NoteDao()

}