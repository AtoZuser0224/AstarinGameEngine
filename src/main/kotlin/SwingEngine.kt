import java.awt.Graphics
import java.awt.Image
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JFrame
import javax.swing.Timer
import kotlin.system.exitProcess


class SwingEngine(GAME_NAME : String, private val width:Int, private val height:Int, val handler : SwingHandler) : JFrame(){
    private var entitys=ArrayList<Entity>()
    private lateinit var buffImg: Image
    private lateinit var buffG: Graphics
    init {
        // 창의 제목 설정
        title = GAME_NAME

        // 창의 크기 설정
        setSize(width, height)

        // 창을 화면 중앙에 위치시키기
        setLocationRelativeTo(null)

        // 창을 닫을 때 프로그램 종료
        defaultCloseOperation = EXIT_ON_CLOSE

        // 창을 표시
        isVisible = true
        handler.onEnable()
        handler.engine=this
        addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent) {
                handler.KeyPressed(e)
            }

            override fun keyReleased(e: KeyEvent) {

            }
        })

        addWindowListener(object : java.awt.event.WindowAdapter() {
            override fun windowClosing(e: java.awt.event.WindowEvent?) {
                // 종료 시 실행될 작업
                handler.onDisable()
                exitProcess(0) // 프로그램 강제 종료
            }
        })
        val timer = Timer(100) { // 그리기 로직

            repaint()
        }
        timer.start()
    }

    override fun paint(g: Graphics) {
        buffImg = createImage(width, height) // 버퍼링용 이미지 ( 도화지 )
        buffG = buffImg.graphics // 버퍼링용 이미지에 그래픽 객체를 얻어야 그릴 수 있다고 한다. ( 붓? )

        update(g)
    }

    override fun update(g: Graphics) {
        buffG.clearRect(0, 0, 854, 480) // 백지화
        entitys.forEach {
            entitys.forEach { target->
                if (it!=target&&it is ImageEntity&&target is ImageEntity ){
                    val targetMaxX: Double = target.x + target.imagepng.getWidth(this)/2
                    val targetMinX: Double = target.x - target.imagepng.getWidth(this)/2
                    val targetMaxY: Double = target.y + target.imagepng.getHeight(this)/2
                    val targetMinY: Double = target.y - target.imagepng.getHeight(this)/2
                    val maxX: Double = it.x + it.imagepng.getWidth(this)/2
                    val minX: Double = it.x - it.imagepng.getWidth(this)/2
                    val maxY: Double = it.y + it.imagepng.getHeight(this)/2
                    val minY: Double = it.y - it.imagepng.getHeight(this)/2
                    if (targetMaxX >= minX && targetMinX <= maxX && targetMaxY >= minY && targetMinY <= maxY) {
                        handler.ColliderEvent(it, target)
                        it.rigidBody.gr=0.0
                    } else {
                        it.rigidBody.AddGravity()
                    }

                }
            }
            handler.Update(it)
        }
        entitys.forEach {

            it.draw(buffG,this)
        }


        g.drawImage(buffImg, 0, 0, this) // 화면 g에 버퍼(buffG)에 그려진 이미지(buffImg)를 옮김. ( 도화지에 이미지를 출력 )
        repaint()
    }


    fun makeImageEntity(name:String, x:Int, y:Int, image : String): Entity? {
        entitys.forEach {
            if (it.name == name) {
                return null
            }

        }
        val entity=ImageEntity(name,x.toDouble(), y.toDouble(),0.0, image)
        entitys.add(entity)
        return entity
    }
    fun makeTextEntity(name:String, x:Int, y:Int, text : String): Entity? {
        entitys.forEach {
            if (it.name == name) {
                return null
            }

        }
        val entity=TextEntity(name,x.toDouble(), y.toDouble(),0.0, text)
        entitys.add(entity)
        return entity
    }


    fun getEntity(name:String):Entity?{
        entitys.forEach {
            if (it.name==name){
                return it
            }
        }
        return null
    }


}