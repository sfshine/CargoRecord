package cn.su.cargorecord.db

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Created by sfshine@qq.com on 2019/2/17 0017.
 */
val MIGRATION_1_2 = object : Migration(1, 2) {

    override fun migrate(database: SupportSQLiteDatabase) {
        Log.d("Migration", "Migration 1->2")
        database.execSQL("ALTER TABLE cargo ADD COLUMN costPrice REAL")
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        Log.d("Migration", "Migration 2->3")
    }
}