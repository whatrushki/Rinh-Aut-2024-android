package app.what.main.di

import app.what.main.children.profile.domain.ProfileController
import org.koin.dsl.module

val mainModule = module {
    single<ProfileController> { ProfileController() }
}