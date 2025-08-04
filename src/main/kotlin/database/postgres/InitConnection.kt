package main.kotlin.database.postgres

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import java.sql.Connection

internal object InitConnection {
   private val config = HikariConfig().apply {
      jdbcUrl = AuthPostgres.SECRET_BDD
      driverClassName = "org.postgresql.Driver"
      maximumPoolSize = 10
      minimumIdle = 2
      leakDetectionThreshold = 5_000
      connectionTimeout = 30_000
      idleTimeout = 600_000
      maxLifetime = 1_800_000
   }

   private val ds = HikariDataSource(config)

   init {
      // Validación rápida al iniciar
      ds.connection.use { /* OK */ }
   }

   internal fun connect(): Connection = ds.connection

   internal fun shutdown() {
      ds.close()
   }
}
