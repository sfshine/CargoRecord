package cn.su.cargorecord.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import cn.su.cargorecord.db.entity.Cargo
import cn.su.cargorecord.db.entity.CargoRecord
import java.util.*

/**
 * Created by sfshine@qq.com on 2019/2/16 0016.
 */
@Dao
interface CargoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(cargo: Cargo)
}