import sun.swing.SwingUtilities2.getFontMetrics
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.Image
import java.awt.image.ImageObserver
import java.awt.FontMetrics
class TextEntity(name:String, x: Double, y: Double, direct: Double, private var text:String):Entity(name,x, y, direct) {
    override lateinit var imagepng: Image

    override var height: Int=0

    override var width: Int=0

    override fun draw(g: Graphics, ig: ImageObserver) {


        // 텍스트를 그리기 위한 폰트 설정
        val font = Font("Arial", Font.PLAIN, 20)
        g.font = font

        // 텍스트를 그리기 위한 색상 설정
        g.color = Color.BLACK

        // 캔버스에 텍스트 그리기
        g.drawString(text, x.toInt(), y.toInt())// 비행기 이미지 출력.
    }

}