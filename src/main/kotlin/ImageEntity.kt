import java.awt.Graphics
import java.awt.Image
import java.awt.Toolkit
import java.awt.image.ImageObserver

class ImageEntity(name:String, x: Double, y: Double, direct: Double, var image: String):Entity(name,x, y, direct)
{
    override lateinit var imagepng: Image
    init {

        var imageTool: Toolkit = Toolkit.getDefaultToolkit()
        imagepng= imageTool.getImage(image)
    }





    override var height: Int=0

    override var width: Int=0


    override fun draw(g: Graphics, ig: ImageObserver) {
        height=imagepng.getHeight(ig)
        width=imagepng.getWidth(ig)
        g.drawImage(imagepng, x.toInt(), y.toInt(), ig) // 비행기 이미지 출력.
    }
}