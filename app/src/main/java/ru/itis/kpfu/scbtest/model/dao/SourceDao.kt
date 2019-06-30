package ru.itis.kpfu.scbtest.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import ru.itis.kpfu.scbtest.model.entity.room.SourcePojo

@Dao
interface SourceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(source: SourcePojo)

    @Delete
    fun delete(source: SourcePojo)

    @Query("SELECT * FROM sources")
    fun getAll() : LiveData<List<SourcePojo>>
}
