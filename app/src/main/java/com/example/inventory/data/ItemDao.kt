package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Delete

@Dao
interface ItemDao {
    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

}