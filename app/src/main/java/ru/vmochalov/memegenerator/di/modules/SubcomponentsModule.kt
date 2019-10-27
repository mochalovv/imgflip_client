package ru.vmochalov.memegenerator.di.modules

import dagger.Module
import ru.vmochalov.memegenerator.di.component.MainActivityComponent

/**
 * Created by Vladimir Mochalov on 27.10.2019.
 */
@Module(subcomponents = [MainActivityComponent::class])
class SubcomponentsModule