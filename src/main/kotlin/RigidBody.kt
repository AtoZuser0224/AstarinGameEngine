class RigidBody(val entity: Entity) {
    var gravity=10.0
    var isGravity=false
    var gr=0.0

    fun AddGravity(){
        if (isGravity){

            gr+=0.1

            entity.y+=gr*gravity
        }
    }
}