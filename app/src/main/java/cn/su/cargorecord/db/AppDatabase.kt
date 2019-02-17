package cn.su.cargorecord.db.dao

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import cn.su.cargorecord.App
import cn.su.cargorecord.db.Converters
import cn.su.cargorecord.db.MIGRATION_1_2
import cn.su.cargorecord.db.MIGRATION_2_3
import cn.su.cargorecord.db.entity.*

/**
 * The Room database for this app
 */
const val DATABASE_NAME = "cargo-db"

@Database(
    entities = [CargoRecord::class,
        Cargo::class,
        Cushion::class,
        Manufacture::class,
        Person::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cargoRecordDao(): CargoRecordDao
    abstract fun cargoDao(): CargoDao
    abstract fun personDao(): PersonDao
    abstract fun manufactureDao(): ManufactureDao
    abstract fun cushionDao(): CushionDao

    companion object {
        private const val TAG = "AppDatabase"
        val INSTANCE: AppDatabase by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            buildDatabase(App.context)
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.d(TAG, "onCreate")
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        Log.d(TAG, "onOpen")
                    }
                })
                .build()
        }
    }
}
