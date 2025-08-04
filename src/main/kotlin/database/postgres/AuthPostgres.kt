package main.kotlin.database.postgres

import main.SECRETS

object AuthPostgres {
   internal val SECRET_BDD: String = SECRETS.BDD_SECRET.path
}