package material.companion_object

fun main() {
    println("getSingleton ${InstanceVsSingleton.getSingleton().hashCode()}")
    println("getSingleton ${InstanceVsSingleton.getSingleton().hashCode()}")
    println("getSingleton ${InstanceVsSingleton.getSingleton().hashCode()}")

    println("getInstance() ${InstanceVsSingleton.getInstance().hashCode()}")
    println("getInstance() ${InstanceVsSingleton.getInstance().hashCode()}")
    println("getInstance() ${InstanceVsSingleton.getInstance().hashCode()}")

}