package ru.itis.kpfu.scbtest.model.repository

import ru.itis.kpfu.scbtest.model.dao.SourceDao
import ru.itis.kpfu.scbtest.model.entity.room.SourcePojo

class SourceRepository(private val sourceDao: SourceDao) {

    fun insert(obj: SourcePojo) = sourceDao.insert(obj)

    fun delete(obj: SourcePojo) = sourceDao.delete(obj)
}