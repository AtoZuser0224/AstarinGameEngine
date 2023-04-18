import java.awt.Graphics
import java.awt.Image
import java.awt.image.ImageObserver
import java.lang.Math.cos
import java.lang.Math.sin

abstract class Entity(
    var name:String,
    var x: Double,
    var y: Double,
    var direct: Double,

) {
    abstract var imagepng: Image
    abstract var height:Int
    abstract var width:Int
    val rigidBody=RigidBody(this)

    fun Movex(x: Int){
        this.x+=x
    }
    fun Movey(y: Int){
        this.y+=y
    }
    fun move(move:Double){
        // 각도를 라디안으로 변환
        val angleInRadians = Math.toRadians(direct)

        // x축으로의 이동량 계산
        val deltaX = move * cos(angleInRadians)

        // y축으로의 이동량 계산
        val deltaY = move * sin(angleInRadians)

        // 새로운 좌표 계산
        this.x+= deltaX
        this.y+= deltaY


    }
    fun move(move:Int){
        val angleInRadians = Math.toRadians(direct)

        // x축으로의 이동량 계산
        val deltaX = move * kotlin.math.cos(angleInRadians)

        // y축으로의 이동량 계산
        val deltaY = move * kotlin.math.sin(angleInRadians)

        // 새로운 좌표 계산
        this.x+= deltaX
        this.y+= deltaY
    }
    fun SetDir(dir:Int){
        direct=dir.toDouble()
    }



    open fun draw(g:Graphics,ig:ImageObserver){


    }


}