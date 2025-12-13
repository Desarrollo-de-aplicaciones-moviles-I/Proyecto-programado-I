package Interfaces

import Entity.DTOAlert

interface OnItemClickListener {
    fun onItemClicked (alert: DTOAlert)
}