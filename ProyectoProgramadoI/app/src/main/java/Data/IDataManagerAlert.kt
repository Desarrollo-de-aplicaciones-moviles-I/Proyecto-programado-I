package Data

import Entity.Alert

interface IDataManagerAlert {
    fun addAlert(alerta: Alert)
    fun getAlertByUser(idUsuario: Int): List<Alert>
}