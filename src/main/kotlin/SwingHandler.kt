import java.awt.event.KeyEvent

abstract class SwingHandler() {
    lateinit var engine:SwingEngine
    abstract fun onEnable()
    abstract fun onDisable()
    abstract fun Update(entity: Entity)
    open fun KeyPressed(e: KeyEvent) {}
    open fun ColliderEvent(entity: Entity,target: Entity) {}
}