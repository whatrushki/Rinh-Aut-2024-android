package app.what.main.children.live.di

import app.what.main.children.live.domain.LiveController
import org.koin.dsl.module

val liveModule = module {
    single<LiveController> { LiveController() }
}