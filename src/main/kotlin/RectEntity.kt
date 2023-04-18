import java.awt.Color
import java.awt.Graphics
import java.awt.Image
import java.awt.image.ImageObserver

class RectEntity(name:String, x: Double, y: Double, direct: Double,override var height: Int,override var width: Int):Entity(name, x, y, direct) {
    override lateinit var imagepng: Image





    override fun draw(g: Graphics, ig: ImageObserver) {
        g.color = Color.RED
        g.fillRect(x.toInt(), y.toInt(), width, height)
    }

}