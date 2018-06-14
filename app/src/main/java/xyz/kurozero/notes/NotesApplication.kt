package xyz.kurozero.notes

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import xyz.kurozero.notes.di.AppComponent
import xyz.kurozero.notes.di.DaggerAppComponent
import xyz.kurozero.notes.di.NoteDaoModule
import xyz.kurozero.notes.mvp.model.AppDatabase
import xyz.kurozero.notes.mvp.model.Note
import com.reactiveandroid.ReActiveAndroid
import com.reactiveandroid.ReActiveConfig
import com.reactiveandroid.internal.database.DatabaseConfig

class NotesApplication : Application() {

    companion object {
        lateinit var graph: AppComponent
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        context = this
        graph = DaggerAppComponent.builder().noteDaoModule(NoteDaoModule()).build()

        val appDatabaseConfig = DatabaseConfig.Builder(AppDatabase::class.java)
                .addModelClasses(Note::class.java)
                .build()

        ReActiveAndroid.init(ReActiveConfig.Builder(this)
                .addDatabaseConfigs(appDatabaseConfig)
                .build())
    }

}
