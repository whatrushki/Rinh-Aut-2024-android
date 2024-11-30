package app.what.main.children.profile.di

import app.what.main.children.profile.domain.ProfileController
import org.koin.dsl.module

val profileModule = module {
    single { ProfileController() }
}