package com.example.repository.room

import androidx.room.*

@Dao
interface HistoryDao {
    // Получить весь список слов
    @Query("SELECT * FROM HistoryEntity")
    fun all(): List<HistoryEntity>

    // Получить конкретное слово
    @Query("SELECT * FROM HistoryEntity WHERE word LIKE :word")
    fun getDataByWord(word: String): List<HistoryEntity>

    // Сохранить новое слово
    // onConflict = OnConflictStrategy.IGNORE означает, что дубликаты не будут
    // сохраняться
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: HistoryEntity)
    // Вставить список слов
    // onConflict = OnConflictStrategy.IGNORE означает, что дубликаты не будут
    // сохраняться
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(entities: List<HistoryEntity>)
    // Обновить слово
    @Update
    fun update(entity: HistoryEntity)
    // Удалить слово
    @Delete
    fun delete(entity: HistoryEntity)
}