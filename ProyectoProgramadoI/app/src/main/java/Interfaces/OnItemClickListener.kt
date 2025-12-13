package Interfaces

import Entity.Alert
import Entity.DTOAlert

interface OnItemClickListener {
    fun onItemClicked (alert: DTOAlert)
}