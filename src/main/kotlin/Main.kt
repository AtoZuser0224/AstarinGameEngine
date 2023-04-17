
fun main(args: Array<String>) {
    val swing = SwingEngine("test",1920,1080,handler())
    val main=swing.makeImageEntity("main",1000,-5000,
        image = "C:\\Users\\A\\Documents\\GitHub\\GameEngine\\src\\main\\kotlin\\ice-2.jpg"
    )
    main?.isGravity=true
    val target=swing.makeImageEntity("target",1000,500,
        image = "C:\\Users\\A\\Documents\\GitHub\\GameEngine\\src\\main\\kotlin\\ice-2.jpg"
    )
    val text=swing.makeTextEntity("hello",50,50,"aaa")


}

