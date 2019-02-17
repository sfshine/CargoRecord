package cn.su.cargorecord.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by sfshine@qq.com on 2019/2/17 0017.
 * CREATE TABLE Manufacture (
 * manufactureId CHAR(10) NOT NULL,
 * name CHAR(10)
 * );
 */
@Entity(
    tableName = "manufacture"
)
data class Manufacture(
    @ColumnInfo(name = "name") var name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}