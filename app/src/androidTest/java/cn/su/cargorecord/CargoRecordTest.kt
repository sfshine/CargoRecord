package cn.su.cargorecord

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.runner.AndroidJUnit4
import cn.su.cargorecord.db.dao.AppDatabase
import cn.su.cargorecord.db.entity.CargoRecord
import cn.su.cargorecord.util.getValue
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import java.util.*


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CargoRecordTest {
    private val TAG: String = "CRT"
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testA1_Add() {
        try {
            AppDatabase.INSTANCE.cargoRecordDao().add(
                CargoRecord("testA1_Add2", Date()).apply { id = 1 }
            )
            AppDatabase.INSTANCE.cargoRecordDao().add(
                CargoRecord("testA1_Add1", Date(1550373835000)).apply { id = 2 }
            )
        } catch (e: SQLiteConstraintException) {
            Assert.fail(">>>>>>testA1_Add exception:<<<<<<<\n" + Log.getStackTraceString(e))
        }
    }

    @Test
    fun testA2_AddAll() {
        val cargoRecordList = listOf(
            CargoRecord("testA2_AddAll2", Date(1550373836000)),
            CargoRecord("testA2_AddAll1", Date(1550373837000))
        )
        AppDatabase.INSTANCE.cargoRecordDao().addAll(cargoRecordList)
    }


    @Test
    fun testB1_GetAllCargoRecords() {
        val dataList = getValue(AppDatabase.INSTANCE.cargoRecordDao().getAllCargoRecords())
        Assert.assertEquals(dataList.size, 4)
        Log.d(TAG, "----testGetAllCargoRecords start----")
        for (data in dataList) {
            Log.d(TAG, data.toString())
        }
        Log.d(TAG, "----testGetAllCargoRecords end----")
    }

    @Test
    fun testB2_GetCargoRecordSince() {
        val orderTime = Date(1550373837000)
        val dataList = getValue(AppDatabase.INSTANCE.cargoRecordDao().getCargoRecordSince(orderTime))
        Assert.assertEquals(dataList.size, 2)
        Log.d(TAG, "----testGetCargoRecordSince----")
        for (data in dataList) {
            Log.d(TAG, data.toString())
        }
        Log.d(TAG, "----testGetCargoRecordSince----")
    }

    @Test
    fun testB3_GetCargoRecordByOrderTime() {
        val orderTime = Date(1550373837000)
        val dataList = AppDatabase.INSTANCE.cargoRecordDao().getCargoRecordByOrderTime(orderTime)
        Assert.assertEquals(dataList.size, 1)
        Log.d(TAG, "----testGetCargoRecordByOrderTime----")
        for (data in dataList) {
            Log.d(TAG, data.toString())
        }
    }

    @Test
    fun testC1_UpdateRecord() {
        val cargoRecord = CargoRecord("testUpdateRecord", Date(1550373835000))
        cargoRecord.id = 2
        val result = AppDatabase.INSTANCE.cargoRecordDao().updateRecord(cargoRecord)
        Log.d(TAG, "testC1_UpdateRecord result:$result")
        val dataList = AppDatabase.INSTANCE.cargoRecordDao().getCargoRecordById(cargoRecord.id)
        Assert.assertEquals(dataList[0].note, cargoRecord.note)
    }

    @Test
    fun testC2_UpdateNoteByRecordTime() {
        val date = Date(1550373836000)
        val newNote = "testUpdateNoteByRecordTime"
        val result = AppDatabase.INSTANCE.cargoRecordDao().updateNoteByRecordTime(newNote, date)
        Log.d(TAG, "testC2_UpdateNoteByRecordTime result:$result")
        val dataList = AppDatabase.INSTANCE.cargoRecordDao().getCargoRecordByOrderTime(date)
        Assert.assertEquals(dataList[0].note, newNote)
    }

    @Test
    fun testD1_DeleteByRecordId() {
        val cargoRecord = CargoRecord("testDeleteByRecordId", Date())
        cargoRecord.id = 1
        val result = AppDatabase.INSTANCE.cargoRecordDao().deleteByRecord(cargoRecord)
        Assert.assertEquals(1, result)
    }

    @Test
    fun testD2_DeleteByRecordTime() {
        val newNote = "testUpdateNoteByRecordTime"
        val result = AppDatabase.INSTANCE.cargoRecordDao().deleteByNote(newNote)
        Assert.assertEquals(1, result)
    }

    @Test
    fun testD3_DeleteAll() {
        val result = AppDatabase.INSTANCE.cargoRecordDao().deleteAll()
        Assert.assertEquals(2, result)
        val dataList = getValue(AppDatabase.INSTANCE.cargoRecordDao().getAllCargoRecords())
        Assert.assertEquals(dataList.size, 0)
    }
}
