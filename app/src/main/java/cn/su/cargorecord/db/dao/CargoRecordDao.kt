package cn.su.cargorecord.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import cn.su.cargorecord.db.entity.CargoRecord
import java.util.*

/**
 * Created by sfshine@qq.com on 2019/2/16 0016.
 */
@Dao
interface CargoRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(cargoRecord: CargoRecord)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(cargoRecords: List<CargoRecord>)

    @Query("SELECT * FROM cargoRecord ORDER BY orderTime desc")
    fun getAllCargoRecords(): LiveData<List<CargoRecord>>

    @Query("SELECT cargoRecord.*, person.name AS personName FROM cargoRecord,person WHERE cargoRecord.deliverPersonId = person.id AND orderTime >= :orderTime ORDER BY orderTime desc")
    fun getCargoRecordSince(orderTime: Date): LiveData<List<CargoRecord>>

    @Query("SELECT * FROM cargoRecord WHERE orderTime=:orderTime")
    fun getCargoRecordByOrderTime(orderTime: Date): List<CargoRecord>

    @Query("SELECT * FROM cargoRecord WHERE id=:id")
    fun getCargoRecordById(id: Long): List<CargoRecord>

    @Update(onConflict = REPLACE)
    fun updateRecord(CargoRecord: CargoRecord): Int

    @Query("UPDATE cargoRecord SET note = :newNote WHERE orderTime = :orderTime")
    fun updateNoteByRecordTime(newNote: String, orderTime: Date): Int

    @Delete
    fun deleteByRecord(record: CargoRecord): Int

    @Query("DELETE FROM cargoRecord where note = :note")
    fun deleteByNote(note: String): Int

    @Query("DELETE FROM cargoRecord")
    fun deleteAll(): Int
}