package cn.su.cargorecord.db.entity

import androidx.room.*
import java.util.*

/**
 * Created by sfshine@qq.com on 2019/2/16 0016.
 *
 * CREATE TABLE CargoRecord (recordId CHAR(10) NOT NULL,
 * cushionSourceId CHAR(10) NOT NULL,deliverPersonId CHAR(10) NOT NULL,
 * cargoId CHAR(10) NOT NULL,
 * manufactureId CHAR(10) NOT NULL,
 * orderTime TIMESTAMP(10),
 * deliverTime TIMESTAMP(10),
 * money FLOAT(10),
 * note VARCHAR(10)
 * );
 */

@Entity(
    tableName = "cargoRecord",
    foreignKeys = [
        ForeignKey(
            entity = Person::class,
            parentColumns = ["id"],
            childColumns = ["deliverPersonId"]
        ),
        ForeignKey(
            entity = Cargo::class,
            parentColumns = ["id"],
            childColumns = ["cargoId"]
        )],
    indices = [
        Index("deliverPersonId"),
        Index("cargoId"),
        Index("cushionId"),
        Index("manufactureId")]
)
data class CargoRecord(
    @ColumnInfo(name = "cushionId") var cushionId: Int,
    @ColumnInfo(name = "deliverPersonId") var deliverPersonId: Int,
    @ColumnInfo(name = "cargoId") var cargoId: Int,
    @ColumnInfo(name = "manufactureId") var manufactureId: Int,
    @ColumnInfo(name = "orderTime") var orderTime: Date,
    @ColumnInfo(name = "deliverTime") var deliverTime: Date,
    @ColumnInfo(name = "money") var money: Double,
    @ColumnInfo(name = "note") var note: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    override fun toString(): String {
        return "CargoRecord(recordId='$id', cushionId=$cushionId, deliverPersonId=$deliverPersonId, cargoId=$cargoId, manufactureId=$manufactureId, orderTime=$orderTime, deliverTime=$deliverTime, money=$money, note='$note')"
    }

    constructor(note: String, orderTime: Date) : this(
        1, 1, 1, 1,
        orderTime, Date(), 10.00, note
    )
}