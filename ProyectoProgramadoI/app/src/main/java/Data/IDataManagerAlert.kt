package Data

import Entity.Alert

interface IDataManagerAlert {
    fun addAlert(alert: Alert)
    fun getAlertByUser(idUser: Int): List<Alert>
}