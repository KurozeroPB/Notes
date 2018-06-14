package xyz.kurozero.notes.di

import dagger.Component
import xyz.kurozero.notes.mvp.presenters.MainPresenter
import xyz.kurozero.notes.mvp.presenters.NotePresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [NoteDaoModule::class])
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)

    fun inject(notePresenter: NotePresenter)
}