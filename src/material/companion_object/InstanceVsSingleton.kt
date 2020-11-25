package material.companion_object

class InstanceVsSingleton {

    companion object {
        private val singleton = InstanceVsSingleton()
        fun getSingleton(): InstanceVsSingleton {
            return singleton
        }

        fun getInstance(): InstanceVsSingleton {
            return InstanceVsSingleton()
        }
    }

}