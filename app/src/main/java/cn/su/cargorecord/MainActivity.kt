package cn.su.cargorecord

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cn.su.cargorecord.databinding.ActivityMainBinding
import cn.su.cargorecord.db.dao.AppDatabase
import cn.su.cargorecord.db.entity.Cargo
import cn.su.cargorecord.db.entity.Person
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, mBinding.drawerLayout)
        setSupportActionBar(mBinding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        mBinding.navigationView.setupWithNavController(navController)

        Thread {
            AppDatabase.INSTANCE.cargoDao().add(Cargo("南方红木椅"))
            AppDatabase.INSTANCE.cargoDao().add(Cargo("北方花梨木"))
            AppDatabase.INSTANCE.personDao().add(Person("张一明"))
            AppDatabase.INSTANCE.personDao().add(Person("马运"))
        }.start()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_Person -> {
            }
        }
        mBinding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
