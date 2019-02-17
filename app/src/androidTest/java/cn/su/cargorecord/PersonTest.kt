package cn.su.cargorecord

/**
 * Created by sfshine@qq.com on 2019/2/17 0017.
 */
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.runner.AndroidJUnit4
import cn.su.cargorecord.db.dao.AppDatabase
import cn.su.cargorecord.db.entity.Person
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PersonTest {
    private val TAG: String = "CT"
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testA1_Add() {
        AppDatabase.INSTANCE.personDao().add(
            Person("testA1_Add1")
        )
        AppDatabase.INSTANCE.personDao().add(
            Person("testA1_Add2")
        )
    }
}