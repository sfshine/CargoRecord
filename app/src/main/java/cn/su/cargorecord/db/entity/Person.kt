package cn.su.cargorecord.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by sfshine@qq.com on 2019/2/17 0017.
 * CREATE TABLE Person (
 * personId CHAR(10) NOT NULL,
 * name VARCHAR(10)
 * );
 */
@Entity(
    tableName = "person"
)
data class Person(
    @ColumnInfo(name = "name") var name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}