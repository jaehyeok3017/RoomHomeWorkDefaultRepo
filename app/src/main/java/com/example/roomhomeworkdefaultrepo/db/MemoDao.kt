package com.example.roomhomeworkdefaultrepo.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao {
    @Query("SELECT * FROM PostData")
    fun getAll() : List<PostData>

    @Insert
    fun insertData(vararg pdata : PostData) // vararg = 몇 개를 가져와도, 에러를 뱉어내지 않음

    @Delete
    fun deleteData(pdata : PostData)

    @Update
    fun updateData(pdata : PostData)
}