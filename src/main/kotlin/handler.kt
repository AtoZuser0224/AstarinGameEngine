import java.awt.event.KeyEvent

class handler():SwingHandler() {


    override fun onEnable() {
        println("start")
    }

    override fun onDisable() {
        println("disable")
    }

    override fun Update(entity: Entity) {

    }

    override fun KeyPressed(e: KeyEvent) {
        if (e.keyChar=='a'){
            engine.getEntity("hello")!!.Movex(-25)
        }
        if (e.keyChar=='d'){
            engine.getEntity("hello")!!.Movex(25)
        }
        if (e.keyChar=='w'){
            engine.getEntity("hello")!!.Movey(-25)
        }
        if (e.keyChar=='s'){
            engine.getEntity("hello")!!.Movey(25)
        }
    }

    override fun ColliderEvent(entity: Entity, target: Entity) {
        if (entity.name=="hello"){
            println("suceesd")
        }
    }
}