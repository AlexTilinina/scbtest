package ru.itis.kpfu.scbtest.ui.sourcelist

import javax.inject.Inject

class SourceIdHolder @Inject constructor() {

    companion object {

        private val sourceIdHolder = SourceIdHolder()

        fun getInstance() = sourceIdHolder
    }

    var sourceId: String = ""
}