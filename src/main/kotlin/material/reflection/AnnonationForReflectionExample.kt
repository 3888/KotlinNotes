package material.reflection

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

fun main() {
    reflections()
}

@ImAPlant
class Plant {
    private fun trim() {}
    private fun fertilize() {}

    private val test1 = "test1"
    private val test2 = "test2"

    // apply OnGet to isGrowing getter
    @get:OnGet
    val isGrowing: Boolean = true

    // apply OnSet to needsFood setter
    @set:OnSet
    var needsFood: Boolean = false
}

// This annotation does not do anything
annotation class ImAPlant

// Getter and setter
@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

// Get information about the class at runtime
fun reflections() {
    val classObj = Plant::class

    // Printing all the methods of the class
    for (method in classObj.declaredMemberFunctions) {
        println("method ${method.name}") // trim fertilize
    }

    // Printing all the values of the class
    for (member in classObj.members) {
        println("members ${member.name}") // trim fertilize
    }

    // print all annotations
    for (annotation in classObj.annotations) {
        println("annotation ${annotation.annotationClass.simpleName}")  // ImAPlant
    }

    // find one annotation, or null
    val annotated = classObj.findAnnotation<ImAPlant>()
    annotated?.apply {
        println("Found a plant annotation!")  // Found a plant annotation
    }

}
