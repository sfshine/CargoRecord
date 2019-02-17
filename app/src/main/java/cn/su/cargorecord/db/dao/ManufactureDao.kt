package cn.su.cargorecord.db.dao

import androidx.room.*
import cn.su.cargorecord.db.entity.Manufacture

/**
 * Created by sfshine@qq.com on 2019/2/16 0016.
 */
@Dao
interface ManufactureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(manufacture: Manufacture)
}