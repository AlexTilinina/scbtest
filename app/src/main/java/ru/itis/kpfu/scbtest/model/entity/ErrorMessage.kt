package ru.itis.kpfu.scbtest.model.entity

data class ErrorMessage(val status:String,
                   val code: String,
                   val message: String)